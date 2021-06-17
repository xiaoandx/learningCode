/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems
 * and consequences.
 *
 * In case of code problems, feedback can be made through the following email address.
 *                                              <xiaoandx@gmail.com>
 *
 * @Description: 避免死锁-银行家算法  以分配资源进程已经初始化
 * @Author: WEI.ZHOU
 * @Date: 2021-06-16 16:33:19
 * @Version: V1.2
 */
#include "stdio.h"
#include "stdlib.h"

/**
 * 线程数量
 */
#define PROCESSES_NUMBER 5

/**
 * 资源数量
 */
#define RESOURCES_NUMBER 3

/**
 * 剩余可以资源数量
 */
int Available[RESOURCES_NUMBER] = {10,5,7};

/**
 * 线程最大资源需求
 */
int RESOURCES_NUMBERax[PROCESSES_NUMBER][RESOURCES_NUMBER] = {
    {7,5,3},
    {3,2,2},
    {9,0,2},
    {2,2,2},
    {4,3,2}};

/**
 * 线程以获得资源数量
 */
int Allocation[PROCESSES_NUMBER][RESOURCES_NUMBER] = {
    {0,1,0},
    {2,0,0},
    {3,0,2},
    {2,1,1},
    {0,0,2}};

/**
 * 线程需要的资源数量
 */
int Need[PROCESSES_NUMBER][RESOURCES_NUMBER];

/**
 * 每个线程结果
 */
int Success[PROCESSES_NUMBER];

// 工作向量
int work[RESOURCES_NUMBER];

// 是否满足资源分配
int finish[PROCESSES_NUMBER];

/**
 * 初始化所有进程的T0时刻的资源分配表
 * @Date: 2021-06-16 19:08:09
 */
void init() {
    int i,j;
    // 根据进程需求最大数量 - 已分配资源  = Need(还需资源数)
    for (i = 0; i < PROCESSES_NUMBER; i++) {
        for (j = 0; j < RESOURCES_NUMBER; j++) {
            Need[i][j] = RESOURCES_NUMBERax[i][j] - Allocation[i][j];
        }
    }
    // 资源总数 - 以分配的资源数 = Available(还剩余资源数)
    for (i = 0; i < RESOURCES_NUMBER; i++) {
        int sum = 0;
        for (j = 0; j < PROCESSES_NUMBER; j++) {
            sum += Allocation[j][i];
        }
        Available[i] -= sum;
    }
}

/**
 * 打印显示进程的资源分配表
 * @Date: 2021-06-16 19:09:40
 */
void menuContext() {
    printf("======================银行家算法测试代码=================\n");
    printf("\t\t当前系统资源情况表：\n");
    printf("PID       Max      Allocation     Need        Available        Work        Finish\n");
    int i,j;
    for (i = 0; i < PROCESSES_NUMBER; i++) {
        printf("P%d    ", i);
        for (j = 0; j < RESOURCES_NUMBER; j++) {
            printf("%3d", RESOURCES_NUMBERax[i][j]);
        }
        printf("   ");
        for (j = 0; j < RESOURCES_NUMBER; j++) {
            printf("%3d", Allocation[i][j]);
        }
        printf("   ");
        for (j = 0; j < RESOURCES_NUMBER; j++) {
            printf("%3d", Need[i][j]);
        }
        if (i == 0) {
            printf("   ");
            for (j = 0; j < RESOURCES_NUMBER; j++) {
                printf("%4d", Available[j]);
            }
        } else {
            printf("      ");
        }
        if (i == 0) {
            printf("   ");
            for (j = 0; j < RESOURCES_NUMBER; j++) {
                printf("%5d", work[j]);
            }
        } else {
            printf("\t\t\t\t");
        }
        printf("   ");
        printf("%5d", finish[i]);
        printf("\n");
    }
}

/**
 * 工作向量work初始化，和状态向量Finish初始化为0 
 * @Date: 2021-06-17 20:00:39
 */
void workAndFinishInit(){
    int i;
    for (i = 0; i < RESOURCES_NUMBER; i++) {
        work[i] = Available[i];
    }
    for (i = 0; i < PROCESSES_NUMBER; i++) {
        finish[i] = 0;
    }
}

