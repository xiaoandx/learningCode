/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 顺序串的定义及方法实现
 * @Author: WEI.ZHOU
 * @Date: 2020-11-04 18:42:41
 * @Version: V1.0
 * @LastEditTime: 2020-11-06 22:55:25
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <iostream>
#include <math.h>

#define INIT_STRAND_SIZE 100
#define NUL 999
#define INPUT_OK 9999
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define DEF_ONE 1
#define DEF_TWO 2
#define DEF_ZERO 0
#define LF '\n'
#define LN '\0'

typedef int sequenceTree[INIT_STRAND_SIZE];

/**
 * @brief   初始化顺序树
 * @date    2020-11-04 21:36:02
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要初始化的树
 * @return  {int} 1->操作成功；0->操作失败
 */
int initTree(sequenceTree T);

/**
 * @brief   获取树的深度
 * @date    2020-11-04 21:47:48
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要初始化的树
 * @return  {int} 树的深度
 */
int getTreeDepth(sequenceTree T);

/**
 * @brief   创建新顺序树
 * @date    2020-11-05 22:05:33
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要创建的树
 * @return  {int} 1->操作成功；0->操作失败
 */
int createTree(sequenceTree T);

/**
 * @brief   树的输出
 * @date     2020-11-05 22:19:13
 * @author   WEI.ZHOU
 * @param    sequenceTree T 需要输出树
 */
void printTreeTierOrder(sequenceTree T);

/**
 * @brief   判断树是否为空
 * @date    2020-11-05 22:49:07
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @return  {int} 1->为空；0->不为空
 */
int treeEmpty(sequenceTree T);

/**
 * @brief   获取树根节点值
 * @date    2020-11-05 22:51:28
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @return  {int} 根节点的数值
 */
int getTreeRootValue(sequenceTree T);

/**
 * @brief   获取树某层节点的数值
 * @date    2020-11-05 22:56:28
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int tier 树的第几层
 * @param   int i 某层第几个节点
 * @param   int &value 节点的数值
 * @return  {int} 1->操作成功；0->操作失败
 */
int getTreeNodeValue(sequenceTree T, int tier, int i, int &value);

/**
 * @brief   替换树中某层的某个节点的值
 * @date    2020-11-06 13:24:21
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int tier 树的第几层
 * @param   int i 某层第几个节点
 * @param   int data 新节点的数值
 * @return  {int} 1->操作成功；0->操作失败
 */
int assignTreeNodeValue(sequenceTree T, int tier, int i, int data);

/**
 * @brief   获取某个数的双亲节点值
 * @date    2020-11-06 13:36:37
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int date 需要寻找双亲节点值
 * @return  {int} 双亲值(999 无双亲)
 */
int getTreeParent(sequenceTree T, int data);

/**
 * @brief   获取对应节点的左孩子节点数值
 * @Date    2020-11-06 13:43:46
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int date 需要寻找左孩子节点值
 * @return  {int} 左孩子节点值(如果返回999 无左孩子节点)
 */
int getTreeLeftChild(sequenceTree T, int data);

/**
 * @brief   获取对应节点的右孩子节点数值
 * @Date    2020-11-06 13:43:49
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int date 需要寻找右孩子节点值
 * @return  {int} 右孩子节点值(如果返回999 无右孩子节点)
 */
int getTreeRightChild(sequenceTree T, int data);

/**
 * @brief   获取查找节点的左兄弟节点值
 * @Date    2020-11-06 13:50:45
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int date 需要寻找左兄弟节点值
 * @return  {int} 左兄弟节点值(如果返回999 无左兄弟节点)
 */
int getTreeLeftSibling(sequenceTree T, int data);

/**
 * @brief   获取查找节点的右兄弟节点值
 * @Date    2020-11-06 13:51:20
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int date 需要寻找右兄弟节点值
 * @return  {int} 右兄弟节点值(如果返回999 无右兄弟节点)
 */
int getTreeRightSibling(sequenceTree T, int data);

/**
 * @brief   前序输出树
 * @Date    2020-11-06 14:03:27
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int pos 开始输出起点
 */
void printTreePrOrder(sequenceTree T, int pos);

/**
 * @brief   中序输出树
 * @Date    2020-11-06 14:03:27
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int pos 开始输出起点
 */
void printTreeInOrder(sequenceTree T, int pos);

/**
 * @brief   后序输出树
 * @Date    2020-11-06 14:03:27
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @param   int pos 开始输出起点
 */
