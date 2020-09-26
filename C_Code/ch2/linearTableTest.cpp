/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     *
*  The following code is only used for learning and communication, not for illegal and commercial use.   *
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   *
*  -consequences.                                                                                        *
*                                                                                                        *
*  In case of code problems, feedback can be made through the following email address.                   *
*                                   <xiaoandx@gmail.com>                                                 *
*                                                                                                        *
*  FileName:  linearTableTest                                                                            *
*  Author:  WEI.ZHOU                                                                                     *
*  Version:  1.0                                                                                         *
*  Date:  2020-09-24                                                                                     *
*  Description: 线性表顺序存储结构类型定义，表现，及实现具体操作                                                 *
*  Others:  NULL                                                                                         *                                                             
**********************************************************************************************************/

#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define LIST_INIT_SIZE 100
#define LISTINC 20

typedef struct {
    int *elem;
    int length;
    int listSize;
}ExampleList;

int initList(ExampleList &e);
void listTraveres(ExampleList e);
int destoyList(ExampleList &e);
int listInsert(ExampleList &e, int i, int data);
int listDelete(ExampleList &e, int i, int &delete_value);
int listEmpty(ExampleList &e);
int listLength(ExampleList e);
int getElem(ExampleList &e,int i,int &getPositionValue);

int main(){
    ExampleList e;
    int delete_value ;
    int getPositionValue;
    initList(e);
    listInsert(e,1,10);
    listInsert(e,1,11);
    //listInsert(e,1,12);
    //destoyList(e);
    //listDelete(e,2,delete_value);
    //listEmpty(e);
    //cout<<listEmpty(e)<<endl;
    //listLength(e);
    //cout<<listLength(e)<<endl;
    //getElem(e,2,getPositionValue);
    //cout<<getPositionValue<<endl;
    listTraveres(e);
    return 0;
}

/**
 * @brief 初始化线性表，并在内存中分配空间
 * @param ExampleList 引用其需要初始化的线性表
 * @return int 返回操作状态，1成功；0失败
 * */
int initList(ExampleList &e){
	e.elem=(int *)malloc(LIST_INIT_SIZE * sizeof(int));
	if(!e.elem){
        return OPERATION_ERROR;
    }
	e.length = 0;
	e.listSize = LIST_INIT_SIZE;
	return OPERATION_SUCCESS;
};

/**
 * @brief 循环遍历线性表中的数据
 * @param ExampleList 引用其需要循环遍历的线性表
 * @return void
 * */
void listTraveres(ExampleList e){
    int i ;
    for ( i = 0; i < e.length; i++){
        cout<<e.elem[i]<<"  ";
    }
};

/**
 * @brief 销毁线性表
 * @param ExampleList 引用其需要销毁线性表
 * @return int 返回操作状态，1成功；0失败
 * */
int destoyList(ExampleList &e){
    free(e.elem);
    if(!e.elem){
       return OPERATION_ERROR;
    }
    e.elem = NULL;
    e.length = 0;
    e.listSize = 0;
    return OPERATION_SUCCESS;
};

/**
 * @brief 向线性表插入数据
 * @param ExampleList 引用其插入数据的线性表
 * @param int   插入数据位置
 * @param int   具体插入的数据
 * @return int 返回操作状态，1成功；0失败
 * */
int listInsert(ExampleList &e, int i, int data){
    int j;
    if(i<1 || i>e.length+1){
        return OPERATION_ERROR;
    }
    if(e.length == e.listSize){
        int *base;
	    base=(int *)realloc(e.elem,(e.listSize+LISTINC)*sizeof(int));
	    if(!base){
            return OPERATION_ERROR;
        }
	    e.listSize = e.listSize + LISTINC;
	}
    for(j=e.length;j >= i-1; j--){
        e.elem[j] = e.elem[j-1];
    }
    e.elem[i-1] = data;
    e.length += 1;
    return OPERATION_SUCCESS;
};

/**
 * @brief 向线性表删除数据
 * @param ExampleList 引用其删除数据的线性表
 * @param int   删除数据位置
 * @param int   删除位置的数据
 * @return int 返回操作状态，1成功；0失败
 * */
int listDelete(ExampleList &e, int i, int &delete_value){
    int j;
    if(i<1 || i> e.length){
         return OPERATION_ERROR;
    }
    delete_value = e.elem[i-1];
    for(j = i;j<e.length;j++){
        e.elem[j-1] = e.elem[j];
    }
    e.length -= 1;
    return OPERATION_SUCCESS;
};

/**
 * @brief 判断向线性表是否有数据
 * @param ExampleList 引用其判断向线性表
 * @return int 返回操作状态，1 有；0 null
 * */
int listEmpty(ExampleList &e){
    return e.length == 0 ? OPERATION_ERROR : OPERATION_SUCCESS;
};

/**
 * @brief 查询向线性表数据长度
 * @param ExampleList 引用其查询向线性表
 * @return int 返回数据表的数据长度
 * */
int listLength(ExampleList e){
    return e.length;
};

/**
 * @brief 查询向线性表某个位置的数据
 * @param ExampleList 引用其查询向线性表
 * @param int   查询数据位置
 * @param int   该位置的具体数值
 * @return int 返回操作状态，1 有；0 null
 * */
int getElem(ExampleList &e,int i,int &getPositionValue){
    if (i<1 || i>e.length){
        return OPERATION_ERROR;
    }
    getPositionValue = e.elem[i-1];
    return OPERATION_SUCCESS;
};





