/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <xiaoandx@gmail.com>                                                 
*                                                                                                        
*  FileName:  chainQueue                                                                         
*  Author:  WEI.ZHOU                                                                                     
*  Version:  1.0                                                                                         
*  Date:  2020-10-15                                                                                     
*  Description: 链式队列                                                             
*  Others:                                                                                                                                      
**********************************************************************************************************/

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
int initQueue(QueueLike &q);

/**
 * @brief 遍历链队列
 * @param  QueueLike &q 需要进行操作的链队列
 */
void traverseQueue(QueueLike q);

/**
 * @brief 向链队列插入数据
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回操作状态，1->成功；0->失败
 */
int appendQueue(QueueLike &q,int data);

/**
 * @brief 向链队列删除数据
 * @param  QueueLike &q 需要进行操作的链队列
 * @param  int &value 需要返回删除的具体值
 * @return int 返回操作状态，1->成功；0->失败
 */
int deleteQueue(QueueLike &q,int &value);

/**
 * @brief 链队列销毁
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回操作状态，1->成功；0->失败
 */
int destoryQueue(QueueLike &q);

/**
 * @brief 链队列清除
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回操作状态，1->成功；0->失败
 */
int clearQueue(QueueLike &q);

/**
 * @brief 获取链队列的元素长度
 * @param  QueueLike &q 需要进行操作的链队列
 * @return int 返回链式队列的实际元素长度
 */
int queueLength(QueueLike q);

int getFrontValue(QueueLike q, int &value);

int main(){
    QueueLike q;
    int value;
    initQueue(q);
    appendQueue(q,101);
    //deleteQueue(q,value);
    //traverseQueue(q);
    //destoryQueue(q);
    //clearQueue(q);
    appendQueue(q,103);
    cout<<queueLength(q)<<endl;
    getFrontValue(q,value);
    cout<<value<<endl;
    traverseQueue(q);

    return OPERATION_SUCCESS;
}

int initQueue(QueueLike &q){
    q.front = (QuNodePrt)malloc(sizeof(quNode));
    if(!q.front){ return OPERATION_ERROR;}
    q.front -> next = NULL;
    q.later = q.front;
    return OPERATION_SUCCESS;
}

void traverseQueue(QueueLike q){
    QuNodePrt middleVariable;
    middleVariable = q.front -> next;
    while (middleVariable != NULL){
        cout<<middleVariable -> data<<" ";
        middleVariable = middleVariable -> next;
    }
    cout<<endl;
}

int appendQueue(QueueLike &q,int data){
    QuNodePrt middleVariable;
    middleVariable = (QuNodePrt)malloc(sizeof(quNode));
    if(!middleVariable){ return OPERATION_ERROR;}
    middleVariable -> data = data;
    middleVariable -> next = NULL;
    q.later -> next = middleVariable;
    q.later = middleVariable;
    return OPERATION_SUCCESS;
}

int deleteQueue(QueueLike &q,int &value){
    QuNodePrt middleVariable;
    if(q.front == q.later){ return OPERATION_ERROR;}
    middleVariable = q.front -> next;
    value = middleVariable -> data;
    q.front -> next = middleVariable -> next;
    if(q.front == middleVariable){ q.later = q.front;}
    free(middleVariable);
    return OPERATION_SUCCESS; 
}

int destoryQueue(QueueLike &q){
    QuNodePrt middleVariable;
    while (!q.front){
        middleVariable = q.front -> next;
        free(q.front);
        q.front = middleVariable;
    }
    return OPERATION_SUCCESS;
}

int clearQueue(QueueLike &q){
    int statusOne = destoryQueue(q);
    if(VALUE_ZERO != statusOne){
        int statusTwo = initQueue(q);
        if(VALUE_ZERO != statusTwo){
            return OPERATION_SUCCESS;
        }
        return OPERATION_ERROR;
    }
    return OPERATION_ERROR;
}

int queueLength(QueueLike q){
    QuNodePrt middleVariable;
    middleVariable = q.front -> next;
    int count = INIT_VALUE_ONE;
    if(q.front == q.later){ return OPERATION_ERROR;}
    while (middleVariable -> next != NULL){
        count += CHANGE_VALUE_ONE;
        middleVariable = middleVariable -> next;
    }
    return count;
}

int getFrontValue(QueueLike q, int &value){
    if(q.front == q.later){ return OPERATION_ERROR;}
    value = q.front -> next -> data;
    return OPERATION_SUCCESS;
}