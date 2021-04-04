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
package club.xiaoandx.expound.prototype;

/**  
 * <p> 创建型 - 原型模式（Prototype） </p> 
 *	说明：</br>
 *	简单理解就是，使用原型实例指定要创建对象的类型，通过<b>复制</b>这个原型来创建新对象。
 * @ClassName:Prototype   
 * @author: WEI.ZHOU
 * @date: 2021-04-04 14:01
 * @since: JDK1.8
 * @version V1.0.0
 */
public class Prototype {

	public static void main(String[] args) {
		PrototypeAbstract prototype = new ConcretePrototype("WEI.ZHOU");
		PrototypeAbstract cloneObject = prototype.myClone();
		System.out.println(prototype.toString());
		System.out.println(cloneObject.toString());
		System.out.println(prototype == cloneObject);
	}

}

//	================================== 原型具体实现代码 ====================================

abstract class PrototypeAbstract {
    abstract PrototypeAbstract myClone();
}

class ConcretePrototype extends PrototypeAbstract {

    private String filed;

    public ConcretePrototype(String filed) {
        this.filed = filed;
    }

    @Override
    PrototypeAbstract myClone() {
        return new ConcretePrototype(filed);
    }

    @Override
    public String toString() {
        return filed;
    }
}
