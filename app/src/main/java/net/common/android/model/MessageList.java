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
public class MessageList {
		public static class Attr{
			public static final String GOODS_ID = "id";
			public static final String GOODS_NAME = "name";
			public static final String GOODS_TIME = "uptimestr";
		}
		private String id;
		private String name;
		private String uptimestr;
		





















		public MessageList(String id, String name, String uptimestr
				) {
			super();
			this.id = id;
			this.name = name;
			this.uptimestr = uptimestr;
		}







		//		String id, String name, String sickname,String bodylevel
		public static ArrayList<MessageList> newInstanceList(String jsonDatas){
			ArrayList<MessageList> AdvertDatas = new ArrayList<MessageList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.GOODS_ID);
					String name = obj.optString(Attr.GOODS_NAME);
					String updatetime = obj.optString(Attr.GOODS_TIME);
					MessageList bean =new MessageList(id, name, updatetime);
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







		public String getName() {
			return name;
		}







		public void setName(String name) {
			this.name = name;
		}







		public String getUptimestr() {
			return uptimestr;
		}







		public void setUptimestr(String uptimestr) {
			this.uptimestr = uptimestr;
		}





















		

}
