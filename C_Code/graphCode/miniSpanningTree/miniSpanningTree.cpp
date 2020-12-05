/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						        <xiaoandx@gmail.com>
 * 
 * @Description: 最小生成树( 克鲁斯卡尔（Kruskal)最小生成树)
 * @Author: WEI.ZHOU
 * @Date: 2020-12-05 16:55:52
 * @Version: V1.0
 * @Others: Running test instructions
 *          1.考虑弧边权重信息，再创建图时调用默认函数进行创建
 *          2.文件中大部分代码可以选择删除
 *          3.代码反馈：<https://github.com/xiaoandx/learningCode/issues>
 * 			
 */
#include <stdio.h>
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
 * DG:有向图，DN:无向网，UDG:有向网，UDN:无向网
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

typedef struct {
    vertexType start;
    vertexType end;
    int weight;
}arcData;

/**
 * @brief   获取节点的位置
 * @Date    2020-11-27 21:03:40
 * @param   mGraph G 需要进行查询的图
 * @param   vertexType v 需要查询的节点值
 * @return  {int} 返回节点位置（-1为空）
 */
int locatVexIndex(mGraph G, vertexType v);

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
 * @brief   获取图中所有的弧边，保存再数组中
 * @Date    2020-12-05 18:05:22
 * @param   mGraph G 需要操作的图
 * @return  arcData* 包含图中所有的弧边的数组地址
 */
arcData* getGraphAllArc(mGraph G);

/**
 * @brief   对所有弧边进行升序
 * @Date    2020-12-05 18:06:36
 * @param   arcData* arc    含有所有弧边的地址
 * @param   int arcnum      弧边总数
 */
void sortedGraphArc(arcData* arc, int arcnum);

/**
 * @brief   获取最少生成树中i的终点
 * @Date    2020-12-05 18:08:59
 * @param   int vends[]  保存"已有最小生成树"中每个顶点在该最小树中的终点。
 * @param   int i 第i位置
 * @return  {int}   终点位置
 */
int getEnd(int vends[], int i);

/**
 * @brief   克鲁斯卡尔（Kruskal)最小生成树
 * @Date    2020-12-05 18:11:14
 * @param   mGraph G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int kruskal(mGraph G);

int main() {
    mGraph g;
    createExampleGraph(g);
    displayGraph(g);
    std::cout<<LF;
    kruskal(g);
    return OPERATION_SUCCESS;
}

int createExampleGraph(mGraph &G){
    G.kind = DN;
    G.vexnum = TWO * TWO;
    char a[10]="1";
    char b[10]="2";
    char c[10]="3";
    char d[10]="4";
    strcpy(G.vexs[0],a);
    strcpy(G.vexs[1],b);
    strcpy(G.vexs[2],c);
    strcpy(G.vexs[3],d);
    G.arcs[0][0].adj = ZERO;
    G.arcs[0][1].adj = 3; G.arcs[1][0].adj = 3;
    G.arcs[0][2].adj = 2; G.arcs[2][0].adj = 2;
    G.arcs[0][3].adj = 6; G.arcs[3][0].adj = 6;
    G.arcs[1][1].adj = 0; 
    G.arcs[1][2].adj = 0; G.arcs[2][1].adj = 0;
    G.arcs[1][3].adj = 4; G.arcs[3][1].adj = 4;
    G.arcs[2][2].adj = 0; 
    G.arcs[2][3].adj = 5; G.arcs[3][2].adj = 5;
    G.arcs[3][3].adj = 0; 
    G.arcnum = 5;
    return OPERATION_SUCCESS;
}

int locatVexIndex(mGraph G, vertexType v) {
    for (int i = ZERO; i < G.vexnum; i++) {
        if (strcmp(G.vexs[i], v) == ZERO) {
            return i;
        }
    }
    return MINUS_ONE;
}

void displayGraph(mGraph G) {
    std::cout << "graph node :";
    for (int i = ZERO; i < G.vexnum; i++) {
        std::cout << G.vexs[i] << " ";
    }
    std::cout << LF << "graph arcs:" << LF;
    for (int i = ZERO; i < G.vexnum; i++) {
        for (int j = ZERO; j < G.vexnum; j++) {
            std::cout << G.arcs[i][j].adj << " - ";
            if (G.kind == UDG || UDN == G.kind) {
                // std::cout << G.arcs[i][j].info << " \t ";
                printf(" %s \t", G.arcs[i][j].info);
            }
        }
        std::cout << LF;
    }
}

int isEmpty(mGraph G){
    if(ZERO == G.vexnum){
        return ONE;
    }
    return ZERO;
}

arcData* getGraphAllArc(mGraph G) {
    int i, j;
    int index = ZERO;
    arcData* arc;
    arc = (arcData*)malloc(G.arcnum * sizeof(arcData));
    for (i = ZERO; i < G.vexnum; i++) {
        for (j = i + ONE; j < G.vexnum; j++) {
            if (G.arcs[i][j].adj != ZERO) {
                strcpy(arc[index].start, G.vexs[i]);
                strcpy(arc[index].end, G.vexs[j]);
                arc[index].weight = G.arcs[i][j].adj;
                index += ONE;
            }
        }
    }
    return arc;
}

void sortedGraphArc(arcData* arc, int arcnum) {
    int i, j;
    for (i = ZERO; i < arcnum; i++) {
        for (j = i + ONE; j < arcnum; j++) {
            if (arc[i].weight > arc[j].weight) {
                // 交换"第i条边"和"第j条边"
                arcData tmp = arc[i];
                arc[i] = arc[j];
                arc[j] = tmp;
            }
        }
    }
}

int getEnd(int vends[], int i) {
    while (vends[i] != ZERO) {
        i = vends[i];
    }
    return i;
}

int kruskal(mGraph G) {
    /**
     * @brief   变量说明
     * int i;           for循环变量
     * int index;       数组索引
     * int m,n;         已有的最小生成树"中的终点
     * int p1,p2;       获取第i条边的"起点/终点"的位置序号
     * int length;      最小生成树的弧边数
     * int vends[];     保存"已有最小生成树"中每个顶点在该最小树中的终点
     * arcData rets[];  保存最小生成树的边
     * arcData* arc;    图对应的所有边
     */
    int i, m, n, p1, p2;
    int length;
    int index = ZERO;
    int vends[MAX_VERTEX_NUM] = {
        ZERO};
    arcData rets[MAX_VERTEX_NUM];
    arcData* arc;
    if(isEmpty(G)){ return OPERATION_ERROR;}
    // 获取"图中所有的边"
    arc = getGraphAllArc(G);
    // 将边按照"权"的大小进行排序(从小到大)
    sortedGraphArc(arc, G.arcnum);
    for (i = ZERO; i < G.arcnum; i++) {
        p1 = locatVexIndex(G, arc[i].start);
        p2 = locatVexIndex(G, arc[i].end);
        m = getEnd(vends, p1);
        n = getEnd(vends, p2);
        if (m != n) {
            vends[m] = n;
            rets[index++] = arc[i];
        }
    }
    free(arc);
    // 统计并打印"最小生成树"的信息
    length = ZERO;
    for (i = ZERO; i < index; i++){
        length += rets[i].weight;
    }
    std::cout<<"miniSpanningTreeNodeNumber = "<<length<<LF;
    std::cout<<"miniSpanningTreeArc:";
    for (i = ZERO; i < index; i++){
        std::cout<<"<"<<rets[i].start<<"-"<<rets[i].end<<">";
    }
    return OPERATION_SUCCESS;
}