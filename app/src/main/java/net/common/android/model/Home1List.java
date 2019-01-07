/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:Home1List.java
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
public class Home1List {
		public static class Attr{
			public static final String IMAGE = "image";
			public static final String TITLE = "title";
			public static final String DESC = "desc";
			public static final String KEYWORD = "keyword";
			public static final String KEYWORD1 = "keyword1";
		}
		private String image;
		private String title;
		private String desc;
		private String keyword;
		private String keyword1;
		
		public Home1List() {
		}
		
		public Home1List(String image, String title, String desc,
				String keyword, String keyword1) {
			super();
			this.image = image;
			this.title = title;
			this.desc = desc;
			this.keyword = keyword;
			this.keyword1 = keyword1;
		}

		public static ArrayList<Home1List> newInstanceList(String jsonDatas){
			ArrayList<Home1List> AdvertDatas = new ArrayList<Home1List>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String image = obj.optString(Attr.IMAGE);
					String title = obj.optString(Attr.TITLE);
					String desc = obj.optString(Attr.DESC);
					String keyword = obj.optString(Attr.KEYWORD);
					String keyword1 = obj.optString(Attr.KEYWORD1);
					AdvertDatas.add(new Home1List(image, title, desc, keyword, keyword1));
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return AdvertDatas;
		}


		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDesc() {
			return desc;
		}

		public void setDesc(String desc) {
			this.desc = desc;
		}

		public String getKeyword() {
			return keyword;
		}

		public void setKeyword(String keyword) {
			this.keyword = keyword;
		}

		public String getKeyword1() {
			return keyword1;
		}

		public void setKeyword1(String keyword1) {
			this.keyword1 = keyword1;
		}

		@Override
		public String toString() {
			return "Home1List [image=" + image + ", title=" + title + ", desc="
					+ desc + ", keyword=" + keyword + ", keyword1=" + keyword1
					+ "]";
		}

}
