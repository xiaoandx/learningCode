/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description: 九九乘法表
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 16:02:37
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:36:02
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>
int main() {
    // 第一行字段标题
    printf("  *  1  2  3  4  5  6  7  8  9\n");
    // 循环
    for(int k = 1;k<=9;k++){
        // 循环输出每行的第一个数字
        for (int i = k; i<=k; i++) {
            printf("%3d", i);
            // 循环输出行与每列的乘积
            for (int j = 1; j <=k; j++) {
                printf("%3d", i * j);
            }
            printf("\n");
        }
    }
    return 0;
}