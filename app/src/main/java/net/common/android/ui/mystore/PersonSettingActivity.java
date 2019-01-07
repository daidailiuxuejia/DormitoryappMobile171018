/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.cangshengwang.android.ui.mystore
 * FileNmae:RegisteredActivity.java
 */
package net.common.android.ui.mystore;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;
import java.util.HashMap;

import net.cangshengwang.android.mobile2.R;
import net.common.android.common.HttpUtil;
import net.common.android.common.MyApp;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014年3月10日 下午2:02:39
 */
public class PersonSettingActivity extends Activity {
	private EditText editUserName;
	private EditText editPassword;
	private EditText editPassword2;
	private EditText editphone;
	private ImageView imageBack;
	private Button buttonSend;
	private MyApp myApp;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.personalsetting_view);
		myApp = (MyApp) PersonSettingActivity.this.getApplication();
		editUserName = (EditText) findViewById(R.id.editUserName);
		editPassword = (EditText) findViewById(R.id.editPassword);
		editPassword2 = (EditText) findViewById(R.id.editPassword2);
		editphone = (EditText) findViewById(R.id.editphone);
		imageBack = (ImageView) findViewById(R.id.imageBack);
		buttonSend = (Button) findViewById(R.id.buttonSend);
		loaddata();
		buttonSend.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				String username = editUserName.getText().toString();
				String password = editPassword.getText().toString();
				String password2 = editPassword2.getText().toString();
				String phone = editphone.getText().toString();
				if(username.equals("") || username==null){
					Toast.makeText(PersonSettingActivity.this, "用户名不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}
			/*	if(password.equals("") ||  password==null){
					Toast.makeText(PersonSettingActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}*/
				if(password2.equals("") ||  password2==null){
					Toast.makeText(PersonSettingActivity.this, "密码不能为空", Toast.LENGTH_SHORT).show();;
					return ;
				}
				
			/*	if(!password.equals(password2)){
					Toast.makeText(PersonSettingActivity.this, "密码不一致", Toast.LENGTH_SHORT).show();;
					return ;
				}*/
				
				SendData(username, password2, phone);
			}
		});
		imageBack.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				PersonSettingActivity.this.finish();
			}
		});
	}
	
	public void SendData(String username , String password ,String phone){
		String url = HttpUtil.URL_UPDATEPWD;
		String query ="";
		query+="user.id="+myApp.getLoginKey()+"&";
		query+="user.username="+username+"&";
		query+="user.password="+password+"&";
		query+="user.realname=QQ&";
		query+="user.jobstatus=1&";
		query+="user.qqnum=QQ&";
		query+="user.phone="+phone;
		url+=query;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
//						Login login=Login.newInstanceList(arrlist);
//						myApp.setLoginKey(login.getKey());
//						myApp.setLoginName(login.getUsername());
						
						if(arrlist.equals("1")){
							Toast.makeText(PersonSettingActivity.this, "恭喜，修改成功", Toast.LENGTH_SHORT).show();;
			            	Intent intent = new Intent(PersonSettingActivity.this,MyStoreActivity.class);
			            	PersonSettingActivity.this.startActivity(intent);
						}else{
							Toast.makeText(PersonSettingActivity.this, "抱歉，修改失败", Toast.LENGTH_SHORT).show();;
						}
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			
			
				
		/*		InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, InputMethodManager.HIDE_NOT_ALWAYS);
        */
				
		
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(PersonSettingActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(PersonSettingActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
		
		
		
		
	}
	public void loaddata(){
		String url = HttpUtil.URL_LOAD;
		String query ="";
		query+="user.id="+myApp.getLoginKey();
		url+=query;
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				JSONObject obj;
				try {
					obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					JSONObject user = new JSONObject(arrlist);
					if(obj.length()> 0){
						String username = user.optString("username");
						String password = user.optString("password");
						String qqnum = user.optString("qqnum");
						String phone = user.optString("phone");
						String realname = user.optString("realname");
						
						editUserName.setText(username);
						editPassword.setText(password);
						editphone.setText(phone);
						
						
						
						
						
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
				
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(PersonSettingActivity.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(PersonSettingActivity.this, result, Toast.LENGTH_SHORT).show();;
		}
		
		
		
		
	}

}
