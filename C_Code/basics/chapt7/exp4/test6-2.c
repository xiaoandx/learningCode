/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 写一个函数判断一个整数n是否为素数。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-28 14:03:59
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>
#include <math.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ZERO 0
#define ONE 1
#define TWO 2
/**
 * @brief   判断是否为素数
 * @Date    2020-11-28 14:06:40
 * @param   int n 需要判断的整数
 * @return  {int} 0->不是素数；1->素数
 */
int isPrime(int n);

int main() {
    int number;
    printf("输入整数：");
    scanf("%d", &number);
    if (isPrime(number)){
        printf("  %d 是素数\n", number);
    }else{
        printf("  %d 不是素数\n", number);
    }
    return OPERATION_SUCCESS;
}


int isPrime(int n) {
    int i;
    for (i = TWO ; i <= sqrt(n); i++)
        if (n % i == ZERO){
            return ZERO;
        }
    return ONE;
}
