package com.sklay.core.chat.client.android;

import java.util.List;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.sklay.core.chat.nio.constant.CIMConstant;
import com.sklay.core.chat.nio.mutual.ClientData;
import com.sklay.core.chat.nio.mutual.Message;
import com.sklay.core.chat.nio.mutual.ServerData;

/**
 * 消息入口，所有消息都会经过这里
 * 
 * @author 3979434
 * 
 */
public abstract class CIMEnventListenerReceiver extends BroadcastReceiver implements OnCIMMessageListener
{
    public Context context;
    
    @Override
    public void onReceive(Context ctx, Intent it)
    {
        
        context = ctx;
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_NETWORK_CHANGED))
        {
            ConnectivityManager connectivityManager = (ConnectivityManager)context.getSystemService("connectivity");
            android.net.NetworkInfo info = connectivityManager.getActiveNetworkInfo();
            
            onDevicesNetworkChanged(info);
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_CONNECTION_CLOSED))
        {
            onConnectionClosed();
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_CONNECTION_FAILED))
        {
            onConnectionFailed((Exception)it.getSerializableExtra("exception"));
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_CONNECTION_SUCCESS))
        {
            onDispatchConnectionSucceed();
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_MESSAGE_RECEIVED))
        {
            filterType999Message((Message)it.getSerializableExtra("message"));
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_REPLY_RECEIVED))
        {
            onReplyReceived((ServerData)it.getSerializableExtra("replyBody"));
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_SENT_FAILED))
        {
            onSentFailed((Exception)it.getSerializableExtra("exception"),
                (ClientData)it.getSerializableExtra("sentBody"));
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_SENT_SUCCESS))
        {
            onSentSucceed((ClientData)it.getSerializableExtra("sentBody"));
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_UNCAUGHT_EXCEPTION))
        {
            onUncaughtException((Exception)it.getSerializableExtra("exception"));
        }
        
        if (it.getAction().equals(CIMConnectorManager.ACTION_CONNECTION_STATUS))
        {
            onConnectionStatus(it.getBooleanExtra(CIMPushManager.KEY_CIM_CONNECTION_STATUS, false));
        }
        
    }
    
    protected boolean isInBackground(Context context)
    {
        List<RunningTaskInfo> tasksInfo =
            ((ActivityManager)context.getSystemService(Context.ACTIVITY_SERVICE)).getRunningTasks(1);
        if (tasksInfo.size() > 0)
        {
            
            if (context.getPackageName().equals(tasksInfo.get(0).topActivity.getPackageName()))
            {
                
                return false;
            }
        }
        return true;
    }
    
    private void onConnectionClosed()
    {
        
        boolean isManualStop = CIMDataConfig.getBoolean(context, CIMDataConfig.KEY_MANUAL_STOP);
        
        boolean isManualDestory = CIMDataConfig.getBoolean(context, CIMDataConfig.KEY_CIM_DESTORYED);
        
        if (CIMConnectorManager.netWorkAvailable(context) && !isManualStop && !isManualDestory)
        {
            CIMPushManager.init(context);
        }
    }
    
    private void onConnectionFailed(Exception e)
    {
        if (CIMConnectorManager.netWorkAvailable(context))
        {
            CIMPushManager.init(context);
        }
    }
    
    private void onUncaughtException(Throwable arg0)
    {
    }
    
    private void onDevicesNetworkChanged(NetworkInfo info)
    {
        
        if (info != null)
        {
            CIMPushManager.init(context);
        }
        
        onNetworkChanged(info);
    }
    
    private void filterType999Message(com.sklay.core.chat.nio.mutual.Message message)
    {
        if (CIMConstant.MessageType.TYPE_999.equals(message.getType()))
        {
            CIMDataConfig.putBoolean(context, CIMDataConfig.KEY_MANUAL_STOP, true);
        }
        
        onMessageReceived(message);
    }
    
    private void onSentFailed(Exception e, ClientData body)
    {
        
        // 与服务端端开链接，重新连接
        if (e instanceof CIMSessionDisableException)
        {
            CIMPushManager.init(context);
        }
        else
        {
            // 发送失败 重新发送
            CIMPushManager.sendRequest(context, body);
        }
        
    }
    
    private void onDispatchConnectionSucceed()
    {
        
        CIMPushManager.setAccount(context);
        CIMDataConfig.putBoolean(context, CIMDataConfig.KEY_MANUAL_STOP, false);
        
        onConnectionSucceed();
    }
    
    private void onSentSucceed(ClientData body)
    {
    }
    
    @Override
    public abstract void onMessageReceived(com.sklay.core.chat.nio.mutual.Message message);
    
    @Override
    public abstract void onReplyReceived(ServerData body);
    
    public abstract void onNetworkChanged(NetworkInfo info);
}
