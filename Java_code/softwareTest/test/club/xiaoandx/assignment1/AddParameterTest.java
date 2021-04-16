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

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;

/**  
 * <p> 加法参数化测试类 </p> 
 * @ClassName:AddParameterTest   
 * @author: WEI.ZHOU
 * @date: 2021-04-16 09:54
 * @since: JDK1.8
 * @version V1.0.0
 */
@RunWith(Parameterized.class)
public class AddParameterTest {
	
	/**
	 * 断言结果允许误差
	 */
	private static final double DELTA = 0.01;
	
	/**
	 * 获取数学运行类对象(单例模式)
	 */
	private MathAction mathAction;
	
	@Parameter(0)
	public double dividend;  
	
	@Parameter(1)
    public double divisor;  
	
	@Parameter(2)
    public double result;
	
	@Before
	public void getMathAction() {
		mathAction = MathAction.getMathAction();
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
    @Parameterized.Parameters  
    public static Iterable<Object[]> getParameters() {  
        return Arrays.asList(new Object[][]{  
                {3, 3, 6}, {5, 1, 6}, {12, 4, 16}, {100, 200, 300}
        });  
    }
	
	/**
	 * <p> 多参数测试断言测试执行 </p></br>
	 *    assertEquals(double x, double y) 方法。因为double值比较相等时存在误差，</br>
	 *  官方已经不推荐使用该方法。</br>
	 *    需要用assertEquals(double x,double y,double delta) 方法进行比较。</br>
	 *  其中第三个参数为误差。常见误差设置为0.01</br>
	 * @Title: test2  
	 * @date: 2021-04-16 09:21 void    
	 * @since: 1.0.0   
	 */
	@Test
	public void testAdd2() {
		 assertEquals(result, mathAction.add(dividend, divisor), DELTA);
	}
	
	
}
