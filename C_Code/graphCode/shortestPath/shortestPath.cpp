/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 最短路径
 * @Author: WEI.ZHOU
 * @Date: 2020-12-09 20:00:11
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdlib.h>
#include <string.h>
#include <iostream>

#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define MAX_VERTEX_NUM 20
#define VERTEX_SIZE 10
#define INIT_SIZE 999999
#define MINUS_ONE -1
#define ZERO 0
#define ONE 1
#define TWO 2
#define LF '\n'

/**
 * @brief   变量说明
 * int vRType       图中弧的权重(0代表无弧)
 * char vertexType[VERTEX_SIZE]     图中保存节点信息
 * char infoType                网中弧包括的其它信息
 */
typedef int vRType;
typedef char vertexType[VERTEX_SIZE];
typedef char infoType;

/**
 * DG:有向图，DN:有向网，UDG:无向图，UDN:无向网
 */
enum graphKind { DG, DN, UDG, UDN };
typedef struct {
    vRType adj;
    infoType* info;
} arcCell, adjMatrix[MAX_VERTEX_NUM][MAX_VERTEX_NUM];
typedef struct {
    vertexType vexs[MAX_VERTEX_NUM];
    adjMatrix arcs;
    int vexnum, arcnum;
    graphKind kind;
} mGraph;


/**
 * @brief   输出显示图
 * @Date    2020-11-27 21:34:03
 * @param   mGraph &G 需要操作的图
 */
void displayGraph(mGraph G);

/**
 * @brief   判断图是否为空
 * @Date    2020-11-30 14:37:05
 * @param   mGraph G 需要操作的图
 * @return  {int} 1->NULL; 0->not NULL
 */
int isEmpty(mGraph G);

/**
 * @brief   创建例子图(含权重) 用户进行最小生成树操作
 * @Date    2020-12-05 17:03:23
 * @param   mGraph &G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int createExampleGraph(mGraph &G);

/**
 * @brief   迪杰斯特拉算法
 * @Date    2020-12-09 20:13:37
 * @param   mGraph G    需要操作的网
 * @param   int pos    起点
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int shartesPathDij(mGraph G, int pos);

int main() {
    mGraph g;
    createExampleGraph(g);
    displayGraph(g);
    shartesPathDij(g, ZERO);
    return OPERATION_SUCCESS;
}

int createExampleGraph(mGraph &G){
    G.kind = DN;
    strcpy(G.vexs[0],"v0");strcpy(G.vexs[1],"v1");
    strcpy(G.vexs[2],"v2");strcpy(G.vexs[3],"v3");
    strcpy(G.vexs[4],"v4");strcpy(G.vexs[5],"v5");
    G.vexnum = 6;
    for(int i = ZERO; i<G.vexnum; i++){
        for(int j = ZERO; j<G.vexnum; j++){
            G.arcs[i][j].adj = INIT_SIZE;
            G.arcs[i][j].info = NULL;
        }
    }
    G.arcs[0][2].adj = 10; G.arcs[0][4].adj = 30;
    G.arcs[0][5].adj = 100;G.arcs[1][2].adj = 5;
    G.arcs[2][3].adj = 50;G.arcs[3][5].adj = 10;
    G.arcs[4][3].adj = 20; G.arcs[4][5].adj = 60; 
    G.arcnum = 8;
    return OPERATION_SUCCESS;
}

void displayGraph(mGraph G) {
    std::cout << "graph node :\t";
    for (int i = ZERO; i < G.vexnum; i++) {
        std::cout << G.vexs[i] << " \t";
    }
    std::cout << LF << "graph arcs:" << LF;
    for (int i = ZERO; i < G.vexnum; i++) {
        for (int j = ZERO; j < G.vexnum; j++) {
        	vRType gert = (G.arcs[i][j].adj == INIT_SIZE) ? ZERO : G.arcs[i][j].adj;
            std::cout << gert << "\t-\t";
        }
        std::cout << LF << LF;
    }
}

int isEmpty(mGraph G){
    if(ZERO == G.vexnum){
        return ONE;
    }
    return ZERO;
}

int shartesPathDij(mGraph G, int pos) {
    int dist[G.vexnum];
    int mack[G.vexnum];
    int path[G.vexnum];
    vRType routeLenght = ZERO;
    if (isEmpty(G) && pos < ZERO && pos > G.vexnum) {
        return OPERATION_ERROR;
    }
    //  初始化
    for (int i = ZERO; i < G.vexnum; i++) {
        dist[i] = G.arcs[pos][i].adj;
        mack[i] = ZERO;
        path[i] = pos;
    }
    mack[pos] = ONE;

    for (int i = ZERO; i < G.vexnum; i++) {
        vRType min = INIT_SIZE;
        int minIndex = MINUS_ONE;
        for (int j = ZERO; j < G.vexnum; j++) {
            if (mack[j] == ZERO && dist[j] < min) {
                min = dist[j];
                minIndex = j;
            }
        }
        if (minIndex > MINUS_ONE) {
            mack[minIndex] = ONE;
        }
        for (int j = ZERO; j < G.vexnum; j++) {
            if (mack[j] == ZERO && dist[j] > (min + G.arcs[minIndex][j].adj)) {
                dist[j] = min + G.arcs[minIndex][j].adj;
                path[j] = minIndex;
            }
        }
    }

    // 打印输出
    for (int i = ZERO; i < G.vexnum; i++) {
        std::cout << G.vexs[pos] << " -> " << G.vexs[i] << ": ";
        int k = i;
        do {
            std::cout << k << " <- ";
            k = path[k];
        } while (k != pos);
        routeLenght = (dist[i] == INIT_SIZE) ? ZERO : dist[i];
        std::cout << pos << " path lenght ：" << routeLenght << LF;
    }
    return OPERATION_SUCCESS;
}