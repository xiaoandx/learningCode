/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 9 用指针变量作为函数参数，按从小到大的顺序输出三个整数
 * @Author: WEI.ZHOU
 * @Date: 2020-12-13 10:51:25
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
#define N 3

/**
 * @brief   输入N位数组
 * @Date    2020-12-12 22:10:43
 * @param   int* T 需要保存的数组地址
 * @return  {int} 创建结果
 */
int input(int* T);

/**
 * @brief   数组升序排序
 * @Date    2020-11-14 12:52:31
 * @param   int* T 需要操作的数组地址
 * @param   int V  数组长度
 */
void arrayRiseSort(int* T, int V);

/**
 * @brief   数组输出
 * @Date    2020-12-12 22:12:47
 * @param   int* T 需要操作的数组地址
 */
void output(int* T);

int main() {
    int number[N];
    input(number);
    arrayRiseSort(number,N);
    output(number);
    return OPERATION_SUCCESS;
}

int input(int* T) {
    int i;
    for (i = ZERO; i < N; i++){
    	printf("请输入第%d个整数: ",(i + ONE));
        scanf("%d", &T[i]);
    }
    return OPERATION_SUCCESS;
}

void arrayRiseSort(int* T, int V) {
    int i, j, tepm;
    for (i = ZERO; i < V; i++) {
        for (j = i + ONE; j < V; j++) {
            if (*(T + i) > *(T + j)) {
                tepm = *(T + i);
                *(T + i) = *(T + j);
                *(T + j) = tepm;
            }
        }
    }
}

void output(int* T) {
    int i;
    printf("升序输出%d个整数：",N);
    for (i = ZERO; i < N; i++){
        printf("%d ", *(T + i));
    }  
}
