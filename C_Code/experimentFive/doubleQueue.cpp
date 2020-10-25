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
 * @LastEditTime: 2020-10-23 13:21:08
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define VALUE_ZERO 0

typedef struct quNode{
    int data; 
    struct quNode *next,*last;
}QuNode,*QuNodePrt;

typedef struct{
    QuNodePrt front,later;
}QueueLike;

/**
 * @brief   初始化双端队列
 * @date    2020-10-20 20:04:22
 * @param   QueueLike 需要进行初始化的双端链队列
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int initDoubleQueue(QueueLike &q);

/**
 * @brief   入队
 * @Date    2020-10-20 20:19:30
 * @param   QueueLike 需要进行操作的双端链队列
 * @param   int data 需要入队的数据
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int pushDoubleQueue(QueueLike &q,int data);

/**
 * @brief   出队列
 * @Date:   2020-10-21 10:48:36
 * @param   QueueLike 需要进行操作的双端链队列
 * @param   int value 出队的数据 
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int popDoubleQueue(QueueLike &q,int &value);

/**
 * @brief   遍历双端队列
 * @Date:   2020-10-21 11:14:16
 * @param   QueueLike 需要进行操作的双端链队列
 */
void traverseDoubleQueue(QueueLike q);

/**
 * @brief   队尾添加元素
 * @Date:   2020-10-21 11:23:24
 * @param   QueueLike 需要进行操作的双端链队列
 * @param   int data 需要入队的数据
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int rearPushDoubleQueue(QueueLike &q,int data);

/**
 * @brief   队尾删除元素
 * @Date:   2020-10-21 11:27:47
 * @param   QueueLike 需要进行操作的双端链队列
 * @param   int value 出队的数据 
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int rearPopDoubleQueue(QueueLike &q,int &value);

/**
 * @brief   判断双端队列是否为空
 * @Date:   2020-10-21 11:34:47
 * @param   QueueLike 需要进行操作的双端链队列 
 * @return  {int} 返回操作状态，1->不为空；0->为空
 */
int emptyDoubleQueue(QueueLike q);

/**
 * @brief   销毁双端队列
 * @Date:   2020-10-21 12:39:10
 * @param   QueueLike 需要进行操作的双端链队列 
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int destoryDoubleQueue(QueueLike &q);

/**
 * @brief   清空双端队列
 * @Date    2020-10-21 12:45:37
 * @param   QueueLike 需要进行操作的双端链队列 
 * @return  {int} 返回操作状态，1->成功；0->失败
 */
int clearDoubleQueue(QueueLike &q);

void add();
int main(){
    QueueLike q;
    int value;
    cout<<initDoubleQueue(q)<<endl;
    pushDoubleQueue(q,12);
    pushDoubleQueue(q,13);
    destoryDoubleQueue(q);
    traverseDoubleQueue(q);
    //popDoubleQueue(q,value);
    //cout<<value<<endl;
    //rearPushDoubleQueue(q,19);
    //traverseDoubleQueue(q);
    //cout<<emptyDoubleQueue(q)<<endl;
}

int initDoubleQueue(QueueLike &q){
    q.front = (QuNodePrt)malloc(sizeof(quNode));
    if(!q.front){ return OPERATION_ERROR;}
    q.front -> next = NULL;
    q.front -> last = NULL;
    q.later = q.front;
    return OPERATION_SUCCESS;
}

int pushDoubleQueue(QueueLike &q,int data){
    QuNodePrt middleVariable;
    if(!q.front){ return OPERATION_ERROR;}
    middleVariable = (QuNodePrt)malloc(sizeof(quNode));
    if(!middleVariable){ return OPERATION_ERROR;}  
    middleVariable -> data = data;
    if(q.front == q.later){
        q.front -> next = middleVariable;
        middleVariable -> last = q.front;
        middleVariable -> next = NULL;
        q.later = middleVariable;
        return OPERATION_SUCCESS;
    }
    middleVariable -> next = q.front -> next;
    middleVariable -> last = q.front;
    q.front -> next -> last = middleVariable;
    q.front -> next = middleVariable;
    return OPERATION_SUCCESS; 
}

int popDoubleQueue(QueueLike &q,int &value){
    QuNodePrt middleVariable;
    if(q.front == q.later){ return OPERATION_ERROR;}
    middleVariable = q.front -> next;
    value = middleVariable -> data;
    if(q.front -> next == q.later){
        q.later = q.front;
        q.later -> next = NULL;
        free(middleVariable);
        return OPERATION_SUCCESS;
    }
    middleVariable -> next -> last = q.front;
    q.front -> next = middleVariable -> next;
    free(middleVariable);
    return OPERATION_SUCCESS;
}

void traverseDoubleQueue(QueueLike q){
     QuNodePrt middleVariable;
     middleVariable = q.front -> next;
     while (middleVariable){
         cout<<middleVariable -> data<<" ";
         middleVariable = middleVariable -> next;
     }
     cout<<endl;
}

int rearPushDoubleQueue(QueueLike &q,int data){
    QuNodePrt middleVariable;
    if(!q.front){ return OPERATION_ERROR;}
    middleVariable = (QuNodePrt)malloc(sizeof(quNode));
    if(!middleVariable){ return OPERATION_ERROR;}  
    middleVariable -> data = data;
    if(q.front == q.later){
        q.front -> next = middleVariable;
        middleVariable -> last = q.front;
        middleVariable -> next = NULL;
        q.later = middleVariable;
        return OPERATION_SUCCESS;
    }
    q.later -> next = middleVariable;
    middleVariable -> next = NULL;
    middleVariable -> last = q.later;
    q.later = middleVariable;
    return OPERATION_SUCCESS; 
}

int rearPopDoubleQueue(QueueLike &q,int &value){
    QuNodePrt middleVariable;
    if(q.front == q.later){ return OPERATION_ERROR;}
    middleVariable = q.later;
    value = middleVariable -> data;
    q.later = middleVariable -> last;
    q.later -> next = NULL;
    free(middleVariable);
    return OPERATION_SUCCESS;
}

int emptyDoubleQueue(QueueLike q){
    if(q.front == q.later){ return OPERATION_ERROR;}
    return OPERATION_SUCCESS;
}

int destoryDoubleQueue(QueueLike &q){
    QuNodePrt middleVariable;   
    while (q.front){
        middleVariable = q.front -> next;
        free(q.front);
        q.front = middleVariable;
    }
    return OPERATION_SUCCESS;
}

int clearDoubleQueue(QueueLike &q){
    int status_one = destoryDoubleQueue(q);
    if(VALUE_ZERO != status_one){
        int status_two = initDoubleQueue(q);
        if(VALUE_ZERO != status_two){return OPERATION_SUCCESS;}else{return OPERATION_ERROR;}
    }
    return OPERATION_ERROR;
}