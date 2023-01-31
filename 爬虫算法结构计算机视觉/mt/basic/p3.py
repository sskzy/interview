# coding=utf-8
import time

# 切片[N:M]
# 列表(list)[]
arr1 = [i for i in range(1, 7)]
# 增
list.append(arr1, 7)
arr1.extend([5, 9, 2, 1])
arr1.insert(0, 1)

# 删
list.remove(arr1, 1)
list.pop(arr1, 0)

# 改
arr1[2] = 2
arr1[0:2] = [0, 1]

# 排序
list.sort(arr1, reverse=False)
print(arr1[:len(arr1)])

# 元组 () 元组与列表类似，不同之处在于元组的元素不能修改
# 元组中的元素值是不允许修改的，但我们可以对元组进行连接组合
# 元组中的元素值是不允许删除的，但我们可以使用del语句来删除整个元组
tup = ()
tup1 = (1,)  # 只有一个元素就加个 ',' 吧

# 字典 Dictionary {}
dic2 = {'k1': 'v1', 'k2': 'v2', 'k3': 'v3', 'k4': 'v4'}
for i in dic2:
    print('key: ' + i, '=', 'value: ' + dic2.get(i))

localtime = time.localtime(time.time())
print(localtime)
print(time.strftime("%Y-%m-%d %H:%M:%S", time.localtime()))
