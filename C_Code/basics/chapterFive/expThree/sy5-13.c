/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:100以内的素数存放到一个数组中
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
#define N 100
#define DEF_ONE 1
#define DEF_TWO 2
#define DEF_ZERO 0

int main() {
    int j, n = DEF_ZERO, a[N] = {DEF_ZERO};

    for (int i = DEF_ONE; i <= N; i++) {
        int sta = DEF_ZERO;
        for (int j = DEF_TWO; j < i; j++) {
            if (i % j == DEF_ZERO) {
                sta = DEF_ONE;
            }
        }
        if (DEF_ZERO == sta && DEF_ONE != i) {
            a[n++] = i;
            printf("%d ", a[n - DEF_ONE]);
        }
    }
    return DEF_ZERO;
}
