# -*- coding:utf-8 -*-
# @File : xlwt_test.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/22 21:56

import xlwt

book = xlwt.Workbook("utf-8")
sheet = book.add_sheet("sheet1")

for i in range(0, 9):
    for j in range(0, i + 1):
        sheet.write(i, j, "%d * %d = %d" % ((i + 1), (j + 1), (i + 1) * (j + 1)))
book.save("新建文档.xls")
