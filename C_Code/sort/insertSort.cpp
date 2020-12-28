/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 插入排序
 * @Author: WEI.ZHOU
 * @Date: 2020-12-24 19:10:25
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
 * @brief: 插入排序算法
 * @Date: 2020-12-24 20:52:53
 * @param {int} T[] 需要排序的集合
 * @param {int} n   几个数据个数
 */
void insertSort(int T[], int n);

/**
 * @brief: 折半插入排序 
 * @Date: 2020-12-24 20:59:21
 * @param {int} T[] 需要排序的集合
 * @param {int} n   集合个数
 */
void insertSortHaif(int T[], int n);

int main(){
    int a[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};
    // insertSort(a, 11);
    insertSortHaif(a, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }
    return OPERATION_SUCCESS;
}

void insertSort(int T[], int n) {
    int i, j, temp;
    for (i = 1; i < n; i++) {
        if (T[i] < T[i - 1]) {
            temp = T[i];
            for (j = i - 1; T[j] > temp && j >= 0; j--) {
                T[j + 1] = T[j];
            }
            T[j + 1] = temp;
        }
    }
}

void insertSortHaif(int T[], int n) {
    int i, j, temp;
    int low, high, mid;
    for (i = 1; i < n; i++) {
        low = 0;
        high = i - 1;
        temp = T[i];
        while (low <= high) {
            mid = (int)(low + high) / 2;
            if (temp < T[mid])
                high = mid - 1;
            else
                low = mid + 1;
        }
        for (j = i - 1; j >= high + 1; j--) {
            T[j + 1] = T[j];
        }
        T[j + 1] = temp;
    }
}