/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:字符串中的大写字母转为小写字母
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
#include <string.h>

int main() {
    char str[80] = "This Is a c Program";
    int i;
    printf("String is: %s\n", str);
    for (i = 0; str[i] != '\0'; i++)
        if (str[i]>= 'A' && str[i]<='Z')
            str[i] += 32;
    printf("Result is: %s\n", str);
    return 1;
}

