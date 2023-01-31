# coding:utf-8
# 堆排序(应用)
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
        if j + 1 <= high and li[j + 1] < li[j]:  # j + 1 <= height防止空指针
            j += 1  # 将较大的孩子赋值给 j
        # 比较 j 和 tmp
        if li[j] < tmp:  # 当li[j] < tmp时完成一次向下调整 跳出循环
            li[i] = li[j]  # 将 j 向下赋值
            i = j
            j = 2 * i + 1
        else:  # 跳出循环
            break
    li[i] = tmp  # 将最后一个 元素放入最后一个位置


def topk(li, k):
    heap = li[0:k]
    # 建立 k堆
    for i in range((k - 2) // 2, -1, -1):
        sift(heap, i, k - 1)

    # 遍历剩余除 k堆 外的数
    for i in range(k, len(li) - 1):
        if li[i] > heap[0]:
            heap[0] = li[i]
            sift(heap, 0, k - 1)

    # 出数
    for i in range(k - 1, -1, -1):
        heap[0], heap[i] = heap[i], heap[0]
        sift(heap, 0, i - 1)

    return heap


# heap_sort(堆排序) 时间复杂度 O(nlogn)

li = [i for i in range(10)]
random.shuffle(li)
print(li)
print(topk(li, 5))
