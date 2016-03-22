package ro.pub.cs.systems.eim.lab05.startedservice.service;

import ro.pub.cs.systems.eim.lab05.startedservice.general.Constants;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ServiceThread  extends Thread {
	
	private Context context;
	
	public ServiceThread(Context context) {
		this.context = context;
	}

	@Override
	public void run() {
		while(true) {
			Log.d(Constants.TAG, "Thread.run() was invoked, PID:" + android.os.Process.myPid() + " TID:" + android.os.Process.myTid());
			sendMessage(Constants.MESSAGE_STRING);
			sleep();
			sendMessage(Constants.MESSAGE_INTEGER);
			sleep();
			sendMessage(Constants.MESSAGE_ARRAY_LIST);
			sleep();
		}
	}
	
	
	private void sleep() {
		try {
			Log.d(Constants.TAG, "Thread.sleep() method was invoked");
			Thread.sleep(Constants.SLEEP_TIME);
		} catch(InterruptedException ex) {
			
		}
	}
	
	private void sendMessage(int messageType) {
		Intent intent = new Intent();
		switch (messageType) {
		case Constants.MESSAGE_STRING:
			Log.d(Constants.TAG, "Thread.sendMessage(MESSAGE_STRING) method was invoked");
			intent.setAction(Constants.ACTION_STRING);
			intent.putExtra(Constants.DATA, Constants.STRING_DATA);
			break;
		case Constants.MESSAGE_INTEGER:
			Log.d(Constants.TAG, "Thread.sendMessage(MESSAGE_INTEGER) method was invoked");
			intent.setAction(Constants.ACTION_INTEGER);
			intent.putExtra(Constants.DATA, Constants.INTEGER_DATA);
			break;
		case Constants.MESSAGE_ARRAY_LIST:
			Log.d(Constants.TAG, "Thread.sendMessage(MESSAGE_ARRAY_LIST) method was invoked");
			intent.setAction(Constants.ACTION_ARRAY_LIST);
			intent.putExtra(Constants.DATA, Constants.ARRAY_LIST_DATA);
			break;
		default:
			break;
		}
		
		context.sendBroadcast(intent);
	}
	
}
