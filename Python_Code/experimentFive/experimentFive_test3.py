"""
Copyright (c) 2020 WEI.ZHOU. All rights reserved.
The following code snippets are only used for circulation and cannot be used for business.
If the code is used, no consent is required, but the author has nothing to do with any problems
and consequences.
In case of code problems, feedback can be made through the following email address.
                                   <xiaoandx@gmail.com>
@author: WEI.ZHOU
@data:2020-10-29
"""

# 输入某年某月某日，判断这一天是这一年的第几天
months = (0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334)
sumDay = 0
dateTime = input("请输入年-月-日：2020-10-22: ")
dataTimes = list(map(int, dateTime.split("-")))

if (dataTimes[0] % 400 == 0) or ((dataTimes[0] % 4 == 0) and (dataTimes[0] % 100 != 0)):
    sumDay += 1

if 0 < dataTimes[1] <=12:
    sumDay = months[dataTimes[1] - 1]
else:
    print("月份输入错误！！")
sumDay += dataTimes[2]

print("{}年-{}月-{}日处于全年的{}天".format(dataTimes[0], dataTimes[1], dataTimes[2], sumDay))
