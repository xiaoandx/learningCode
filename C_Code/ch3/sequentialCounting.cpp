/*********************************************************************************************************
*  Copyright (c) 2020 WEI.ZHOU. All rights reserved.                                                     *
*  The following code is only used for learning and communication, not for illegal and commercial use.   *
*  If the code is used, no consent is required, but the author has nothing to do with any problems and   *
*  -consequences.                                                                                        *
*                                                                                                        *
*  In case of code problems, feedback can be made through the following email address.                   *
*                                   <xiaoandx@gmail.com>                                                 *
*                                                                                                        *
*  FileName:  sequentialCounting                                                                         *
*  Author:  WEI.ZHOU                                                                                     *
*  Version:  1.0                                                                                         *
*  Date:  2020-09-24                                                                                     *
*  Description: 约瑟夫循环单链表解决排队报数问题                                                              *
*  Others:  
*        有n个人，编号为1，2，3...counts围成一个圆圈，按照顺时针方向从编号为key的人
*        开始报数，报数为number的人出列，她的下一个人重新开始报数，数到number的人出列
*        如此重复下去，知道所有人都出列，编写一个算法，要求输入counts,number,key按照出列的顺序输出对应的值
*        example:
*        8,1,2,3,4,5,6,7  	counts=8,key=2,number=3
*        则按照输出的数值及编号为：4 7 2 6 3 1 5                                                                                        *                                                             
**********************************************************************************************************/

#include <iostream>
#include <stdio.h>
using namespace std;

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0

typedef struct Node{
    int data;
    struct Node *next;
}Nodes,*linkNode;

/**
 * @brief 初始化生成需要长度的链式线性表，并在内存中分配空间
 * @param int 数据长度，生成多少元素的循环链表
 * @return linkNode 返回生成的数据循环链表
*/
linkNode initGenerateList(int counts);

/**
 * @brief 循环遍历链式线性表
 * @param linkLNode 引用其需要初始化的链表指针地址
*/
void ergodicList(linkNode l1);

/**
 * @brief 按照出列的顺序输出对应元素的值
 * @param linkLNode 引用其需要循环遍历的链表指针地址
 * @param number 循环报数的大小（如：1，2，3）就填3
 * @param key   从链表的第几位循环开始报数
 * @return int int 返回操作状态，1成功；0失败
*/
int loopOut(linkNode l1, int number, int key);

/**
 * 变量声明：
 *  counts 生成多少元素的循环链表
 *  number 报数的大小（如：1，2，3）就填3
 *  key 最开始从链表的第几位开始报数
*/
int main(){
    int counts,number,key;
    linkNode l1;
    cout<<"请依次输入链表的大小、报数大小、报数开始位置（空格区分）：";
    cin>>counts>>number>>key;
    cout<<counts<<" "<<number<<" "<<key<<endl;
    l1 = initGenerateList(counts);
    cout<<"链表初始化遍历结果如下："<<endl;
    ergodicList(l1);
    cout<<" 按照出列的顺序输出对应元素的值如下："<<endl;
    loopOut(l1,number,key);
    return 0;
}

linkNode initGenerateList(int counts){
    linkNode head = NULL,newNode,pre;
    head = (Nodes *)malloc(sizeof(Nodes));
    pre = head;
    pre -> data = 1;
    if(NULL == newNode){cout<<"节点创建失败"<<endl;exit(-1);}
    for(int i = 2;i <= counts;i++){
        newNode = (Nodes *)malloc(sizeof(Nodes));
        newNode -> data = i;
        pre -> next = newNode;
        pre = newNode;
    }
    pre -> next = head;
    return pre;
}

void ergodicList(linkNode l1){
    if(!l1){cout<<"循环链表为空"<<endl;exit(-1);}
    linkNode middle = l1;
    while (middle -> next != l1){
       cout<<middle -> data<<" "; 
       middle = middle -> next;
    }
    cout<<middle -> data<<endl;
}

int loopOut(linkNode l1, int number, int key){
    int index;
    linkNode middleOne,copyNode,middleTwo;
    middleOne = l1;
    if(!middleOne){return OPERATION_ERROR;}
    while (key - 1){
       middleOne = middleOne -> next;
       key--;
    }
    while (middleOne -> next != middleOne){
       for ( index = 1; index < number; index++){
           middleTwo = middleOne;
           middleOne = middleOne -> next;
       }
        copyNode = middleOne -> next;
        cout<<middleOne -> data<<" ";
        middleTwo -> next = middleOne -> next;
        free(middleOne);
        middleOne = copyNode;
    }
    cout<<middleOne -> data<<" ";
    free(middleOne);
    return OPERATION_SUCCESS;
}
