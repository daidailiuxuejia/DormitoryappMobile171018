/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:AddressDetails.java
 */
package net.common.android.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * @author KingKong·HE
 * @Time 2014年1月17日 下午4:44:35
 */
public class UpdateAddress {
		public static class Attr{
			public static final String ALLOW_OFFPAY = "allow_offpay";
			public static final String CONTENT = "content";
			public static final String OFFPAY_HASH = "offpay_hash";
		}
		
		private String allow_offpay;
		private String content;
		private String offpay_hash;
		
		public UpdateAddress() {
		}


		public UpdateAddress(String allow_offpay, String content,
				String offpay_hash) {
			super();
			this.allow_offpay = allow_offpay;
			this.content = content;
			this.offpay_hash = offpay_hash;
		}


		public static UpdateAddress  newInstanceList(String json){
			UpdateAddress bean = null;
			try {
				JSONObject obj = new JSONObject(json);
				if(obj.length()> 0){
					String allow_offpay = obj.optString(Attr.ALLOW_OFFPAY);
					String content = obj.optString(Attr.CONTENT);
					String offpay_hash = obj.optString(Attr.OFFPAY_HASH);
					bean = new UpdateAddress(allow_offpay, content, offpay_hash);
					System.out.println("bean-->"+bean.toString());
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return bean;
		}


		public String getAllow_offpay() {
			return allow_offpay;
		}


		public void setAllow_offpay(String allow_offpay) {
			this.allow_offpay = allow_offpay;
		}


		public String getContent() {
			return content;
		}


		public void setContent(String content) {
			this.content = content;
		}


		public String getOffpay_hash() {
			return offpay_hash;
		}


		public void setOffpay_hash(String offpay_hash) {
			this.offpay_hash = offpay_hash;
		}


		@Override
		public String toString() {
			return "UpdateAddress [allow_offpay=" + allow_offpay + ", content="
					+ content + ", offpay_hash=" + offpay_hash + "]";
		}

}
