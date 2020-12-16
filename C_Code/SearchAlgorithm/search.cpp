/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description:  查找算法分类举例
 * @Author: WEI.ZHOU
 * @Date: 2020-12-16 14:57:32
 * @Version: V1.0
 * @Others: Running test instructions
 *          1）静态查找和动态查找；
 *              注：静态或者动态都是针对查找表而言的。动态表指查找表中有删除和插入操作的表。
 *          2）无序查找和有序查找。
 *              无序查找：被查找数列有序无序均可；
 *              有序查找：被查找数列必须为有序数列。
 *          3）平均查找长度（Average Search Length，ASL）：
 *              需和指定key进行比较的关键字的个数的期望值，称为查找算法在查找成功时的平均查找长度。
 *              对于含有n个数据元素的查找表，查找成功的平均查找长度为：ASL = P i*C i的和。
 *              P i：查找表中第i个数据元素的概率。
 *              C i：找到第i个数据元素时已经比较过的次数。
 * 			
 */
#include <iostream>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define MINUS_ONE -1
#define ONE 1
#define TWO 2
#define ZERO 0
#define LF '\n'
#define N 10

typedef int ArrayType;

/**
 * @brief   顺序查找
 * @Date    2020-12-16 15:01:55
 * @param   ArrayType *T    被查询对象
 * @param   ArrayType value 查询对象
 * @param   int n           被查询对象数组长度
 * @return  {int} -1——>not value
 */
int sequenceSearch(ArrayType* T, ArrayType value, int n);

/**
 * @brief   二分查找(一)
 * @Date    2020-12-16 15:11:24
 * @param   ArrayType *T    被查询对象
 * @param   ArrayType value 查询对象
 * @param   int n           被查询对象数组长度
 * @return  {int} -1——>not value
 */
int binarySearchOne(ArrayType* T, ArrayType value, int n);

/**
 * @brief   二分查找(二)
 * @Date    2020-12-16 15:11:24
 * @param   ArrayType *T    被查询对象
 * @param   ArrayType value 查询对象
 * @param   int low         查询范围起点
 * @param   int high        查询范围尾点
 * @return  {int} -1——>not value
 */
int binarySearchTwo(ArrayType* T, ArrayType value, int low, int high);

/**
 * @brief   插值查找 
 * @Date    2020-12-16 15:20:03
 * @param   ArrayType *T    被查询对象
 * @param   ArrayType value 查询对象
 * @param   int low         查询范围起点
 * @param   int high        查询范围尾点
 * @return  {int} -1——>not value
 */
int insertionSearch(ArrayType* T, ArrayType value, int low, int high);

int main() {
    ArrayType arrayTest[N] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int index;
    //index = sequenceSearch(arrayTest, 6, N);
    //index = binarySearchOne(arrayTest, 6, N);
    index = insertionSearch(arrayTest, 6, 0, 9);
    std::cout << "在arrayTest查找6所在的位置为：" << index << LF;
    return OPERATION_SUCCESS;
}

int sequenceSearch(ArrayType* T, ArrayType value, int n) {
    int i;
    for (i = ZERO; i < n; i++) {
        if (T[i] == value) {
            return i;
        }
    }
    return MINUS_ONE;
}

int binarySearchOne(ArrayType* T, ArrayType value, int n) {
    int low, high, mid;
    low = ZERO;
    high = n - ONE;
    while (low <= high) {
        mid = (low + high) / TWO;
        if (T[mid] == value)
            return mid;
        if (T[mid] > value)
            high = mid - ONE;
        if (T[mid] < value)
            low = mid + ONE;
    }
    return MINUS_ONE;
}

int binarySearchTwo(ArrayType* T, ArrayType value, int low, int high) {
    int mid = low + (high - low) / TWO;
    if (T[mid] == value)
        return mid;
    if (T[mid] > value)
        return binarySearchTwo(T, value, low, mid - ONE);
    if (T[mid] < value)
        return binarySearchTwo(T, value, mid + ONE, high);
    return mid;
}

int insertionSearch(ArrayType* T, ArrayType value, int low, int high) {
    int mid = low + (value - T[low]) / (T[high] - T[low]) * (high - low);
    if (T[mid] == value)
        return mid;
    if (T[mid] > value)
        return insertionSearch(T, value, low, mid - ONE);
    if (T[mid] < value)
        return insertionSearch(T, value, mid + ONE, high);
    return mid;
}