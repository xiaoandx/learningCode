/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 用指针，实现从键盘输入十个整数，计算出最大值和最小值，并返回它们所在的数组中的位置
 * @Author: WEI.ZHOU
 * @Date: 2020-12-12 21:50:44
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define INIT_MAX_NUMBER 999999
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
 * @brief   查找数组最大值及下标
 * @Date    2020-12-12 22:11:45
 * @param   int* T 需要操作的数组地址
 * @param   int V 数组长度
 */
void findArrayMax(int* T, int V);

/**
 * @brief   查找数组最小值及下标
 * @Date    2020-12-12 22:11:45
 * @param   int* T 需要操作的数组地址
 * @param   int V 数组长度
 */
void findArrayMin(int* T, int V);

int main() {
    int number[N];
    input(number);
    findArrayMax(number,N);
    findArrayMin(number,N);
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

void findArrayMax(int* T, int V){
	int i;
    int index = ZERO;
    int max = *T;
    for(i=ZERO; i<V; i++){
        if(*(T + i) > max){
            max = *(T + i);
            index = i;
        }
    }
    printf("数组中最大的数为%d,在第%d位\n",max, index);
}

void findArrayMin(int* T, int V){
    int i, index = ZERO;
    int min = INIT_MAX_NUMBER;
    for (i = ZERO; i < V; i++) {
        if (*(T + i) < min) {
            min = *(T + i);
            index = i;
        }
    }
    printf("数组中最小的数为%d,在第%d位\n", min, index);
}