void printTreePostOrder(sequenceTree T, int pos);

/**
 * @brief   清空树
 * @Date    2020-11-06 22:42:23
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @return  {int} 1->操作成功；0->操作失败
 */
int clearTree(sequenceTree T);

/**
 * @brief   获取树节点个数
 * @Date    2020-11-06 22:45:25
 * @author  WEI.ZHOU
 * @param   sequenceTree T 需要操作的树
 * @return  {int} 树节点个数
 */
int getTreeLength(sequenceTree T);

int main(){
    int value;
    sequenceTree T;
    initTree(T);
    T[0] = 1;
    T[1] = 2;
    T[2] = 3;
    T[3] = 4;
    T[4] = 5;
    T[5] = 6;
    T[6] = 7;
    // std::cout<<getTreeDepth(T)<<LF;
    //createTree(T);
    printTreeTierOrder(T);
    //getTreeNodeValue(T,2,1,value);
    //std::cout<<getTreeRootValue(T)<<LF;
    //assignTreeNodeValue(T,2,2,10);
    //printTreeTierOrder(T);
    std::cout<<getTreeLength(T)<<LF;
    
    return OPERATION_SUCCESS;
}

int initTree(sequenceTree T){
    for(int i = DEF_ZERO; i<INIT_STRAND_SIZE; i++){
        T[i] = NUL;
    }
    return OPERATION_SUCCESS;
}

int getTreeDepth(sequenceTree T){
    if(T[DEF_ZERO] == NUL){ return OPERATION_ERROR;}
    for(int i = INIT_STRAND_SIZE-1; i>=0; i--){
        if(T[i] != NUL){
            return (int)(log(i + DEF_ONE)/log(2) + 1.1);
        }
    }
    return OPERATION_ERROR;
}

void printTreeTierOrder(sequenceTree T){
    int depth = getTreeDepth(T);
    for(int i = DEF_ONE; i<=depth; i++){
        for(int j=pow(DEF_TWO, i - DEF_ONE) - DEF_ONE; j<=pow(DEF_TWO, i)- DEF_TWO; j++){
            if(T[j] != NUL){ std::cout<<T[j]<<"  ";}else{ std::cout<<"NULL  ";}
        }
        std::cout<<LF;
    }
}

int createTree(sequenceTree T){
    initTree(T);
    int i = DEF_ZERO;
    std::cout<<"创建说明：空格数据用999表示，结束输入用9999表示"<<LF;
    while (true){
        if(i != DEF_ZERO){
            if(T[(i + DEF_ONE)/DEF_TWO - DEF_ONE] == NUL){
                std::cout<<"本次输入错误";
                return OPERATION_ERROR;
            }
        }
        std::cin>>T[i];
        if(T[i] == INPUT_OK){return OPERATION_ERROR;}
        std::cout<<"目前的Tree："<<LF;
        printTreeTierOrder(T);
        std::cout<<".................................................."<<LF;
        i += DEF_ONE;
    }
    return OPERATION_SUCCESS;
}

int treeEmpty(sequenceTree T){
    if(T[DEF_ZERO] == NUL){
        return OPERATION_SUCCESS;
    }
    return OPERATION_ERROR;
}

int getTreeRootValue(sequenceTree T){
    if(T[DEF_ZERO] != NUL){
        return T[DEF_ZERO];
    }
    return OPERATION_ERROR;
}

int getTreeNodeValue(sequenceTree T, int tier, int i, int &value){
    int depth = getTreeDepth(T);
    int titerCount = pow(tier, i - DEF_ONE);
    if(depth < tier || titerCount < i){ return OPERATION_ERROR;}
    value = T[(int)pow(DEF_TWO, tier - DEF_ONE) + i - DEF_TWO];
    if(value == NUL){ return OPERATION_ERROR;}
    return OPERATION_SUCCESS;
}

int assignTreeNodeValue(sequenceTree T, int tier, int i, int data){
    int depth = getTreeDepth(T);
    int titerCount = pow(tier, i - DEF_ONE);
    if(depth < tier || titerCount < i){ return OPERATION_ERROR;}
    int nodeNumber;
    nodeNumber = (int)pow(DEF_TWO, tier - DEF_ONE) + i - DEF_TWO;
    if(DEF_ZERO == nodeNumber){
        T[DEF_ZERO] = data;
        return OPERATION_SUCCESS;
    }
    if(NUL == data && T[DEF_TWO * nodeNumber + DEF_ONE] == NUL ||\
        T[DEF_TWO * nodeNumber + DEF_TWO] == NUL){
        return OPERATION_ERROR;
    }
    if(NUL != data && T[(int)((nodeNumber + DEF_ONE)/DEF_TWO) - DEF_ONE] == NUL){
        return OPERATION_ERROR;
    }
    T[nodeNumber] = data;
    return OPERATION_SUCCESS;
}

