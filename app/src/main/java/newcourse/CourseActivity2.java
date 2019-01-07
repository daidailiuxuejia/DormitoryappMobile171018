package newcourse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import net.cangshengwang.android.mobile2.R;
import net.common.android.common.HttpUtil;
import net.common.android.common.MyApp;
import net.common.android.model.CourseList;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import com.baidu.location.BDLocation;
import com.baidu.location.BDLocationListener;
import com.baidu.location.LocationClient;
import com.baidu.location.LocationClientOption;


import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.graphics.Color;
import android.text.Layout;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.RadioGroup.OnCheckedChangeListener;

public class CourseActivity2 extends Activity {
	LinearLayout weekPanels[] = new LinearLayout[7];
	List courseData[] = new ArrayList[7];
	int itemHeight;
	int marTop, marLeft;
	  private MyApp myApp;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.kechengbiao);
		//
		  myApp = (MyApp) CourseActivity2.this.getApplication();
		itemHeight = getResources().getDimensionPixelSize(
				R.dimen.weekItemHeight);
		marTop = getResources().getDimensionPixelSize(R.dimen.weekItemMarTop);
		marLeft = getResources().getDimensionPixelSize(R.dimen.weekItemMarLeft);
		

		// 数据
		 loadingGoodsListData();

		for (int i = 0; i < weekPanels.length; i++) {
			weekPanels[i] = (LinearLayout) findViewById(R.id.weekPanel_1 + i);
			initWeekPanel(weekPanels[i], courseData[i]);
		}

	}
	public void loadingGoodsListData(){
		
	
		String url = HttpUtil.URL_COURSE2+myApp.getBanji();
		
		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if(response.getStatusLine().getStatusCode()==200){
				// 获得响应
				result = EntityUtils.toString(response.getEntity());
				
				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
//					JSONObject obj = new JSONObject(json);
					if(arrlist!="" && !arrlist.equals("arrlist") && arrlist!=null && !arrlist.equals("[]")){
					
						ArrayList<CourseList> goods_list=CourseList.newInstanceList(arrlist);
						List<Course> list1 = new ArrayList<Course>();
						List<Course> list2 = new ArrayList<Course>();
						List<Course> list3 = new ArrayList<Course>();
						List<Course> list4 = new ArrayList<Course>();
						List<Course> list5 = new ArrayList<Course>();
						for(CourseList c:goods_list){
							if(c.getWeek() == 1){
								Course c1 = new Course(c.getName(),c.getRoom(),c.getStart(),c.getStep(),c.getTeach(),c.getId());
								list1.add(c1);
							}
							if(c.getWeek() == 2){
								Course c1 = new Course(c.getName(),c.getRoom(),c.getStart(),c.getStep(),c.getTeach(),c.getId());
								list2.add(c1);
							}
							if(c.getWeek() == 3){
								Course c1 = new Course(c.getName(),c.getRoom(),c.getStart(),c.getStep(),c.getTeach(),c.getId());
								list3.add(c1);
							}
							if(c.getWeek() == 4){
								Course c1 = new Course(c.getName(),c.getRoom(),c.getStart(),c.getStep(),c.getTeach(),c.getId());
								list4.add(c1);
							}
							if(c.getWeek() == 5){
								Course c1 = new Course(c.getName(),c.getRoom(),c.getStart(),c.getStep(),c.getTeach(),c.getId());
								list5.add(c1);
							}
						}
						courseData[0] = list1;
						courseData[1] = list2;
						courseData[2] = list3;
						courseData[3] = list4;
						courseData[4] = list5;
						
						
					}else{
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}
	
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CourseActivity2.this, result, Toast.LENGTH_SHORT).show();;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(CourseActivity2.this, result, Toast.LENGTH_SHORT).show();;
		}
	}
	public void getData() {
		List<Course> list1 = new ArrayList<Course>();
		Course c1 = new Course("软件工程", "A402", 1, 4, "典韦", "1002");
		list1.add(c1);
		list1.add(new Course("C语言", "A101", 6, 3, "甘宁", "1001"));
		courseData[0] = list1;

		List<Course> list2 = new ArrayList<Course>();
		list2.add(new Course("计算机组成原理", "A106", 6, 3, "马6超", "1001"));
		courseData[1] = list2;

		List<Course> list3 = new ArrayList<Course>();
		list3.add(new Course("数据库原理", "A105", 2, 3, "孙权", "1008"));
		list3.add(new Course("计算机网络", "A405", 6, 2, "司马懿", "1009"));
		list3.add(new Course("电影赏析", "A112", 9, 2, "诸葛亮", "1039"));
		courseData[2] = list3;

		List<Course> list4 = new ArrayList<Course>();
		list4.add(new Course("数据结构", "A223", 1, 3, "刘备", "1012"));
		list4.add(new Course("操作系统", "A405", 6, 3, "曹操", "1014"));
		courseData[3] = list4;

		List<Course> list5 = new ArrayList<Course>();
		list5.add(new Course("Android开发", "C120", 1, 4, "黄盖", "1250"));
		list5.add(new Course("游戏设计原理", "C120", 8, 4, "陆逊", "1251"));
		courseData[4] = list5;
	}

	@SuppressLint("NewApi")
	public void initWeekPanel(LinearLayout ll, List<Course> data) {
		if (ll == null || data == null || data.size() < 1)
			return;
		Log.i("Msg", "初始化面板");
		Course pre = data.get(0);
		for (int i = 0; i < data.size(); i++) {
			final Course c = data.get(i);
			TextView tv = new TextView(this);
			LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
					LinearLayout.LayoutParams.FILL_PARENT, itemHeight
							* c.getStep() + marTop * (c.getStep() - 1));
			if (i > 0) {
				lp.setMargins(marLeft,
						(c.getStart() - (pre.getStart() + pre.getStep()))
								* (itemHeight + marTop) + marTop, 0, 0);
			} else {
				lp.setMargins(marLeft, (c.getStart() - 1)
						* (itemHeight + marTop) + marTop, 0, 0);
			}
			tv.setLayoutParams(lp);
			tv.setGravity(Gravity.TOP);
			tv.setGravity(Gravity.CENTER_HORIZONTAL);
			tv.setTextSize(12);
			tv.setTextColor(getResources().getColor(R.color.white));
			tv.setText(c.getName() + "\n" + c.getRoom() + "\n" + c.getTeach());
			// tv.setBackgroundColor(getResources().getColor(R.color.classIndex));
			tv.setBackground(getResources().getDrawable(R.drawable.blue_block));
			tv.setOnClickListener(new OnClickListener() {

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
//					saveloc(langitude+"", latitude+"", c.getRoom(), c.getName());
				
				}
			});
			ll.addView(tv);
			pre = c;
		}
	}

}
