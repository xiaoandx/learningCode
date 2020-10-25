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
 * @Date: 2020-10-25 14:27:51
 * @Version: V1.0
 * @LastEditTime: 2020-10-25 14:30:02
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>  
int main(){
    //定义整型变量a,b
    int a, b;
    //定义浮点变量c
    float c;                    
    //输入变量a,b      
    printf("输入两个整数(用,隔开)：");         
    scanf("%d,%d", &a, &b);  
    c = (a + b) / 2.0;
    printf("c = %f", c);
    return 0;
}