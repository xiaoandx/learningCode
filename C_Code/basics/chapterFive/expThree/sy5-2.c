/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:输出一维数组中元素的最小值及其下标 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
int main() {
    int i, m, p,
    /* m为最小值，p为其下标 */
    a[10] = {9, 8, 7, 6, 1, 3, 5, 18, 2, 4}; 
    m = a[0];
    p = 0;
    for (i = 1; i < 10; i++)
        if (a[i] < m) {
            m = a[i];
            p = i;
        }
    printf("%d,%d\n", a[p], p);
    return 0;
}
