/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email address.
 *                           <xiaoandx@gmail.com>
 *
 * @Description: 赫夫曼树定义与操作(使用stringToWeight方法进行输入电文在后续求编码)
 * @Author: WEI.ZHOU
 * @Date: 2020-11-19 16:26:10
 * @Version: V1.0
 * @Others:  Running test instructions
 *           1. 默认权重个数 4 ,修改默认参数修改宏定义中的 INIT_SIZE
 *           2. 运行测试代码需要先创建权重数值，不想输入创建，可将int* w; w = createWeight(); 
 *              修改为int w[INIT_SIZE];w[0]=7,w[1]=5,w[2]=2,w[3]=4;
 *           3. 修改权重编码默认样式A、B，可以修改默认参数修改宏定义中的 L_CODE、R_CODE
 *           4. 如有代码问题可以 issues  <https://github.com/xiaoandx/learningCode>
 *           5. 提供两种：一种已知权重，求权重编码(方法：createWeight)
 *                      二种输入任意电文，进行编码(方法：stringToWeight)
 */
#include <stdlib.h>
#include <string.h>
#include <iostream>

#define INIT_SIZE 4
#define STRING_SIZE 20
#define INIT_MIX 9999999
#define OPERATION_SUCCESS 1
#define OPERATION_ERROR 0
#define DEF_ONE 1
#define DEF_TWO 2
#define DEF_ZERO 0
#define MINUS_ONE -1
#define LF '\n'
#define END '\0'
#define L_CODE 'A'
#define R_CODE 'B'

/**
 * @brief: 赫夫曼树结构
 */
typedef struct huffmanNode {
    unsigned int weight;
    unsigned int parent;
    unsigned int lchild;
    unsigned int rchild;
} huffmanNode, *huffmanTree;

/**
 * @brief: 存放赫夫曼编码数组
 */
typedef char** huffmanCode;

/**
 * @brief   初始化树
 * @Date    2020-11-19 16:43:47
 * @param huffmanTree &T 赫夫曼树
 */
void initTree(huffmanTree& T);

/**
 * @brief   创建赫夫曼树
 * @Date    2020-11-19 17:21:56
 * @param   huffmanTree &hT 需要创建的赫夫曼树
 * @param   int *w 权重数组集合
 * @param   int N 权重个数
 * @return  {int} 1->操作成功；0->操作失败
 */
int createHuffmanTree(huffmanTree& hT, int* w, int N);

/**
 * @brief   查询权重数组中最小的两个位置
 * @Date    2020-11-19 17:23:44
 * @param   huffmanTree &hT 需要创建的赫夫曼树
 * @param   int &min_one 最小的权重的下标位置
 * @param   int &min_two 倒数第二小的权重的下标位置
 * @param   int N 权重个数
 */
void findHuffmanTreeMin(huffmanTree hT, int& min_one, int& min_two, int n);

/**
 * @brief   获取权重的最小权重的下标位置
 * @Date    2020-11-19 17:25:27
 * @param   huffmanTree &hT 需要创建的赫夫曼树
 * @param   int N 权重个数
 * @return  {int} 最新权重的位置
 */
int getTreeMin(huffmanTree hT, int n);

/**
 * @brief   获取赫夫曼编码
 * @Date    2020-11-19 17:28:46
 * @param   huffmanTree hT 赫夫曼树
 * @param   huffmanTree &hC 储存转换后的赫夫曼代码
 * @return  {int} 1->操作成功；0->操作失败
 */
int huffmanTreeCode(huffmanTree hT, huffmanCode& hC);

/**
 * @brief   打印显示赫夫曼编码
 * @Date    2020-11-19 18:03:15
 * @param   huffmanTree hT 赫夫曼树
 * @param   huffmanTree hC 储存转换后的赫夫曼代码
 */
void showHuffmanCode(huffmanTree hT, huffmanCode hC);

/**
 * @brief   创建权重列表(已知权重)
 * @Date    2020-11-19 19:45:41
 * @return  { int array[] } weight数组
 */
int* createWeight();

/**
 * @brief   输入电文统计权重列表
 * @Date    2020-11-23 14:38:35
 * @return  {int array[]} 字符转权重列表
 */
int* stringToWeight();

int main() {
    huffmanTree hT;
    huffmanCode hC;
    int* w;
    w = stringToWeight();
    std::cout<<LF;
    std::cout<<"input strings to weightArray is: ";
    for(int i=0;i<4;i++){
        std::cout<<w[i]<<" ";
    }
    std::cout<<"\n============ string to huffmancode ============"<<LF;
    initTree(hT);
    createHuffmanTree(hT, w, INIT_SIZE);
    huffmanTreeCode(hT, hC);
    showHuffmanCode(hT, hC);
    return OPERATION_SUCCESS;
}

void initTree(huffmanTree& T) {
    T = NULL;
}

