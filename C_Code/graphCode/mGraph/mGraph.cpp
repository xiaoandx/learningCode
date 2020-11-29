/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 图的定义与操作
 * @Author: WEI.ZHOU
 * @Date: 2020-11-27 16:55:52
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
 * DG:有向图，DN:有向网，UDG:无向网，UDN:无向网
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
 * @brief   创建图
 * @Date    2020-11-27 17:02:52
 * @param   mGraph &G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int createGraph(mGraph& G);

/**
 * @brief   获取节点的位置
 * @Date    2020-11-27 21:03:40
 * @param   mGraph G 需要进行查询的图
 * @param   vertexType v 需要查询的节点值
 * @return  {int} 返回节点位置（-1为空）
 */
int locatVexIndex(mGraph G, vertexType v);

/**
 * @brief   图创建抽离公共(包括初始化，获取图节点等)
 * @Date    2020-11-27 22:13:07
 * @param   mGraph &G 需要进行操作的图
 * @param   graphKind V 图类型
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int creatCommon(mGraph& G, graphKind V);

/**
 * @brief   创建有向图
 * @Date    2020-11-27 20:45:59
 * @param   mGraph &G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int createDG(mGraph& G);

/**
 * @brief   创建无向图
 * @Date    2020-11-27 20:45:59
 * @param   mGraph &G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int createDN(mGraph& G);

/**
 * @brief   创建有向网
 * @Date    2020-11-27 20:45:59
 * @param   mGraph &G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int createUDG(mGraph& G);

/**
 * @brief   创建无向网
 * @Date    2020-11-27 20:45:59
 * @param   mGraph &G 需要操作的图
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int createUDN(mGraph& G);

/**
 * @brief   输出显示图
 * @Date    2020-11-27 21:34:03
 * @param   mGraph &G 需要操作的图
 */
void displayGraph(mGraph G);

/**
 * @brief   获取图连接节点的第一条弧的另一端节点位置
 * @Date    2020-11-27 22:25:31
 * @param   mGraph G 需要查询的图
 * @param   int V 查询节点的位置
 * @return  {int} 接节点的第一条弧的另一端节点位置（-1 无弧）
 */
int findFirstAdjVex(mGraph G, int V);

/**
 * @brief   获取图连接节点的一条弧的下一条弧连接节点的节点位置
 * @Date    2020-11-27 22:31:03
 * @param   mGraph G 需要查询的图
 * @param   int V 查询节点的位置
 * @param   int P 上一条弧的节点位置
 * @return  {int} 连接节点的一条弧的下一条弧连接节点的节点位置（-1 无弧）
 */
int findNextAdjVex(mGraph G, int V, int P);

/**
 * @brief   顶点重新赋值
 * @Date    2020-11-29 19:47:31
 * @param   mGraph &G 需要操作的图
 * @param   vertexType V 需要修改的顶点值
 * @param   vertexType e 赋值的新值
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int putVex(mGraph& G, vertexType V, vertexType e);

/**
 * @brief   插入顶点
 * @Date    2020-11-29 19:55:04
 * @param   mGraph &G 需要操作的图
 * @param   vertexType V 插入顶点的值
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int insertVexNode(mGraph& G, vertexType V);

/**
 * @brief   插入弧
 * @Date    2020-11-29 20:05:55
 * @param   mGraph &G 需要操作的图
 * @param   vertexType V 弧的第一个顶点
 * @param   vertexType N 弧的第二个顶点
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int insertArc(mGraph& G, vertexType V, vertexType N);

/**
 * @brief   删除图中的节点
 * @Date    2020-11-29 20:16:33
 * @param   mGraph &G 需要操作的图
 * @param   vertexType V 需要删除的顶点
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int deleteVexNode(mGraph& G, vertexType V);

/**
 * @brief   删除两节点的弧
 * @Date    2020-11-29 20:19:57
 * @param   mGraph &G 需要操作的图
 * @param   vertexType V 弧的第一个顶点
 * @param   vertexType N 弧的第二个顶点
 * @return  {int} 1->SUCCESSFUL; 0->ERROR
 */
int deleteArc(mGraph& G, vertexType V, vertexType N);

int main() {
    mGraph g;
    createGraph(g);
    displayGraph(g);
    return OPERATION_SUCCESS;
}

int createGraph(mGraph& G) {
    /**
     * @brief: 变量说明
     * int kind 创建图的类型(0:有向图，1:有向网，2:无向网，3:无向网，)
     */
    int kind;
    std::cout << "input graph kind (0:DG,1:DN,2:DN,3:DN) : ";
    std::cin >> kind;
    switch (kind) {
        case ZERO:
            return createDG(G);
        case ONE:
            return createDN(G);
        case TWO:
            return createUDG(G);
        case ONE + TWO:
            return createUDN(G);
    }
    return MINUS_ONE;
}

int locatVexIndex(mGraph G, vertexType v) {
    for (int i = ZERO; i < G.vexnum; i++) {
        if (strcmp(G.vexs[i], v) == ZERO) {
            return i;
        }
    }
    return MINUS_ONE;
}

