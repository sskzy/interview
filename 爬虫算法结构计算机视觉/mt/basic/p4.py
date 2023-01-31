# coding=utf-8
import MySupport


def change(mylist):
    mylist.append([1, 2, 3, 4])
    print("函数内取值: ", mylist)


mylist = [10, 20, 30]
change(mylist)
print("函数外取值: ", mylist)


def printInfo(name, age=18):
    print("Name: ", name, "Age: ", age)


printInfo(name="miki")


def fuZhi(a, *b, **c):
    print(a, b, c)


fuZhi(853521, 65134, 635263, 45563, 365, x=99, y=999)

sum = lambda arg1, arg2: arg1 + arg2

# 调用sum函数
print("相加后的值为 : ", sum(10, 20))
print("相加后的值为 : ", sum(20, 20))
