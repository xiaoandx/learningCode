i = 0; j = 1; x = 0

while i < 5:
    x = 4 * j
    for i in range(0, 5):
        if x % 4 != 0:
            break
        else:
            i += 1; j += 1
            x = x * 5 / 4 + 1

print("桃子至少有{}个".format(int(x)))