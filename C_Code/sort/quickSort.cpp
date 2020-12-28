/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 快速排序
 * @Author: WEI.ZHOU
 * @Date: 2020-12-28 14:26:38
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
 * @brief  快速排序
 * @Date: 2020-12-28 14:27:45
 * @param {int} *T  需要排序的集合地址
 * @param {int} l   排序范围起点
 * @param {int} k   排序范围终点
 */
void quickSort(int T[], int l, int k);

int main(){
    int a[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};
    quickSort(a, 0, 10);
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }
    return OPERATION_SUCCESS;
}

void quickSort(int T[], int l, int k) {
    // 判断传入取区间范围
    if (l < k) {
        int i = l, j = k, x = T[l];
        while (i < j) {
            // 左往右进行判断（如果：T[i]>T[j]  j进行左移动 在进行交换）
            while (i < j && T[j] >= x) {
                 j--;
            }
            if (i < j){
                T[i++] = T[j];
            }
            // 左往右进行判断（如果：T[i]<T[j]  i进行右移动 在进行交换）
            while (i < j && T[i] < x){
                i++;
            }
            if (i < j){
                 T[j--] = T[i];
            }
        }
        T[i] = x;
        quickSort(T, l, i - 1);
        quickSort(T, i + 1, k);
    }
}