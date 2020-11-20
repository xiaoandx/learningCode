/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description: 用选择法对十个数排序
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 12:48:39
 * @Version: V1.0
 * @Others: Running test instructions
 *          1. 分析题目得到，需要将数组进行排序（升序/降序）
 *          2. 选择排序创建两个自定义方法，升序、降序的方法（main）中都进行方法调用
 */
#include <stdio.h>
#define N 10
#define DEF_ONE 1
#define DEF_ZERO 0

/**
 * @brief   数组升序排序
 * @Date    2020-11-14 12:52:31
 * @param   int T[]  需要排序的数组
 * @param   int V  数组长度
 */
void arrayRiseSort(int T[], int V);

/**
 * @brief   数组降序排序
 * @Date    2020-11-14 12:52:31
 * @param   int T[]  需要排序的数组
 * @param   int V  数组长度
 */
void arrayDropSort(int T[], int V);

int main() {
    int arrN[N];
    // 循环输入数组
    for (int i = DEF_ZERO; i < N; i++) {
        printf("请输入数组arr的第%d个数:", i + DEF_ONE);
        scanf("%d", &arrN[i]);
    }
    // 输出输入的数组
    printf("\n输入的数组arr为：");
    for (int i = DEF_ZERO; i < N; i++) {
        printf("%d  ", arrN[i]);
    }
    // 排序输出
    printf("\n选择降序排序后的数组为：");
    arrayDropSort(arrN, N);
    printf("\n选择升序排序后的数组为：");
    arrayRiseSort(arrN, N);

    return DEF_ONE;
}

void arrayRiseSort(int T[], int V) {
    int tepm;
    for (int i = DEF_ZERO; i < V; i++) {
        // T[i]依次和T[i]之后的元素作比较
        for (int j = i + 1; j < V; j++) {
            // 如果有比T[i]小的则两个比较数交换
            if (T[i] > T[j]) {
                tepm = T[i];
                T[i] = T[j];
                T[j] = tepm;
            }
        }
    }
    for (int i = DEF_ZERO; i < V; i++) {
        printf("%d  ", T[i]);
    }
    printf("\n");
}

void arrayDropSort(int T[], int V) {
    int tepm;
    for (int i = DEF_ZERO; i < V; i++) {
        // T[i]依次和T[i]之后的元素作比较
        for (int j = i + 1; j < V; j++) {
            // 如果有比T[i]大的则两个比较数交换
            if (T[i] < T[j]) {
                tepm = T[i];
                T[i] = T[j];
                T[j] = tepm;
            }
        }
    }
    for (int i = DEF_ZERO; i < V; i++) {
        printf("%d  ", T[i]);
    }
    printf("\n");
}
