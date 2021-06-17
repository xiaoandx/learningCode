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
 * @Date: 2021-06-16 16:33:19
 * @Version: V1.0
 * 			
 */
#include "stdio.h"
#include "stdlib.h"
#include "string.h"

/**
 * 线程数量
 */
#define N 5

/**
 * 资源数量
 */
#define M 3

/**
 * 剩余可以资源数量
 */
int Available[M];

/**
 * 线程最大资源需求
 */
int Max[N][M];

/**
 * 线程以获得资源数量
 */
int Allocation[N][M];

/**
 * 线程需要的资源数量
 */
int Need[N][M];

/**
 * 每个线程结果 
 */
int Success[N];

/**
 * 系统还剩余线程数量
 */
char* AvailablePath =
    (char *)"D:\\desktop_2\\desktop\\ss\\yibingCode\\C_"
    "Code\\BankerAagorithm\\Available.txt";

/**
 * 线程最大资源需求初始数据 
 */
char* MaxPath =
    (char *)"D:\\desktop_2\\desktop\\ss\\yibingCode\\C_Code\\BankerAagorithm\\Max.txt";

/**
 * 线程已经分配资源数据 
 */
char* AllocationPath =
    (char *)"D:\\desktop_2\\desktop\\ss\\yibingCode\\C_"
    "Code\\BankerAagorithm\\Allocation.txt";

/**
 * 读取TxT文件中行内数据（1D example：19 34 34 ...）
 * @Date: 2021-06-16 18:46:45
 * @param {char*}       数据文件路径
 * @param {int} arr     保存数据数组
 * @param {int} m       行内数据数
 */
void readFileDataBy1D(char* fileName, int arr[], int m);

/**
 * 读取TxT文件中所有数据（2D example：19 34 34 ...
 *                                16 34 56 ...）
 * @Date: 2021-06-16 18:51:18
 * @param  {char*}          数据文件路径
 * @param {int arr[][]} arr 数据保存数组
 * @param {int} n           列内数据数
 * @param {int} m           行内数据数
 */
void readFileDataBy2D(char* fileName, int arr[][M], int n, int m);

/**
 * 指定线程请求资源
 * @Date: 2021-06-16 19:06:09
 * @param {int} current     线程编号
 * @param {int[]} request   请求分配资源数量
 */
void handle(int current, int request[]);

/**
 * 初始化所有进程的T0时刻的资源分配表
 * @Date: 2021-06-16 19:08:09
 */
void init();

/**
 * 打印显示进程的资源分配表
 * @Date: 2021-06-16 19:09:40
 */
void menuContext();

/**
 * 安全检查-看是否满足分配后存在进程安全序列
 * @Date: 2021-06-16 19:11:24
 * @return {int}        1 检查通过有安全序列；0检查不通过，不存在安全序列
 */
int checkSecure();

/**
 * 控制台暂停
 * @Date: 2021-06-16 19:14:35
 */
void pause();

/**
 * 运行主函数
 * @Date: 2021-06-16 19:15:02
 */
int main() {
    // 新进程请求资源数组
    int request[M];
    // 新请求的进程编号
    int current;
    init();
    while (true) {
        menuContext();
        // 检查T0时刻是否存在安全序列
        checkSecure();
        printf("\n输入需要再次分配的进程编号P:");
        scanf("%d", &current);
        for (int i = 0; i < M; i++) {
            printf("输入%d进程要分配的资源%d数量:",current, i + 1);
            scanf("%d", &request[i]);
        }
        // 进程资源分配
        handle(current, request);

        pause();
    }
    return 0;
}


void readFileDataBy1D(char* fileName, int arr[], int m) {
    int i;
    FILE* fp = fopen(fileName, "rb");
    for (i = 0; i < m; i++) {
        fscanf(fp, "%d", &arr[i]);
    }
}

void menuContext() {
    printf("========================银行家算法测试代码===============\n");
    printf("\t\t当前系统资源情况表：\n");
    printf("PID       Max      Allocation    Need        Available\n");
    for (int i = 0; i < N; i++) {
        printf("P%d    ", i);
        for (int j = 0; j < M; j++) {
            printf("%3d", Max[i][j]);
        }
        printf("   ");
        for (int j = 0; j < M; j++) {
            printf("%3d", Allocation[i][j]);
        }
        printf("   ");
        for (int j = 0; j < M; j++) {
            printf("%3d", Need[i][j]);
        }
        if (i == 0) {
            printf("   ");
            for (int j = 0; j < M; j++) {
                printf("%4d", Available[j]);
            }
            printf("\n");
        } else {
            printf("   ");
            printf("\n");
        }
    }
}

