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
 * @author KingKong��HE
 * @Time 2014��1��17�� ����4:44:35
 */
public class FriendBean {
		public static class Attr{
			public static final String TYPE_ID = "id";
			public static final String TYPE_NAME = "name";
			public static final String TYPE_QQ = "qqnum";
			public static final String TYPE_PHONE = "phone";
			public static final String TYPE_ADDRESS = "address";
			public static final String TYPE_IMAGE = "image_url";
			public static final String TYPE_STATUS = "status";
			public static final String TYPE_TYPE = "type";
		
		}
		private String id;
		private String name;
		private String qqnum;
		private String phone;
		private String address;
		private String image_url;
		private String status;
		private String type;
		
		public FriendBean() {
		}
		





		public FriendBean(String id, String name, String qqnum, String phone,
				String address,String image_url,String status,String type) {
			super();
			this.id = id;
			this.name = name;
			this.qqnum = qqnum;
			this.phone = phone;
			this.address = address;
			this.image_url = image_url;
			this.status = status;
			this.type = type;
		}






		public static ArrayList<FriendBean> newInstanceList(String jsonDatas){
			ArrayList<FriendBean> AdvertDatas = new ArrayList<FriendBean>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String type_id = obj.optString(Attr.TYPE_ID);
					String name = obj.optString(Attr.TYPE_NAME);
					String qq = obj.optString(Attr.TYPE_QQ);
					String phone = obj.optString(Attr.TYPE_PHONE);
					String address = obj.optString(Attr.TYPE_ADDRESS);
					String image_url = obj.optString(Attr.TYPE_IMAGE);
					String status = obj.optString(Attr.TYPE_STATUS);
					String type = obj.optString(Attr.TYPE_TYPE);
					FriendBean bean =new FriendBean(type_id,name,qq,phone,address,image_url,status,type);
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






		public String getName() {
			return name;
		}






		public String getType() {
			return type;
		}






		public void setType(String type) {
			this.type = type;
		}






		public void setName(String name) {
			this.name = name;
		}






		public String getQqnum() {
			return qqnum;
		}






		public void setQqnum(String qqnum) {
			this.qqnum = qqnum;
		}






		public String getPhone() {
			return phone;
		}






		public void setPhone(String phone) {
			this.phone = phone;
		}






		public String getAddress() {
			return address;
		}






		public void setAddress(String address) {
			this.address = address;
		}






		public String getImage_url() {
			return image_url;
		}






		public void setImage_url(String image_url) {
			this.image_url = image_url;
		}






		public String getStatus() {
			return status;
		}






		public void setStatus(String status) {
			this.status = status;
		}



		

}
