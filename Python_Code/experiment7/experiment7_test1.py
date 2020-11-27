number = int(input("输入总人数："))
key = int(input("输报数关键值："))


def findEndIndex(Array):
    index = 0
    for i in Array:
        index += 1
        if i != 0:
            return index


def josephNumber(N, K):
    number_size = N;
    peopleArray = []
    for i in range(N):
        peopleArray.append(i + 1)
    # 报数起点
    point = 0
    # 报数
    numberKey = 0
    # 循环报数
    while N > 1:
        index = point % number_size
        if peopleArray[index] != 0:
            numberKey += 1
        if numberKey == K:
            peopleArray[index] = 0
            N -= 1
            numberKey = 0
        point += 1

    # 查询最后一个人的位置
    return findEndIndex(peopleArray)


print("{}个人进行约瑟夫环，{}退出，剩下最后一个人是{}号".format(number, key, josephNumber(number, key)))
