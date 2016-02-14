package dao;

import java.awt.Font;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;

import org.jfree.chart.labels.StandardPieSectionLabelGenerator;

import org.jfree.chart.plot.PiePlot;
import org.jfree.chart.plot.PlotOrientation;

import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;

import entity.PieChartData;

public class JFreeChartDao {
	
	public JFreeChart PieChart(ArrayList<PieChartData> list,String ChartTitle)
	{
		if (list!=null&&list.size()>0) {
			DefaultPieDataset PieDataset = new DefaultPieDataset();
			for (int i = 0; i < list.size(); i++){
				PieChartData data = list.get(i);
				PieDataset.setValue(data.getKeyString(), data.getValueDouble());
			}
		    JFreeChart pieChart = ChartFactory.createPieChart(ChartTitle, PieDataset, true, true, false);
			PiePlot piePlot = (PiePlot) pieChart.getPlot(); 
			
			piePlot.setSectionOutlinesVisible(false);//设置边框是否可见
			piePlot.setForegroundAlpha(0.8f); //设置图片透明度
			
			
		    Font font = new Font("微软雅黑", Font.CENTER_BASELINE, 30);//定义字体格式，中文标题需要使用中文字体，否则显示方块    
		    TextTitle title = new TextTitle(ChartTitle); //定义图片标题  
		    title.setFont(font);//设置标题的格式 
		  	pieChart.setTitle(title);//把标题设置到图片里面  
		  	pieChart.getLegend().setItemFont(new Font("微软雅黑", Font.CENTER_BASELINE, 24));//设置图例字体
		  	piePlot.setLabelFont(new Font("微软雅黑", Font.CENTER_BASELINE, 18));//设置标签字体
		  	
		  	//piePlot.setExplodePercent("杭州", 0.10); //爆炸模式,使Pie的一块分离出去,不支持3D
		  //设置上面的样式,0表示KEY,1表示VALUE,2表示百分之几,DecimalFormat用来显示百分比的格式  
		    piePlot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}:{1}({2})",NumberFormat.getNumberInstance(),new DecimalFormat("0.00%")));
			
			return pieChart;
		}
		return null;
		
	}

	public static void main(String[] args) {
		ArrayList<PieChartData> list = new ArrayList<PieChartData>();
		PieChartData date1 = new PieChartData();
		date1.setKeyString("技术");
		date1.setValueDouble((double) 6);
		list.add(date1);
		PieChartData date2 = new PieChartData();
		date2.setKeyString("消防");
		date2.setValueDouble((double) 8);
		list.add(date2);
		PieChartData date3 = new PieChartData();
		date3.setKeyString("运维");
		date3.setValueDouble((double) 20);
		list.add(date3);
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();  
        //数据初始化  
        dataset.addValue(1.0, "北京", "苹果");  
        dataset.addValue(7.0, "北京", "香蕉");  
        dataset.addValue(-3.0, "北京", "桔子");  
        dataset.addValue(2.0, "上海", "苹果");  
        dataset.addValue(3.0, "上海", "香蕉");  
        dataset.addValue(2.0, "上海", "桔子");  
        //创建 JFreeChart 对象  
        JFreeChart chart = ChartFactory.createBarChart("Bar Chart 例子","水果(X)", "价格(Y)", dataset,PlotOrientation.VERTICAL,true,true,false);  
        //配置JFreeChart对象相关信息,如:字体大小,颜色,防止乱码  
        //输出  
        FileOutputStream fos_jpg03 = null;  
        try {  
            fos_jpg03 = new FileOutputStream("F:\\java包\\Bar01.jpg");  
            ChartUtilities.writeChartAsJPEG(fos_jpg03,0.99f,chart,800,600,null);  
            fos_jpg03.close();  
            System.out.println("保存成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
			
		JFreeChartDao jDao = new JFreeChartDao();
		FileOutputStream fos_jpg = null;  //创建输出流
        try {             
            fos_jpg = new FileOutputStream("F:\\java包\\Pie.jpg");  
            //用工具把图象写到硬盘,支持两种格式,JPG,PNG,还支持MAP  
            ChartUtilities.writeChartAsJPEG(fos_jpg,0.75f,jDao.PieChart(list,"成绩分析"),640,480,null);  
            fos_jpg.close();  
            System.out.println("保存成功");
        } catch (Exception e) {  
            e.printStackTrace();  
        } 

	}

}
