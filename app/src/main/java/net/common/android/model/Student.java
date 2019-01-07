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
public class Student {
		public static class Attr{
			public static final String DORM_ID = "id";
			public static final String DORM_NAME= "name";
			public static final String DORM_XUEHAO = "xuehao";
			public static final String DORM_CLASS = "class_name";
			public static final String DORM_LOUHAO = "louhao";
			public static final String DORM_DORM = "dormitory_name";
		}
		private String id;
		private String name;
		private String xuehao;
		private String class_name;
		private String dormitory_name;
		private String louhao;
		







public Student(String id, String name, String xuehao,
				String class_name, String dormitory_name,String louhao) {
			super();
			this.id = id;
			this.name = name;
			this.xuehao = xuehao;
			this.class_name = class_name;
			this.dormitory_name = dormitory_name;
			this.louhao = louhao;
		}



//		public Attr(String id, String nickname, String phonenum) {
		public static ArrayList<Student> newInstanceList(String jsonDatas){
			ArrayList<Student> AdvertDatas = new ArrayList<Student>();
			
			try {
				JSONArray arr = new JSONArray(jsonDatas);
				int size = null == arr ? 0 : arr.length();
				System.out.println("size-->" + size);
				for(int i = 0; i < size; i++){
					JSONObject obj = arr.getJSONObject(i);
					String id = obj.optString(Attr.DORM_ID);
					String name = obj.optString(Attr.DORM_NAME);
					String xuehao = obj.optString(Attr.DORM_XUEHAO);
					String class_name = obj.optString(Attr.DORM_CLASS);
					String dormitory_name = obj.optString(Attr.DORM_DORM);
					String louhao = obj.optString(Attr.DORM_LOUHAO);
					Student bean =new Student(id, name, xuehao,class_name,dormitory_name,louhao);
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



		public String getXuehao() {
			return xuehao;
		}



		public void setXuehao(String xuehao) {
			this.xuehao = xuehao;
		}



		public String getClass_name() {
			return class_name;
		}



		public void setClass_name(String class_name) {
			this.class_name = class_name;
		}



		public String getDormitory_name() {
			return dormitory_name;
		}



		public void setDormitory_name(String dormitory_name) {
			this.dormitory_name = dormitory_name;
		}



		public String getLouhao() {
			return louhao;
		}



		public void setLouhao(String louhao) {
			this.louhao = louhao;
		}







		

}
