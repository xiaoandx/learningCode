import random


def catchMe(n=5, maxStep=10):
    hole = [0] * n
    initial = random.randrange(0, n)
    hole[initial] = 1

    while maxStep >= 0:
        maxStep -= 1
        while True:
            x = int(input('请输入狐狸在的洞口编号 0-{0} ：'.format(n - 1)))
            if 0 <= x < n:
                break
            else:
                print('输入不符要求')

        if hole[x] == 1:
            print('成功')
            break
        else:
            print('没抓到')

        if initial == n - 1:
            new = initial - 1
        elif initial == 0:
            new = initial + 1
        else:
            new = random.choice((-1, 1))
        hole[initial], hole[new] = 0, 1
        initial = new
    else:
        print('再来一次')


catchMe(5, 10)
