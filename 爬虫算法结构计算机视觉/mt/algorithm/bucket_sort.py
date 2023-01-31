# -*- coding:utf-8 -*-
# @File : bucket_sort.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/5/14 12:11
# @AlgorithmName: bucket sort(桶排序)
# @TimeComplexity: O(n+k) O(n^2k)
# @SpatialComplexity: O(nk)
import random


def bucket_sort(li, n=100, max_num=10000):
    buckets = [[] for _ in range(n)]  # 创建了n个桶 即n个维数组由一个数组存储
    for var in li:
        ''' i 表示var放在那个桶 
            当var = 1000时 放在第99号桶 因为数组中不存在第100号桶'''
        i = min(var // (max_num // n), n - 1)
        buckets[i].append(var)

        # 向桶添加元素采用冒泡的方式,小于前移,大于跳出
        for j in range(len(buckets[i]) - 1, 0, -1):
            if buckets[i][j] < buckets[i][j - 1]:
                buckets[i][j], buckets[i][j - 1] = buckets[i][j - 1], buckets[i][j]
            else:
                break

    sorted_li = []
    for buc in buckets:
        sorted_li.extend(buc)  # sorted_li += buc

    return sorted_li


li = [i for i in range(100)]
random.shuffle(li)
print(bucket_sort(li))
