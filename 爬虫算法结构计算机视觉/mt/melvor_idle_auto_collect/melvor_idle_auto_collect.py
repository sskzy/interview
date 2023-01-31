# -*- coding:utf-8 -*-
# @File : melvor_idle_auto_collect.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/25 17:29

import cv2
import pyautogui
import time


def get_xy(img_path):
    pyautogui.screenshot().save("./pic/screenshot.png")
    img_win = cv2.imread("./pic/screenshot.png")
    img_terminal = cv2.imread(img_path)
    height, width, channel = img_terminal.shape
    result = cv2.matchTemplate(img_win, img_terminal, cv2.TM_SQDIFF_NORMED)
    upper_left = cv2.minMaxLoc(result)[2]
    lower_right = (upper_left[0] + width, upper_left[1] + height)
    avg = (int((upper_left[0] + lower_right[0]) / 2), int((upper_left[1] + lower_right[1]) / 2))
    return avg


def auto_click(var_avg):
    # pyautogui.click(var_avg[0], var_avg[1], button='left')
    print(var_avg[0], var_avg[1])
    pyautogui.click(var_avg[0], var_avg[1], duration=1)
    time.sleep(1)


def routine(img_model_path, name):
    avg = get_xy(img_model_path)
    print(f"正在点击{name}")
    auto_click(avg)


def main():
    time.sleep(3)
    routine("./pic/img_1.png", "拾取所有")
    # pyautogui.click(563,226)
    # pyautogui.typewrite(['f'])
    pyautogui.keyDown('f')
    time.sleep(0.5)
    pyautogui.keyUp('f')


if __name__ == "__main__":
    main()
