# -*- coding:utf-8 -*-
# @File : mirror_auto.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/25 14:31

import time
import cv2
import pyautogui


def get_xy(img_model_path):
    """
    用来判定游戏画面的点击坐标
    :param img_model_path:用来检测的图片
    :return:以元组形式返回检测到的区域中心的坐标
    """
    # 将图片截图并且保存
    pyautogui.screenshot().save("./pic/screenshot.png")
    # 待读取图像
    img = cv2.imread("./pic/screenshot.png")
    # 图像模板
    img_terminal = cv2.imread(img_model_path)
    # 读取模板的高度宽度和通道数
    height, width, channel = img_terminal.shape
    # 使用matchTemplate进行模板匹配（标准平方差匹配）
    result = cv2.matchTemplate(img, img_terminal, cv2.TM_SQDIFF_NORMED)
    # 解析出匹配区域的左上角图标
    upper_left = cv2.minMaxLoc(result)[2]
    # 计算出匹配区域右下角图标（左上角坐标加上模板的长宽即可得到）
    lower_right = (upper_left[0] + width, upper_left[1] + height)
    # 计算坐标的平均值并将其返回
    avg = (int((upper_left[0] + lower_right[0]) / 2), int((upper_left[1] + lower_right[1]) / 2))
    return avg


def auto_Click(var_avg):
    pyautogui.click(var_avg[0], var_avg[1], button='left')
    time.sleep(1)


def routine(img_model_path, name):
    avg = get_xy(img_model_path)
    print(f"正在点击{name}")
    # auto_Click(avg)
    pyautogui.doubleClick(avg)


def main():
    routine("./pic/img.png", "设置")


if __name__ == "__main__":
    main()
