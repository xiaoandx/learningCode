# -*- coding: UTF-8 -*-
import random

maxNumber = 10000
firstPrize, secondPrize, thirdAward = 0, 0, 0


def getPosition():
    return random.randint(0, 360)


for i in range(0,maxNumber):
    pos = getPosition()
    if 0 <= pos < 30:
        firstPrize += 1
    elif 30 < pos < 108:
        secondPrize += 1
    else:
        thirdAward += 1

print("该游戏，共玩{}次\n"
      "一等奖：{}次 {}%概率\n "
      "二等奖：{}次 {}%概率\n"
      " 三等奖：{}次 {}%概率\n "
      .format(maxNumber, firstPrize,
        firstPrize / 100,
        secondPrize, secondPrize / 100,
        thirdAward,thirdAward / 100)
      )
