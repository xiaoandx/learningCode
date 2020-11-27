stairs = int(input("输入楼梯数目："))


def climbingCount(N):
    defendCount = {
        1: 1,
        2: 2,
        3: 4
    }
    if N in defendCount.keys():
        return defendCount[N]
    else:
        return climbingCount(N - 1) + climbingCount(N - 2) + climbingCount(N - 3)


print("{}阶楼梯共有{}中上楼梯方法".format(stairs, climbingCount(stairs)))
