/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 计算1到100之间的奇数之和及偶数之和。请填空
 * @Author: WEI.ZHOU
 * @Date: 2020-11-07 16:02:37
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 18:02:17
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include "stdio.h"
int main(){
    int a, b, c, i;
    /* 变量赋初值 */
    a = 0, c = 0; 
    for (i = 0; i <= 100; i += 2) {
        /* 变量a存放偶数的和 */
        a += i; 
        b = i+1;
        /* 变量c存放奇数的和 */
        c += b; 
    }
    printf("Sum of Evens is %d\n", a);
    printf("Sum of Odds is %d\n", c - 101);
    return 0;
}