/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 
 * @Author: WEI.ZHOU
 * @Date: 2020-10-31 17:34:01
 * @Version: V1.0
 * @LastEditTime: 2020-10-31 20:03:19
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>

#define INIT_STRAND_SIZE 255
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define DEF_ONE 1
#define DEF_ZERO 0
#define LF '\n'

typedef struct chainTree{
    int data;
    struct chainTree *leftChild, *rightChild;
}chainTree, *chainTreeNode;

/**
 * @brief   前序遍历
 * @date    2020-10-31 19:34:26
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void preTraversalchainTree(chainTreeNode &T);

/**
 * @brief   中序遍历
 * @date    2020-10-31 19:35:34
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void midTraversalchainTree(chainTreeNode &T);

/**
 * @brief   后序遍历
 * @date    2020-10-31 19:35:38
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void postTraversalchainTree(chainTreeNode &T);

/**
 * @brief   层序遍历
 * @date    2020-10-31 19:40:57
 * @param   chainTreeNode &T 需要遍历的节点树 
 */
void levelTravresalchainTree(chainTreeNode &T);

/**
 * @brief`  获取树的深度
 * @Date    2020-10-31 19:50:22
 * @param   chainTreeNode T 需要操作的节点树 
 * @return  {int} 树的深度
 */
int getDepthOfchainTree(chainTreeNode T);

/**
 * @brief   获取树叶子的数量
 * @Date    2020-10-31 19:58:29
 * @param   chainTreeNode T 需要操作的节点树
 * @return  {int} 树的叶子数量
 */
int getChainTreeLeafSum(chainTreeNode T);

int main(){
    chainTreeNode c;
    return OPERATION_SUCCESS;
}

void preTraversalchainTree(chainTreeNode &T){
    if(T){
        std::cout<<T -> data<<" ";
        preTraversalchainTree(T -> leftChild);
        preTraversalchainTree(T -> rightChild);
    }
}

void midTraversalchainTree(chainTreeNode &T){
    if(T){
        midTraversalchainTree(T -> leftChild);
        std::cout<<T -> data<<" ";
        midTraversalchainTree(T -> rightChild);
    }
}

void postTraversalchainTree(chainTreeNode &T){
    if(T){
        postTraversalchainTree(T -> leftChild);
        postTraversalchainTree(T -> rightChild);
        std::cout<<T -> data<<" ";
    }
}

void levelTravresalchainTree(chainTreeNode &T){
    if(T == NULL){ return ;}
    chainTreeNode middle[INIT_STRAND_SIZE];
    int index = DEF_ZERO, numPut = DEF_ZERO;
    middle[index++] = T;
    while (numPut < index){
        chainTreeNode q = middle[numPut++];
        std::cout<<q -> data<<" ";
        if(q->leftChild != NULL){
            middle[index++] = q -> leftChild;
        }
        if(q->rightChild != NULL){
            middle[index++] = q -> rightChild;
        }
    }
}

int getDepthOfchainTree(chainTreeNode T){
    if(T == NULL){ return OPERATION_ERROR;}
    int leftDepth = getDepthOfchainTree(T -> leftChild) + DEF_ONE;
    int rightDepth = getDepthOfchainTree(T -> rightChild) + DEF_ONE;
    if(leftDepth >= rightDepth){ return leftDepth;}
    return rightDepth;
}

int getChainTreeLeafSum(chainTreeNode T){
    if(!T){ return OPERATION_ERROR;}
    if(!T -> leftChild && !T -> rightChild){
        return DEF_ONE;
    }else{
        return getChainTreeLeafSum(T -> leftChild) + getChainTreeLeafSum(T -> rightChild);
    }
}