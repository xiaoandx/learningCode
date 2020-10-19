/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <xiaoandx@gmail.com>                                                 
*                                                                                                        
*  FileName:  test2                                                                         
*  Author:  WEI.ZHOU                                                                                     
*  Version:  1.0                                                                                         
*  Date:  2020-10-16                                                                                     
*  Description: 求n位数值的平均数                                                              
*  Others:                
*           test case：
*                   one.求2个数值的平均值(结果保留两位小数)
*                     param  3  2 
*                     return 2.50
*           be careful：
*                   one.数据类型间的转换，提别是在int/int所得到的类型及结果不一致时，需要
                    将类型变为float，应该平均值常常有小数等                                                                                                  
**********************************************************************************************************/

#include <stdio.h>

#define INIT_VALUE_ZERO 0
#define INIT_FLOAT_VALUE_ZERO 0.0
#define ARRAY_SIZE 100

/**
 * @brief   求多个整数的平均值
 * @param   int count 需要求的整数平均值的个数(<100)
 * @return  float 直接返回平均值结果（保留两位小数）
 */
float getAverage(int count);

int main(){
    int count;
    float average = INIT_FLOAT_VALUE_ZERO;
    printf("请输入需要求平均数的数量 (count<100) :");
    //输入正整数count
    scanf("%d", &count);
    average = getAverage(count);
    printf("输入的数值的平均数 = %.2f\n",average); 
    return 0;
}

float getAverage(int count){
    //初始化数组元素
    int number[ARRAY_SIZE] = {NULL}; 
    //定义循环变量和正整数变量
    int i = INIT_VALUE_ZERO;  
    //定义和变量为float型，注意计算的数据类型      
    float sum = INIT_FLOAT_VALUE_ZERO;     
    //定义平均数变量为float型，注意计算的数据类型
    float average = INIT_FLOAT_VALUE_ZERO;
    //提示输入count个正整数 
    printf("\n请输入 %d 个整数（空格分开，回车结束）:", count); 
    for (i = 0; i < count; i++){
        scanf("%d", &number[i]); 
        sum += number[i];
    }
    return sum / (float) count;
}