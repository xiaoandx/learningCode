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
 * @Date: 2020-11-01 15:47:55
 * @Version: V1.0
 * @LastEditTime: 2020-11-01 16:20:26
 * @LastEditors: WEI.ZHOU
 * @Others: 
 */
#include <stdio.h>

/**
 * @brief   判断成绩等级
 * @date    2020-11-01 16:19:44
 * @param   float score 成绩
 * @return  {char} 对应成绩的等级
 */
char getGrade(float score);

int main(){
    float score;
    char grade;
    printf("输入学生成绩：");
    pan:
    scanf("%f",&score);
    if(score<0 || score >100){
        printf("输入成绩错误重新输入：");
        goto pan;
    }
    grade = getGrade(score);
    printf("成绩%.2f的评定等级为：%c", score, grade);
    return 0;
}

char getGrade(float score){
    switch ((int)score/10){
        case 10:
        case 9:
            return 'A';
            break;
        case 8:
            return 'B';
            break;
        case 7:
            return 'C';
            break;
        case 6:
            return 'D';
            break;
        default:
            return 'E';
            break;
    }
}