# -*- coding: UTF-8 -*-

from random import randint

maxNumber = 100
maxSecond = 10


def getNumber():
    return randint(1, maxNumber)


def guessNumber():
    value = getNumber()
    for i in range(maxSecond):
        if i == 0:
            strP = "开始游戏，第{}次猜的数字(1-100)："
        else:
            strP = "  继续输入第{}次猜的数字："

        x = int(input(strP.format(i + 1)))

        if i == maxSecond:
            print("猜的次数大于{}了，游戏结束".format(maxSecond))
            break

        if 1 <= x <= maxNumber:
            if x == value:
                print("恭喜你 游戏猜对了，共猜了{}次，答案就是{}".format((i + 1), x))
                break
            elif x > value:
                print("猜大了", end='')
            else:
                print("猜小了", end='')
        else:
            print("输入数字不合法")


guessNumber()
