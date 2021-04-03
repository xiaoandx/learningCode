/**
 * Copyright (c) 2021 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 * In case of code problems, feedback can be made through the following email address.
 * <p>
 * <xiaoandx@gmail.com>
 */
package club.xiaoandx.section2;

import java.util.Scanner;

/**
 * <p>
 * 编写一个智能购物计算小程序，在一家商店有书本、铅笔、橡皮、可乐、零食五种商品，商品价格如下表所示。
 * 商品名称	价格
 * 书本	12元
 * 铅笔	1元
 * 橡皮	2元
 * 可乐	3元
 * 零食	5元
 * 假如你带了20元，且必须购买一本书，剩余的钱还可以购买哪种商品，
 * 可以购买几件，购买完后又能剩余多少钱？
 * </p>
 *
 * @version V0.1
 * @ClassName:Example1
 * @author: WEI.ZHOU
 * @date: 2021/3/13 14:13
 * @since: JDK1.8
 */
public class Example2 {
    @SuppressWarnings("resource")
	public static void main(String[] args) {
        // 铅笔价格
        int pencil = 1;
        //  橡皮价格
        int rubber = 2;
        // 可乐价格
        int cole = 3;
        // 书本价格
        int book = 12;
        // 零食价格
        int snacks = 5;
        System.out.println("一共有20元");
        System.out.println("书本的价格为 " + book);
        System.out.println("1.铅笔的价格为 " + pencil);
        System.out.println("2.橡皮的价格为 " + rubber);
        System.out.println("3.可乐的价格为 " + cole);
        System.out.println("4.零食的价格为 " + snacks);
        System.out.print("请输入其它需要购买商品的编号：");
        Scanner sca = new Scanner(System.in);
        int number = sca.nextInt();

        switch (number) {
            case 1:
                int pencilMoney = 20 - book;
                int pencilSum = pencilMoney / pencil;
                int pencilSurplus = pencilMoney % pencil;
                System.out.println("购买完书本后还可以购买铅笔" + pencilSum + "" +
                        "个，还剩" + pencilSurplus + "元");
                break;
            case 2:
                int rubberMoney = 20 - book;
                int rubberSum = rubberMoney / rubber;
                int rubberSurplus = rubberMoney % rubber;
                System.out.println("购买完书本后还可以购买橡皮" + rubberSum + "" +
                        "个，还剩" + rubberSurplus + "元");
                break;
            case 3:
                int coleMoney = 20 - book;
                int coleSum = coleMoney / cole;
                int coleSurplus = coleMoney % cole;
                System.out.println("购买完书本后还可以购买可乐" + coleSum + "" +
                        "个，还剩" + coleSurplus + "元");
                break;
            case 4:
                int snacksMoney = 20 - book;
                int snacksSum = snacksMoney / snacks;
                int snacksSurplus = snacksMoney % snacks;
                System.out.println("购买完书本后还可以购买可乐" + snacksSum + "" +
                        "个，还剩" + snacksSurplus + "元");
                break;
            default:
                System.out.println("输入编号错误！！！！！！！！");
                break;
        }
    }
}