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
public class TypeNext {
		public static class Attr{
			public static final String GC_ID = "gc_id";
			public static final String GC_NAME = "gc_name";
		}
		private String gc_id;
		private String gc_name;
		
		public TypeNext() {
		}
		
		public TypeNext(String gc_id, String gc_name) {
			super();
			this.gc_id = gc_id;
			this.gc_name = gc_name;
		}


		public static ArrayList<TypeNext> newInstanceList(String jsonDatas){
			ArrayList<TypeNext> typeList = new ArrayList<TypeNext>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String gc_id = obj.optString(Attr.GC_ID);
					String gc_name = obj.optString(Attr.GC_NAME);
					TypeNext t=new TypeNext(gc_id, gc_name);
					typeList.add(t);
					System.out.println("t-->"+t.toString());
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return typeList;
		}


		public String getGc_id() {
			return gc_id;
		}


		public void setGc_id(String gc_id) {
			this.gc_id = gc_id;
		}


		public String getGc_name() {
			return gc_name;
		}


		public void setGc_name(String gc_name) {
			this.gc_name = gc_name;
		}

		@Override
		public String toString() {
			return "Type [gc_id=" + gc_id + ", gc_name=" + gc_name + "]";
		}

}