/**
 * 安全检查-看是否满足分配后存在进程安全序列
 * @Date: 2021-06-16 19:11:24
 * @return {int}        1 检查通过有安全序列；0检查不通过，不存在安全序列
 */
int checkSecure() {
    int i;
    workAndFinishInit();
    printf("安全序列： ");
    while (1) {
        int i;
        int j;
        // 标识这一轮是否有进程完成
        int status = 0;
        for (i = 0; i < PROCESSES_NUMBER; i++) {
            // 判断循环进程是否满足了资源要求分配，如果这个进程没有完成，则判断其是否可以完成
            if (!finish[i]) {
                // temp=0 表示可以完成
                int temp = 0;
                for ( j= 0; j < RESOURCES_NUMBER; j++) {
                    if (Need[i][j] > work[j]) {
                        temp = 1;
                        break;
                    }
                }
                if (!temp) {
                    for (j = 0; j < RESOURCES_NUMBER; j++) {
                        work[j] += Allocation[i][j];
                    }
                    finish[i] = 1;
                    status += 1;
                    printf("%d ", i);
                }
            }
        }
        if (!status) {
            break;
        }
    }
    printf("\n\n");
    // 判断所有进程的finish是否为1(满足)，如果有一个线程为0那说明不存在安全序列
    for (i = 0; i < PROCESSES_NUMBER; i++) {
        if (!finish[i]) {
            return 0;
        }
    }
    // 所有的线程都能安全，存在安全序列
    return 1;
}

/**
 * 指定线程请求资源
 * @Date: 2021-06-16 19:06:09
 * @param {int} current     线程编号
 * @param {int[]} request   请求分配资源数量
 */
void handle(int current, int request[]) {
    int i;
    // 进程任务是否完成
    int finish = 1;
    // 检查剩余的资源数量 是否满足请求所需的资源数
    for (i = 0; i < RESOURCES_NUMBER; i++) {
        if (request[i] > Need[current][i]) {
            printf("进程请求的资源已超过它所需要的最大值资源\n");
            workAndFinishInit();
            return;
        }
        if (request[i] > Available[i]) {
            printf("系统可用资源不足以进行分配\n");
            workAndFinishInit();
            return;
        }
    }

    // 剩余资源数量 满足请求数量，进行假分配
    for (i = 0; i < RESOURCES_NUMBER; i++) {
        Available[i] -= request[i];
        Allocation[current][i] += request[i];
        Need[current][i] -= request[i];
    }

    // 假分配后进行安全序列检查，不存在安全序列，回退刚刚假分配的资源数
    if (!checkSecure()) {
        for (i = 0; i < RESOURCES_NUMBER; i++) {
            Available[i] += request[i];
            Allocation[current][i] -= request[i];
            Need[current][i] += request[i];
        }
        printf("资源分配安全检查失败，不存在安全序列\n");
        return;
    }

    // 判断新申请的进程是否还需要资源
    for (i = 0; i < RESOURCES_NUMBER; i++) {
        if (Need[current][i] > 0) {
            finish = 0;
            break;
        }
    }
    // 如果新申请进程need都为0表示进程已经完成，回收已经分配的资源
    if (finish) {
        for (i = 0; i < RESOURCES_NUMBER; i++) {
            Available[i] += Allocation[current][i];
        }
        Success[current] = 1;
    }
}

/**
 * 控制台暂停
 * @Date: 2021-06-16 19:14:35
 */
void pause() {
    getchar();
    printf("资源分配判断完成，按任意键继续操作!");
    getchar();

}

/**
 * 运行主函数
 * @Date: 2021-06-16 19:15:02
 */
int main(){
    // 新进程请求资源数组
    int request[RESOURCES_NUMBER];
    // 新请求的进程编号
    int current;
    init();
    while (1) {
        menuContext();
        // 检查T0时刻是否存在安全序列
        checkSecure();
        printf("\n输入需要再次分配的进程编号P:");
        scanf("%d", &current);
                int i;
        for (i = 0; i < RESOURCES_NUMBER; i++) {
            printf("输入进程%d要分配的资源%d数量:",current, i + 1);
            scanf("%d", &request[i]);
        }
        // 进程资源分配
        handle(current, request);

        pause();
    }
    return 0;
}