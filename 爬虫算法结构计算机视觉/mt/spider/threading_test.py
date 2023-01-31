# -*- coding:utf-8 -*-
# @File : threading_test.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/22 11:44
import threading
import time


# 唱歌任务
def sing():
    # 获取当前线程
    print("sing当前执行的线程为：", threading.current_thread())
    for i in range(3):
        print("正在唱歌...%d" % i)
        time.sleep(1)


# 跳舞任务
def dance():
    # 获取当前线程
    print("dance当前执行的线程为：", threading.current_thread())
    for i in range(3):
        print("正在跳舞...%d" % i)
        time.sleep(1)


if __name__ == '__main__':
    # 获取当前线程
    print("当前执行的线程为：", threading.current_thread())
    # 创建唱歌的线程
    # target： 线程执行的函数名
    sing_thread = threading.Thread(target=sing)

    # 创建跳舞的线程
    dance_thread = threading.Thread(target=dance)

    # 开启线程
    sing_thread.start()
    dance_thread.start()
