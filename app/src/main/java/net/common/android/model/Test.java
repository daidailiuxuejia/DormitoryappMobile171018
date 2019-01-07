/**
 * ProjectName:AndroidShopNC2014Moblie
 * PackageName:net.shopnc.android.model
 * FileNmae:Test.java
 */
package net.common.android.model;

/**
 * @author KingKong·HE
 * @Time 2014-1-14 上午10:25:32
 */
public class Test {
	
	public Test() {
	}

	public Test(String name) {
		super();
		this.name = name;
	}

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Test [name=" + name + "]";
	}
	
	

}
