/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:列程序的功能是：计算正整数num的各位上的数字之和。例如 ：
 * 输入：251，则应输出：8。 请将程序补充完整。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 16:02:37
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:02:09
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>
int main() {
    int num, k;
    // k赋初值
    k = 0;  
    printf("Please enter a number:");
    scanf("%d", &num);
    do {
        //取最低位并累加
        k = k + num % 10;  
        //去掉最低位
        num /= 10;         
    } while (num);
    printf("%d\n", k);
    return 0;
}