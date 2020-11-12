/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 二叉树的链式定义与操作
 * @Author: WEI.ZHOU
 * @Date: 2020-10-31 17:34:01
 * @Version: V1.0
 * @LastEditTime: 2020-11-12 16:41:31
 * @Others: 
 */
#include <iostream>


#define INIT_STRAND_SIZE 255
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define NUL 999
#define DEF_ONE 1
#define DEF_ZERO 0
#define LF '\n'

typedef struct chainTree{
    int data;
    struct chainTree *leftChild, *rightChild;
}chainTree, *chainTreeNode;

/**
 * @brief   引入队列操作方法
 * @Date    2020-11-11 20:19:59
 */
#include "queue.h"

/**
 * @brief   初始化树
 * @Date    2020-11-06 23:21:53
 * @author  WEI.ZHOU
 * @param   chainTreeNode &T 需要操作的节点树
 * @return  {int} 1->操作成功；0->操作失败
 */
int initTree(chainTreeNode &T);

/**
 * @brief   创建二叉树
 * @Date    2020-11-09 17:34:22
 * @author  WEI.ZHOU
 * @param   chainTreeNode &T 需要创建的树 
 */
void createTree(chainTreeNode &T);

/**
 * @brief   前序遍历
 * @date    2020-10-31 19:34:26
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void printTreePrOrder(chainTreeNode &T);

/**
 * @brief   中序遍历
 * @date    2020-10-31 19:35:34
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void printTreeInOrder(chainTreeNode &T);

/**
 * @brief   后序遍历
 * @date    2020-10-31 19:35:38
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void printTreePostOrder(chainTreeNode &T);

/**
 * @brief   层序遍历
 * @date    2020-10-31 19:40:57
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void printTreeTierOrder(chainTreeNode &T);

/**
 * @brief  获取树的深度
 * @Date    2020-10-31 19:50:22
 * @param   chainTreeNode T 需要操作的节点树 
 * @return  {int} 树的深度
 */
int getTreeDepth(chainTreeNode T);

/**
 * @brief   获取树叶子的数量
 * @Date    2020-10-31 19:58:29
 * @param   chainTreeNode T 需要操作的节点树
 * @return  {int} 树的叶子数量
 */
int getChainTreeLeafSum(chainTreeNode T);

/**
 * @brief   判断树是否为空
 * @Date    2020-11-09 19:42:35
 * @param   chainTreeNode T 需要操作的节点树
 * @return  {int} 1->空树；0->不为空
 */
int treeEmpty(chainTreeNode T);

/**
 * @brief   查找对应值所在节点地址
 * @Date    2020-11-11 19:11:22
 * @author  WEI.ZHOU
 * @param   chainTreeNode T 需要操作的节点树
 * @param   int data 需要查找的值
 * @return  {chainTreeNode} 值所在的节点指针
 */
chainTreeNode findTreeNodeByData(chainTreeNode T, int data);

/**
 * @brief   获取树的左孩子节点数据
 * @Date    2020-11-11 19:28:36
 * @author  WEI.ZHOU
 * @param   chainTreeNode T 需要操作的节点树
 * @param   int data 需要查找的节点值
 * @return  {int} 查找节点左孩子节点的数值
 */
int getTreeLeftChild(chainTreeNode T, int data);

/**
 * @brief   获取树的右孩子节点数据
 * @Date    2020-11-11 19:28:36
 * @author  WEI.ZHOU
 * @param   chainTreeNode T 需要操作的节点树
 * @param   int data 需要查找的节点值
 * @return  {int} 查找节点右孩子节点的数值
 */
int getTreeRightChild(chainTreeNode T, int data);

/**
 * @brief   获取指定数值节点的双亲节点
 * @Date    2020-11-12 14:09:47
 * @param   chainTreeNode T 需要操作的节点树
 * @param   int data 需要查找的节点值 
 * @return  {int} 双亲节点的数值
 */
int getTreeParent(chainTreeNode T, int data);

/**
 * @brief   层序遍历
 * @Date    2020-11-12 16:39:30
 * @param   chainTreeNode T 需要操作的节点树
 */
void printTreeTier(chainTreeNode T);

int main(){
    chainTreeNode c;
    initTree(c);
    std::cout<<"append Tree input 999 is NULL: ";
    createTree(c);
    printTreeTier(c);
    std::cout<<getTreeDepth(c)<<LF;
    std::cout<<getTreeLeftChild(c,2)<<LF;
    std::cout<<getTreeRightChild(c,2)<<LF;
    std::cout<<getTreeParent(c,2)<<LF;
    return OPERATION_SUCCESS;
}

int initTree(chainTreeNode &T){
    T = NULL;
    return OPERATION_SUCCESS;
}

