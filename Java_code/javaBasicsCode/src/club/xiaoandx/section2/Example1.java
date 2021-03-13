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
 * 现要对华为和小米两种手机产品进行入库，本案例要求编写一个模拟商品入库的程序，
 * 可以在控制台输入入库商品的数量，最后打印出仓库中所有商品详细信息以及
 * 所有商品的总库存数和库存商品总金额。
 * </p>
 *
 * @version V0.1
 * @ClassName:Example1
 * @author: WEI.ZHOU
 * @date: 2021/3/13 14:13
 * @since: JDK1.8
 */
public class Example1 {
    public static void main(String[] args) {
        //华为手机
        String huaweiBrand = "华为";
        double huaweiSize = 5.5;
        double huaweiPrice = 3688.88;
        String huaweiConfig = "8+128g 全面刘海屏";
        //小米手机
        String xiaomiBrand = "小米";
        double xiaomiSize = 5.0;
        double xiaomiPrice = 2988.88;
        String xiaomiConfig = "4+64g 全面屏";
        //华为手机入库
        System.out.println("品牌型号：" + huaweiBrand + "\n尺寸：" + huaweiSize);
        System.out.println("价格：" + huaweiPrice);
        System.out.println("配置：" + huaweiConfig);
        Scanner sc1 = new Scanner(System.in);
        System.out.println("请输入" + huaweiBrand + "手机的库存：");
        int huanweiCount = sc1.nextInt();
        double huaweiTotal = huanweiCount * huaweiPrice;
        System.out.println("库存" + huaweiBrand + "手机的总金额:" + huaweiTotal);

        //小米手机入库
        System.out.println("品牌型号：" + xiaomiBrand);
        System.out.println("尺寸：" + xiaomiSize);
        System.out.println("价格：" + xiaomiPrice);
        System.out.println("配置：" + xiaomiConfig);
        System.out.println("请输入" + xiaomiBrand + "手机的库存");
        int xiaomiCount = sc1.nextInt();
        double xiaomiTotal = xiaomiCount * xiaomiPrice;
        System.out.println("库存" + xiaomiBrand + "手机的总金额：" + xiaomiTotal);
        //库存清单
        System.out.println("------------库存清单------------");
        System.out.println("品牌型号    尺寸    价格    配置    库存    数量    总价");
        System.out.println(huaweiBrand + "    " + huaweiSize + "   " + huaweiPrice + "   " + huaweiConfig + "   " + huanweiCount + "   " + huaweiTotal);
        System.out.println(xiaomiBrand + "    " + xiaomiSize + "   " + xiaomiPrice + "   " + xiaomiConfig + "   " + xiaomiCount + "   " + xiaomiTotal);
        System.out.println("---------------------------------");
        int total = huanweiCount + xiaomiCount;
        double totalMoney = huaweiTotal + xiaomiTotal;
        //总库存数量与库存总价
        System.out.println("总库存：" + total);
        System.out.println("库存总价：" + totalMoney + "￥");
    }
}
