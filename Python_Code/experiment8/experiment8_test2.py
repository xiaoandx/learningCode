# -*- coding: UTF-8 -*-
import random

condition = True;


def initDoor():
    result = {}
    for i in range(3):
        result[i] = 'goat'
    result[random.randint(0, 3)] = 'car'
    return result


def goGame():
    doors = initDoor()
    while condition:
        firstDoorNum = int(input("输入你要打开的门号: "))

        if 0 <= firstDoorNum <= 2:
            break
        else:
            print("输入门号错误 范围是 {} - {} :".format(0, 2))

    for door in doors.keys() - {firstDoorNum}:
        if doors[door] == 'goat':
            print("门后有山羊的是：", door)
            thirDoor = (doors.keys() - {door, firstDoorNum}).pop()
            change = input("是否选择  {} 号门 y/n：".format(thirDoor))
            if change == 'y':
                finalDoorNum = thirDoor
            else:
                finalDoorNum = firstDoorNum

            if doors[finalDoorNum] == 'goat':
                return "你输了 !"
            else:
                return "你赢了"


while condition:
    print(goGame())
    r = input("再试一次？ (y/n) :")
    if r == 'n':
        break