void createTree(chainTreeNode &T){
    int data;
    std::cin>>data;
    if(NUL == data){
        T = NULL;
    }else{
        T = (chainTreeNode)malloc(sizeof(chainTree));
        if(!T){exit(DEF_ONE);}
        T -> data = data;
        std::cout<<"add "<<data<<" leftChild：";
        createTree(T -> leftChild);
         std::cout<<"add "<<data<<" rightChild：";
        createTree(T -> rightChild);
    }
}

void printTreePrOrder(chainTreeNode &T){
    if(T){
        std::cout<<T -> data<<" ";
        printTreePrOrder(T -> leftChild);
        printTreePrOrder(T -> rightChild);
    }
}

void printTreeInOrder(chainTreeNode &T){
    if(T){
        printTreeInOrder(T -> leftChild);
        std::cout<<T -> data<<" ";
        printTreeInOrder(T -> rightChild);
    }
}

void printTreePostOrder(chainTreeNode &T){
    if(T){
        printTreePostOrder(T -> leftChild);
        printTreePostOrder(T -> rightChild);
        std::cout<<T -> data<<" ";
    }
}

void printTreeTierOrder(chainTreeNode &T){
    if(T == NULL){ return ;}
    chainTreeNode middle[INIT_STRAND_SIZE];
    int index = DEF_ZERO, numPut = DEF_ZERO;
    middle[index++] = T;
    while (numPut < index){
        chainTreeNode q = middle[numPut++];
            std::cout<<q->data<<" ";
        if(q->leftChild != NULL){
            middle[index++] = q -> leftChild;
        }
        if(q->rightChild != NULL){
            middle[index++] = q -> rightChild;
        }
    }
}

int getTreeDepth(chainTreeNode T){
    int depth, leftDepth, rightDepth;
    if(NULL == T){ return OPERATION_ERROR;}
    leftDepth = getTreeDepth(T -> leftChild);
    rightDepth = getTreeDepth(T -> rightChild);
    return DEF_ONE + (leftDepth > rightDepth ? leftDepth : rightDepth);
}

int getChainTreeLeafSum(chainTreeNode T){
    if(!T){ return OPERATION_ERROR;}
    if(!T -> leftChild && !T -> rightChild){
        return DEF_ONE;
    }else{
        return getChainTreeLeafSum(T -> leftChild) + getChainTreeLeafSum(T -> rightChild);
    }
}

int treeEmpty(chainTreeNode T){
    if(T){
        return OPERATION_ERROR;
    }
    return OPERATION_SUCCESS;
}

chainTreeNode findTreeNodeByData(chainTreeNode T, int data){
    QueueLike q;
    chainTreeNode cT;
    if(T != NULL){
        initQueue(q);
        appendQueue(q, T);
        while (!emptyQueue(q)){
            deleteQueue(q, cT);
            if(data == cT->data){
                return cT;
            }
            if(cT->leftChild != NULL){
                appendQueue(q, cT->leftChild);
            }
            if(cT->rightChild != NULL){
                appendQueue(q, cT->rightChild);
            }
        }
        return NULL;
    }
    return NULL;
}

int getTreeLeftChild(chainTreeNode T, int data){
    chainTreeNode cT;
    if(T != NULL){
        cT = findTreeNodeByData(T, data);
        if(cT->leftChild != NULL){
            return cT->leftChild->data;
        }
        return NUL;
    }
    return NUL;
}

int getTreeRightChild(chainTreeNode T, int data){
    chainTreeNode cT;
    if(T != NULL){
        cT = findTreeNodeByData(T, data);
        if(cT->rightChild != NULL){
            return cT->rightChild->data;
        }
        return NUL;
    }
    return NUL;
}

int getTreeParent(chainTreeNode T, int data){
    QueueLike q;
    chainTreeNode cT;
    if(T != NULL){
        initQueue(q);
        appendQueue(q, T);
        while (!emptyQueue(q)){
            deleteQueue(q, cT);
            if(cT->leftChild && cT->leftChild->data == data){
                return cT->data;
            }
            if(cT->rightChild && cT->rightChild->data == data){
                return cT->data;
            }
            if(cT->leftChild != NULL){
                appendQueue(q, cT->leftChild);
            }
            if(cT->rightChild != NULL){
                appendQueue(q, cT->rightChild);
            }
        }
        return NUL;
    }
    return NUL;
}

void printTreeTier(chainTreeNode T){
    QueueLike q;
    chainTreeNode cT;
    if(T != NULL){
        initQueue(q);
        appendQueue(q, T);
        while (!emptyQueue(q)){
            deleteQueue(q, cT);
            std::cout<<cT->data<<"  ";
            if(cT->leftChild != NULL){
                appendQueue(q, cT->leftChild);
            }
            if(cT->rightChild != NULL){
                appendQueue(q, cT->rightChild);
            }
        }

    }
}