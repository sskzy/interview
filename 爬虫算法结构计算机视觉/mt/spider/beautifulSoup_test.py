# -*- coding:utf-8 -*-
# @File : beautifulSoup_test.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/22 00:53

from bs4 import BeautifulSoup
import urllib.request
import urllib.parse
import urllib.error
import re

url = "https://movie.douban.com/top250?start=0&filter="
headers = {
    "user-agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.42"
}


def getHtml():
    request = urllib.request.Request(url, headers=headers)
    response = urllib.request.urlopen(request)
    html = response.read().decode("utf-8")
    return html


def getBsAssemble():
    html = getHtml()
    bs = BeautifulSoup(html, "html.parser")
    return bs


'''
1.Tag               bs.title            标签对象   
2.NavigableString   bs.title.string     标签内的字符串
3.BeautifulSoup     bs                  document对象
4.Comment           bs.title.string     注解[字符串]对象 
'''


def trial1():
    html = getHtml()
    bs = BeautifulSoup(html, "html.parser")
    print("bs.title: ", bs.title, type(bs.title), end=" ")
    print("bs.title.string: ", bs.title.string, type(bs.title.string), end=" ")
    print("bs: ", type(bs), end=" ")


# (1)find_all() 字符串完全匹配
def trial2():
    bs = getBsAssemble()
    l_list = bs.find_all("img")
    for i in l_list:
        if i.has_attr("width") and "100" == i.attrs["width"]:
            print(i.attrs["alt"])


# kwages 参数
def trial2_1():
    bs = getBsAssemble()
    l_list = bs.find_all(class_="item")
    for i in l_list:
        print(i)


# 字符串文本 参数
def trial2_2():
    bs = getBsAssemble()
    l_list = bs.find_all(text=["item", "hao123", "贴吧"])
    for i in l_list:
        print(i)


# 正则匹配
def trial2_3():
    bs = getBsAssemble()
    l_list = bs.find_all(text=re.compile("/d"))  # 正则匹配数字
    for i in l_list:
        print(i)


# limit 限定获取长度
def trial2_4():
    bs = getBsAssemble()
    l_list = bs.find_all("a", limit=3)


def trial2_5():
    bs = getBsAssemble()
    l_list = bs.select("title")  # 标签名
    l_list_1 = bs.select(".item")  # 类名
    l_list_2 = bs.select("#item")  # id名
    l_list_3 = bs.select("img[alt='肖申克的救赎']")  # 属性匹配
    l_list_4 = bs.select("header > title")  # 子标签层级

    l_list_5 = bs.select(".mnav ~ .bir")
    print(l_list_5[0].get_text())  # 类mnav的兄弟bir的文本内容


def main():
    trial2_5()


if __name__ == "__main__":
    main()
