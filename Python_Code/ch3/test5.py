# 字符串切片操作
strs = "hello Python hello c! "

print(strs[6:12])

# 从后向前切片，最后一个字符串索引是-1
print(strs[-8:-1])
# 从索引为-3的字符串到字符串开始
print(strs[:-3])

print("字符串中是否包含java：",("java" in strs))
print("字符串中是否包含Python：","Python" in strs)