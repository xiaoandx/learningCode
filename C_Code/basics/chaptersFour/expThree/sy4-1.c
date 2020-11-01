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
 * @Date: 2020-11-01 12:58:55
 * @Version: V1.0
 * @LastEditTime: 2020-11-01 13:39:53
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>
int main() {
    int a = 3, b = 5, c = 8;
    if (c-- != 0 || a++ < 3)
        b = b + 1;
    printf("a=%d\tb=%d\tc=%d\n", a, b, c);
    return 0;
}
 