# coding=utf-8

a = 1
while a < 7:
    print('yyy: ', a, end=' ') if a % 2 == 0 else print('nnn: ', a, end=' ')
    a += 1

print()
for word in 'hello world':
    print(word, end='')

print()
n, *ame = 'my name is xiaoMing'
print(n, end='')
for word in ame:
    print(word, end='')


print()  # for else  for 不是通过 break 跳出而中断的的情况下执行，while … else 也是一样
for n1 in range(2, 100):
    for n2 in range(2, n1):
        if n1 % n2 == 0:
            break
    else:
        print(n1, end=' ')

print()  # while else
count = 0
while count < 5:
    print(count, " is  less than 5")
    count = count + 1
else:
    print(count, " is not less than 5")


#  pass 便是占据一个位置，因为如果定义一个空函数程序会报错
def method(): pass


print()
import random

print('随机选择数: ', random.choice(range(1, 10)))
print('随机实数[0,1) ', random.random())
print('范围内的实数: ', random.uniform(3, 5))
list = [20, 16, 10, 5]
random.shuffle(list)
print("随机排序列表 : ", list)

import math

print(math.cos(0))
print(math.sin(0))
print(math.tan(0))
print(round(math.pi, 2))
print(round(math.e, 1))

print('hello ' * 3)
print('h' in 'hello')
print('hello'[:4])
# python的字符串内建函数...太多了
