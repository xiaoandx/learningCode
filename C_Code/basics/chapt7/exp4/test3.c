/*
 * @explain: Copyright (c) 2020 WEI.ZHOU. All rights reserved.
 * The following code is only used for learning and communication, not for illegal and commercial use.
 * If the code is used, no consent is required, but the author has nothing to do with any problems 
 * and consequences.
 * 
 * In case of code problems, feedback can be made through the following email address.
 * 						<xiaoandx@gmail.com>
 * 
 * @Description: 
 * @Author: WEI.ZHOU
 * @Date: 2020-11-29 15:48:49
 * @Version: V1.0
 * @Others: Running test instructions
 * 			
 */
#include <stdio.h>

/**
 * @brief   浮点数求和
 * @Date    2020-11-29 15:52:05
 * @param   float x, float y 需要求和数
 * @return  {float} 结果
 */
float add(float x, float y);

int main() {
    float a, b, c;
    scanf("%f,%f", &a, &b);
    c = add(a, b);
    printf("%f", c);
    return 0;
}
float add(float x, float y) {
    float z;
    z = x + y;
    return z;
}