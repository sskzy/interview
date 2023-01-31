# coding = utf-8

# 集合 唯一的列表
lst = {"111", "222"}
lst.add("333")
lst.update({"444", "555"})
lst.remove("111")  # 会报错
lst.discard("333")  # 不会报错
lst.pop()

print('集合', lst)

s1 = {10, 20, 30, 40, 50}
s2 = {10, 20, 30}
s3 = {60, 70}

print(s2.issubset(s1))  # 是否是子集
print(s1.issuperset(s2))  # 是否是超集
print(s1.isdisjoint(s3))  # 是否有无交集

print(s1 | s2)  # 并集
print(s1 & s2)  # 交集
print(s1 - s2)  # 差集
print(s1 ^ s2)  # 对称差集
