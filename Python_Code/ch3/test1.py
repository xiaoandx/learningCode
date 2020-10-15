"""
Copyright (c) 2020 WEI.ZHOU. All rights reserved.
The following code snippets are only used for circulation and cannot be used for business.
If the code is used, no consent is required, but the author has nothing to do with any problems and consequences.
In case of code problems, feedback can be made through the following email address.
                                   <xiaoandx@gmail.com>
"""
# 声明保存成绩列表
recordList = []
refereeNumber = int(input("请输入评委人数:"))

# 判断评委人数是否大于2人
while refereeNumber <= 2:
    print("评委人数需大于2")
    refereeNumber = int(input("输入评委人数："))

number = refereeNumber


# 判断输入成绩是否满足0-100
def check_score(score):
    if 0 <= score <= 100:
        return score
    else:
        print("分数不合法，重新输入！")
        return check_score(int(input("输入分数：")))


# 根据评委人数循环输入成绩
while number > 0:
    score = check_score(int(input("输入分数:")))
    recordList.append(score)
    number -= 1

# 计算平均成绩
avg_score = (sum(recordList) - min(recordList) - max(recordList)) / (refereeNumber - 2)

print("选手的平均成绩为 {:.2} 分".format(avg_score))
