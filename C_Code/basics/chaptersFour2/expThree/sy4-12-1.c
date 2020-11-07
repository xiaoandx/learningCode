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
 * @Date: 2020-11-07 18:02:42
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 19:13:53
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>

#define DEF_ONE 1
#define DEF_ZERO 0

/**
 * @brief   求两个整数的最大公约数
 * @date    2020-11-07 18:25:18
 * @author  WEI.ZHOU
 * @param   int a 第一个整数
 * @param   int b 第二个整数
 * @return  {int} 最大公约数
 */
int getMaxCommonDivisor(int a, int b);

/**
 * @brief   求两个整数的最小公倍数
 * @date    2020-11-07 18:25:18
 * @author  WEI.ZHOU
 * @param   int a 第一个整数
 * @param   int b 第二个整数
 * @return  {int} 最小公倍数 注意：返回0 -> 求取失败
 */
int getMinCommonMultiple(int a, int b);

int main() {
    int x, y, maxCommonDivis, maxCommonMul;
    printf("输入两个整数逗号（英文）分隔: ");
    scanf("%d,%d", &x, &y);
    maxCommonDivis = getMaxCommonDivisor(x,y);
    maxCommonMul = getMinCommonMultiple(x,y);

    printf("%d与%d的最大公约数为：%d\n", x,y,maxCommonDivis);
    printf("%d与%d的最小公倍数为：%d\n", x,y,maxCommonMul);
    return 0;
}

int getMaxCommonDivisor(int a, int b){
    int maxCommonDivisor,t;
    if (a > b) { t = a; a = b; b = t;}
    for (maxCommonDivisor = a; maxCommonDivisor>DEF_ZERO; maxCommonDivisor--){
        if (a % maxCommonDivisor == DEF_ZERO && b % maxCommonDivisor == DEF_ZERO){
            break;
        }
    }
    return maxCommonDivisor;
}

int getMinCommonMultiple(int a, int b){
    int sum1,t;
    if (a > b) { t = a; a = b; b = t;}
    for(int i = DEF_ONE; i<=a; i++){
        sum1 = i * b;
        for(int j = DEF_ONE; j<=b; j++){
            if(sum1 == j * a){
               return sum1;
            }
        }
    }
    return sum1;
}