int creatCommon(mGraph& G, graphKind V) {
    /**
     * @brief: 变量说明
     * int i, j;                   循环变量
     */
    int i, j;
    G.kind = V;
    std::cout << "input vexnum and arcnum number：";
    std::cin >> G.vexnum >> G.arcnum;
    for (i = ZERO; i < G.vexnum; i++) {
        std::cout << "input " << i + ONE << " node: ";
        std::cin >> G.vexs[i];
    }
    for (i = ZERO; i < G.vexnum; i++) {
        for (j = ZERO; j < G.vexnum; j++) {
            G.arcs[i][j].adj = ZERO;
            G.arcs[i][j].info = NULL;
        }
    }
    return OPERATION_SUCCESS;
}

int createDG(mGraph& G) {
    /**
     * @brief: 变量说明
     * vertexType v_one, v_two;     创建弧的两个节点值
     * int i, status;               i循环变量，status 创建节点初始化状态
     * int key_one, key_two;        创建弧的两个节点值所在图中的位置
     */
    vertexType v_one, v_two;
    int i, status;
    int key_one, key_two;
    status = creatCommon(G, DG);
    if (OPERATION_ERROR == status) {
        return OPERATION_ERROR;
    }
    for (i = ZERO; i < G.arcnum; i++) {
        std::cout << "input " << i + ONE << " arcn (space separation):";
        std::cin >> v_one >> v_two;
        key_one = locatVexIndex(G, v_one);
        key_two = locatVexIndex(G, v_two);
        G.arcs[key_one][key_two].adj = ONE;
    }
    return OPERATION_SUCCESS;
}

int createDN(mGraph& G) {
    /**
     * @brief: 变量说明
     * vertexType v_one, v_two;     创建弧的两个节点值
     * int i, status;               i循环变量，status 创建节点初始化状态
     * int key_one, key_two;        创建弧的两个节点值所在图中的位置
     */
    vertexType v_one, v_two;
    int i, status;
    int key_one, key_two;
    status = creatCommon(G, DG);
    if (OPERATION_ERROR == status) {
        return OPERATION_ERROR;
    }
    for (i = ZERO; i < G.arcnum; i++) {
        std::cout << "input " << i + ONE << " arcn (space separation):";
        std::cin >> v_one >> v_two;
        key_one = locatVexIndex(G, v_one);
        key_two = locatVexIndex(G, v_two);
        G.arcs[key_one][key_two].adj = ONE;
        G.arcs[key_two][key_one].adj = ONE;
    }
    return OPERATION_SUCCESS;
}

int createUDG(mGraph& G) {
    /**
     * @brief: 变量说明
     * vertexType v_one, v_two;     创建弧的两个节点值
     * int i, status;               i循环变量，status 创建节点初始化状态
     * int key_one, key_two;        创建弧的两个节点值所在图中的位置
     * char * infoValue;            有向网的弧中包含的信息
     */
    vertexType v_one, v_two;
    int i, status;
    int key_one, key_two;
    char* infoValue;
    status = creatCommon(G, DG);
    if (OPERATION_ERROR == status) {
        return OPERATION_ERROR;
    }
    for (i = ZERO; i < G.arcnum; i++) {
        std::cout << "input " << i + ONE << " arcn (space separation):";
        std::cin >> v_one >> v_two;
        key_one = locatVexIndex(G, v_one);
        key_two = locatVexIndex(G, v_two);
        G.arcs[key_one][key_two].adj = ONE;
        infoValue = (infoType*)malloc(VERTEX_SIZE * sizeof(infoType));
        std::cout << "input " << i + ONE << " arcn  info value: ";
        std::cin >> infoValue;
        G.arcs[key_one][key_two].info = infoValue;
    }
    return OPERATION_SUCCESS;
}

int createUDN(mGraph& G) {
    /**
     * @brief: 变量说明
     * vertexType v_one, v_two;     创建弧的两个节点值
     * int i, status;               i循环变量，status 创建节点初始化状态
     * int key_one, key_two;        创建弧的两个节点值所在图中的位置
     * char * infoValue;            无向网的弧中包含的信息
     */
    vertexType v_one, v_two;
    int i, status;
    int key_one, key_two;
    char* infoValue;
    status = creatCommon(G, DG);
    if (OPERATION_ERROR == status) {
        return OPERATION_ERROR;
    }
    for (i = ZERO; i < G.arcnum; i++) {
        std::cout << "input " << i + ONE << " arcn (space separation):";
        std::cin >> v_one >> v_two;
        key_one = locatVexIndex(G, v_one);
        key_two = locatVexIndex(G, v_two);
        G.arcs[key_one][key_two].adj = ONE;
        G.arcs[key_two][key_one].adj = ONE;
        infoValue = (infoType*)malloc(VERTEX_SIZE * sizeof(infoType));
        std::cout << "input " << i + ONE << " arcn  info value: ";
        std::cin >> infoValue;
        G.arcs[key_one][key_two].info = infoValue;
        G.arcs[key_two][key_one].info = infoValue;
    }
    return OPERATION_SUCCESS;
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
                std::cout << &G.arcs[i][j].info << " \t ";
            }
        }
        std::cout << LF;
    }
}

