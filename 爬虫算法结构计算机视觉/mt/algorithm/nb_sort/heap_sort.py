# coding:utf-8
# 堆排序 O(nlogn)
import random


def sift(li, low, high):
    """
    :param li: 列表
    :param low: 堆的根节点位置
    :param high: 堆最后一个元素位置
    :return:
    """
    i = low  # 根节点
    j = 2 * i + 1  # 根节点的左孩子
    tmp = li[low]  # 储存堆顶

    while j <= high:  # 若 j = high 及 j 为最后一个数 跳出且赋值给末尾
        # 比较 左右孩子大小
        if j + 1 <= high and li[j + 1] > li[j]:  # j + 1 <= height防止空指针
            j += 1  # 将较大的孩子赋值给 j
        # 比较 j 和 tmp
        if li[j] > tmp:  # 当li[j] < tmp时完成一次向下调整 跳出循环
            li[i] = li[j]  # 将 j 向下赋值
            i = j
            j = 2 * i + 1
        else:  # 跳出循环
            break
    li[i] = tmp  # 将最后一个 元素放入最后一个位置


def heap_sort(li):
    n = len(li)
    for i in range((n - 2) // 2, -1, -1):  # 调整除了叶节点的次数
        # i 表示建堆是调整的部分根的下标
        sift(li, i, n - 1)
    # 建堆完成
    print(li)

    # 挨个出数
    for i in range(n - 1, -1, -1):
        li[0], li[i] = li[i], li[0]  # 交换 根节点和最后一位数据
        sift(li, 0, i - 1)  # 将最后一位在进行一次向下调整


li = [i for i in range(10)]
random.shuffle(li)
print(li)
heap_sort(li)
print(li)
