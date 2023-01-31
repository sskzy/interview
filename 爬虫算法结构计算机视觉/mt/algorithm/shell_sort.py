# coding:utf-8
# 希尔排序
import random


def insert_sort(li, gap):
    for i in range(gap, len(li)):
        tmp = li[i]
        j = i - gap
        while j >= 0 and li[j] > tmp:
            li[j + gap] = li[j]
            j -= gap
        li[j + gap] = tmp


def shell_sort(li):
    d = len(li) // 2
    while d >= 1:
        insert_sort(li, d)
        d = d // 2


li = [i for i in range(20)]
random.shuffle(li)
print(li)
shell_sort(li)
print(li)
