/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     *
*  The following code is only used for learning and communication, not for illegal and commercial use.   *
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   *
*  -consequences.                                                                                        *
*                                                                                                        *
*  In case of code problems, feedback can be made through the following email address.                   *
*                                   <xiaoandx@gmail.com>                                                 *
*                                                                                                        *
*  FileName:  linearTableLDPTest                                                                         *
*  Author:  WEI.ZHOU                                                                                     *
*  Version:  1.0                                                                                         *
*  Date:  2020-09-24                                                                                     *
*  Description: 线性表链式存储结构类型定义，表现，及实现具体操作                                                 *
*  Others:  NULL                                                                                         *                                                             
**********************************************************************************************************/

#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define INPUT_VALUE_ZERO 0
#define INITIALIZE_ZERO 0
#define INITIALIZE_ONE 1
#define INCREASING 1

typedef struct LNod{
   int data;
   struct LNod *next;
}LNode,*linkLNode;

/**
 * @brief 初始化链式线性表，并在内存中分配空间
 * @param linkLNode 引用其需要初始化的线性表头指针
 * @return int 返回操作状态，1成功；0失败
 * */
int initList(linkLNode &L);

/**
 * @brief 遍历输出链式线性表
 * @param linkLNode 需要初遍历输出链式线性表头指针
 * */
void ergodicList(linkLNode L);

/**
 * @brief 向i处插入数据元素
 * @param linkLNode 需要链式线性表头指针
 * @param int 插入元素位置
 * @param int 具体插入的数据
 * @return int 返回操作状态，1成功；0失败
 * */
int insertList(linkLNode L,int i,int data);

/**
 * @brief 删除i处的数据元素
 * @param linkLNode 需要操作链式线性表头指针
 * @param int 删除元素位置
 * @param int 具体删除的数据
 * @return int 返回操作状态，1成功；0失败
 * */
int deteList(linkLNode L,int i,int &var);

/**
 * @brief 判断链表是否为空
 * @param linkLNode 需要操作链式线性表头指针
 * @return int 返回操作状态，1不为空；0为空
 * */
int listEmpty(linkLNode L);

/**
 * @brief 返回数据在链表中的位置
 * @param linkLNode 需要操作链式线性表头指针
 * @return int 返回数据在链表中的位置；0为链表中无该数据
 * */
int locateList(linkLNode L,int data);

/**
 * @brief 销毁数据链表
 * @param linkLNode 需要操作链式线性表头指针
 * @return int 返回操作状态，1销毁成功；0无链表
 * */
int destroyList(linkLNode L);

/**
 * @brief 清空数据链表
 * @param linkLNode 需要操作链式线性表头指针
 * @return int 返回操作状态，1清空成功；0无链表
 * */
int clearList(linkLNode L);

/**
 * @brief 返回数据链表长度
 * @param linkLNode 需要操作链式线性表头指针
 * @return int 返回具体长度，返回0则无链表
 * */
int listLength(linkLNode L);

/**
 * @brief 获取链表指定位置的数据
 * @param linkLNode 需要操作链式线性表头指针
 * @return int 返回具体位置的数据；返回0则无链表、位置不存在数据
 * */
int getListData(linkLNode L,int i);

/**
 * @brief 返回指定元素数据的前一个元素
 * @param linkLNode 需要操作链式线性表头指针
 * @param int   需要查询的数据
 * @param linkLNode 返回查询到指定数据的前一个元素
 * @return int 返回操作状态；返回1返回数据成功；返回0则无链表、该数据处在第一个元素，无前元素
 * */
int priorListData(linkLNode L,int data,linkLNode &pro_L);

/**
 * @brief 返回指定元素数据的后一个元素
 * @param linkLNode 需要操作链式线性表头指针
 * @param int   需要查询的数据
 * @param linkLNode 返回查询到指定数据的后一个元素
 * @return int 返回操作状态；返回1返回数据成功；返回0则无链表、该数据处在第最后一个元素，无后元素
 * */
int nextListData(linkLNode L,int data,linkLNode &next_L);

int main(){
    linkLNode L,L2;
    int var;
    // 1.链表初始化(头指针)
    cout<<"初始化链式线性表："<<endl;
    initList(L);
    cout<<"初始化插入数据后的链表："<<endl;
    insertList(L,1,12);
    insertList(L,1,13);
    insertList(L,1,14);
    ergodicList(L);
    //deteList(L,2,var);
    //cout<<"清空、销毁数据链表"<<endl;
    //destroyList(L);
    //clearList(L);
    cout<<"第二个位置所在的节点数据为："<<getListData(L,2);
    //cout<<listLength(L)<<endl;
    //nextListData(L,13,L2);
    //cout<<L2->data<<endl;
    //ergodicList(L);
   
    
    return INITIALIZE_ZERO;
}

