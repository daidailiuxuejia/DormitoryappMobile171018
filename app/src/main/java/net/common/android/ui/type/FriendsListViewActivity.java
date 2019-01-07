/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.ui.type
 * FileNmae:GoodsListViewActivity.java
 */
package net.common.android.ui.type;

import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import net.cangshengwang.android.mobile2.R;
import net.common.android.common.HttpUtil;
import net.common.android.common.MyApp;
import net.common.android.common.MyBackAsynaTask;
import net.common.android.model.FriendBean;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * @author KingKong·HE
 * @Time 2014-1-9 上午11:33:44
 */
public class FriendsListViewActivity extends Activity implements
		OnScrollListener {

	private ListView goodsListView;
	private GameAdapter adapter;
	private String keyword;
	private String b;
	private MyApp myApp;
	private TextView list_view_title;
	// private EditText textHomeSearch;
	// private ImageButton imageSearch;
	// private EditText textHomeSearch;
	// private ImageButton imageSearch;
	private List<FriendBean> basemarkBeans = new ArrayList<FriendBean>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.friends_list);
		myApp = (MyApp) FriendsListViewActivity.this.getApplication();
		goodsListView = (ListView) findViewById(R.id.goodsListView);
		list_view_title = (TextView) findViewById(R.id.list_view_title);
		// textHomeSearch = (EditText) findViewById(R.id.textHomeSearch);
		// imageSearch = (ImageButton) findViewById(R.id.imageSearch);
		// textHomeSearch = (EditText) findViewById(R.id.textHomeSearch);
		// imageSearch = (ImageButton) findViewById(R.id.imageSearch);
		adapter = new GameAdapter();
		goodsListView.setAdapter(adapter);
		goodsListView.setSelection(0);
		loadingGoodsListData(b);

		goodsListView.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, final int arg2,
					long arg3) {

				new AlertDialog.Builder(FriendsListViewActivity.this)
						.setTitle("提示")
						.setMessage("是否删除该用户")
						.setNegativeButton("取消",
								new DialogInterface.OnClickListener() {

									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										dialog.dismiss();
									}
								})
						.setPositiveButton("确定",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										del(basemarkBeans.get(arg2).getId());
									}
								}).show();
				/*
				 * Intent intent = new Intent(FriendsListViewActivity.this,
				 * AddMessageActivity.class); intent.putExtra("id",
				 * basemarkBeans.get(arg2).getId()); startActivity(intent);
				 */
			}
		});
	}
	public void del(String id) {
		String url = HttpUtil.URL_DELUSER+id;

		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());

				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					// JSONObject obj = new JSONObject(json);
					if (arrlist != "" && !arrlist.equals("arrlist")
							&& arrlist != null && !arrlist.equals("[]")) {

						if(arrlist.equals("1")){
							Toast.makeText(FriendsListViewActivity.this, "操作成功",
									Toast.LENGTH_SHORT).show();
							loadingGoodsListData("");
							
						}else{
							Toast.makeText(FriendsListViewActivity.this, "操作失败",
									Toast.LENGTH_SHORT).show();
						}
					} else {
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(FriendsListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(FriendsListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		}
	}
	public void loadingGoodsListData(String b) {
		basemarkBeans= new ArrayList<FriendBean>();
		String url = HttpUtil.URL_FRIENDSLIST;

		HttpPost request = HttpUtil.getHttpPost(url);
		String result = null;
		try {
			// 获得响应对象
			HttpResponse response = HttpUtil.getHttpResponse(request);
			// 判断是否请求成功
			if (response.getStatusLine().getStatusCode() == 200) {
				// 获得响应
				result = EntityUtils.toString(response.getEntity());

				try {
					JSONObject obj = new JSONObject(result);
					String arrlist = obj.optString("jsonString");
					// JSONObject obj = new JSONObject(json);
					if (arrlist != "" && !arrlist.equals("arrlist")
							&& arrlist != null && !arrlist.equals("[]")) {

						ArrayList<FriendBean> goods_list = FriendBean
								.newInstanceList(arrlist);
						basemarkBeans.addAll(goods_list);
						adapter.notifyDataSetChanged();
					} else {
					}
				} catch (JSONException e) {
					e.printStackTrace();
				}

			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(FriendsListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		} catch (IOException e) {
			e.printStackTrace();
			result = "网络异常！";
			Toast.makeText(FriendsListViewActivity.this, result,
					Toast.LENGTH_SHORT).show();
			;
		}
	}

	@Override
	public void onScroll(AbsListView arg0, int arg1, int arg2, int arg3) {
		// TODO Auto-generated method stub

	}

	@Override
	public void onScrollStateChanged(AbsListView arg0, int arg1) {
		// TODO Auto-generated method stub

	}

	private class GameAdapter extends BaseAdapter {
		private LayoutInflater inflater;

		private GameAdapter() {
			inflater = LayoutInflater.from(FriendsListViewActivity.this);
		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return basemarkBeans.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return basemarkBeans.get(position);
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			Holder holder;
			if (convertView == null) {
				convertView = inflater
						.inflate(R.layout.friends_list_item, null);
				holder = new Holder();
				holder.imageGoodsPic = (ImageView) convertView
						.findViewById(R.id.imageGoodsPic);
				holder.textGoodsName = (TextView) convertView
						.findViewById(R.id.textGoodsName);
				convertView.setTag(holder);
			} else {
				holder = (Holder) convertView.getTag();
			}

			String role = "";
			if (basemarkBeans.get(position).getStatus().equals("0")) {
				role = "普通用户";
			} else {
				role = "宠物医生\n擅长动物类型:" + basemarkBeans.get(position).getType();
			}
			holder.textGoodsName
					.setText(basemarkBeans.get(position).getPhone());
			if (basemarkBeans.get(position).getImage_url().length() > 0) {
				String imagename = basemarkBeans.get(position).getImage_url()
						.split("\\\\")[1];
				MyBackAsynaTask asynaTask = new MyBackAsynaTask(
						HttpUtil.URL_BASEUPLOAD + imagename,
						holder.imageGoodsPic);
				asynaTask.execute();

			}
			return convertView;
		}

	}

	private class Holder {
		ImageView imageGoodsPic;
		TextView textGoodsName;
	}

}
