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
 * @Date: 2020-11-28 15:05:33
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define ARRAY_SIZE 16
#define ZERO 0
/**
 * @brief   整数转二进制
 * @Date    2020-11-28 15:09:31
 * @param   int N 十进制整数
 */
int getBinary(int N);
int main(){
    int n;
    printf("Please input number n: ");
    scanf("%d",&n);
    getBinary(n);
    return OPERATION_SUCCESS;
}
int getBinary(int N) {
    int gam[ARRAY_SIZE], i, nu=N;
    for (i = 0; N != ZERO; i++){
        gam[i] = N % 2;
        N = N / 2;
    }
    printf("\n %d 的二进制为：",nu);
    for (; i != ZERO; i--){
        printf("%d", gam[i - 1]);
    }
    return OPERATION_SUCCESS;
}
