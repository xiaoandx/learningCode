/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 用指针的方法处理：输入十个整数，将其中最小的数与第一个数交换，
 * 将最大数和最后一个数交换！
 * @Author: WEI.ZHOU
 * @Date: 2020-12-12 21:50:44
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
#define N 10

/**
 * @brief   输入N位数组
 * @Date    2020-12-12 22:10:43
 * @param   int* T 需要保存的数组地址
 * @return  {int} 创建结果
 */
int input(int* T);

/**
 * @brief   数组交换
 * @Date    2020-12-12 22:11:45
 * @param   int* T 需要操作的数组地址
 * @param   int V 数组长度
 */
void exchangeArray(int* T, int V);

/**
 * @brief   数组输出
 * @Date    2020-12-12 22:12:47
 * @param   int* T 需要操作的数组地址
 */
void output(int* T);

int main() {
    int number[N];
    input(number);
    exchangeArray(number,N);
    output(number);
    return OPERATION_SUCCESS;
}

int input(int* T) {
    int i;
    for (i = ZERO; i < N; i++){
    	printf("请输入%d个数字: ",(i + ONE));
        scanf("%d", &T[i]);
    }
    return OPERATION_SUCCESS;
}

void exchangeArray(int* T, int V){
    int i,temp;
    for(i=ZERO; i<V/TWO; i++){
        temp = *(T + i);
        *(T + i) = *(T + (V-ONE-i));
        *(T + (V-ONE-i)) = temp;
    }
}

void output(int* T) {
    int i;
    printf("逆序输出%d个数字",N);
    for (i = ZERO; i < N; i++){
        printf("%d ", *(T + i));
    }  
}
