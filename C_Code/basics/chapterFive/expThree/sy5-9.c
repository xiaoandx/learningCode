/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for
 * illegal and commercial use. If the code is used, no consent is required, but
 * the author has nothing to do with any problems and consequences.
 *
 * In case of code problems, feedback can be made through the following email
 * address. <xiaoandx@gmail.com>
 *
 * @Description:一行文字，不超过80个字符，
 * 分别统计出其中英文大写字母、小写字母、数字、空格、及其它字符的个数。
 * @Author: WEI.ZHOU
 * @Date: 2020-11-14 08:56:42
 * @Version: V1.0
 */
#include <stdio.h>
#define N 80
#define DEF_ONE 1
#define DEF_ZERO 0
int main() {
    int upper=DEF_ZERO, lower=DEF_ZERO, num=DEF_ZERO, space=DEF_ZERO, other=DEF_ZERO;
    char c[N];
    printf("请输入字符串<80：");
    gets(c);
    for(int i=0; i<N-DEF_ONE; i++){
        if(c[i] == '\0'){ break;}else{
            if ((c[i] >= 'A' && c[i] <= 'Z')) {
                upper++;
            } else if ((c[i] >= 'a' && c[i] <= 'z')) {
                lower++;
            } else if (c[i] == ' ' || c[i] == '\t') {
                space++;
            } else if (c[i] >= '0' && c[i] <= '9') {
                num++;
            } else {
                other++;
            }
        }
    }
    printf("大写字母=%d,小写字母=%d,数字=%d,空格=%d,其他=%d\n", \
     upper, lower, num, space, other);
    return DEF_ONE;
}
