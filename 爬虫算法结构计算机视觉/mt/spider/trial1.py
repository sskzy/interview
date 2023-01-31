# -*- coding:utf-8 -*-
# @File : trial1.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/22 11:38

from bs4 import BeautifulSoup
import re
import urllib.request, urllib.error
import threading

url = "http://www.fzmjtc.cn/"
headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/105.0.0.0 Safari/537.36 Edg/105.0.1343.42"
}


def getUrl():
    while True:
        print(threading.current_thread())
        urllib.request.urlopen(url)


def insert(tmp_list):
    sql = """
           insert into tbl_student(`name`,`url`,`author`,`time`) values('%s','%s','%s',%d)  
        """ % (tmp_list[0], tmp_list[1], tmp_list[2], tmp_list[3])
    print(sql)


def main():
    # print("start...")
    # for i in range(1, 10):
    #     url_thread = threading.Thread(target=getUrl)
    #     url_thread.start()

    tmp_list = ["qwe", "asd", "zxc", 123]
    insert(tmp_list)


if __name__ == "__main__":
    main()
