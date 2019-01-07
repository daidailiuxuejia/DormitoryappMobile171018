/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android
 * FileNmae:StartActivity.java
 */
package net.common.android;

import java.util.Timer;
import java.util.TimerTask;

import org.apache.http.HttpStatus;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import net.cangshengwang.android.mobile2.R;
import net.common.android.common.Constants;
import net.common.android.common.HttpUtil;
import net.common.android.common.MyApp;
import net.common.android.common.SystemHelper;
import net.common.android.handler.RemoteDataHandler;
import net.common.android.handler.RemoteDataHandler.Callback;
import net.common.android.model.ResponseData;
import net.common.android.ui.mystore.LoginActivity;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class StartActivity extends Activity{
	
	private MyApp myApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start_view);
		
		myApp = (MyApp) StartActivity.this.getApplication();
		myApp.addActivity(this);
		//start new activity
	
		
		
		new Timer().schedule(new TimerTask() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				
		
				
				//start new activity
				Intent it=new Intent();
				it.setClass(StartActivity.this,LoginActivity.class);
				startActivity(it);
				StartActivity.this.finish();
			}
		}, 1000);
	  		
						
				
  		
		
	
	}

}
