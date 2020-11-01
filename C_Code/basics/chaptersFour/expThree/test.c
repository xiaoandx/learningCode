/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 
 * @Author: WEI.ZHOU
 * @Date: 2020-11-01 13:59:10
 * @Version: V1.0
 * @LastEditTime: 2020-11-01 15:30:49
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>

// 定义宏变量 PIS
#define PTS 3.14159

int main() {
    // 定义声明半径
    float r;
    printf("请输入0-10000范围内的数：");

    // 判断输入半径是否满足要求
    pan:
    scanf("%f", &r);
    if (r < 0 || r > 10000) {
        printf("输入错误重新输入：");
        goto pan;
    }
    // 输出面积
    printf("半径为%.2f的圆的面积为：%.2f", r, (PTS * r *r));
    
    return 0;
}