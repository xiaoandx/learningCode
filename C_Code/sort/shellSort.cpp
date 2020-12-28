/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 希尔排序
 * @Author: WEI.ZHOU
 * @Date: 2020-12-24 21:05:31
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
 * @brief:  希尔排序
 * @Date: 2020-12-24 21:06:55
 * @param {int} T[] 需要进行排序的集合
 * @param {int} n   集合数据的长度
 */
void shellSort(int T[], int n);

int main() {
    int a[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};
    shellSort(a, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }
    return OPERATION_SUCCESS;
}

void shellSort(int T[], int n) {
    int i, j, temp;
    int gap = n;
    do {
        gap = gap / 3 + 1;
        for (i = gap; i < n; i = i + 1) {
            if (T[i] < T[i - gap]) {
                temp = T[i];
                for (j = i - gap; T[j] > temp && j >= 0; j = j - gap) {
                    T[j + gap] = T[j];
                }
                T[j + gap] = temp;
            }
        }
    } while (gap > 1);
}
