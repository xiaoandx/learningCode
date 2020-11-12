/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 队列操作工具
 * @Author: WEI.ZHOU
 * @Date: 2020-11-11 18:41:38
 * @Version: V1.0
 * @Others: 
 */
#include <iostream>
#include <stdlib.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define DEF_ZERO 0
#define DEF_ONE 1
#define LF '\n'

typedef chainTreeNode DataType;

typedef struct quNode{
    DataType data;
    struct quNode *next;
}QuNode,*QuNodePrt;

typedef struct{
    QuNodePrt front,later;
}QueueLike;

/**
 * @brief 初始化链队列
 * @param  QueueLike &q 需要进行初始化的链队列
 * @return int 返回操作状态，1->成功；0->失败
 */
int initQueue(QueueLike &q){
    q.front = (QuNodePrt)malloc(sizeof(quNode));
    if(!q.front){ return OPERATION_ERROR;}
    q.front -> next = NULL;
    q.later = q.front;
    return OPERATION_SUCCESS;
}

/**
 * @brief 遍历链队列
 * @param  QueueLike &q 需要进行操作的链队列
 */
void traverseQueue(QueueLike q){
    QuNodePrt middleVariable;
    middleVariable = q.front -> next;
    while (middleVariable != NULL){
        std::cout<<middleVariable -> data<<" ";
        middleVariable = middleVariable -> next;
    }
    std::cout<<LF;
}

/**
 * @brief 向链队列插入数据
 * @param  QueueLike &q 需要进行操作的链队列
 * @param  DataType data 需要入队的值
 * @return int 返回操作状态，1->成功；0->失败
 */
int appendQueue(QueueLike &q,DataType data){
    QuNodePrt middleVariable;
    middleVariable = (QuNodePrt)malloc(sizeof(quNode));
    if(!middleVariable){ return OPERATION_ERROR;}
    middleVariable -> data = data;
    middleVariable -> next = NULL;
    q.later -> next = middleVariable;
    q.later = middleVariable;
    return OPERATION_SUCCESS;
}

/**
 * @brief 出队列
 * @param  QueueLike &q 需要进行操作的链队列
 * @param  DataType &value 出队列的具体值
 * @return int 返回操作状态，1->成功；0->失败
 */
int deleteQueue(QueueLike &q, DataType &value){
    QuNodePrt middleVariable;
    if(q.front == q.later){ return OPERATION_ERROR;}
    middleVariable = q.front -> next;
    value = middleVariable -> data;
    q.front -> next = middleVariable -> next;
    if(q.later == middleVariable){ q.later = q.front;}
    free(middleVariable);
    return OPERATION_SUCCESS; 
}

/**
 * @brief 链队列销毁
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回操作状态，1->成功；0->失败
 */
int destoryQueue(QueueLike &q){
    QuNodePrt middleVariable;
    while (!q.front){
        middleVariable = q.front -> next;
        free(q.front);
        q.front = middleVariable;
    }
    return OPERATION_SUCCESS;
}

/**
 * @brief 链队列清除
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回操作状态，1->成功；0->失败
 */
int clearQueue(QueueLike &q){
    int statusOne = destoryQueue(q);
    if(DEF_ZERO != statusOne){
        int statusTwo = initQueue(q);
        if(DEF_ZERO != statusTwo){
            return OPERATION_SUCCESS;
        }
        return OPERATION_ERROR;
    }
    return OPERATION_ERROR;
}

/**
 * @brief 获取链队列的元素长度
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回链式队列的实际元素长度
 */
int queueLength(QueueLike q){
    QuNodePrt middleVariable;
    middleVariable = q.front -> next;
    int count = DEF_ONE;
    if(q.front == q.later){ return OPERATION_ERROR;}
    while (middleVariable -> next != NULL){
        count += DEF_ONE;
        middleVariable = middleVariable -> next;
    }
    return count;
}

/**
 * @brief 获取链队列的头部元素
 * @param  QueueLike &q 需要进行操作的链队列
 * @param DataType &value 返回链式队列的头部元素的data
 */
int getFrontValue(QueueLike q, DataType &value){
    if(q.front == q.later){ return OPERATION_ERROR;}
    value = q.front -> next -> data;
    return OPERATION_SUCCESS;
}

/**
 * @brief 获取链队列的队尾元素
 * @param  QueueLike &q 需要进行操作的链队列
 * @param DataType &value 返回链式队列的队尾元素的data
 */
int getLaterValue(QueueLike q, DataType &value){
    if(q.front == q.later){ return OPERATION_ERROR;}
    value = q.later -> data;
    return OPERATION_SUCCESS;
}

/**
 * @brief 队列是否为空
 * @param  QueueLike q 需要进行操作的链队列
 * @return int 返回操作状态，1->为空；0->不为空
 */
int emptyQueue(QueueLike q){
    if(q.front == q.later){ return OPERATION_SUCCESS;}
    return OPERATION_ERROR;
}