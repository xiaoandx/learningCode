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
package club.xiaoandx.experiment3.assignment1.test3;

import club.xiaoandx.experiment3.assignment1.test3.factory.GreenstuffFactory;
import club.xiaoandx.experiment3.assignment1.test3.factory.impl.NotTransgenosisFactory;
import club.xiaoandx.experiment3.assignment1.test3.factory.impl.TransgenosisFactory;
import club.xiaoandx.experiment3.assignment1.test3.greenstuff.Greenstuff;

/**  
 * <p> 抽象工厂模式种植蔬菜测试类 </p> 
 *	1. 向声明创建蔬菜工厂接口
 *	2. 在通过实现蔬菜工厂接口的转基因与非转基因类进行种植指定的蔬菜
 *	3. 得到需要种植蔬菜对象调用方法进行种植成长收获
 * @ClassName:TestGreenstuff   
 * @author: WEI.ZHOU
 * @date: 2021-04-01 19:56
 * @since: JDK1.8
 * @version V1.0.0
 */
public class TestGreenstuff {

	public static void main(String[] args) {
		//	声明创建转基因蔬菜工厂对象 （通过转基因蔬菜工厂可以种植 转基因根菜与转基因茎菜）
		GreenstuffFactory transgenosisFactory = new TransgenosisFactory();
		//	通过转基因工厂 得到 转基因根菜
		Greenstuff transgenosisRootGreenstuff = transgenosisFactory.getRootGreebstuff();
		//	通过转基因工厂 得到 转基因茎菜
		Greenstuff transgenosisStemGreenstuff = transgenosisFactory.getStemGreenstuff();
		
		//	声明创建非转基因蔬菜工厂对象 （通过非转基因蔬菜工厂可以种植 非转基因根菜与非转基因茎菜）
		GreenstuffFactory notTransgenosisFactory = new NotTransgenosisFactory();
		//	通过非转基因工厂 得到  非转基因根菜
		Greenstuff  notTransgenosisRootGreebstuff = notTransgenosisFactory.getRootGreebstuff();
		//	通过非转基因工厂 得到 非转基因茎菜
		Greenstuff notTransgenosisStemGreenstuff = notTransgenosisFactory.getStemGreenstuff();
		
		//	开始种植--------------
		//	种植 转基因根菜
		transgenosisRootGreenstuff.sowing();
		transgenosisRootGreenstuff.growUp();
		transgenosisRootGreenstuff.fruit();
		System.out.println("==============================");
		
		//	种植 转基因茎菜
		transgenosisStemGreenstuff.sowing();
		transgenosisStemGreenstuff.growUp();
		transgenosisStemGreenstuff.fruit();
		System.out.println("==============================");

		//	种植 非转基因根菜
		notTransgenosisRootGreebstuff.sowing();
		notTransgenosisRootGreebstuff.growUp();
		notTransgenosisRootGreebstuff.fruit();
		System.out.println("==============================");

		//	种植 非转基因茎菜
		notTransgenosisStemGreenstuff.sowing();
		notTransgenosisStemGreenstuff.growUp();
		notTransgenosisStemGreenstuff.fruit();
	}

}
