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
#include <stdlib.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define INIT_MAX_NUMBER 99999
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

/**
 * @brief   查找数组最大值及下标
 * @Date    2020-12-12 22:11:45
 * @param   int* T 需要操作的数组地址
 * @param   int V 数组长度
 * @return  {int} 最大数位置
 */
int findArrayMax(int* T, int V);

/**
 * @brief   查找数组最小值及下标
 * @Date    2020-12-12 22:11:45
 * @param   int* T 需要操作的数组地址
 * @param   int V 数组长度
 * @return  {int} 最小数位置
 */
int findArrayMin(int* T, int V);

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
    int temp = ZERO;
    int maxIndex = findArrayMax(T, V);
    int minIndex = findArrayMin(T, V);
    temp = *T;
    *T = *(T + minIndex);
    *(T + minIndex) = temp;
    temp = *(T + N - ONE);
    *(T + N - ONE) = *(T + maxIndex);
    *(T + maxIndex) = temp;
}

void output(int* T) {
    int i;
    printf("逆序输出%d个数字",N);
    for (i = ZERO; i < N; i++){
        printf("%d ", *(T + i));
    }  
}

int findArrayMax(int* T, int V){
	int i, j;
    int index = ZERO;
    int *temp = (int*)malloc(N * sizeof(int));
    for(j = ZERO;j<N;j++){
        temp[j] = T[j];
    }
    int max = *temp;
    for(i=ZERO; i<V; i++){
        if(*(temp + i) > max){
            max = *(temp + i);
            index = i;
        }
    }
    free(temp);
    return index;
}

int findArrayMin(int* T, int V){
    int i, j, index = ZERO;
    int *temp = (int*)malloc(N * sizeof(int));
    for(j = ZERO;j<N;j++){
        temp[j] = T[j];
    }
    int min = INIT_MAX_NUMBER;
    for (i = ZERO; i < V; i++) {
        if (*(temp + i) < min) {
            min = *(temp + i);
            index = i;
        }
    }
    free(temp);
    return index;
}