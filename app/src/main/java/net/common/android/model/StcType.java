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
public class StcType {
		public static class Attr{
			public static final String GC_ID = "stc_id";
			public static final String GC_NAME = "stc_name";
			public static final String IMAGE = "image";
			public static final String TEXT = "text";
		}
		private String gc_id;
		private String gc_name;
		private String image;
		private String text;
		
		public StcType() {
		}
		
		public StcType(String gc_id, String gc_name, String image, String text) {
			super();
			this.gc_id = gc_id;
			this.gc_name = gc_name;
			this.image = image;
			this.text = text;
		}


		public static ArrayList<StcType> newInstanceList(String jsonDatas){
			ArrayList<StcType> typeList = new ArrayList<StcType>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String gc_id = obj.optString(Attr.GC_ID);
					String gc_name = obj.optString(Attr.GC_NAME);
					String image = obj.optString(Attr.IMAGE);
					String text = obj.optString(Attr.TEXT);
					StcType t=new StcType(gc_id, gc_name, image, text);
					typeList.add(t);
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


		public String getImage() {
			return image;
		}


		public void setImage(String image) {
			this.image = image;
		}


		public String getText() {
			return text;
		}


		public void setText(String text) {
			this.text = text;
		}


		@Override
		public String toString() {
			return "StcType [gc_id=" + gc_id + ", gc_name=" + gc_name + ", image="
					+ image + ", text=" + text + "]";
		}

}
