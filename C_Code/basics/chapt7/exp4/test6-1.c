/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 输出以下的结果，用函数调用实现。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-29 17:54:01
 * @Version: V1.0
 * @Others: Running test instructions
 *      ******************
        ******************
            How do you do!
        ******************
        ******************
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1

/**
 * @brief   输出虚线
 * @Date    2020-11-29 17:58:46
 */
void printW();

/**
 * @brief   输出虚线
 * @Date    2020-11-29 18:01:57
 * @param   int N 虚线长度
 */
void printW(int N);

/**
 * @brief   输出字符串
 * @Date    2020-11-29 17:58:46
 */
void printStr(char *V);

int main(){
    char str[20] = "How do you do!";
    printW(26);
    printW(26);
    printStr(str);
    printW(26);
    printW(26);
    return OPERATION_SUCCESS;
}

void printW(){
    printf("******************\n");
}

void printW(int N){
    for(int i = 0; i<N;i++){
         printf("*");
    }
    printf("\n");
}

void printStr(char *V){
    printf("  %s\n",V);
}