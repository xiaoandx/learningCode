/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 循环队列
 * @Author: WEI.ZHOU
 * @Date: 2020-10-21 21:02:48
 * @Version: V1.0
 * @LastEditTime: 2020-10-21 21:40:41
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>
#include <stdlib.h>
using namespace std;

#define INIT_QUEUE_SIZE 5
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define VALUE_ZERO 0
#define CHANGE_VALUE_ONE 1

typedef struct{
    int *base;
    int front,rear;
}LoopQueue;

/**
 * @brief   初始化循环队列
 * @Date    2020-10-21 21:05:54
 * @param   LoopQueue 需要进行初始化的循环队列
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int initLoopQueue(LoopQueue &lq);

/**
 * @brief   遍历循环队列
 * @Date    2020-10-21 21:10:55
 * @param   LoopQueue 需要进行操作的循环队列
 */
void traverseLoopQueue(LoopQueue lq);

/**
 * @brief   向队列插入数据元素
 * @Date    2020-10-21 21:21:50
 * @param   LoopQueue 需要进行操作的循环队列
 * @param   int data 插入的元素 
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int appendLoopQueue(LoopQueue &lq,int data);

/**
 * @brief   从队列中删除数据元素
 * @Date    2020-10-21 21:29:00
 * @param   LoopQueue 需要进行操作的循环队列
 * @param   int &value 删除的具体元素
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int deleteLoopQueue(LoopQueue &lq,int &value);

/**
 * @brief   获取循环队列的长度
 * @Date    2020-10-21 21:35:23
 * @param   LoopQueue 需要进行操作的循环队列
 * @return  {int} 队列的具体长度
 */
int getLoopQueueLength(LoopQueue lq);

/**
 * @brief   判断循环队列是否为空
 * @Date    2020-10-21 21:38:18
 * @param   LoopQueue 需要进行操作的循环队列
 * @return  {int} 返回操作状态，1->不为空；0->为空
 */
int emptyLoopQueue(LoopQueue lq);

int main(){
    LoopQueue lq;
    int value;
    initLoopQueue(lq);
    appendLoopQueue(lq,12);
    appendLoopQueue(lq,13);
    appendLoopQueue(lq,14);
    appendLoopQueue(lq,15);
    appendLoopQueue(lq,16);
    traverseLoopQueue(lq);
    cout<<"lq length:"<<getLoopQueueLength(lq)<<endl;
    deleteLoopQueue(lq,value);
    traverseLoopQueue(lq);
    cout<<"lq length:"<<getLoopQueueLength(lq)<<endl;
    return OPERATION_SUCCESS;
}

int initLoopQueue(LoopQueue &lq){
    lq.base = (int *)malloc(INIT_QUEUE_SIZE * sizeof(int));
    if(!lq.base){ return OPERATION_ERROR;}
    lq.front = VALUE_ZERO;
    lq.rear = VALUE_ZERO;
    return OPERATION_SUCCESS;
}

void traverseLoopQueue(LoopQueue lq){
    while (lq.front != lq.rear){
        cout<<lq.base[lq.front]<<" ";
        lq.front = (lq.front + CHANGE_VALUE_ONE) % INIT_QUEUE_SIZE;
    }
    cout<<endl;
}

int appendLoopQueue(LoopQueue &lq,int data){
    if((lq.rear + 1)%INIT_QUEUE_SIZE == lq.front){ return OPERATION_ERROR;}
    lq.base[lq.rear] = data;
    lq.rear = (lq.rear + CHANGE_VALUE_ONE) % INIT_QUEUE_SIZE;
    return OPERATION_SUCCESS;
}

int deleteLoopQueue(LoopQueue &lq,int &value){
    if(lq.front == lq.rear){ return OPERATION_ERROR;}
    value = lq.base[lq.front];
    lq.front = (lq.front + CHANGE_VALUE_ONE) % INIT_QUEUE_SIZE;
    return OPERATION_SUCCESS;
}

int getLoopQueueLength(LoopQueue lq){
    return (lq.rear - lq.front + INIT_QUEUE_SIZE) % INIT_QUEUE_SIZE;
}

int emptyLoopQueue(LoopQueue lq){
    if(lq.front  == lq.rear){ return OPERATION_ERROR;}
    return OPERATION_SUCCESS;
}