/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 排序部分算法
 * @Author: WEI.ZHOU
 * @Date: 2020-12-28 14:56:02
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

/**
 * @brief: 插入排序算法
 * @Date: 2020-12-24 20:52:53
 * @param {int} T[] 需要排序的集合
 * @param {int} n   几个数据个数
 */
void insertSort(int T[], int n);

/**
 * @brief:  希尔排序
 * @Date: 2020-12-24 21:06:55
 * @param {int} T[] 需要进行排序的集合
 * @param {int} n   集合数据的长度
 */
void shellSort(int T[], int n);

/**
 * @brief:  冒泡排序修改型
 * @Date: 2020-12-24 21:16:39
 * @param {int} T[] 需要进行排序的数据集合
 * @param {int} n 数据集合的长度
 */
void bubbleSort2(int T[], int n);

/**
 * @brief:  冒泡排序
 * @Date: 2020-12-24 21:16:39
 * @param {int} T[] 需要进行排序的数据集合
 * @param {int} n 数据集合的长度
 */
void bubbleSort(int T[], int n);

/**
 * @brief:  选择排序
 * @param {int} *T  需要排序的集合地址
 * @param {int} n   数据集合的长度
 */
void selectSort(int T[], int n);

int main() {
    int a[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};
    std::cout << "原始数据集合(未排序)：";
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }

    std::cout << LF << " 快速排序：";
    quickSort(a, 0, 10);
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }
    int b[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};

    std::cout << LF << " 插入排序：";
    insertSort(b, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << b[i] << " ";
    }
    int c[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};

    std::cout << LF << " 希尔排序：";
    shellSort(c, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << c[i] << " ";
    }
    int d[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};

    std::cout << LF << " 冒泡排序：";
    bubbleSort2(d, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << d[i] << " ";
    }
    int e[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};

    std::cout << LF << " 选择排序：";
    selectSort(e, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << e[i] << " ";
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
            if (i < j) {
                T[i++] = T[j];
            }
            // 左往右进行判断（如果：T[i]<T[j]  i进行右移动 在进行交换）
            while (i < j && T[i] < x) {
                i++;
            }
            if (i < j) {
                T[j--] = T[i];
            }
        }
        T[i] = x;
        quickSort(T, l, i - 1);
        quickSort(T, i + 1, k);
    }
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

void selectSort(int T[], int n) {
    int i, j;
    int minIndex, temp;
    for (i = 0; i < n; i++) {
        minIndex = i;
        for (j = i + 1; j < n; j++) {
            if (T[j] < T[minIndex]) {
                minIndex = j;
            }
        }
        temp = T[i];
        T[i] = T[minIndex];
        T[minIndex] = temp;
    }
}