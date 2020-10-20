/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 									<xiaoandx@gmail.com>
 * 
 * @Description: 双端队列（链式）
 * @Author: WEI.ZHOU
 * @Date: 2020-10-20 19:59:47
 * @Version: V1.0
 * @LastEditTime: 2020-10-20 20:21:28
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define VALUE_ZERO 0
#define CHANGE_VALUE_ONE 1
#define INIT_VALUE_ONE 1

typedef struct quNode{
    int data; 
    struct quNode *next,*last;
}QuNode,*QuNodePrt;

typedef struct{
    QuNodePrt front,later;
}QueueLike;

/**
 * @brief 初始化双端队列
 * @date  2020-10-20 20:04:22
 * @param  QueueLike 需要进行初始化的双端链队列
 * @return {int} 返回操作状态，1->成功；0->失败
 */
int initDoubleQueue(QueueLike &q);

/**
 * @brief 入队
 * @Date: 2020-10-20 20:19:30
 * @param  QueueLike 需要进行操作的双端链队列
 * @param  int data 需要入队的数据
 * @return {int} 返回操作状态，1->成功；0->失败
 */
int appendDoubleQueue(QueueLike &q,int data);

int main(){
    QueueLike q;
    cout<<initDoubleQueue(q)<<endl;
    appendDoubleQueue(q,12);
}

int initDoubleQueue(QueueLike &q){
    q.front = (QuNodePrt)malloc(sizeof(quNode));
    if(!q.front){ return OPERATION_ERROR;}
    q.front -> next = NULL;
    q.front -> last = NULL;
    q.later = q.front;
    return OPERATION_SUCCESS;
}

int appendDoubleQueue(QueueLike &q,int data){
    if(!q.front){ return OPERATION_ERROR;}
    
}