int findFirstAdjVex(mGraph G, int V) {
    int i;
    for (i = ZERO; i < G.vexnum; i++) {
        if (ONE == G.vexs[V][i]) {
            return i;
        }
    }
    return MINUS_ONE;
}

int findNextAdjVex(mGraph G, int V, int P) {
    for (int i = P + ONE; i < G.vexnum; i++) {
        if (ONE == G.vexs[V][i]) {
            return i;
        }
    }
    return MINUS_ONE;
}

int putVex(mGraph& G, vertexType V, vertexType e) {
    if (!G.vexnum) {
        return OPERATION_ERROR;
    }
    int key = locatVexIndex(G, V);
    if (key < ZERO) {
        return OPERATION_ERROR;
    }
    strcpy(G.vexs[key], e);
    return OPERATION_SUCCESS;
}

int insertVexNode(mGraph& G, vertexType V) {
    /**
     * @brief: 变量说明
     * vRType N    图中弧的权重
     */
    if (G.vexnum == ZERO) {
        return OPERATION_ERROR;
    }
    vRType N = ZERO;
    if (G.kind % TWO == ONE) {
        N = INIT_SIZE;
    }
    strcpy(G.vexs[G.vexnum], V);

    for (int i = ZERO; i < G.vexnum; i++) {
        G.arcs[G.vexnum][i].adj = N;
        G.arcs[G.vexnum][i].info = NULL;
        G.arcs[i][G.vexnum].adj = N;
        G.arcs[i][G.vexnum].info = NULL;
    }
    G.vexnum += ONE;
    return OPERATION_SUCCESS;
}

int insertArc(mGraph& G, vertexType V, vertexType N) {
    /**
     * @brief: 变量说明
     * int vexKey_one, vexKey_two    插入两节点间的弧的位置
     */
    if (G.vexnum == ZERO) {
        return OPERATION_ERROR;
    }
    int vexKey_one, vexKey_two;
    vexKey_one = locatVexIndex(G, V);
    vexKey_two = locatVexIndex(G, N);
    if (vexKey_one < ZERO || vexKey_two < ZERO) {
        return OPERATION_ERROR;
    }
    G.arcnum += ONE;
    if (G.kind % TWO) {
        std::cout << "input arc weight : ";
        std::cin >> G.arcs[vexKey_one][vexKey_two].adj;
    } else {
        G.arcs[vexKey_one][vexKey_two].adj = ONE;
    }
    if (G.kind == ONE || G.kind == ONE + TWO) {
        G.arcs[vexKey_two][vexKey_one] = G.arcs[vexKey_one][vexKey_two];
    }
    return OPERATION_SUCCESS;
}
int deleteArc(mGraph& G, vertexType V, vertexType N) {
    /**
     * @brief: 变量说明
     * int vexKey_one, vexKey_two    删除两节点间的弧的位置
     */
    if (G.vexnum == ZERO) {
        return OPERATION_ERROR;
    }
    int vexKey_one, vexKey_two;
    vexKey_one = locatVexIndex(G, V);
    vexKey_two = locatVexIndex(G, N);
    if (vexKey_one < ZERO || vexKey_two < ZERO) {
        return OPERATION_ERROR;
    }
    if (G.arcs[vexKey_one][vexKey_two].adj == ONE) {
        G.arcs[vexKey_one][vexKey_two].adj = ZERO;
        G.arcnum -= ONE;
        return OPERATION_SUCCESS;
    }
    return OPERATION_ERROR;
}

int deleteVexNode(mGraph& G, vertexType V) {
    /**
     * @brief: 变量说明
     * int i, j     循环变量
     * int vexKey   删除节点的位置
     */
    if (G.vexnum == ZERO) {
        return OPERATION_ERROR;
    }
    int i, j;
    int vexKey = locatVexIndex(G, V);
    if (vexKey < ZERO) {
        return OPERATION_ERROR;
    }
    for (i = ZERO; i < G.vexnum; i++) {
        deleteArc(G, V, G.vexs[i]);
        deleteArc(G, G.vexs[i], V);
    }
    for (i = vexKey + ONE; i < G.vexnum; i++) {
        strcpy(G.vexs[i - ONE], G.vexs[i]);
    }
    for (i = vexKey + ONE; i < G.vexnum; i++) {
        for (j = ZERO; j < G.vexnum; j++) {
            G.arcs[i - ONE][j] = G.arcs[i][j];
        }
    }
    for (i = vexKey + ONE; i < G.vexnum; i++) {
        for (j = ZERO; j < G.vexnum; j++) {
            G.arcs[j][i - ONE] = G.arcs[j][i];
        }
    }
    G.vexnum -= ONE;
    return OPERATION_SUCCESS;
}