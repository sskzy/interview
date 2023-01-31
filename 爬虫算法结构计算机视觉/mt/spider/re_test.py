# -*- coding:utf-8 -*-
# @File : re_test.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/22 13:45

import re


# r 防止转义字符
def hasModeObject():
    pat = re.compile("a|b")
    m = pat.search(r"c\t\ndbpe")
    print(m)


def hasNotModeObject():
    print(re.search("a|b", r"dfoa"))


def trial1():
    m = re.findall("[a-z]+", r"ab7+45 8b'f-a'e5n \\&h9?2af")
    print(m)


def trial2():
    print(re.sub("h", "H", r"hello Python hello World"))


def main():
    trial2()


if __name__ == "__main__":
    main()
