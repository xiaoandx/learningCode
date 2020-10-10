
'''
Copyright (c) 2020 WEI.ZHOU. All rights reserved.                           

The following code snippets are only used for circulation and cannot be used for business.      

If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.                                                                                   

In case of code problems, feedback can be made through the following email address.         

                                   <xiaoandx@gmail.com>
'''

#计算平均分的总和
name = input("学生的姓名：");
chinese = float(input("语文成绩："));
maths = float(input("数学成绩："));
english = float(input("英语成绩："));
#求和与求平均分
sum = chinese + maths + english;
average = sum/3;

#输出
print("总成绩=%.2f" % sum);
print("平均成绩=%.2f" % average);
