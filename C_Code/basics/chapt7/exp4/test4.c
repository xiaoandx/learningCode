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
 * @Date: 2020-11-29 15:55:34
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

long int fact(long int x, long int n);

int main(){
    long int fact(long x, long n); /*声明fact函数*/
    long int x;
    long int n;
    printf("please enter X and  N(>=0): ");
    scanf("%ld,%ld", &x, &n);
    printf("%ld,%ld=%ld", x, n, fact(x, n));
    return 0;
}

/*定义fact函数求xn */
long int fact(long int x, long int n) {
    long int i, s;
    /*求累积变量的初始化*/
    s = 1; 
    if (n == 0){
        return 1;
    }
    /*用循环实现xn*/
    for (i = 1; i <= n; i++) {
        s = s * x;
    }
    /*返回结果xn*/
    return s; 
}