int initList(linkLNode &L){
    L=(LNode *)malloc(sizeof(LNode));
    if(!L){return OPERATION_ERROR;}
    L ->next = NULL;
    return OPERATION_SUCCESS;
}

void ergodicList(linkLNode L){
    linkLNode backups;
	backups=L->next;
	while(backups!=NULL){
		cout<<backups->data<<"  ";
		backups=backups->next;		
	}
	cout<<endl;
}

int insertList(linkLNode L,int i,int data){
    linkLNode backups,backupsTwo;
    int j = INITIALIZE_ZERO;
    backups = L;
    while (backups != NULL && j<i-1){
        backups = backups -> next;
        j += INCREASING;
    }
    if(backups == NULL){return OPERATION_ERROR;} 
    backupsTwo = (LNode *)malloc(sizeof(LNode));
    if (!backupsTwo){return OPERATION_ERROR;}
    backupsTwo -> data = data;
    backupsTwo -> next = backups -> next;
    backups -> next = backupsTwo;
    return OPERATION_SUCCESS;
}

int deteList(linkLNode L,int i,int &var){
    linkLNode backups,backupsTwo;
    int j = INITIALIZE_ZERO;
    backups = L;
    while (backups != NULL && j < i-1){
        backups = backups -> next;
        j += INCREASING;
    }
    if(backups == NULL){return OPERATION_ERROR;} 
    backupsTwo = backups -> next;
    var = backupsTwo -> data;
    backups -> next = backupsTwo -> next;
    free(backupsTwo);
    return OPERATION_SUCCESS;
}

int listEmpty(linkLNode L){
    if(L -> next == NULL){ return OPERATION_ERROR;}
    return OPERATION_SUCCESS;    
}

int locateList(linkLNode L,int data){
    linkLNode backups;
	int j = INITIALIZE_ONE;
	backups = L->next;
	while(backups != NULL){
		if(backups -> data == data){return j;}
		backups=backups -> next;
		j += INCREASING;		
	}
	return OPERATION_ERROR;
}

int destroyList(linkLNode L){
    linkLNode backups,backupsTwo;
    backups = L;
    if (backups -> next == NULL){
       return OPERATION_ERROR;
    }
    while (backups != NULL){
        backupsTwo = backups -> next;
        free(backups);
        backups = backupsTwo;
    }
    return OPERATION_SUCCESS;
}

int clearList(linkLNode L){
    linkLNode backups,backupsTwo;
    if (L->next == NULL){
        return OPERATION_ERROR;
    }
    backups = L -> next;
    while (backups != NULL){
        backupsTwo = backups -> next;
        free(backups);
        backups = backupsTwo;
    }
    L -> next = NULL;
    return OPERATION_SUCCESS;
}

int listLength(linkLNode L){
    linkLNode backups;
    int i;
    backups = L;
    if (backups -> next == NULL){
        return OPERATION_ERROR;
    }
    while (backups -> next != NULL){
        backups = backups -> next;
        i += INCREASING;
    }
    return i;
}

int getListData(linkLNode L,int i){
    linkLNode backups;
    int j = INITIALIZE_ZERO,k;
    k = listLength(L);
    backups = L;
    if (backups -> next == NULL || i > k || i <= INPUT_VALUE_ZERO){
        return OPERATION_ERROR;
    }
    while(j<i){
        backups = backups -> next;
        j += INCREASING;
    }
    return backups -> data;
}

int priorListData(linkLNode L,int data,linkLNode &pro_L){
    linkLNode backups,backupsTwo;
    backupsTwo = L -> next;
    if(L -> next == NULL){ return OPERATION_ERROR;}
    while (backupsTwo -> next != NULL || backupsTwo -> data != data){
        if (backupsTwo -> data != data){
            backups = backupsTwo;
            backupsTwo = backupsTwo -> next;
        }
        pro_L =  backups;
        return OPERATION_SUCCESS;
    }
    return OPERATION_ERROR;
}

int nextListData(linkLNode L,int data,linkLNode &next_L){
    linkLNode backups;
    if(L -> next == NULL){ return OPERATION_ERROR;}
    backups = L -> next;
    while (backups -> next != NULL){
        if (backups -> data == data){
            next_L = backups-> next;
            return OPERATION_SUCCESS;
        }
        backups = backups -> next;
    }
    return OPERATION_ERROR;
}