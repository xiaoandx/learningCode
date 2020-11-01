/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description: 数组排序
 * @Author: WEI.ZHOU
 * @Date: 2020-11-01 15:47:55
 * @Version: V1.0
 * @LastEditTime: 2020-11-01 17:49:52
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>

#define INIT_MAX_SIZE 256

/**
 * @brief   冒泡降序
 * @date    2020-11-01 17:36:15
 * @author  WEI.ZHOU
 * @param   int T[] 需要排序的数组
 * @param   int T_Size 数组长度
 */
void dropSort(int T[], int T_Size);

/**
 * @brief   数组打印
 * @date    2020-11-01 17:36:15
 * @author  WEI.ZHOU
 * @param   int T[] 需要打印的数组
 * @param   int T_Size 数组长度
 */
void printArray(int T[], int T_Size);

int main() {
    // 创建定义一个保存输入数值的数组
    int number[INIT_MAX_SIZE];
    // 记录数组保存数据的长度
    int arraySize = 0;
    // 记录回车字符
    char inputChar;
    // 记录输入的数据
    printf("请输入数字逗号分隔：");
    do {
        scanf("%d", &number[arraySize++]);
    } while ((inputChar = getchar()) != '\n');

    // 降序排序
    dropSort(number, arraySize);
    // 数组打印
    printArray(number, arraySize);
    return 0;
}

void dropSort(int T[], int T_Size) {
    int j, k, t;
    for (j = 0; j < T_Size; j++) {
        for (k = j + 1; k < T_Size; k++)
            if (T[j] < T[k]) {
                t = T[k];
                T[k] = T[j];
                T[j] = t;
            }
    }
}

void printArray(int T[], int T_Size) {
    for (int i = 0; i < T_Size; i++) {
        printf("%d  ", T[i]);
    }
    printf("\n");
}