/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 线索树的定义与相关操作
 * @Author: WEI.ZHOU
 * @Date: 2020-11-12 16:59:24
 * @Version: V1.0
 * @Others: 
 */
#include <iostream>
#include <stdlib.h>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define NUL 999
#define DEF_ONE 1
#define DEF_ZERO 0
#define LF '\n'

typedef int DataType;

/**
 * @brief: 
 *         创建枚举类型来表示标签的类型(其实就是指明标签等于0，还是1)
 *         link = 0 ； thread = 1；
 *         0 表示旁边的指针指向孩子节点(左指向左孩子节点，右反正同理)
 *         1 表示旁边的指针指前驱还是后继(左指向前驱，右反正同理指向后继)
 */
typedef enum {
    link,
    thread
}pointerTag;

typedef struct threadTree{
    DataType data;
    struct threadTree *leftChild, *rightChild;
    pointerTag lTag, rTag;
}threadTree, *threadTreeNode;

/**
 * @brief: 
 *          声明一个树的临时节点，用于保存线索中需要查找的前一个节点
 */
threadTreeNode pre;

/**
 * @brief   初始化树
 * @Date    2020-11-12 17:06:46
 * @param   threadTreeNode &T 需要操作的节点树
 * @return  {int} 1->操作成功；0->操作失败
 */
int initTree(threadTreeNode &T);

/**
 * @brief   创建线索树
 * @Date    2020-11-12 17:08:41
 * @param   threadTreeNode &T 需要操作的树
 */
void createTree(threadTreeNode &T);

/**
 * @brief   中序遍历链表线索化
 * @Date    2020-11-14 17:54:09
 * @param   threadTreeNode &p 二叉树的根节点，不同于T，p->leftChild = T;
 */
void inThreadTree(threadTreeNode p);

/**
 * @brief   创建中序遍历二叉树的线索头节点，并线索二叉树
 * @Date    2020-11-14 18:08:52
 * @param   threadTreeNode &Thrt 需要创建的主根节点
 * @param   threadTreeNode T 需要线索化的二叉树根节点
 * @return  {int} 1->操作成功；0->操作失败
 */
int createInProTree(threadTreeNode &Thrt, threadTreeNode T);

/**
 * @brief   非递归 中序遍历
 * @Date    2020-11-14 18:13:40
 * @param   threadTreeNode Thrt 线索完成后的根节点
 */
void printTreeInOrder(threadTreeNode Thrt);

int main(){
    threadTreeNode T, Thrt;
    initTree(T);
    std::cout<<"append Tree input 999 is NULL: ";
    createTree(T);
    std::cout<<"\n创建树成功下面进行线索化....................... \n";
    createInProTree(Thrt,T);
    std::cout<<"线索化成功，中序遍历输出结果：";
    printTreeInOrder(Thrt);
    return OPERATION_SUCCESS;
}

int initTree(threadTreeNode &T){
    T = NULL;
    return OPERATION_SUCCESS;
}

void createTree(threadTreeNode &T){
    DataType data;
    std::cin>>data;
    if(NUL == data){
        T = NULL;
    }else{
        T = (threadTreeNode)malloc(sizeof(threadTree));
        if(!T){ return;}
        T -> data = data;
        std::cout<<"add "<<data<<" leftChild：";
        createTree(T -> leftChild);
        if(T -> leftChild != NULL){
            T -> lTag = link;
        }else{
            T -> lTag = thread;
        }
        std::cout<<"add "<<data<<" rightChild：";
        createTree(T -> rightChild);
        if(T -> rightChild != NULL){
            T -> rTag = link;
        }else{
            T -> rTag = thread;
        }
    }
}

void inThreadTree(threadTreeNode p){
    if(p){
        inThreadTree(p -> leftChild);
        if(!p -> leftChild){
            p -> lTag = thread;
            p -> leftChild = pre;
        }
        if(!pre -> rightChild){
            pre -> rTag = thread;
            pre -> rightChild = p;
        }
        pre = p;
        inThreadTree(p -> rightChild);
    }
}

int createInProTree(threadTreeNode &Thrt, threadTreeNode T){
    Thrt = (threadTreeNode)malloc(sizeof(threadTree));
    if(!Thrt){return OPERATION_ERROR;}
    Thrt -> lTag = link;
    Thrt -> rTag = thread;
    Thrt -> rightChild = Thrt;
    if(!T){
        Thrt -> leftChild = Thrt;
    }else{
        Thrt -> leftChild = T;
        pre = Thrt;
        inThreadTree(T);
        pre -> rightChild = Thrt;
        pre -> rTag = thread;
        Thrt -> rightChild = pre;

    }
    return OPERATION_SUCCESS;
}

void printTreeInOrder(threadTreeNode Thrt){
    threadTreeNode T = Thrt -> leftChild;
    while (T != Thrt){
        while( T -> lTag == link ){ T = T -> leftChild; }
        std::cout<<T -> data<<"  ";
        while( T -> rTag == thread && T -> rightChild != Thrt){
            T = T -> rightChild;
            std::cout<<T -> data<<"  ";
        }
        T = T -> rightChild;
    }
}