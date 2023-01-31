# -*- coding:utf-8 -*-
# @File : urllib_test.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/21 17:45

import urllib.request
import urllib.parse
import urllib.error

url = "http://httpbin.org"
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.42"
}
data = bytes(urllib.parse.urlencode({"Msg": "Hello World"}), "utf-8")


# get
def getMethod():
    response = urllib.request.urlopen(url + "/get")
    print(response.read().decode("utf-8"))


# post
def postMethod():
    response = urllib.request.urlopen(url + "/post", data)
    print(response.read().decode("utf-8"))


# time out
def timeOUtTest():
    try:
        response = urllib.request.urlopen(url + "/get", None, 0.01)
        print(response.read().decode("utf-8"))
    except urllib.error.URLError as e:
        response = urllib.request.urlopen(url + "/get", None, 1)
        print(response.read().decode("utf-8"))


def getStatus():
    response = urllib.request.urlopen(url + "/get")
    print(response.status)
    # print(response.getheaders())
    print(response.getheader("Server"))


# User-Agent 伪装
def UserAAgentCamouflage():
    req = urllib.request.Request(url + "/post", data, headers, None, False, "POST")
    response = urllib.request.urlopen(req)
    print(response.read().decode("utf-8"))


def baiDu():
    req = urllib.request.Request("https://www.baidu.com/", None, headers)
    response = urllib.request.urlopen(req)
    print(response.read().decode("utf-8"))


def main():
    baiDu()


if __name__ == "__main__":
    main()
