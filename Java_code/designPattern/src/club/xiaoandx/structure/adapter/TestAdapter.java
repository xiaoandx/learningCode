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
package club.xiaoandx.structure.adapter;

import club.xiaoandx.structure.adapter.interfa.Duck;
import club.xiaoandx.structure.adapter.interfa.Turkey;
import club.xiaoandx.structure.adapter.interfa.impl.TurkeyAdapter;
import club.xiaoandx.structure.adapter.interfa.impl.WildTurkey;

/**  
 * <p> 结构型设计模式 - 适配器模式 </p> 
 * 适配器模式(Adapter pattern): 将一个类的接口, 转换成客户期望的另一个接口。 </br>
 * 适配器让原本接口不兼容的类可以合作无间。 对象适配器使用组合, 类适配器使用多重继承。</br>
 * <pre>
 * 实例：
 *  鸭子(Duck)和火鸡(Turkey)拥有不同的叫声，Duck 的叫声调用 quack() 方法，而 Turkey 调用 gobble() 方法。 
 *  要求将 Turkey 的 gobble() 方法适配成 Duck 的 quack() 方法，从而让火鸡冒充鸭子！
 * </pre>
 * @ClassName:Adapter   
 * @author: WEI.ZHOU
 * @date: 2021-04-14 17:07
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestAdapter {
	public static void main(String[] args) {
		Turkey turkey = new WildTurkey();
		Duck duck = new TurkeyAdapter(turkey);
		duck.quack();
	}
}
