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
 * @Date: 2020-10-25 14:14:24
 * @Version: V1.0
 * @LastEditTime: 2020-10-25 14:14:37
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>  

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0 

int main(){
    float longs,wide,qrea,perimeter;
    printf("请输入矩形的长和宽：");
    scanf("%f%f",&longs,&wide);
    qrea = longs * wide;                                                                        
    perimeter = (longs + wide) * 2;
    printf("矩形的面积是：%.2f\n周长是：%.2f",qrea,perimeter);
    return OPERATION_SUCCESS;
}