/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 选择排序
 * @Author: WEI.ZHOU
 * @Date: 2020-12-28 14:33:57
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
 * @brief:  选择排序
 * @param {int} *T  需要排序的集合地址
 * @param {int} n   数据集合的长度
 */
void selectSort(int T[], int n);

int main(){
    int a[] = {12, 3, 45, 98, 34, 26, 29, 109, 27, 208, 6};
    selectSort(a, 11);
    for (int i = 0; i < 11; i++) {
        std::cout << a[i] << " ";
    }
    return OPERATION_SUCCESS;
}

void selectSort(int T[], int n){
    int i,j;
    int minIndex, temp;
    for(i=0;i<n;i++ ){
        minIndex = i;
        for(j = i+1; j<n;j++){
            if(T[j]<T[minIndex]){
                minIndex = j;
            }
        }
        temp = T[i];
        T[i] = T[minIndex];
        T[minIndex] = temp;
    }
}