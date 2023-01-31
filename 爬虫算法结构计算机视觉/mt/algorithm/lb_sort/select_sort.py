# coding:utf-8
# 选择排序 O(n^2)
import random


def select_sort(li):
    for i in range(len(li) - 1):
        min_loc = i
        for j in range(i + 1, len(li)):
            if li[j] < li[min_loc]:
                min_loc = j
        li[i], li[min_loc] = li[min_loc], li[i]


li = [i for i in range(20)]
random.shuffle(li)
print(li)
select_sort(li)
print(li)
