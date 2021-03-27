/*
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and 
 * commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * 
 *                        <xiaoandx@gmail.com>
 */
package club.xiaoandx.experiment2.test2;

/**  
 * <p> 任务二 </p> 
 *	2. P55页第5题
 * @ClassName:Questions3   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:21
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Questions3 {
	public static void main(String[] args) {
		/*
		 * Test:
		 * 	1. 通过具体图像生成器获取对应图形对象
		 * 	2. 用得到图形生成器进行绘制
		 */
		Chart lineChart = new LineChartFactory().getChart();
		Chart berChar = new BarChartFactory().getChart();
		lineChart.draw();
		berChar.draw();
	}
}

/**
 * <p> 图像抽象类 </p> 
 * @ClassName:Chart   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:41
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class Chart{
	
	/**
	 * <p> 绘图抽象方法 </p></br>
	 * @Title: draw  
	 * @date: 2021-03-25 22:42 void    
	 * @since: 1.0.0   
	 */
	public abstract void draw();
}

/**
 * <p> 柱状图 </p> 
 * @ClassName:LineChart   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:44
 * @since: JDK1.8
 * @version V1.0.0
 */
class LineChart extends Chart{

	/**   
	 * <p> 绘制柱状图 </p></br>
	 * <p>Title: draw</p> 
	 * @date: 2021-03-25 22:43       
	 * @see club.xiaoandx.experiment2.test2.Chart#draw()   
	 */
	@Override
	public void draw() {
		System.out.println("正在绘制柱状图");
	}
}

/**
 * <p> 曲线生成器 </p> 
 * @ClassName:BarChart   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:45
 * @since: JDK1.8
 * @version V1.0.0
 */
class BarChart extends Chart{

	/**   
	 * <p> 绘制曲线图 </p></br>
	 * <p>Title: draw</p> 
	 * @date: 2021-03-25 22:44       
	 * @see club.xiaoandx.experiment2.test2.Chart#draw()   
	 */
	@Override
	public void draw() {
		System.out.println("正在绘制曲线图");
	}
}

/**
 * <p> chart 抽象工厂 </p> 
 * @ClassName:ChartFcatory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:47
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class ChartFcatory{
	
	/**
	 * <p> 获取具体Chart对象 </p></br>
	 * @Title: getChart  
	 * @date: 2021-03-25 22:48
	 * @return Chart    
	 * @since: 1.0.0   
	 * @throws
	 */
	public abstract Chart getChart();
}

/**
 * <p> 直线生成器工厂 </p> 
 * @ClassName:LineChartFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:49
 * @since: JDK1.8
 * @version V1.0.0
 */
class LineChartFactory extends ChartFcatory{

	/**   
	 * <p> 获取直线生成器对象 </p></br>
	 * <p>Title: getChart</p> 
	 * @date: 2021-03-25 22:49    
	 * @return  Chart	图形生成器 
	 * @see club.xiaoandx.experiment2.test2.ChartFcatory#getChart()   
	 */
	@Override
	public Chart getChart() {
		return new LineChart();
	}
}

/**
 * <p> 曲线生成器工厂 </p> 
 * @ClassName:BarChartFactory
 * @author: WEI.ZHOU
 * @date: 2021-03-25 22:49
 * @since: JDK1.8
 * @version V1.0.0
 */
class BarChartFactory extends ChartFcatory{

	/**   
	 * <p> 获取曲线生成器对象 </p></br>
	 * <p>Title: getChart</p> 
	 * @date: 2021-03-25 22:49    
	 * @return  Chart	图形生成器 
	 * @see club.xiaoandx.experiment2.test2.ChartFcatory#getChart()   
	 */
	@Override
	public Chart getChart() {
		return new BarChart();
	}
}