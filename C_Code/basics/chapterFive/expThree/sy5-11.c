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
 * @Others: 
 */
#include <stdio.h>
#include <string.h>

int main() {
    char str1[100], str2[100];
    int i = 0, j = 0;
    printf("please input the string1:");
    scanf("%s", str1);
    printf("please input the string2:");
    gets(str2);
    for (i = 0; str1[i] != '\0'; i++)
        ; /*注意，此处空语句不可少*/
    for (j = 0; str2[i] != '\0'; j++) {
        str1[i] = str2[j];
        i++;
    }
    str1[i] = '\0'; /*给出新的字符串的结束符*/
    printf("the catenated string is %s", str1);
    return 1;
}

