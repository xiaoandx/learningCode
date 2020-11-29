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
    return 0;
}


int isPrime(int n) {
    int i;
    for (i = 2; i <= sqrt(n); i++)
        if (n % i == 0){
            return 0;
        }
    return 1;
}