void readFileDataBy2D(char* fileName, int arr[][M], int n, int m) {
    int i,j;
    FILE* fp = fopen(fileName, "rb");
    for (i = 0; i < n; i++) {
        for (j = 0; j < m; j++) {
            fscanf(fp, "%d", &arr[i][j]);
        }
    }
}

void init() {
    readFileDataBy1D(AvailablePath, Available, M);
    readFileDataBy2D(MaxPath, Max, N, M);
    readFileDataBy2D(AllocationPath, Allocation, N, M);
    // 根据进程需求最大数量 - 已分配资源  = Need(还需资源数)
    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            Need[i][j] = Max[i][j] - Allocation[i][j];
        }
    }
    // 资源总数 - 以分配的资源数 = Available(还剩余资源数)
    for (int i = 0; i < M; i++) {
        int sum = 0;
        for (int j = 0; j < N; j++) {
            sum += Allocation[j][i];
        }
        Available[i] -= sum;
    }
}

int checkSecure() {
    // 工作向量
    int work[M];
    // 是否满足资源分配
    int finish[N];
    // 初始化work=Available,；finish=0
    for (int i = 0; i < M; i++) {
        work[i] = Available[i];
    }
    for (int i = 0; i < N; i++) {
        finish[i] = 0;
    }

    printf("安全序列： ");
    while (1) {
        // 标识这一轮是否有进程完成
        int flag = 0;
        for (int i = 0; i < N; i++) {
            // 判断循环进程是否满足了资源要求分配，如果这个进程没有完成，则判断其是否可以完成
            if (!finish[i]) {
                // temp=0 表示可以完成
                int temp = 0;
                for (int j = 0; j < M; j++) {
                    if (Need[i][j] > work[j]) {
                        temp = 1;
                        break;
                    }
                }
                if (!temp) {
                    for (int j = 0; j < M; j++) {
                        work[j] += Allocation[i][j];
                    }
                    finish[i] = 1;
                    flag++;
                    printf("%d ", i);
                }
            }
        }
        if (!flag) {
            break;
        }
    }
    printf("\n\n");
    // 判断所有进程的finish是否为1(满足)，如果有一个线程为0那说明不存在安全序列
    for (int i = 0; i < N; i++) {
        if (!finish[i]) {
            return 0;
        }
    }
    // 所有的线程都能安全，存在安全序列
    return 1;
}

void handle(int current, int request[]) {
    // 进程任务是否完成
    int finish = 1;
    // 检查剩余的资源数量 是否满足请求所需的资源数
    for (int i = 0; i < M; i++) {
        if (request[i] > Need[current][i]) {
            printf("请求的资源大于需要的资源\n");
            return;
        }
        if (request[i] > Available[i]) {
            printf("没有足够的资源可分配\n");
            return;
        }
    }

    // 剩余资源数量 满足请求数量，进行假分配
    for (int i = 0; i < M; i++) {
        Available[i] -= request[i];
        Allocation[current][i] += request[i];
        Need[current][i] -= request[i];
    }

    // 加分配后进行安全序列检查，不存在安全序列，回退变化资源数
    if (!checkSecure()) {
        for (int i = 0; i < M; i++) {
            Available[i] += request[i];
            Allocation[current][i] -= request[i];
            Need[current][i] += request[i];
        }
        printf("安全检查未通过\n");
        return;
    }
    
    // 判断新申请的进程是否还需要资源
    for (int i = 0; i < M; i++) {
        if (Need[current][i] > 0) {
            finish = 0;
            break;
        }
    }
    // 如果新申请进程need都为0表示进程已经完成，回收已经分配的资源
    if (finish) {
        for (int i = 0; i < M; i++) {
            Available[i] += Allocation[current][i];
        }
        Success[current] = 1;
    }
}

void pause() {
    getchar();
    printf("按任意键继续!");
    getchar();
}