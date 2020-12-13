/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 用指针将一个a[4][4]  =  { 1,1,1,1,  2,2,2,2,  3,3,3,3,4,4,4,4 }转置。
 * @Author: WEI.ZHOU
 * @Date: 2020-12-12 21:50:44
 * @Version: V1.0
 * @Others: Running test instructions
 *          1.  *(T[1]+1)--------表示的是T[1][1]的值
 *          2.  (*T+1)[1]--------表示的是T[0][2]的值	
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ZERO 0
#define ONE 1
#define TWO 2
#define LF '\n'
#define N 4

/**
 * @brief   二维数组置换
 * @Date    2020-12-12 22:11:45
 * @param   int (*T)[N] 需要操作的数组地址
 * @param   int V 数组长度
 */
void transpositionArray(int (*T)[N], int V);

/**
 * @brief   数组输出
 * @Date    2020-12-12 22:12:47
 * @param   int (*T)[N] 需要操作的数组地址
 */
void output(int (*T)[N]);

int main() {
    int number[N][N] = {1, 1, 1, 1, 2, 2, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4};
    transpositionArray(number, N);
    output(number);
    return OPERATION_SUCCESS;
}

void transpositionArray(int (*T)[N], int V) {
    int i, j;
    int(*p)[N] = T;
    int s[N][N];
    for (i = ZERO; i < V; i++) {
        for (j = ZERO; j < V; j++) {
            // s[i][j] = p[j][i];
            *(s[i] + j) = *(p[j] + i);
        }
    }
    for (i = ZERO; i < V; i++) {
        for (j = ZERO; j < V; j++) {
            // T[i][j] = s[i][j];
            *(T[i] + j) = *(s[i] + j);
        }
    }
}

void output(int (*T)[N]) {
    int i, j;
    for (i = ZERO; i < N; i++) {
        for (j = ZERO; j < N; j++) {
            printf("%d ", *(T[i] + j));
        }
        printf("\n");
    }
}
