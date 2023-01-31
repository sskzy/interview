# coding=utf-8
# 计数排序 O(n)
import random


def count_sort(li, max):  # max 是数组中最大的数字 我觉得应该要有 max 和 min
    count = [0 for _ in range(max + 1)]
    for val in li:
        count[val] += 1
    li.clear()
    for index, value in enumerate(count):
        for i in range(value):
            li.append(index)


li = [random.randint(0, 20) for _ in range(20)]
random.shuffle(li)
count_sort(li, 20)
print(li)
