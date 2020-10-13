/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     
*  The following code is only used for learning and communication, not for illegal and commercial use.   
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   
*  -consequences.                                                                                       
*                                                                                                        
*  In case of code problems, feedback can be made through the following email address.                  
*                                   <xiaoandx@gmail.com>                                                 
*                                                                                                        
*  FileName:  chainStack                                                                         
*  Author:  WEI.ZHOU                                                                                     
*  Version:  1.0                                                                                         
*  Date:  2020-10-10                                                                                     
*  Description: 进制转换(链式存储结构实现栈)                                                              
*  Others:                                                                                                                                    
**********************************************************************************************************/

#include <iostream>
#include <stdlib.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define OPERATION_GET_VALUE_ERROR -1
#define CHANGE_VALUE_ONE 1
#define WHILE_VALUE_ZERO 0
#define VALUE_ZERO 0
#define STACK_INIT_SIZE 20
#define STACK_INCREMENT 5

//声明链式结构栈的结构体
typedef struct node{
    int data;
    struct node *next;
}nodeN,*nodeLink;

//声明链式结构栈的的栈顶结构体
typedef struct chainStack{
     nodeLink top;
     int chainStackSize;
}chainStackN, *chainStackPrt;

/**
 * @brief 初始化栈
 * @param  chainStackPrt 需要初始化的结构体变量
 * @return int 返回操作状态，1成功；0失败
 * **/
int initChainStack(chainStackPrt &cs);

/**
 * @brief   入栈
 * @param  chainStackPrt 需要入栈的引用地址
 * @return int 返回操作状态，1成功；0失败
 * **/
int push(chainStackPrt &cs, int data);

/**
 * @brief   栈的长度
 * @param  chainStackPrt 需要操作栈栈的引用地址
 * @return int 栈的实际长度
 * **/
int chainStackLenght(chainStackPrt cs);

/**
 * @brief   获取栈顶的数据
 * @param  chainStackPrt 需要操作栈的引用地址
 * @return int 栈顶的数据
 * **/
int getChainStackTop(chainStackPrt cs);

/**
 * @brief   出栈
 * @param  chainStackPrt 需要出栈的引用地址
 * @return int 栈顶的数据
 * **/
int pop(chainStackPrt &cs);

/**
 * @brief  判断是否为空
 * @param  chainStackPrt 需要判断的栈的引用地址
 * @return int 1->为空；0->不为空；-1->传入栈错误不存在
 * **/
int chainStackEmpty(chainStackPrt cs);

/**
 * @brief  循环遍历输出栈的数据
 * @param  chainStackPrt 需要输出的栈的引用地址
 * **/
void traverChainStack(chainStackPrt cs);

int main(){
    chainStackPrt cs;
    cout<<"初始化中........";
    cout<<endl;
    cout<<"初始化成功 SUCCESS"<<endl;
    initChainStack(cs);
    cout<<"依次入栈：12，13，14"<<endl;
    push(cs,12);
    push(cs,13);
    push(cs,14);
    cout<<"当前的栈为：";
    traverChainStack(cs);
    cout<<"当前栈是否为空："<<(chainStackEmpty(cs)==0?"不为空":"为空")<<endl;
    cout<<"出栈的数据为："<<pop(cs)<<endl;
    cout<<"当前栈的长度为："<<chainStackLenght(cs)<<endl;
    return 0;
}

int initChainStack(chainStackPrt &cs){
    if(!cs){ return OPERATION_ERROR;}
    cs = (chainStack *)malloc(sizeof(chainStack));
    cs -> top = NULL;
    cs -> chainStackSize = WHILE_VALUE_ZERO;
    return OPERATION_SUCCESS;
}

int push(chainStackPrt &cs, int data){
    if(!cs){ return OPERATION_ERROR;}
    nodeLink n = (node *)malloc(sizeof(node));
    n -> next = cs -> top;
    n -> data = data;
    cs -> top = n;
    cs -> chainStackSize += CHANGE_VALUE_ONE;
    return OPERATION_SUCCESS;
}

int chainStackLenght(chainStackPrt cs){
    return cs -> chainStackSize;
}

int getStackTop(chainStackPrt cs){
    if(!cs){ return OPERATION_GET_VALUE_ERROR;}
    nodeLink n = cs -> top;
    return n -> data;
}

int pop(chainStackPrt &cs){
    int varData;
    if(!cs || cs -> chainStackSize == WHILE_VALUE_ZERO){ return OPERATION_GET_VALUE_ERROR;}
    nodeLink n = cs -> top;
    varData = n -> data;
    cs -> top = n -> next;
    free(n);
    cs -> chainStackSize -= CHANGE_VALUE_ONE;
    return varData;
}

int chainStackEmpty(chainStackPrt cs){
    if(!cs){ return OPERATION_GET_VALUE_ERROR;}
    return cs -> chainStackSize == VALUE_ZERO ? OPERATION_SUCCESS : OPERATION_ERROR;
}

void traverChainStack(chainStackPrt cs){
    if(!cs || cs -> chainStackSize == WHILE_VALUE_ZERO){return;}
    nodeLink n = cs -> top;
    while (n){
        cout<<n -> data<<" ";
        n = n -> next;
    }
    cout<<endl;
}
