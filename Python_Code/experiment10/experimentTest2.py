times = 1
towers = {'A': [], 'B': [], 'C': []}


def haonoi(num, src, dst, temp=None):
    if num < 1:
        return
    global times
    haonoi(num - 1, src, temp, dst)
    print("the {0} times move:{1} - -> {2}".format(times, src, dst))
    towers[dst].append(towers[src].pop())
    for tower in "ABC":
        print(tower, ":", towers[tower])
    times += 1
    haonoi(num - 1, temp, dst, src)


def main():
    n = int(input("输入盘子个数："))
    towers['A'] = list(range(n, 0, -1))
    haonoi(n, 'A', 'C', 'B')


if __name__ == '__main__':
    main()
