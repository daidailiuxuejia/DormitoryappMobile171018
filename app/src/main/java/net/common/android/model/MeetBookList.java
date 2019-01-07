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
public class MeetBookList {
		public static class Attr{
			public static final String GOODS_ID = "id";
			public static final String GOODS_NAME = "roomname";
			public static final String GOODS_STATUS = "status";
			public static final String GOODS_START = "starttimestr";
			public static final String GOODS_END = "endtimestr";
		}
		private String id;
		private String roomname;
		private String starttimestr;
		private String endtimestr;
		private String status;
		


		public MeetBookList(String id, String roomname, String starttimestr,
				String endtimestr,String status) {
			super();
			this.id = id;
			this.roomname = roomname;
			this.starttimestr = starttimestr;
			this.endtimestr = endtimestr;
			this.status = status;
		}



		//		String id, String name, String sickname,String bodylevel
		public static ArrayList<MeetBookList> newInstanceList(String jsonDatas){
			ArrayList<MeetBookList> AdvertDatas = new ArrayList<MeetBookList>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.GOODS_ID);
					String name = obj.optString(Attr.GOODS_NAME);
					String start = obj.optString(Attr.GOODS_START);
					String end = obj.optString(Attr.GOODS_END);
					String status = obj.optString(Attr.GOODS_STATUS);
					MeetBookList bean =new MeetBookList(id, name, start,end,status);
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



		public String getRoomname() {
			return roomname;
		}



		public void setRoomname(String roomname) {
			this.roomname = roomname;
		}



		public String getStarttimestr() {
			return starttimestr;
		}



		public void setStarttimestr(String starttimestr) {
			this.starttimestr = starttimestr;
		}



		public String getEndtimestr() {
			return endtimestr;
		}



		public void setEndtimestr(String endtimestr) {
			this.endtimestr = endtimestr;
		}



		public String getStatus() {
			return status;
		}



		public void setStatus(String status) {
			this.status = status;
		}












		

}
