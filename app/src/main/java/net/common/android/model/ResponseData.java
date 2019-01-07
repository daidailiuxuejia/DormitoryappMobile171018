package net.common.android.model;


/**
 * 响应数据
 * @author hjgang
 */
public class ResponseData {
	
	public static final class Attr{
		public static final String CODE = "code";
		public static final String HASMORE = "hasmore";
		public static final String JSON = "json";
		public static final String RESULT = "result";
		public static final String COUNT = "count";
		public static final String LOGIN = "login";
	}
	
	/** 状态码:200 | 304 | 404 | 500 */
	private int code;
	/** 是否有下一页 */
	private boolean hasMore;
	/** JSON格式的字符串 */
	private String json;
	/** 字符串结果 */
	private String result;
	/** 总记录数 */
	private long count;
	
	private int login = -1;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public boolean isHasMore() {
		return hasMore;
	}
	public void setHasMore(boolean hasMore) {
		this.hasMore = hasMore;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	
	public int getLogin() {
		return login;
	}
	public void setLogin(int login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return "ResponseData [code=" + code + ", hasMore=" + hasMore
				+ ", json=" + json + ", result=" + result + ", count=" + count
				+ "]";
	}
}
