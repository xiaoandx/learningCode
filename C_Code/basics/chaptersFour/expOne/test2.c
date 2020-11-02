/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:
 * @Author: WEI.ZHOU
 * @Date: 2020-10-31 13:42:48
 * @Version: V1.0
 * @LastEditTime: 2020-11-02 21:28:37
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>

int main() {
    // 创建成绩变量float，考虑到成绩可能为小数
    float score = 0.0;
    printf("输入学生的成绩：");
    // 输入成绩，错误时继续输入（goto实现简单）
    sc:
    scanf("%f", &score);
    if (!(score >= 0 && score <= 100)){
        printf("成绩输入错误，再次输入学生成绩：");
        goto sc;
    }
    //判断成绩等级
    if (score >= 90) {
        printf("A\n");
    } else if (score >= 60) {
        printf("B\n");
    } else {
        printf("C\n");
    }
    return 0;
}