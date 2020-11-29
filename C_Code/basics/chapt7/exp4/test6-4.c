/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 下面程序的功能是：求二维数组a中的上三角元素之和。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-29 10:34:51
 * @Version: V1.0
 * @Others: Running test instructions
 *          例如：a中的元素为：
 *                        4    4    34    37
                          7    3    12    8
                          5    6     5    52
                          24   23    2    10
 * 			
 */
#include <stdio.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ZERO 0
#define ONE 1
#define TWO 2
#define N 4

/**
 * @brief   矩阵上三角和
 * @Date    2020-11-29 10:38:30
 * @param   int array[N][N] 矩阵
 * @return  {int} 上三角和
 */
int arraySum(int array[N][N]);

int main(){
    int a[N][N] = {4, 4, 34, 37, 7, 3, 12, 8, 5, 6, 5, 52, 24, 23, 2, 10};
    printf("The up-right sum is: %d\n", arraySum(a));
    return OPERATION_SUCCESS;
}

int arraySum(int array[N][N]) {
    int i, j, sum;
    sum = 0;
    for (i = ZERO; i < N; i++) {
        for (j = i; j < N; j++) {
            if (i != j) {
                sum += array[i][j];
            }
        }
    }
    return sum;
}
