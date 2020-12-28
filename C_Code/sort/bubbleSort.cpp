/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 冒泡排序+冒泡改进
 * @Author: WEI.ZHOU
 * @Date: 2020-12-24 21:10:56
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <iostream>
#include <stdlib.h>
#include <string.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define MINUS_ONE -1
#define ONE 1
#define TWO 2
#define ZERO 0
#define LF '\n'

/**
 * @brief:  原始冒泡排序
 * @Date: 2020-12-24 21:12:51
 * @param {int} T[] 需要进行排序的集合
 * @param {int} n   集合的数据长度
 */
void bubbleSort(int T[], int n);

/**
 * @brief:  冒泡排序修改型
 * @Date: 2020-12-24 21:16:39
 * @param {int} T[] 需要进行排序的数据集合
 * @param {int} n 数据集合的长度
 */
void bubbleSort2(int T[], int n);

int main(){
    int a[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};
    bubbleSort(a, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }
    return OPERATION_SUCCESS;
}

void bubbleSort(int T[], int n) {
    int i, j, temp;
    for (i = 0; i < n - 1; i++) {
        for (j = n - 1; j > i; j--) {
            if (T[j - 1] > T[j]) {
                temp = T[j];
                T[j] = T[j - 1];
                T[j - 1] = temp;
            }
        }
    }
}

void bubbleSort2(int T[], int n) {
    int i, j, temp;
    int flag = 1;
    for (i = 0; i < n - 1 && flag; i++) {
        flag = 0;
        for (j = n - 1; j > i; j--) {
            if (T[j] < T[j - 1]) {
                temp = T[j];
                T[j] = T[j - 1];
                T[j - 1] = temp;
                flag = 1;
            }
        }
    }
}