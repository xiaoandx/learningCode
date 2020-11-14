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
 * 第一个数和最后一个数，第二个数与倒数第二个数交换的思想将十个数的数组逆序输出。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 * @Others: 推荐使用方法二
 */

#include <stdio.h>
int main() {
    int i, j, a[2][3] = {{1, 2, 3}, {4, 5, 6}};
    for (i = 0; i < 2; i++) {
        for (j = 0; j < 3; j++)
            printf("%d ", a[i][j]);
        printf("\n");
    }
    return 0;
}


    