int getTreeParent(sequenceTree T, int data){
    if(NUL == T[DEF_ZERO] || data == T[DEF_ZERO]){ return NUL;}
    for(int i=DEF_ONE; i<INIT_STRAND_SIZE; i++){
        if(data == T[i]){
            return T[(int)((i + DEF_ONE)/DEF_TWO) - DEF_ONE];
        }
    }
    return NUL;
}

int getTreeLeftChild(sequenceTree T, int data){
    if(NUL != data && NUL != T[DEF_ZERO]){
        for(int i=DEF_ZERO; i<INIT_STRAND_SIZE; i++){
            if(data == T[i] && NUL != T[DEF_TWO * i + DEF_ONE]){
                return T[DEF_TWO * i + DEF_ONE];
            }
        }
        return NUL;
    }
    return NUL;
}

int getTreeRightChild(sequenceTree T, int data){
    if(NUL != data && NUL != T[DEF_ZERO]){
        for(int i=DEF_ZERO; i<INIT_STRAND_SIZE; i++){
            if(data == T[i] && NUL != T[DEF_TWO * i + DEF_TWO]){
                return T[DEF_TWO * i + DEF_TWO];
            }
        }
        return NUL;
    }
    return NUL;
}

int getTreeLeftSibling(sequenceTree T, int data){
    if(NUL == data && NUL == T[DEF_ZERO]){
        for(int i=DEF_ZERO; i<INIT_STRAND_SIZE; i++){
            if(data == T[i] && NUL == T[i - DEF_ONE] && i % DEF_TWO == DEF_ZERO){
                return T[i - DEF_ONE];
            }
        }
        return NUL;
    }
    return NUL;
}

int getTreeRightSibling(sequenceTree T, int data){
    if(NUL == data && NUL == T[DEF_ZERO]){
        for(int i=DEF_ZERO; i<INIT_STRAND_SIZE; i++){
            if(data == T[i] && NUL == T[i + DEF_ONE] && i % DEF_TWO == DEF_ONE){
                return T[i + DEF_ONE];
            }
        }
        return NUL;
    }
    return NUL;   
}

void printTreePrOrder(sequenceTree T, int pos){
    if(T[pos] != NUL){
        std::cout<<T[pos]<<"  ";
    }
    if(T[DEF_TWO * pos + DEF_ONE] != NUL){
        printTreePrOrder(T, (DEF_TWO * pos + DEF_ONE));
    }
    if(T[DEF_TWO * pos + DEF_TWO] != NUL){
        printTreePrOrder(T, (DEF_TWO * pos + DEF_TWO));
    } 
}

void printTreeInOrder(sequenceTree T, int pos){
    if(T[DEF_TWO * pos + DEF_ONE] != NUL){
        printTreePrOrder(T, (DEF_TWO * pos + DEF_ONE));
    }
    if(T[pos] != NUL){
        std::cout<<T[pos]<<"  ";
    }
    if(T[DEF_TWO * pos + DEF_TWO] != NUL){
        printTreePrOrder(T, (DEF_TWO * pos + DEF_TWO));
    } 
}

void printTreePostOrder(sequenceTree T, int pos){
    if(T[DEF_TWO * pos + DEF_ONE] != NUL){
        printTreePrOrder(T, (DEF_TWO * pos + DEF_ONE));
    }
    if(T[DEF_TWO * pos + DEF_TWO] != NUL){
        printTreePrOrder(T, (DEF_TWO * pos + DEF_TWO));
    }
    if(T[pos] != NUL){
        std::cout<<T[pos]<<"  ";
    } 
}

int clearTree(sequenceTree T){
    for(int i=DEF_ZERO; i<INIT_STRAND_SIZE; i++){
        T[i] = NUL;
    }
    return OPERATION_SUCCESS;
}

int getTreeLength(sequenceTree T){
    int len;
    for(len = INIT_STRAND_SIZE;len-DEF_ONE>0; len--){
        if(NUL !=T[len-DEF_ONE] && LN != T[len-DEF_ONE]){
            break;
        }
    }
    return len;
}