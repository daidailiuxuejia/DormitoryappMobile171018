package net.common.android.model;

import java.util.List;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;

@Table(name ="shopnc_search")
public class Search extends Model{
	
	public Search() {
	}
	
	public Search(String searchKeyWord) {
		super();
		this.searchKeyWord = searchKeyWord;
	}

	@Column(name = "searchID")
	public int searchID;
	
	@Column(name = "searchKeyWord")
	public String searchKeyWord;
	
	@Override
	public String toString() {
		return "Search [searchID=" + searchID + ", searchKeyWord="
				+ searchKeyWord + "]";
	}

	/**
	 * 保存历史搜索
	 * */
	public static void searchSava(Search bean){
		Search s = new Search();
		s =bean;
		s.save();
	}
	
	/**
	 * 查询所有历史搜索
	 * */
	public static List<Search> searchQueryList(){
		return new Select().from(Search.class).orderBy("searchKeyWord desc").execute();
	}
	
	/**
	 * 删除全部历史搜索
	 * */
	public static void deleteAll(){
		new Delete().from(Search.class).execute();
	}
}
