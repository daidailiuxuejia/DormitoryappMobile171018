package net.common.android.ui.home;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import net.cangshengwang.android.mobile2.R;
import net.common.android.MainActivity;
import net.common.android.common.Constants;
import net.common.android.common.HttpHelper;
import net.common.android.common.HttpUtil;
import net.common.android.common.MyApp;
import net.common.android.common.MyBackAsynaTask;
import net.common.android.common.MySrcAsynaTask;
import net.common.android.common.SystemHelper;
import net.common.android.handler.RemoteDataHandler;
import net.common.android.handler.RemoteDataHandler.Callback;
import net.common.android.model.Home1List;
import net.common.android.model.Home2List;
import net.common.android.model.MyStore;
import net.common.android.model.ResponseData;
import net.common.android.ui.more.AboutActivity;
import net.common.android.ui.mystore.ChangeDormActivity;
import net.common.android.ui.mystore.LoginActivity;
import net.common.android.ui.mystore.MyStoreActivity;
import net.common.android.ui.type.DormListViewActivity2;
import net.common.android.ui.type.DormListViewActivity;
import net.common.android.ui.type.DormListViewActivity3;
import net.common.android.ui.type.DormListViewActivity4;
import net.common.android.ui.type.FriendsListViewActivity;
import net.common.android.ui.type.StudentListViewActivity;
import net.common.android.ui.type.StudentListViewActivity2;
import net.common.android.ui.widget.Utility;
import newcourse.CourseActivity;
import newcourse.CourseActivity2;

import org.apache.http.HttpStatus;
import org.json.JSONException;
import org.json.JSONObject;

