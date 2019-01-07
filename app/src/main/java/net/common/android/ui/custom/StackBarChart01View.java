/**
 * Copyright 2014  XCL-Charts
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * 	
 * @Project XCL-Charts 
 * @Description Android图表基类库
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 * @Copyright Copyright (c) 2014 XCL-Charts (www.xclcharts.com)
 * @license http://www.apache.org/licenses/  Apache v2 License
 * @version 1.0
 */
package net.common.android.ui.custom;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.xclcharts.chart.BarData;
import org.xclcharts.chart.StackBarChart;
import org.xclcharts.common.DensityUtil;
import org.xclcharts.common.IFormatterDoubleCallBack;
import org.xclcharts.common.IFormatterTextCallBack;
import org.xclcharts.renderer.XChart;
import org.xclcharts.renderer.XEnum;


import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
/**
 * @ClassName StackBarChart01View
 * @Description  堆叠图 的例子
 * @author XiongChuanLiang<br/>(xcl_168@aliyun.com)
 */
public class StackBarChart01View extends DemoView {
	
	private String TAG = "StackBarChart01View";
	private StackBarChart chart = new StackBarChart();
	//标签轴
	List<String> chartLabels = new LinkedList<String>();
	List<BarData> BarDataSet = new LinkedList<BarData>();
	
	Paint pToolTip = new Paint(Paint.ANTI_ALIAS_FLAG);
	private List<Map<String, Object>> oList=new ArrayList<Map<String,Object>>();

	public StackBarChart01View(Context context,List<Map<String, Object>> oList) {
		super(context);
		// TODO Auto-generated constructor stub
		this.oList=oList;
		initView();
	}
	
	public StackBarChart01View(Context context, AttributeSet attrs){   
        super(context, attrs);   
        initView();
	 }
	 
	 public StackBarChart01View(Context context, AttributeSet attrs, int defStyle) {
			super(context, attrs, defStyle);
			initView();
	 }
	 
	 private void initView()
	 {
		 chartLabels();
		 chartDataSet();	
		 chartRender();
	 }
	 
	
	@Override  
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {  
        super.onSizeChanged(w, h, oldw, oldh);  
       //图所占范围大小
        chart.setChartRange(w,h);
    }  				
	
	
	private void chartRender()
	{
		try {
			
			//设置绘图区默认缩进px值,留置空间显示Axis,Axistitle....		
			int [] ltrb = getBarLnDefaultSpadding();
			chart.setPadding(ltrb[0], ltrb[1], ltrb[2], DensityUtil.dip2px(getContext(), 55));	
			
			//显示边框
//			chart.showRoundBorder();			
			chart.setChartDirection(XEnum.Direction.VERTICAL);
			//数据源		
			chart.setCategories(chartLabels);	
			chart.setDataSource(BarDataSet);
			
			//坐标系
			chart.getDataAxis().setAxisMax(50);
			chart.getDataAxis().setAxisMin(0);
			chart.getDataAxis().setAxisSteps(3);
			//指定数据轴标签旋转-45度显示
//			chart.getCategoryAxis().setTickLabelRotateAngle(-20f);	
			Paint labelPaint = chart.getCategoryAxis().getTickLabelPaint();			
			labelPaint.setTextAlign(Align.CENTER);
			labelPaint.setTextSize(15);
//			labelPaint.setTextScaleX(30);
			labelPaint.setColor(Color.rgb(255, 0, 0));
			
			//标题
//			chart.setTitle("文件服务器空间使用情况");
//			chart.addSubtitle("(XCL-Charts Demo)");
			chart.setTitleAlign(XEnum.HorizontalAlign.CENTER);
			chart.setTitleVerticalAlign(XEnum.VerticalAlign.MIDDLE);
			
			//轴标题
//			chart.getAxisTitle().setLeftTitle("单位(TB)");
			
			//背景网格
			chart.getPlotGrid().showEvenRowBgColor();
			chart.getPlotGrid().showOddRowBgColor();
			
			//定义数据轴标签显示格式
			chart.getDataAxis().setLabelFormatter(new IFormatterTextCallBack(){
	
				@Override
				public String textFormatter(String value) {
					
					DecimalFormat df=new DecimalFormat("#0");
					Double tmp = Double.parseDouble(value);
					String label = df.format(tmp).toString();	
					return label;
				}
				
			});
			
			//定义标签轴标签显示格式
			chart.getCategoryAxis().setLabelFormatter(new IFormatterTextCallBack(){
	
				@Override
				public String textFormatter(String value) {
					// TODO Auto-generated method stub				
					String label = value;
					return label;
				}
				
			});
					
			//定义柱形上标签显示格式
			chart.getBar().setItemLabelVisible(true);
			//更改柱状图显示的数据格式
			chart.setItemLabelFormatter(new IFormatterDoubleCallBack() {
				@Override
				public String doubleFormatter(Double value) {
					DecimalFormat df=new DecimalFormat("#0");					 
					String label = df.format(value).toString();
					return label;
				}});	     
			
			//定义柱形上标签显示颜色
			chart.getBar().getItemLabelPaint().setColor(Color.rgb(77, 184, 73));
			//字体粗体
			chart.getBar().getItemLabelPaint().setTypeface(Typeface.DEFAULT_BOLD);
			
			//激活点击监听
			chart.ActiveListenItemClick();
			chart.showClikedFocus();
			chart.setPlotPanMode(XEnum.PanMode.HORIZONTAL);
			
			chart.setBarCenterStyle(XEnum.BarCenterStyle.TICKMARKS);
			
			//chart.disablePanMode();
				
		} catch (Exception e) {
			// TODO Auto-generated catch block
			Log.e(TAG, e.toString());
		}
	}
	private void chartDataSet()
	{
		//标签1对应的柱形数据集
		//更改为投票数
		List<Double> dataSeriesA= new LinkedList<Double>();	
//		dataSeriesA.add((double)12);
//		dataSeriesA.add((double) 4);
//		dataSeriesA.add((double) 5);
//		dataSeriesA.add((double) 75);
		for (int i = 0; i < oList.size(); i++) {
			Double j=(Double) oList.get(i).get("count_");
			dataSeriesA.add(j );
		}

//		List<Double> dataSeriesB= new LinkedList<Double>();	
//		dataSeriesB.add((double)0);
//		dataSeriesB.add((double)0); 
//		dataSeriesB.add(0.0); 

		
		BarDataSet.add(new BarData("成绩分析表",dataSeriesA,Color.rgb(0, 0,255)));
//		BarDataSet.add(new BarData("空闲空间",dataSeriesB,Color.rgb(255, 0, 0)));
	}
	private void chartLabels()
	{
//		chartLabels.add("北京");
//		chartLabels.add("厦门");
//		chartLabels.add("三亚");
//		chartLabels.add("三亚");
		for (int i = 0; i < oList.size(); i++) {
			chartLabels.add((String)oList.get(i).get("name_")); 
		}
		 
	}

