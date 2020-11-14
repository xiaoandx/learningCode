/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:字符串连接
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 * @Others: strcat方法
 */
#include <stdio.h>
#include <string.h>
#define N 80
int main() {
    char str1[80] = "This Is a ", str2[80] = "c Program";
    printf("String1 is: %s\n", str1);
    printf("String2 is: %s\n", str2);
    strcat(str1,str2);
    printf("Result is: %s\n", str1);
    return 1;
}
