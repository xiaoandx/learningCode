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
package club.xiaoandx.experiment3.test3;

/**  
 * <p> 任务1 </p> 
 *	3. P41页第5题
 * @ClassName:Questions1   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 17:05
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Questions1 {
	public static void main(String[] args) {
		Shape shap = null;
		try {
			shap = SimpleShapFactory.getShap("Circle");
		} catch (UnsupportedShapeException e) {
			System.out.println(e.getMessage());
		}
		shap.draw();
	}
}

/**
 * <p> 绘图工具抽象类 </p> 
 * @ClassName:Shape   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 17:13
 * @since: JDK1.8
 * @version V1.0.0
 */
abstract class Shape{
	
	/**
	 * <p> 画图抽象方法 </p></br>
	 * @Title: draw  
	 * @date: 2021-03-25 17:14 void    
	 * @since: 1.0.0   
	 */
	public abstract void draw();
	
	/**
	 * <p> 擦图抽象方法 </p></br>
	 * @Title: erase  
	 * @date: 2021-03-25 17:14 void    
	 * @since: 1.0.0   
	 */
	public abstract void erase();
}

class Circle extends Shape{

	/**   
	 * <p> 实现画图的具体操作方法 </p></br>
	 * <p>Title: draw</p> 
	 * @date: 2021-03-25 17:16       
	 * @see club.xiaoandx.experiment3.test3.Shape#draw()   
	 */
	@Override
	public void draw() {
		System.out.println("正在画圆形.................");
	}

	/**   
	 * <p> 实现擦图的具体方法 </p></br>
	 * <p>Title: erase</p> 
	 * @date: 2021-03-25 17:16       
	 * @see club.xiaoandx.experiment3.test3.Shape#erase()   
	 */
	@Override
	public void erase() {
		System.out.println("正在擦掉圆形................");
	}
}

class Rectangle extends Shape{

	/**   
	 * <p> 实现画图的具体操作方法 </p></br>
	 * <p>Title: draw</p> 
	 * @date: 2021-03-25 17:18      
	 * @see club.xiaoandx.experiment3.test3.Shape#draw()   
	 */
	@Override
	public void draw() {
		System.out.println("正在画矩形.................");
	}

	/**   
	 * <p> 实现擦图的具体方法 </p></br>
	 * <p>Title: erase</p> 
	 * @date: 2021-03-25 17:18       
	 * @see club.xiaoandx.experiment3.test3.Shape#erase()   
	 */
	@Override
	public void erase() {
		System.out.println("正在擦掉矩形................");
	}
}

class Triangle extends Shape{

	/**   
	 * <p> 实现画图的具体操作方法 </p></br>
	 * <p>Title: draw</p> 
	 * @date: 2021-03-25 17:18      
	 * @see club.xiaoandx.experiment3.test3.Shape#draw()   
	 */
	@Override
	public void draw() {
		System.out.println("正在画三角形.................");
	}

	/**   
	 * <p> 实现擦图的具体方法 </p></br>
	 * <p>Title: erase</p> 
	 * @date: 2021-03-25 17:18       
	 * @see club.xiaoandx.experiment3.test3.Shape#erase()   
	 */
	@Override
	public void erase() {
		System.out.println("正在擦掉三角形................");
	}
}

/**
 * <p> 图像创建工厂类 </p> </br>
 *	1. 通过向getShap()传入指定的drawType 就会得到指定类型的图像对象 </br>
 * 		eg: getShap("Circle") 回得到一个圆形对象
 * @ClassName:SimpleShapFactory   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 17:23
 * @since: JDK1.8
 * @version V1.0.0
 */
class SimpleShapFactory{
	public static Shape getShap(String drawType) throws UnsupportedShapeException {
		Shape shap = null;
		if (drawType.equalsIgnoreCase("Circle")) {
			shap = new Circle();
		} else if (drawType.equalsIgnoreCase("Rectangle")) {
			shap = new Rectangle();
		} else if (drawType.equalsIgnoreCase("Triangle")) {
			shap = new Triangle();
		} else {
			throw new UnsupportedShapeException("不支持绘制" + drawType + "图形");
		}
		return shap;
	}
}

/**
 * <p> 自定义绘图几何图形不支持异常 </p> 
 * @ClassName:UnsupportedShapeException   
 * @author: WEI.ZHOU
 * @date: 2021-03-25 17:29
 * @since: JDK1.8
 * @version V1.0.0
 */
class UnsupportedShapeException extends Exception{
	/**   
	 * use serialVersionUID from JDK 1.0.2 for interoperability   
	 */ 
	private static final long serialVersionUID = 85966557233127127L;

	public UnsupportedShapeException(String massage) {
		super(massage);
	}
}