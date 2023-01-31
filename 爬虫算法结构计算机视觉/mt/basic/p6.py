# coding:utf-8


for i in range(10):
    print(i, end=" ")

print()
for i in range(10, -1, -1):
    print(i, end=" ")

print()
count = 0
while count <= 5:
    print(count, end=" ")
    # if count == 3:
    #     break
    count += 1
else:
    print("hello while else")

# start end step
for i in range(5, 10):
    print(i, end=" ")

print()
li = [i for i in range(10)]
for key, value in enumerate(li):
    print("key:", key, " value:", value, )
