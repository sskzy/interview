# -*- coding:utf-8 -*-
# @File : radix_sort.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/5/15 12:22
# @AlgorithmName: radix sort(基数排序)
# @TimeComplexity: O(kn)
# @SpatialComplexity: O(k+n)
import random


def radix_sort(li):
    max_num = max(li)
    it = 0
    while 10 ** it <= max_num:
        buckets = [[] for _ in range(10)]
        for var in li:
            digit = (var // 10 ** it) % 10  # 取余
            buckets[digit].append(var)

        li.clear()
        for buc in buckets:
            li.extend(buc)

        it += 1


li = list(range(200))
random.shuffle(li)
radix_sort(li)
print(li)
