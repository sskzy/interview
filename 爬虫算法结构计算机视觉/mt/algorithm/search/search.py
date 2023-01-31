# coding:utf-8

# 线性查找
def linear_search(li, val):
    for i in range(len(li)):
        if li[i] == val:
            return i
    else:
        return None


# 二分查找
def binary_search(li, val):
    left = 0
    right = len(li) - 1
    while left <= right:
        mid = (left + right) // 2
        if li[mid] == val:
            return mid
        elif li[mid] > val:  # 中间的值比val大,right左移
            right = mid - 1
        elif li[mid] < val:  # 中间的值比val小,left右移
            left = mid + 1
    return -1


li = [i for i in range(15)]
print(linear_search(li, 4))
print(binary_search(li, 5))
