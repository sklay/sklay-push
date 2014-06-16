package com.sklay.chat.ui;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.sklay.chat.R;
import com.sklay.chat.adapter.SystemMsgListViewAdapter;
import com.sklay.chat.app.CIMMonitorActivity;
import com.sklay.chat.app.Constant;
import com.sklay.chat.network.HttpAPIRequester;
import com.sklay.chat.network.HttpAPIResponser;
import com.sklay.chat.network.Page;
import com.sklay.core.chat.client.android.CIMPushManager;
import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.mutual.Message;

public class SystemMessageActivity extends CIMMonitorActivity implements
		OnClickListener, HttpAPIResponser {

	protected ListView chatListView;
	int currentPage = 1;
	protected SystemMsgListViewAdapter adapter;
	private ArrayList<Message> list;

	public HashMap<String, Object> apiParams = new HashMap<String, Object>();

	// 客户端向客户端发送消息接口地址
	public final static String SEND_MESSAGE_API_URL = Constant.SERVER_URL
			+ "/cgi/send";

	HttpAPIRequester requester;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_system_chat);
		initViews();
		requester = new HttpAPIRequester(this);
	}

	public void initViews() {

		list = new ArrayList<Message>();

		chatListView = (ListView) findViewById(R.id.chat_list);
		findViewById(R.id.TOP_BACK_BUTTON).setOnClickListener(this);
		findViewById(R.id.TOP_BACK_BUTTON).setVisibility(View.VISIBLE);

		Button button = ((Button) findViewById(R.id.talk));

		((TextView) findViewById(R.id.TOP_BACK_BUTTON)).setText("登录");
		((TextView) findViewById(R.id.TITLE_TEXT)).setText("系统消息");
		((TextView) findViewById(R.id.account)).setText(this.getIntent()
				.getStringExtra("account"));

		adapter = new SystemMsgListViewAdapter(this, list);
		chatListView.setAdapter(adapter);

		showToask("登录成功，请通过后台页面发送消息吧^_^");

		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				try {
					sendMessage();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// 收到消息
	@Override
	public void onMessageReceived(com.sklay.core.chat.nio.mutual.Message message) {

		if (message.getType().equals(Constant.MessageType.TYPE_999)) {
			// 返回登录页面，停止接受消息
			CIMPushManager.stop(this);

			this.showToask("你被迫下线!");
			Intent intent = new Intent(this, LoginActivity.class);
			startActivity(intent);
			this.finish();
		} else {
			MediaPlayer.create(this, R.raw.classic).start();
			list.add(message);
			adapter.notifyDataSetChanged();
			chatListView.setSelection(chatListView.getTop());

		}

	}

	@Override
	public void onConnectionSucceed() {
	}

	@Override
	public void onNetworkChanged(NetworkInfo info) {

		if (info == null) {
			showToask("网络已断开");

		} else {
			showToask("网络已恢复，重新连接....");
		}

	}

	// 发送消息示范，用户客户端与客户端之间的消息发送
	private void sendMessage() throws Exception {

		apiParams.put("content", "hello world!");
		apiParams.put("sender", "xiaogou");// 发送者账号
		apiParams.put("receiver", "admin");// 消息接收者账号
		apiParams.put("type", Constant.MessageType.TYPE_0);

		requester.execute(new TypeReference<JSONObject>() {
		}.getType(), null, SEND_MESSAGE_API_URL);

		apiParams.put("receiver", "system");// 消息接收者账号
		requester.execute(new TypeReference<JSONObject>() {
		}.getType(), null, SEND_MESSAGE_API_URL);

	}

	@Override
	public void onSuccess(Object data, List<?> list, Page page, String code,
			String url) {
		hideProgressDialog();

		if (CIMConstant.ReturnCode.CODE_200.equals(code)) {
			showToask("发送成功");
		}

	}

	@Override
	public Map<String, Object> getRequestParams() {
		return apiParams;
	}

	@Override
	public void onRequest() {
		showProgressDialog("提示", "正在发送消息...");
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.TOP_BACK_BUTTON: {
			onBackPressed();
			break;
		}
		}
	}

	@Override
	public void onFailed(Exception e) {
	}

	@Override
	public void onBackPressed() {

		// 返回登录页面，停止接受消息
		CIMPushManager.stop(this);

		Intent intent = new Intent(this, LoginActivity.class);
		startActivity(intent);
		this.finish();
	}

}