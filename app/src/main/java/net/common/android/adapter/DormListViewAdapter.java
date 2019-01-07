/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.adapter
 * FileNmae:GoodsListViewAdapter.java
 */
package net.common.android.adapter;

import java.util.ArrayList;

import net.cangshengwang.android.mobile2.R;
import net.common.android.common.HttpUtil;
import net.common.android.common.MyBackAsynaTask;
import net.common.android.model.Dormitory;
import net.common.android.model.EmployeeList;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * @author KingKong·HE
 * @Time 2014-1-6 下午12:06:09
 */
public class DormListViewAdapter extends BaseAdapter{
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<Dormitory> goodsLists;
	public DormListViewAdapter(Context context) {
		this.context = context;
		this.inflater = LayoutInflater.from(context);
	}
	@Override
	public int getCount() {
		return goodsLists == null ? 0 : goodsLists.size();
	}

	@Override
	public Object getItem(int position) {
		return goodsLists.get(position);
	}
	
	@Override
	public long getItemId(int position) {
		return position;
	}

	
	public ArrayList<Dormitory> getGoodsLists() {
		return goodsLists;
	}
	
	public void setGoodsLists(ArrayList<Dormitory> goodsLists) {
		this.goodsLists = goodsLists;
	}
	
	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		ViewHolder holder;
		Dormitory bean= goodsLists.get(position);
		if (null == convertView) {
			convertView = inflater.inflate(R.layout.listivew_dorm_item, null);
			holder = new ViewHolder();
			holder.textName = (TextView) convertView.findViewById(R.id.textName);
			holder.textTel = (TextView) convertView.findViewById(R.id.textTel);
			holder.textMail = (TextView) convertView.findViewById(R.id.textMail);
			holder.textJob = (TextView) convertView.findViewById(R.id.textJob);
			holder.textDept = (TextView) convertView.findViewById(R.id.textDept);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		
		holder.textName.setText("宿舍号:"+bean.getDormitory_no());
		holder.textTel.setText("容纳人数:"+bean.getCapacity());
		holder.textMail.setText("入住人数:"+bean.getCurrent_no());
		holder.textJob.setText("备注:"+bean.getBeizhu());
//		holder.textDept.setText("年龄:"+bean.getDept());
		holder.textDept.setVisibility(View.GONE);
		
		return convertView;
	}
	class ViewHolder {
		TextView textName;
		TextView textTel;
		TextView textMail;
		TextView textJob;
		TextView textDept;
	}
}
