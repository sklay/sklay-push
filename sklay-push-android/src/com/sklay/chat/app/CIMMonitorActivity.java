package com.sklay.chat.app;

import android.app.Activity;
import android.net.NetworkInfo;
import android.os.Bundle;

import com.sklay.core.chat.client.android.CIMListenerManager;
import com.sklay.core.chat.client.android.OnCIMMessageListener;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.mutual.ServerData;

public abstract class CIMMonitorActivity extends Activity implements
		OnCIMMessageListener {
	CommonBaseControl commonBaseControl;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		CIMListenerManager.registerMessageListener(this, this);

		commonBaseControl = new CommonBaseControl(this);

	}

	@Override
	public void finish() {
		super.finish();
		CIMListenerManager.removeMessageListener(this);

	}

	@Override
	public void onRestart() {
		super.onRestart();
		CIMListenerManager.registerMessageListener(this, this);
	}

	public void showProgressDialog(String title, String content) {
		commonBaseControl.showProgressDialog(title, content);
	}

	public void hideProgressDialog() {
		commonBaseControl.hideProgressDialog();
	}

	public void showToask(String hint) {

		commonBaseControl.showToask(hint);
	}

	@Override
	public void onConnectionSucceed() {
	}

	@Override
	public void onConnectionStatus(boolean isConnected) {
	}

	@Override
	public void onReplyReceived(ServerData reply) {
	}

	@Override
	public void onMessageReceived(Message arg0) {
	}

	@Override
	public void onNetworkChanged(NetworkInfo info) {
	};
}
