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
 * @Date: 2020-11-28 14:49:56
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define ONE 1

/**
 * @brief   组合函数
 * @Date    2020-11-28 14:56:57
 * @param   int i 运算整数
 * @param   int n 运算整数
 * @return  {long int} 结果
 */
long int combination(int i, int n);

/**
 * @brief   求阶乘方法
 * @Date    2020-11-28 14:57:50
 * @param   nt n 运算整数
 * @return  {long int} 阶乘结果
 */
long int getFactorial(int n);

int main(){
    int m, n;
    printf("input m and n: ");
    scanf("%d,%d",&m,&n);
    printf("结果为：%ld\n",combination(m,n));
    return OPERATION_SUCCESS;
}

long int combination(int i, int n){
    return getFactorial(i) / (getFactorial(n) * getFactorial((i-n)));
}

long int getFactorial(int n){
    int i ;
    long int sum = ONE;
    for(i = ONE; i<=n; i++){
        sum *= i;
    }
    return sum;
}