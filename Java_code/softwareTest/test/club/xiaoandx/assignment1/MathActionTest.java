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
package club.xiaoandx.assignment1;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**  
 * <p> Junit学习测试类 </p> 
 * 1. 单个数据测试
 * 2. 参数化测试
 * @ClassName:AdditionTest   
 * @author: WEI.ZHOU
 * @date: 2021-04-16 08:41
 * @since: JDK1.8
 * @version V1.0.0
 */
@RunWith(Parameterized.class)
public class MathActionTest {
	
	/**
	 * 断言结果允许误差
	 */
	private static final double DELTA = 0.01;
	
	/**
	 * 获取功能对象
	 */
	private MathAction mathAction = MathAction.getMathAction();
	
	private double dividend;  
    private double divisor;  
    private double result;

    /**
     * <p> 加法单一参数测试 </p></br>
     * @Title: testAdd  
     * @date: 2021-04-16 09:19 void    
     * @since: 1.0.0   
     */
	@Test
	public void testAdd() {
		double number = mathAction.add(14, 15);
		double as = 29.0;
		assertEquals(number, as, DELTA);
	}
	
	/**
	 * <p> 减法单一参数测试 </p></br>
	 * @Title: testSub  
	 * @date: 2021-04-16 09:19 void    
	 * @since: 1.0.0   
	 */
	@Test
	public void testSub() {
		double number = mathAction.subtract(10, 8);
		double rust = 2;
		assertEquals(number, rust, DELTA);
	}
	
//	===================================== 参数传递测试 ====================================

	/**   
	 * <p> 构造赋值 </p></br>
	 * @Title:  AdditionTest   
	 * @date: 2021-04-16 09:04
	 * @param dividend	参数1
	 * @param divisor	参数2
	 * @param result 	预期结果
	 * @since: 1.0.0
	 */
	public MathActionTest(double dividend, double divisor, double result) {
		super();
		this.dividend = dividend;
		this.divisor = divisor;
		this.result = result;
	}
	
	/**
	 * <p> 加法自定义参数测试数据  并进行测试验证 </p></br>
	 * 用@Parameterized.Parameters注解标注该方法是返回所有参数，被注解的方法必须返  </br>
	 * 回装载数组的Iterable对象，同时必须为public，static，当测试执行时，系统会遍历 </br>
	 * 每组参数（数组）调用构造函数并执行测试。
	 * @Title: getParameters  
	 * @date: 2021-04-16 09:07
	 * @return Iterable<Object[]>    
	 * @since: 1.0.0   
	 */
//    @Parameterized.Parameters  
//    public static Iterable<Object[]> getParameters() {  
//        return Arrays.asList(new Object[][]{  
//                {3, 3, 6}, {5, 1, 6}, {12, 4, 16}, {100, 200, 300}
//        });  
//    }
    
    
	/**
	 * <p> 多参数测试断言 </p></br>
	 * @Title: test2  
	 * @date: 2021-04-16 09:21 void    
	 * @since: 1.0.0   
	 */
//	@Test
//	public void testAdd2() {
//		 assertEquals(result, mathAction.add(dividend, divisor), DELTA);
//	}
	
	/**
	 * <p> 减法自定义参数测试数据  并进行测试验证 </p></br>
	 * @Title: getParameters  
	 * @date: 2021-04-16 09:07
	 * @return Iterable<Object[]>    
	 * @since: 1.0.0   
	 */
    @Parameterized.Parameters  
    public static Iterable<Object[]> getParameters() {  
        return Arrays.asList(new Object[][]{  
                {3, 3, 0}, {5, 1, 4}, {12, 4, 8}, {100, 200, -100}
        });  
    }
    
    @Test
    public void testSub2() {
    	assertEquals(result, mathAction.subtract(dividend, divisor), DELTA);
    }
}