	@Override
    public void render(Canvas canvas) {
        try{
        	
        	//chart.setChartRange(this.getMeasuredWidth(), this.getMeasuredHeight());
            chart.render(canvas);
        } catch (Exception e){
        	Log.e(TAG, e.toString());
        }
    }

	@Override
	public List<XChart> bindChart() {
		// TODO Auto-generated method stub		
		List<XChart> lst = new ArrayList<XChart>();
		lst.add(chart);		
		return lst;
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub		
		super.onTouchEvent(event);		
		if(event.getAction() == MotionEvent.ACTION_UP) 
		{		
//			triggerClick(event.getX(),event.getY());
		}
		return true;
	}
	
	
	//触发监听
//	private void triggerClick(float x,float y)
//	{
//		
//		BarPosition record = chart.getPositionRecord(x,y);			
//		if( null == record) return;
//		
//		if(record.getDataID() >= BarDataSet.size()) return;
//		BarData bData = BarDataSet.get(record.getDataID());		
//		
//		int cid = record.getDataChildID();
//		Double bValue = bData.getDataSet().get(cid);	
//		String label = chartLabels.get(cid);		
//		
//		chart.showFocusRectF(record.getRectF());		
//		chart.getFocusPaint().setStyle(Style.FILL);
//		chart.getFocusPaint().setStrokeWidth(3);		
//		chart.getFocusPaint().setColor(Color.GREEN);	
//		chart.getFocusPaint().setAlpha(100);
//		
//		//在点击处显示tooltip
//		pToolTip.setColor(Color.WHITE);		
//		chart.getToolTip().setAlign(Align.CENTER);
//		chart.getToolTip().setInfoStyle(XEnum.DyInfoStyle.CIRCLE);
//		chart.getToolTip().getBackgroundPaint().setColor(Color.BLACK);
//		
//		//chart.getToolTip().setCurrentXY(record.getRectF().centerX(),record.getRectF().centerY());				
//		chart.getToolTip().setCurrentXY(x,y);	
//		chart.getToolTip().addToolTip(label+" Current Value:" +Double.toString(bValue),pToolTip);
//		
//		this.invalidate();
//		
//	}
	
}
