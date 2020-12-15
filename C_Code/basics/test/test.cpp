/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 输入三条边判断是否构成三角形，并判断构成什么类型的三角形
 * @Author: WEI.ZHOU
 * @Date: 2020-12-14 16:33:58
 * @Version: V1.0
 * @Others: Running test instructions
 *          1.输入三角形三边时，每输入一条边就进行回车 eg：3 \n
 * 			
 */
#include <stdlib.h>
#include <iostream>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define ONE 1
#define TWO 2
#define ZERO 0
#define LF '\n'
#define N 3

/**
 * @brief   输入三角形三条边
 * @Date    2020-12-15 14:11:51
 * @return  {int *} 包含三角形三条边的数组
 */
int* getTriangleSideArray();

/**
 * @brief   判断3条边是否构成三角形并判断什么类型
 * @Date    2020-12-14 17:05:45
 * @param   int *T  三角形三边长度
 * @return  0->error; 1->等腰; 2->等边; 3->直角; 4->一般
 */
int judgeTriangle(int* T);

/**
 * @brief   输出判断结果
 * @Date    2020-12-14 17:34:28
 * @param   int V   判断状态
 */
void printResult(int V);

int main() {
    // int* sideArray = getTriangleSideArray();
    // int resut = judgeTriangle(sideArray);
    // printResult(resut);
    printResult(judgeTriangle(getTriangleSideArray()));
    return OPERATION_SUCCESS;
}

int* getTriangleSideArray() {
    int* sideArray;
    int i;
    sideArray = (int*)malloc(N * sizeof(int));
    for (i = ZERO; i < N; i++) {
        std::cout << "输入三角形第" << (i + ONE) << "条边: ";
        int data;
        std::cin >> data;
        for (; (data > 100 || data < 1);) {
            std::cout << "输入第" << (i + ONE) << "错误 ！！" << LF;
            std::cout << "再次输入三角形第" << (i + ONE) << "条边: ";
            std::cin >> data;
        }
        sideArray[i] = data;
    }
    return sideArray;
}

int judgeTriangle(int* T) {
    /**
     * @brief   变量说明
     * int result 判断结果
     * 0->error; 1->等腰; 2->等边; 3->直角; 4->一般
     */
    if ((T[ZERO] + T[ONE] > T[TWO]) && (T[ZERO] + T[TWO] > T[ONE]) &&
        (T[ONE] + T[TWO] > T[ZERO])) {
        if ((T[ZERO] == T[ONE] && T[ONE] != T[TWO]) ||
            (T[ZERO] == T[TWO] && T[TWO] != T[ONE]) ||
            (T[ONE] == T[TWO] && T[ZERO] != T[TWO])) {
            free(T);
            return ONE;
        }

        if (T[ZERO] == T[ONE] && T[ZERO] == T[TWO]) {
            free(T);
            return TWO;
        } else {
            if ((T[ZERO] * T[ZERO] + T[ONE] * T[ONE] == T[TWO] * T[TWO]) ||
                (T[ZERO] * T[ZERO] + T[TWO] * T[TWO] == T[ONE] * T[ONE]) ||
                (T[TWO] * T[TWO] + T[ONE] * T[ONE] == T[ZERO] * T[ZERO])) {
                free(T);
                return (ONE + TWO);
            }
            free(T);
            return (TWO * TWO);
        }

        if ((T[ZERO] == T[ONE] && T[ONE] != T[TWO]) ||
            (T[ZERO] == T[TWO] && T[TWO] != T[ONE]) ||
            (T[ONE] == T[TWO] && T[ZERO] != T[TWO])) {
            free(T);
            return ONE;
        }
    }
    free(T);
    return ZERO;
}

void printResult(int V) {
    switch (V) {
        case ZERO:
            std::cout << "input error! It's not a triangle" << LF;
            break;
        case ONE:
            std::cout << "等腰三角形" << LF;
            break;
        case TWO:
            std::cout << "等边三角形" << LF;
            break;
        case TWO + ONE:
            std::cout << "直角三角形" << LF;
            break;
        default:
            std::cout << "一般三角形" << LF;
            break;
    }
}