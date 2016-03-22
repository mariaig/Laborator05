package ro.pub.cs.systems.eim.lab05.startedserviceactivity.view;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import ro.pub.cs.systems.eim.lab05.startedserviceactivity.general.Constants;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.TextView;

public class StartedServiceBroadcastReceiver extends BroadcastReceiver {

    private TextView messageTextView;

    // TODO: exercise 8 - default constructor

    public StartedServiceBroadcastReceiver(TextView messageTextView) {
        this.messageTextView = messageTextView;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: exercise 6 - get the action and the extra information from the intent
        // and set the text on the messageTextView
    	final String action = intent.getAction();
    	
    	String extraInfo = null;
    	if(Constants.ACTION_STRING.equals(action)) {
    		extraInfo = intent.getStringExtra(Constants.DATA);
    	} else if(Constants.ACTION_INTEGER.equals(action)) {
    		extraInfo = String.valueOf(intent.getIntExtra(Constants.DATA, 1994));
    	} else {
    		extraInfo = intent.getStringArrayExtra(Constants.DATA).toString();
		}
    	
    	if(messageTextView != null) {
    	      messageTextView.setText(messageTextView.getText().toString() + "\n" + extraInfo);
    	}
        // TODO: exercise 8 - restart the activity through an intent
        // if the messageTextView is not available
    	
    	
    }

}
