# coding:utf-8
# 插入排序 O(n^2)
import random


def insert_sort(li):
    for i in range(1, len(li)):
        tmp = li[i]
        j = i - 1
        while j >= 0 and li[j] > tmp:
            li[j + 1] = li[j]
            j -= 1
        li[j + 1] = tmp


def insert_binary_sort(): pass


li = [i for i in range(20)]
random.shuffle(li)
print(li)
insert_sort(li)
print(li)
