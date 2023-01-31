# coding:utf-8
# 冒泡排序 O(n^2)
import random


def bubble_sort(li):
    for i in range(len(li) - 1):
        exchange = False
        for j in range(len(li) - i - 1):
            if li[j] > li[j + 1]:
                li[j], li[j + 1] = li[j + 1], li[j]
                exchange = True
    if not exchange:  # exchange为改变 即数组排序完成
        return


li = [i for i in range(20)]
random.shuffle(li)
print(li)
bubble_sort(li)
print(li)
