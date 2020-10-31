/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description: 计算利润
 * @Author: WEI.ZHOU
 * @Date: 2020-10-31 13:15:30
 * @Version: V1.0
 * @LastEditTime: 2020-10-31 13:40:40
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>

/*
 * 声明每部分的奖金提成（COMMISSION）
 * 主要是每个利润段的提成金额
 * 10万 => COMMISSION1  20万 => COMMISSION2   40万 => COMMISSION4
 * 60万 => COMMISSION6  100万 => COMMISSION10
 */
#define COMMISSION1 100000 * 0.1
#define COMMISSION2  COMMISSION1 + 100000 * 0.075
#define COMMISSION4  COMMISSION2 + 100000 * 0.05
#define COMMISSION6  COMMISSION4 + 100000 * 0.03
#define COMMISSION10  COMMISSION6 + 400000 * 0.015

/**
 * @brief   获取奖金方法
 * @date    2020-10-31 13:36:12
 * @param   int i 利润
 * @return  {double} 奖金金额
 */
double getCommission(int i);

int main() {
    // 声明保存利润变量
    int i;
    // 声明奖金提成
    double commissionus;
    // 输入利润
    printf("请输入利润i:");
    scanf("%d", &i);
    // 调用获取奖金方法
    commissionus = getCommission(i);
    // 输出
    printf("利润%0.2d可得到的奖金是: %10.2f\n", i, commissionus);
    return 0;
}

double getCommission(int i){
    if (i <= 100000) {
        return i * 0.1;
    } else if (i <= 200000) {
        return COMMISSION1 + (i - 100000) * 0.075;
    } else if (i <= 400000) {
        return COMMISSION2 + (i - 200000) * 0.05;
    } else if (i <= 600000) {
        return COMMISSION4 + (i - 400000) * 0.03;
    } else if (i <= 1000000) {
        return COMMISSION6 + (i - 600000) * 0.015;
    } else {
        return COMMISSION10 + (i - 1000000) * 0.01;
    }
}
