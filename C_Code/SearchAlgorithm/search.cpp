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
#include <stdlib.h>
#include <string.h>
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
 * @brief   二叉树结构体
 */
typedef struct chainTree{
    ArrayType data;
    struct chainTree *leftChild, *rightChild;
}chainTree, *chainTreeNode;

/**
 * @brief   初始化树
 * @Date    2020-11-06 23:21:53
 * @author  WEI.ZHOU
 * @param   chainTreeNode &T 需要操作的节点树
 * @return  {int} 1->操作成功；0->操作失败
 */
int initTree(chainTreeNode &T);

/**
 * @brief   判断树是否为空
 * @Date    2020-11-09 19:42:35
 * @param   chainTreeNode T 需要操作的节点树
 * @return  {int} 1->空树；0->不为空
 */
int treeEmpty(chainTreeNode T);

/**
 * @brief   中序遍历
 * @date    2020-10-31 19:35:34
 * @param   chainTreeNode &T 需要遍历的节点树
 */
void printTreeInOrder(chainTreeNode& T);

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

/**
 * @brief   根据列表数据或者数组数据生成二叉查找树
 * @Date    2020-12-16 19:11:29
 * @param   chainTreeNode &T    二叉树的地址
 * @param   ArrayType arrayTest 数据数组
 * @return  {int} 1->success; 0->error
 */
int createBST(chainTreeNode& T, ArrayType* arrayTest);

/**
 * @brief   插入二叉排序树
 * @Date    2020-12-16 19:20:42
 * @param   chainTreeNode &T    需要插入的二叉排序树
 * @param   ArrayType data      插入的数据
 * @return  {int} 1->success; 0->error
 */
int insertDBT(chainTreeNode& T, ArrayType data);

/**
 * @brief   查询对应Key在二叉查找树中插入的节点
 * @Date    2020-12-16 19:26:36
 * @param   chainTreeNode &T    需要插入的二叉排序树
 * @param   ArrayType data      查询Key
 * @param   chainTreeNode fatherNode
 * 插入点的上一个节点(避免特殊情况找不到对应的插入点)
 * @param   chainTreeNode &inserNode    插入节点
 * @return  {int} 1->success; 0->error
 */
int searchNodeByKey(chainTreeNode T,
                    ArrayType data,
                    chainTreeNode fatherNode,
                    chainTreeNode& inserNode);

int main() {
    chainTreeNode T;
    ArrayType arrayTest[N] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    int index;
    // index = sequenceSearch(arrayTest, 6, N);
    // index = binarySearchOne(arrayTest, 6, N);
    index = insertionSearch(arrayTest, 6, 0, 9);
    std::cout << "在arrayTest查找6所在的位置为：" << index << LF;
    createBST(T, arrayTest);
    printTreeInOrder(T);
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

int initTree(chainTreeNode& T) {
    T = NULL;
    return OPERATION_SUCCESS;
}

void printTreeInOrder(chainTreeNode& T) {
    if (T) {
        printTreeInOrder(T->leftChild);
        std::cout << T->data << " ";
        printTreeInOrder(T->rightChild);
    }
}

int treeEmpty(chainTreeNode T) {
    if (T) {
        return OPERATION_ERROR;
    }
    return OPERATION_SUCCESS;
}

int createBST(chainTreeNode& T, ArrayType* arrayTest) {
    int i;
    int init_state, insert_state;
    init_state = initTree(T);
    if (!init_state) {
        return OPERATION_ERROR;
    }
    for (i = ZERO; i < N; i++) {
        insert_state = insertDBT(T, arrayTest[i]);
    }
    return OPERATION_SUCCESS;
}

int insertDBT(chainTreeNode& T, ArrayType data) {
    int searchState;
    chainTreeNode inserNode, fatherNode, newNode;
    fatherNode = NULL;
    searchState = searchNodeByKey(T, data, fatherNode, inserNode);
    newNode = (chainTreeNode)malloc(sizeof(chainTree));
    newNode->data = data;
    newNode->leftChild = NULL;
    newNode->rightChild = NULL;
    if (!newNode) {
        return OPERATION_ERROR;
    }
    if (!searchState) {
        if (!inserNode) {
            T = newNode;
        } else if (data < inserNode->data) {
            inserNode->leftChild = newNode;
        } else {
            inserNode->rightChild = newNode;
        }
        return OPERATION_SUCCESS;
    }
    return OPERATION_ERROR;
}

int searchNodeByKey(chainTreeNode T,
                    ArrayType data,
                    chainTreeNode fatherNode,
                    chainTreeNode& inserNode) {
    if (treeEmpty(T)) {
        inserNode = fatherNode;
        return OPERATION_ERROR;
    } else if (data == T->data) {
        inserNode = T;
        return OPERATION_SUCCESS;
    } else if (data < T->data) {
        searchNodeByKey(T->leftChild, data, T, inserNode);
    } else {
        searchNodeByKey(T->rightChild, data, T, inserNode);
    }
    return OPERATION_ERROR;
}