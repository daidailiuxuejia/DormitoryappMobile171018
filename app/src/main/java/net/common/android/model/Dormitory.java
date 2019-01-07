/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:GoodsList.java
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
public class Dormitory {
		public static class Attr{
			public static final String DORM_ID = "id";
			public static final String DORM_NO = "dormitory_no";
			public static final String DORM_BEIZHU = "beizhu";
			public static final String DORM_CAPA = "capacity";
			public static final String DORM_CURR_NO = "current_no";
		}
		private String id;
		private String dormitory_no;
		private String beizhu;
		private String capacity;
		private String current_no;
		







public Dormitory(String id, String dormitory_no, String beizhu,
				String capacity, String current_no) {
			super();
			this.id = id;
			this.dormitory_no = dormitory_no;
			this.beizhu = beizhu;
			this.capacity = capacity;
			this.current_no = current_no;
		}



//		public Attr(String id, String nickname, String phonenum) {
		public static ArrayList<Dormitory> newInstanceList(String jsonDatas){
			ArrayList<Dormitory> AdvertDatas = new ArrayList<Dormitory>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.DORM_ID);
					String dormitory_no = obj.optString(Attr.DORM_NO);
					String beizhu = obj.optString(Attr.DORM_BEIZHU);
					String capacity = obj.optString(Attr.DORM_CAPA);
					String current_no = obj.optString(Attr.DORM_CURR_NO);
					Dormitory bean =new Dormitory(id, dormitory_no, beizhu,capacity,current_no);
					//System.out.println("goodlist-->" + bean.toString());
					AdvertDatas.add(bean);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}



		public String getId() {
			return id;
		}



		public void setId(String id) {
			this.id = id;
		}



		public String getDormitory_no() {
			return dormitory_no;
		}



		public void setDormitory_no(String dormitory_no) {
			this.dormitory_no = dormitory_no;
		}



		public String getBeizhu() {
			return beizhu;
		}



		public void setBeizhu(String beizhu) {
			this.beizhu = beizhu;
		}



		public String getCapacity() {
			return capacity;
		}



		public void setCapacity(String capacity) {
			this.capacity = capacity;
		}



		public String getCurrent_no() {
			return current_no;
		}



		public void setCurrent_no(String current_no) {
			this.current_no = current_no;
		}









		

}
