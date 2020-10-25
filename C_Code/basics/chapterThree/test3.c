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
 * @Date: 2020-10-21 22:28:37
 * @Version: V1.0
 * @LastEditTime: 2020-10-24 10:41:10
 * @LastEditors: WEI.ZHOU
 * @Others: 
 *          运行结果：
 *          (1).    c1=a,c2=b
 *                  c1=97,c2=98
 *          (2). 如果将4，5行改成：c1=197；c2=198;运行结果如下：
 *                  c1=,c2=
 *                  c1=-59,c2=-58
 *              因为：char只占一个字节，取值范围为 -128 ~ +127；
 *          (3).如果将第3行改为：int c1,c2;运行结果：
 *                  c1=a,c2=b
 *                  c1=97,c2=98
 *              因为：int表示整数，%c是输出字符，a的ASCLL代码为97，b的是98，所以输出c1=a，c2=b。
 *                   %d表示输出十进制整数，所以输出c1=97，c2=98
 */
#include <stdio.h>
int main() {
    int c1,c2;
    c1 = 97;
    c2 = 98;
    printf("c1=%c,c2=%c\n", c1, c2);
    printf("c1=%d,c2=%d\n", c1, c2);
    return 0;
}