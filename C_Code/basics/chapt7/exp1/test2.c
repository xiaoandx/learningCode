/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 定义一个函数：求某数字（3位数）是否是水仙花（每一位数的立方=本身）153=1^3+5^3+3^3
 * @Author: WEI.ZHOU
 * @Date: 2020-11-28 14:12:06
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ZERO 0
#define ONE 1
#define TWO 2
#define LF '\n'

/**
 * @brief   判断输入的三位整数是否为水仙花数
 * @Date    2020-11-28 14:21:08
 * @param   int V 进行判断的三位整数
 * @return  {*} 1->水仙花数；0->不是水仙花数
 */
int find(int V);

int main(){
    int status, number;
    printf("输入一个三位数：");
    scanf("%d",&number);
    status = find(number);
    if(ZERO == status){
        printf(" %d 不是水仙花数",number);
    }else{
        printf(" %d 是水仙花数",number);
    } 
    return OPERATION_SUCCESS;
}

int find(int V) {
    int i = ZERO, a, b = ZERO;
    int c = V;
    for (i = ZERO; i < 3; i++) {
        a = V % 10;
        b = b + a * a * a;
        V = V / 10;
    }
    if (b == c) {
        return OPERATION_SUCCESS;
    } 
    return OPERATION_ERROR;
}