# -*- coding:utf-8 -*-
# @File : sqlite_test.py
# @Author: SongTC
# @E-mail: 690259811@qq.com
# @CreateTime: 2022/9/23 20:12

import sqlite3

conn = sqlite3.connect("sqlite_test.db")
cursor = conn.cursor()
create = """
    create table tbl_student(
        stu_id integer,
        stu_name text
    )
"""

insert = """
    insert into tbl_student(`stu_id`,`stu_name`) values(1,'qwer');
"""

select = """
    select * from tbl_student
"""

cursor.execute(create)
cursor = cursor.execute(insert)
conn.commit()
cursor = cursor.execute(select)
stu_list = cursor.fetchall()
print(stu_list)
cursor.close()
