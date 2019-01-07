package net.common.android.ui.custom;

import java.util.ArrayList;
import net.cangshengwang.android.mobile2.R;
import net.common.android.model.Test;
import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * 顶部滑动菜单布局设置
 * 
 * @Description: 顶部滑动菜单布局设置
 * 
 * @FileName: SlideMenuLayout.java
 * 
 * @Package com.slide.menu
 * 
 * @Author Hanyonglu
 * 
 * @Date 2012-4-20 上午11:17:31
 * 
 * @Version V1.0
 */
public class RecommendedGoodsLayout {
	// 包含菜单的ArrayList
	private ArrayList<View> menuList = null;

	private Activity activity;

	public RecommendedGoodsLayout(Activity activity) {
		this.activity = activity;
		menuList = new ArrayList<View>();
	}

	/**
	 * 顶部滑动菜单布局
	 * 
	 * @param menuTextViews
	 * @param layoutWidth
	 */
	public View getSlideMenuLinerLayout(Object[] menuTextViews, int layoutWidth) {
		// 包含TextView的LinearLayout
		LinearLayout menuLinerLayout = new LinearLayout(activity);
		menuLinerLayout.setOrientation(LinearLayout.HORIZONTAL);

		// 参数设置
		LinearLayout.LayoutParams menuLinerLayoutParames = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT,
				LinearLayout.LayoutParams.WRAP_CONTENT, 1);
		menuLinerLayoutParames.gravity = Gravity.CENTER_HORIZONTAL;
		// 参数设置
		LinearLayout.LayoutParams childLinerLayoutParames = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		// 添加TextView控件
		for (int i = 0; i < menuTextViews.length; i++) {
			LinearLayout linearLayout = new LinearLayout(activity);
			linearLayout.setGravity(Gravity.CENTER);
			linearLayout.setOrientation(LinearLayout.VERTICAL);
			linearLayout.setPadding(5, 5, 5, 0);
			ImageView imageView = new ImageView(activity);
			imageView.setLayoutParams(childLinerLayoutParames);
			imageView.setBackgroundResource(R.drawable.test_photo04);

			Test abc =  (Test) menuTextViews[i];
			if (abc != null) {
				TextView tvMenu = new TextView(activity);
				tvMenu.setLayoutParams(childLinerLayoutParames);
				tvMenu.setPadding(5, 0, 5, 0);
				tvMenu.setText(abc.getName());
				tvMenu.setTextColor(Color.rgb(144, 144, 144));
				tvMenu.setGravity(Gravity.CENTER);
				tvMenu.setMaxLines(2);

				TextView tMenu = new TextView(activity);
				tMenu.setLayoutParams(childLinerLayoutParames);
				tMenu.setPadding(5, 5, 5, 0);
				tMenu.setText("$15.50");
				tMenu.setTextColor(Color.rgb(155, 33, 12));
				tMenu.setGravity(Gravity.CENTER);


				linearLayout.addView(imageView, new LinearLayout.LayoutParams(150,150));
				linearLayout.addView(tvMenu, childLinerLayoutParames);
				linearLayout.addView(tMenu, childLinerLayoutParames);
				menuLinerLayout.addView(linearLayout, menuLinerLayoutParames);

				menuList.add(menuLinerLayout);
			}
		}

		return menuLinerLayout;
	}

	// 单个菜单事件
	OnClickListener SlideMenuOnClickListener = new OnClickListener() {

		@Override
		public void onClick(View v) {
			String menuTag = v.getTag().toString();
			if (v.isClickable()) {
				for (int i = 0; i < menuList.size(); i++) {
					// if(!menuTag.equals(menuList.get(i).getText())){
					// menuList.get(i).setBackgroundDrawable(null);
					// }
				}
			}
		}
	};
}