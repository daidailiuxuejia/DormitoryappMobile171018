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
public class ArticleList2 {
		public static class Attr{
			public static final String TYPE_ID = "id";
			public static final String TYPE_SUDENTNO = "studentno";
			public static final String TYPE_CONTENT = "conent";
		
		}
		private String id;
		private String content;
		private String studentno;
		
		public ArticleList2() {
		}
		







		public ArticleList2(String id, String content, String studentno) {
			super();
			this.id = id;
			this.content = content;
			this.studentno = studentno;
		}








		public static ArrayList<ArticleList2> newInstanceList(String jsonDatas){
			ArrayList<ArticleList2> AdvertDatas = new ArrayList<ArticleList2>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.TYPE_ID);
					String content = obj.optString(Attr.TYPE_CONTENT);
					String studentno = obj.optString(Attr.TYPE_SUDENTNO);
					ArticleList2 bean =new ArticleList2(id,content,studentno);
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








		public String getContent() {
			return content;
		}








		public void setContent(String content) {
			this.content = content;
		}








		public String getStudentno() {
			return studentno;
		}








		public void setStudentno(String studentno) {
			this.studentno = studentno;
		}









		

}