int createHuffmanTree(huffmanTree& hT, int* w, int N) {
    /**
     * @brief 变量说明：
     * int i         for循环遍历
     * int min_one, min_two     权重数组中依次最小的两个值的位置
     * int nodeNumber       赫夫曼树的节点数
     */
    int i;
    int min_one, min_two;
    int nodeNumber = DEF_TWO * N - DEF_ONE;
    hT = (huffmanTree)malloc((nodeNumber + DEF_ZERO) * sizeof(huffmanNode));
    if (!hT) {
        return OPERATION_ERROR;
    }
    hT[DEF_ZERO].weight = N;
    // 进行哈夫曼树的权重初始化
    for (i = DEF_ONE; i <= nodeNumber; i++) {
        if (i <= N) {
            hT[i].weight = w[i - DEF_ONE];
        } else {
            hT[i].weight = DEF_ZERO;
        }
        hT[i].parent = DEF_ZERO;
        hT[i].lchild = DEF_ZERO;
        hT[i].rchild = DEF_ZERO;
    }
    for (i = (N + DEF_ONE); i <= nodeNumber; i++) {
        findHuffmanTreeMin(hT, min_one, min_two, i - DEF_ONE);
        hT[i].lchild = min_one;
        hT[i].rchild = min_two;
        hT[i].weight = hT[min_one].weight + hT[min_two].weight;
        hT[min_one].parent = i;
        hT[min_two].parent = i;
    }
    return OPERATION_SUCCESS;
}

void findHuffmanTreeMin(huffmanTree hT, int& min_one, int& min_two, int n) {
    min_one = getTreeMin(hT, n);
    min_two = getTreeMin(hT, n);
}

int getTreeMin(huffmanTree hT, int n) {
    /**
     * @brief 变量说明：
     * int i         for循环遍历
     * int min_index     权重数组中最小值的位置
     * int min      权重数组中最小值 default = 9999999
     */
    int i, min_index;
    int min = INIT_MIX;
    for (i = DEF_ONE; i <= n; i++) {
        if (min > hT[i].weight && hT[i].parent == DEF_ZERO) {
            min = hT[i].weight;
            min_index = i;
        }
    }
    hT[min_index].parent = DEF_ONE;
    return min_index;
}

int huffmanTreeCode(huffmanTree hT, huffmanCode& hC) {
    /**
     * @brief 变量说明：
     * int n         权重总数
     * int start     赫夫曼代码数组的下标
     * int f, c      节点的双亲节点的下标
     * char *cd      赫夫曼代码数组
     */
    int n;
    int start;
    unsigned f, c;
    char* cd;
    n = hT[DEF_ZERO].weight;
    hC = (huffmanCode)malloc((n + DEF_ONE) * sizeof(char*));
    cd = (char*)malloc(n * sizeof(char));
    if (!hC || !cd) {
        return OPERATION_ERROR;
    }
    cd[n - DEF_ONE] = END;
    for (int i = DEF_ONE; i <= n; i++) {
        start = n - DEF_ONE;
        c = i;
        f = hT[i].parent;
        while (f != DEF_ZERO) {
            if (hT[f].lchild == c) {
                cd[--start] = L_CODE;
            }
            if (hT[f].rchild == c) {
                cd[--start] = R_CODE;
            }
            c = f;
            f = hT[f].parent;
        }
        hC[i] = (char*)malloc((n - start) * sizeof(char));
        strcpy(hC[i], &cd[start]);
    }
    free(cd);
    return OPERATION_SUCCESS;
}

void showHuffmanCode(huffmanTree hT, huffmanCode hC) {
    for (int i = DEF_ONE; i <= INIT_SIZE; i++) {
        std::cout << "weight: " << hT[i].weight << " huffmanCode: " << hC[i]
                  << LF;
    }
}

int* createWeight() {
    static int weigth[INIT_SIZE];
    std::cout
        << "The default size of the weight array is 4, Press enter and end"
        << LF;
    for (int i = DEF_ZERO; i < INIT_SIZE; i++) {
        std::cout << "input " << i + DEF_ONE << " weight：";
        std::cin >> weigth[i];
    }
    return weigth;
}

int* stringToWeight() {
    /**
     * @brief 变量说明
     * char inputArray[STRING_SIZE] 保存输入字符串(长度默认20)
     * int countArray[STRING_SIZE]  保存每个字符串出现的次数(保存频率不连续)
     * int countArrayS[INIT_SIZE]   返回字符串的权重(频率连续)
     * int elementCount             输入字符的个数
     * int i = DEF_ZERO ,j , a      循环初始值
     * int count                    字符频率初始值
    */
    char inputArray[STRING_SIZE];
    static int countArray[STRING_SIZE];
    int *countArrayS;
    // static int countArrayS[INIT_SIZE];
    
    int elementCount = DEF_ZERO, i = DEF_ZERO, j, count, a = DEF_ZERO;
    std::cout << "The input message: ";
    std::cin >> inputArray;
    countArrayS = (int*)malloc(INIT_SIZE*sizeof(int));
    while (inputArray[i] != END) {
        elementCount++;
        countArray[i] = MINUS_ONE;
        i++;
    }
    for (i = DEF_ZERO; i < elementCount; i++) {
        count = DEF_ONE;
        if (countArray[i] == DEF_ZERO) {
            continue;
        }
        for (j = i + DEF_ONE; j < elementCount; j++) {
            if (inputArray[i] == inputArray[j]) {
                countArray[j] = DEF_ZERO;
                count++;
            }
        }
        countArray[i] = count;
    }
    for (i = DEF_ZERO; i < elementCount; i++) {
        if (countArray[i] != DEF_ZERO) {
            countArrayS[a++] = countArray[i];
        }
    }
    return countArrayS;
}