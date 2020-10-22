# 英文单词
article = '''
Big data analytics and business analytics
by Duan, Lian; Xiong, Ye
Over the past few decades, with the development of automatic identification, data capture and storage technologies, 
people generate data much faster and collect data much bigger than ever before in business, science, engineering, education and other areas. 
Big data has emerged as an important area of study for both practitioners and researchers. 
It has huge impacts on data related problems. 
In this paper, we identify the key issues related to big data analytics and then investigate its applications specifically related to business problems.
'''
# 创建字典
dic = {}
# 将歌词中的标点符号用空格替换
for ch in ",;.?!@":
    article = article.replace(ch, " ");

# 将字符串分割成列表
wordsList = article.split();

# 利用字典统计词频
for i in wordsList:
    if i in dic:
        dic[i] += 1
    else:
        dic[i] = 1

# 统计结果排序
items = list(dic.items());
items.sort(key=lambda x: x[1], reverse=True);

# 打印输出
for item in items:
    word, count = item
    print("{:<12} {:>5}".format(word, count));
