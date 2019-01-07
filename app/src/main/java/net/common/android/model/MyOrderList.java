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

public class MyOrderList {

	/**
	 * private String orderdate; private String username; private float price;
	 * private String goods_name; private String goods_image; private String
	 * address; private int status;
	 *
	 */
	public static class Attr {
		public static final String ORDER_ID = "id";
		public static final String ORDER_DATE = "orderdate";
		public static final String ORDER_USER = "username";
		public static final String ORDER_PRICE = "price";
		public static final String ORDER_GOODS = "goods_name";
		public static final String ORDER_GOODSIMAGE = "goods_image";
		public static final String ORDER_ADDRESS = "address";
		public static final String ORDER_STATUS = "status";

		@Override
		public String toString() {
			return "Attr [getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}

	}

	private String orderdate; // 发布日期
	private int id;
	private String username; // 心愿类型
	private double price; // 心愿标题
	private String goods_name; // 心愿内容
	private String goods_image; // 是否已完成
	private String address; // 是否已完成
	private int status; // 是否已评价

	public MyOrderList(String orderdate, String username, double price,
			String goods_name, String goods_image, String address, int status,int id) {
		super();
		this.orderdate = orderdate;
		this.username = username;
		this.price = price;
		this.goods_name = goods_name;
		this.goods_image = goods_image;
		this.address = address;
		this.status = status;
		this.id=id;
	}

	public MyOrderList() {
	}

	/**
	 * private int id; //id private int userid; //发布用户id private String pubdate;
	 * //发布日期 private String wishtype; //心愿类型 private String wishtitle; //心愿标题
	 * private String content; //心愿内容 private int isfinished; //是否已完成 private
	 * int isevaluated; //是否已评价
	 * theme_id,theme_name,theme_content,theme_likecount
	 * ,theme_commentcount,member_id,member_name,member_avatar
	 * 
	 * 
	 * 
	 * public static final String WISH_ID = "id"; public static final String
	 * WISH_USERID = "userid"; public static final String WISH_PUBDATE =
	 * "pubdate"; public static final String WISH_TYPE = "wishtype"; public
	 * static final String WISH_TITLE = "wishtitle"; public static final String
	 * WISH_CONTENT= "content"; public static final String WISH_ISFINISHED=
	 * "isfinished"; public static final String WISH_ISEVALUTATED=
	 * "isevaluated";
	 * 
	 * @param jsonDatas
	 * @return
	 */

	public static ArrayList<MyOrderList> newInstanceList(String jsonDatas) {
		ArrayList<MyOrderList> AdvertDatas = new ArrayList<MyOrderList>();

		try {
			JSONArray arr = new JSONArray(jsonDatas);
			int size = null == arr ? 0 : arr.length();
			System.out.println("size-->" + size);
			for (int i = 0; i < size; i++) {
				JSONObject obj = arr.getJSONObject(i);
				int id =obj.optInt("id");
				String orderdate = obj.optString(Attr.ORDER_DATE); // 发布日期
				String username = obj.optString(Attr.ORDER_USER); // 心愿类型
				Double price = obj.optDouble(Attr.ORDER_PRICE);
				; // 心愿标题
				String goods_name = obj.optString(Attr.ORDER_GOODS); // 心愿内容
				String goods_image = obj.optString(Attr.ORDER_GOODSIMAGE); // 是否已完成
				String address = obj.optString(Attr.ORDER_ADDRESS); // 是否已完成
				int status = obj.optInt(Attr.ORDER_STATUS); // 是否已评价

				MyOrderList bean = new MyOrderList(orderdate, username, price,
						goods_name, goods_image, address, status,id);
				AdvertDatas.add(bean);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return AdvertDatas;
	}

	public String getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public String getGoods_image() {
		return goods_image;
	}

	public void setGoods_image(String goods_image) {
		this.goods_image = goods_image;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	
}
