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
 * @Date: 2020-11-07 16:02:37
 * @Version: V1.0
 * @LastEditTime: 2020-11-07 17:04:04
 * @LastEditors: WEI.ZHOU
 * @Others:
 */
#include <stdio.h>
int main() {
    int a = 10, b = 0;
    do {
        b += 2;
        a -= 2 + b;
    } while (a >= 0);
    return 0;
}