import baidumap.LocationDemo;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class HomeActivity extends Activity {
	private LinearLayout ll_point;
	private ArrayList<View> arrayList;
	private ArrayList<ImageView> imageViews;
	private Timer timer;
	private MyApp myApp;
	private LayoutInflater HeadlayoutInflater;
	private ViewPager viewPager;
	private int i;
	private int count;
	private TextView textHomeSearch;
	private ScrollView myScrollView;
	private ListView listRecommendGoods;
	private LinearLayout linearLayoutCategory0;
	private LinearLayout linearLayoutCategory1;
	private LinearLayout linearLayoutCategory2;
	private LinearLayout linearLayoutCategory3;
	private LinearLayout linearLayoutCategory4;
	private LinearLayout linearLayoutCategory5;
	private LinearLayout linearLayoutCategory6;
	private LinearLayout linearLayoutCategory7;
	private LinearLayout linearLayoutCategory8;
	private LinearLayout circle_layout;
	private Button buttonSeeAll;
	private Button buttonClickSign;
	private Button buttonHomeLogin;
	private LinearLayout layoutstudent;
	private LinearLayout layoutstudent02;
	private LinearLayout layoutteacher;
	private LinearLayout linearLayoutHomeLogin;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);

		myApp = (MyApp) HomeActivity.this.getApplication();

		textHomeSearch = (TextView) findViewById(R.id.textHomeSearch);
		myScrollView = (ScrollView) findViewById(R.id.myScrollView);
		linearLayoutCategory0 = (LinearLayout) findViewById(R.id.linearLayoutCategory0);
		linearLayoutCategory1 = (LinearLayout) findViewById(R.id.linearLayoutCategory1);
		linearLayoutCategory2 = (LinearLayout) findViewById(R.id.linearLayoutCategory2);
		linearLayoutCategory3 = (LinearLayout) findViewById(R.id.linearLayoutCategory3);
		linearLayoutCategory4 = (LinearLayout) findViewById(R.id.linearLayoutCategory4);
		linearLayoutCategory5 = (LinearLayout) findViewById(R.id.linearLayoutCategory5);
		linearLayoutCategory6 = (LinearLayout) findViewById(R.id.linearLayoutCategory6);
		linearLayoutCategory7 = (LinearLayout) findViewById(R.id.linearLayoutCategory7);
		linearLayoutCategory8 = (LinearLayout) findViewById(R.id.linearLayoutCategory8);
		linearLayoutHomeLogin = (LinearLayout) findViewById(R.id.linearLayoutHomeLogin);

		// loadingHomeData();

		layoutstudent = (LinearLayout) findViewById(R.id.layoutstudent);
		layoutteacher = (LinearLayout) findViewById(R.id.layoutteacher);
		layoutstudent02 = (LinearLayout) findViewById(R.id.layoutstudent02);
	/*	if (myApp.getLoginStatus().equals("0")) {
			layoutstudent.setVisibility(View.VISIBLE);
			layoutstudent02.setVisibility(View.VISIBLE);

		} else {
			layoutstudent.setVisibility(View.GONE);
			layoutstudent02.setVisibility(View.GONE);
		}*/

		CategoryOnClickListener categoryLister = new CategoryOnClickListener();
		linearLayoutCategory0.setOnClickListener(categoryLister);
		linearLayoutCategory1.setOnClickListener(categoryLister);
		linearLayoutCategory2.setOnClickListener(categoryLister);
		linearLayoutCategory3.setOnClickListener(categoryLister);
		linearLayoutCategory4.setOnClickListener(categoryLister);
		linearLayoutCategory5.setOnClickListener(categoryLister);
		linearLayoutCategory6.setOnClickListener(categoryLister);
		linearLayoutCategory7.setOnClickListener(categoryLister);
		linearLayoutCategory8.setOnClickListener(categoryLister);

		RegisterBroadcastReceiver();
		/**
		 * buttonClickSign.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { if(myApp.getLoginKey() ==null
		 *           || myApp.getLoginKey().equals("") ||
		 *           myApp.getLoginKey().equals("null")){ //未登录
		 *           Toast.makeText(HomeActivity.this, "未登录，请先登录",
		 *           Toast.LENGTH_SHORT).show(); return; }else{ //已登录
		 *           clickToSign(); } } });
		 **/
		/**
		 * buttonHomeLogin.setOnClickListener(new OnClickListener() {
		 * 
		 * @Override public void onClick(View v) { Intent intent = new
		 *           Intent(HomeActivity.this, LoginActivity.class);
		 *           HomeActivity.this.startActivity(intent); } });
		 * 
		 *           linearLayoutHomeLogin.setOnClickListener(new
		 *           OnClickListener() {
		 * @Override public void onClick(View v) { Intent intent = new
		 *           Intent(HomeActivity.this, LoginActivity.class);
		 *           HomeActivity.this.startActivity(intent); } });
		 **/

	}

	public void clickToSign() {
		// TODO Auto-generated method stub
		String url = Constants.URL_SIGN;
		HashMap<String, String> params = new HashMap<String, String>();
		params.put("key", myApp.getLoginKey());
		RemoteDataHandler.asyncPost2(url, params, new Callback() {
			@Override
			public void dataLoaded(ResponseData data) {
				if (data.getCode() == HttpStatus.SC_OK) {
					String json = data.getJson();
					JSONObject obj2;
					try {
						obj2 = new JSONObject(json);
						String flag = obj2.getString("flag");
						if (flag.equals("1")) {
							Toast.makeText(HomeActivity.this, "签到成功",
									Toast.LENGTH_SHORT).show();
							;
						} else if (flag.equals("2")) {
							Toast.makeText(HomeActivity.this, "上午已签到",
									Toast.LENGTH_SHORT).show();
							;
						} else if (flag.equals("3")) {
							Toast.makeText(HomeActivity.this, "下午已签到",
									Toast.LENGTH_SHORT).show();
							;
						} else if (flag.equals("4")) {
							Toast.makeText(HomeActivity.this, "今日已签到",
									Toast.LENGTH_SHORT).show();
							;
						}

					} catch (JSONException e) {
						e.printStackTrace();
					}

				} else {
					Toast.makeText(HomeActivity.this, "数据加载失败，请稍后重试",
							Toast.LENGTH_SHORT).show();
					;
				}
			}
		});

	}

	private BroadcastReceiver homeBroadcastReceiver = new BroadcastReceiver() {
		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();
			if (action == Constants.APP_BORADCASTRECEIVER) {
				linearLayoutHomeLogin.setVisibility(View.GONE);
			}
		}
	};

	public void RegisterBroadcastReceiver() {
		IntentFilter homeIntentFilter = new IntentFilter();
		homeIntentFilter.addAction(Constants.APP_BORADCASTRECEIVER);
		HomeActivity.this.registerReceiver(homeBroadcastReceiver,
				homeIntentFilter);
	}

	public class CategoryOnClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			Bundle b = new Bundle();
			Intent intent = null;
			switch (v.getId()) {
			case R.id.linearLayoutCategory0:// 农业生物信息

				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							StudentListViewActivity2.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory1:// 分析软件和工具
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							DormListViewActivity2.class);
					b = new Bundle();
					b.putInt("type", 1);
					intent.putExtras(b);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}

				break;
			case R.id.linearLayoutCategory2:// 成功案例
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							StudentListViewActivity.class);
					b = new Bundle();
					b.putInt("type", 2);
					intent.putExtras(b);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory3:// 农业生物信息

				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							FriendsListViewActivity.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory4:// 分析软件和工具
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							DormListViewActivity3.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}

				break;
			case R.id.linearLayoutCategory5:// 成功案例
				
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							DormListViewActivity4.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				/*if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							ChengjiActivity.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}*/
				break;
			case R.id.linearLayoutCategory6:// 农业生物信息

				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							DormListViewActivity.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;
			case R.id.linearLayoutCategory7:// 分析软件和工具
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							ChangeDormActivity.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}

				break;
			case R.id.linearLayoutCategory8:// 成功案例
				if (myApp.getLoginKey() != "") {
					intent = new Intent(HomeActivity.this,
							AboutActivity.class);
				} else {
					intent = new Intent(HomeActivity.this, LoginActivity.class);
				}
				break;

			}
			if (intent != null) {
				startActivity(intent);
			}
		}
	}



	public int initGetW(String result) {
		int w = 250;
		Bitmap bitmap;
		try {
			bitmap = HttpHelper.downloadBitmap(result);
			w = bitmap.getWidth();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return w;
	}

	public int initGetH(String result) {
		int h = 250;
		Bitmap bitmap;
		try {
			bitmap = HttpHelper.downloadBitmap(result);
			h = bitmap.getHeight();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return h;
	}


	/***
	 * 更新选中点
	 * 
	 * @param index
	 */
	public void draw_Point(int index) {
		for (int i = 0; i < imageViews.size(); i++) {
			imageViews.get(i).setImageResource(R.drawable.point_gray);
		}
		imageViews.get(index).setImageResource(R.drawable.point_red);
	}

	/***
	 * 对图片处理
	 * 
	 * @author zhangjia
	 */
	public Bitmap getBitmap(Bitmap bitmap, int width) {
		int w = bitmap.getWidth();
		int h = bitmap.getHeight();
		Matrix matrix = new Matrix();
		float scale = (float) width / w;
		// 保证图片不变形.
		matrix.postScale(scale, scale);
		// w,h是原图的属性.
		return Bitmap.createBitmap(bitmap, 0, 0, w, h, matrix, true);
	}

	public class ViewPagerAdapter extends PagerAdapter {
		// 界面列表
		private List<View> views;

		public ViewPagerAdapter(List<View> views) {
			this.views = views;
		}

		// 销毁arg1位置的界面
		@Override
		public void destroyItem(View arg0, int arg1, Object arg2) {
			((ViewPager) arg0).removeView(views.get(arg1));
		}

		// 获得当前界面数
		@Override
		public int getCount() {
			if (views != null) {
				// 返回一个比较大的数字
				return views.size();
			}
			return 0;
		}

		// 初始化arg1位置的界面
		@Override
		public Object instantiateItem(View arg0, int arg1) {
			((ViewPager) arg0).addView(views.get(arg1));
			return views.get(arg1);
		}

		// 判断是否由对象生成界面
		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			return (arg0 == arg1);
		}
	}

	@Override
	protected void onResume() {
		super.onResume();
		count = 1;
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		unregisterReceiver(homeBroadcastReceiver);
	}

	// @Override
	// public boolean onKeyDown(int keyCode, KeyEvent event) {
	// if (keyCode == KeyEvent.KEYCODE_BACK) {
	// count++;
	// if (count >= 3) {
	// HomeActivity.this.finish();
	// return true;
	// } else {
	// Toast.makeText(HomeActivity.this, "再点击一次退出程序",
	// Toast.LENGTH_SHORT).show();
	// return true;
	// }
	// } else {
	// return super.onKeyDown(keyCode, event);
	// }
	// }
}
