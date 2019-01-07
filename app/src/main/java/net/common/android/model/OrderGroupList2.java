/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:AdvertList.java
 */
package net.common.android.model;

import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class OrderGroupList2 {
		public static class Attr{
			public static final String PAY_SN = "pay_sn";
			public static final String ORDER_LIST = "order_list";
			public static final String PAY_AMOUNT = "pay_amount";
			public static final String ADD_TIME = "add_time";
		}
		private String pay_sn;
		private String order_list;
		private String pay_amount;
		private String add_time;
		
		public OrderGroupList2() {
		}
		
		public OrderGroupList2(String pay_sn, String order_list,
				String pay_amount, String add_time) {
			super();
			this.pay_sn = pay_sn;
			this.order_list = order_list;
			this.pay_amount = pay_amount;
			this.add_time = add_time;
		}

		public static ArrayList<OrderGroupList2> newInstanceList(String jsonDatas){
			ArrayList<OrderGroupList2> AdvertDatas = new ArrayList<OrderGroupList2>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String pay_sn = obj.optString(Attr.PAY_SN);
					String order_list = obj.optString(Attr.ORDER_LIST);
					String pay_amount = obj.optString(Attr.PAY_AMOUNT);
					String add_time = obj.optString(Attr.ADD_TIME);
					AdvertDatas.add(new OrderGroupList2(pay_sn, order_list, pay_amount, add_time));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}

		public String getPay_sn() {
			return pay_sn;
		}

		public void setPay_sn(String pay_sn) {
			this.pay_sn = pay_sn;
		}

		public String getOrder_list() {
			return order_list;
		}

		public void setOrder_list(String order_list) {
			this.order_list = order_list;
		}

		public String getPay_amount() {
			return pay_amount;
		}

		public void setPay_amount(String pay_amount) {
			this.pay_amount = pay_amount;
		}

		public String getAdd_time() {
			return add_time;
		}

		public void setAdd_time(String add_time) {
			this.add_time = add_time;
		}

		@Override
		public String toString() {
			return "OrderGroupList2 [pay_sn=" + pay_sn + ", order_list="
					+ order_list + ", pay_amount=" + pay_amount + ", add_time="
					+ add_time + "]";
		}


}
