# coding:utf-8

print("hello python")

# ord() 打印字符编码
print(ord('宋'))
# 将23435转化成16进制 用\u打印
print('\u5B8B')
print(chr(98))

# python可以动态修改数据类型
a = 1.766
print('int类型', type(a))
a = 'ads'
print('str类型', type(a))

# 地址相同
n1 = n2 = 10
print(id(n1), id(n2))

# round(n,m) n:数字 m:保留位数
print(round(0.344 + 0.564, 2))

# 复数
x = 123 + 456j
print("实数", x.real)
print("虚数", x.imag)

# 数组小技巧 arr[N:M] 不包含M
s = "asdfghjkl"
print(s[0] in s, s[4], s[1:3], s[-5:-3], s[:5] * 3)

# eval 执行python方式去掉字符串 int,float
# 字符串去引号变成变量 未声明则异常 声明输出变量
s = '3.14+3'
print(s, type(s))
x = eval(s)
print(x, type(x))

# pythons算数运算
# 10/3=3.33 10//3=3 10%3=1 10**3=1000

n1 = n2 = n3 = 10  # 链式赋值
print(n1, n2, n3)

# 系列解包赋值
name, age = '张三', 18  # 元祖分解赋值
print(name, age)

[name1, age1] = ['李四', 1]  # 列表分解赋值
print(name1, age1)

a, b, c = 'sky'  # 字符串分解赋值
print(a, b, c)

part1, *part2 = "room"
print(part1, part2)
