# coding:utf-8
# 归并排序 O(nlogn)
import random


def merge(li, low, mid, high):
    i = low
    j = mid + 1
    ltmp = []
    while i <= mid and j <= high:
        # 判断大小,按照从小到大添加到ltmp
        if li[i] < li[j]:
            ltmp.append(li[i])
            i += 1
        else:
            ltmp.append(li[j])
            j += 1

    # 补全剩余的数
    while i <= mid:
        ltmp.append(li[i])
        i += 1
    while j <= high:
        ltmp.append(li[j])
        j += 1
    li[low: high + 1] = ltmp


def merge_sort(li, low, high):
    if low < high:  # 至少有两个元素
        mid = (low + high) // 2  # 均分
        merge_sort(li, low, mid)  # 左边
        merge_sort(li, mid + 1, high)  # 右边
        merge(li, low, mid, high)  # 整体


li = [i for i in range(20)]
random.shuffle(li)
merge_sort(li, 0, len(li) - 1)
print(li)
