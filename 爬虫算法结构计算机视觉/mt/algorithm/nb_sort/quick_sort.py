# coding=utf-8
# 快速排序
import random


def quick_sort(li, left, right):
    if left < right:
        mid = partition(li, left, right)
        quick_sort(li, left, mid - 1)
        quick_sort(li, mid + 1, right)


def partition(li, left, right):
    tmp = li[left]
    while left < right:
        while li[right] >= tmp and right > left:  # 找出小于 tmp 的值
            right -= 1
        li[left] = li[right]  # 右边值写入左边空位
        while li[left] <= tmp and right > left:  # 找出大于 tmp 的值
            left += 1
        li[right] = li[left]  # 左边值写入右边空位
    li[left] = tmp  # left = right时 tmp 归位
    return left


li = [i for i in range(20)]
random.shuffle(li)
quick_sort(li, 0, len(li) - 1)
print(li)
