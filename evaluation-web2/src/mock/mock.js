import Mock from 'mockjs'

// Mock.mock('/v1/ques-banks/{id}/part4','get',(option)=>{
//  console.log(JSON.parse(option.body))
//  return {
// 	    "code": 200,
// 	    "msg": "OK",
// 	    "data": {
// 	        "list": [{
// 	            "createDate": "2016-09-21",
// 	            "operator": "张三",
// 	            "log": "增加初级-选择题-20题，初级-填空题-20题。",
// 	        }],
// 	        "pagination": {
// 	            "pageNum": 1,
// 	            "pageSize": 10,
// 	            "totalPage": 80,
// 	        }
// 	    }
// 	}
// });

// Mock.mock('/v1/ques-banks/part1','post',(option)=>{
//  console.log(JSON.parse(option.body))
//  return {
	   
// 	       "code": 200,
// 	       "msg": "OK",
// 	       "data": {
// 	           "bankId": 1
	       
// 	   }
// 	}
// });



// Mock.mock(URL + '/loginPwd','post',(option)=>{
//  console.log(JSON.parse(option.body))
//  return {
//   code:0,
//   msg:'success',
  
//   deta:{
//    token:"sdfghjjhcxrtyijjvfgertyuiolkmnbvcxdfguiokmnbftyuiok",
//    userId:"gfdsrtyuiolknbilnkkihhk",
//    expires:"123456787654",
//   },
  
//  }
 
// })

// RegExp('/v1/test' + ".*")
// Mock.mock(RegExp('/v1/ques-banks/4517/part2'+ ".*"), 'get', (option) => {
// 	return {
// 		code: 200,
// 		msg: 'OK',
// 		data: {
// 			subjectName: "学科",
// 			subjects: [{
// 				id1: '1001',
// 				name1: "学科1"
// 			}, {
// 				id1: '1002',
// 				name1: "学科2"
// 			}, {
// 				id1: '1003',
// 				name1: "学科3"
// 			}, {
// 				id1: '1004',
// 				name1: "学科4"
// 			}, {
// 				id1: '1005',
// 				name1: "学科5"
// 			}, {
// 				id1: '1006',
// 				name1: "学科6"
// 			}, {
// 				id1: '1007',
// 				name1: "学科7"
// 			}, {
// 				id1: '1008',
// 				name1: "学科8"
// 			}, {
// 				id1: '1009',
// 				name1: "学科9"
// 			}, {
// 				id1: '1010',
// 				name1: "学科10"
// 			}],
// 			abilityName: "能力",
// 			abilities: [{
// 				id1: '1001',
// 				name1: "能力1"
// 			}, {
// 				id1: '1002',
// 				name1: "能力2"
// 			}, {
// 				id1: '1003',
// 				name1: "能力3"
// 			}, {
// 				id1: '1004',
// 				name1: "能力4"
// 			}, {
// 				id1: '1005',
// 				name1: "能力5"
// 			}, {
// 				id1: '1006',
// 				name1: "能力6"
// 			}, {
// 				id1: '1007',
// 				name1: "能力7"
// 			}, {
// 				id1: '1008',
// 				name1: "能力8"
// 			}, {
// 				id1: '1009',
// 				name1: "能力9"
// 			}, {
// 				id1: '1010',
// 				name1: "能力10"
// 			}]
// 		}
// 	}
// });

// RegExp('/v1/test' + ".*")
// Mock.mock(RegExp('/v1/subject1s'+ ".*"), 'get', (option) => {
// 	return {
// 		code: 200,
// 		msg: 'OK',
// 		data: {
// 			list1: [{
// 				id1: "1001",
// 				name1: "一级学科1",
// 			}, {
// 				id1: "1002",
// 				name1: "一级学科2",
// 			}, {
// 				id1: "1003",
// 				name1: "一级学科3",
// 			}, {
// 				id1: "1004",
// 				name1: "一级学科4",
// 			}, {
// 				id1: "1005",
// 				name1: "一级学科5",
// 			}, {
// 				id1: "1006",
// 				name1: "一级学科6",
// 			}, {
// 				id1: "1007",
// 				name1: "一级学科7",
// 			}]
// 		}
// 	}
// });

// Mock.mock(RegExp('/v1/subject2s'+ ".*"), 'get', (option) => {
// 	return {
// 		code: 200,
// 		msg: 'OK',
// 		data: {
// 			list2: [{
// 				id1: "2001",
// 				name1: "二级学科1",
// 			}, {
// 				id1: "2002",
// 				name1: "二级学科2",
// 			}, {
// 				id1: "2003",
// 				name1: "二级学科3",
// 			}, {
// 				id1: "2004",
// 				name1: "二级学科4",
// 			}, {
// 				id1: "2005",
// 				name1: "二级学科5",
// 			}, {
// 				id1: "2006",
// 				name1: "二级学科6",
// 			}, {
// 				id1: "2007",
// 				name1: "二级学科7",
// 			}]
// 		}
// 	}
// });

// Mock.mock(RegExp('/v1/ability1s'+ ".*"), 'get', (option) => {
// 	return {
// 		code: 200,
// 		msg: 'OK',
// 		data: {
// 			list1: [{
// 				id1: "1001",
// 				name1: "一级能力1",
// 			}, {
// 				id1: "1002",
// 				name1: "一级能力2",
// 			}, {
// 				id1: "1003",
// 				name1: "一级能力3",
// 			}, {
// 				id1: "1004",
// 				name1: "一级能力4",
// 			}, {
// 				id1: "1005",
// 				name1: "一级能力5",
// 			}, {
// 				id1: "1006",
// 				name1: "一级能力6",
// 			}, {
// 				id1: "1007",
// 				name1: "一级能力7",
// 			}]
// 		}
// 	}
// });

// Mock.mock(RegExp('/v1/ability2s'+ ".*"), 'get', (option) => {
// 	return {
// 		code: 200,
// 		msg: 'OK',
// 		data: {
// 			list2: [{
// 				id1: "2001",
// 				name1: "二级能力1",
// 			}, {
// 				id1: "2002",
// 				name1: "二级能力2",
// 			}, {
// 				id1: "2003",
// 				name1: "二级能力3",
// 			}, {
// 				id1: "2004",
// 				name1: "二级能力4"
// 			}, {
// 				id1: "2005",
// 				name1: "二级能力5",
// 			}, {
// 				id1: "2006",
// 				name1: "二级能力6",
// 			}, {
// 				id1: "2007",
// 				name1: "二级能力7",
// 			}]
// 		}
// 	}
// });


//正在建设的题库
Mock.mock(RegExp('/v1/ques-banks/my/incomplete' + ".*"),'get',(option)=>{
	// console.log(JSON.parse(bankId.bankName))
	return {
		"status": 200,
		"message": "succeed",
		"data": {
			"pageNum": 1,
			"pageSize": 10,
			"totalRow": 11,
			"totalPage": 2,
			"result": {
				"1": [{
					"bankId": 1,
					"bankName": "Java面向对象-20",
					"creatorId": 1,
					"creatorName": "张三",
					"managerId": 2,
					"managerName": "李四",
					"submitProgress": "30%",
					"auditProgress": "50%",
					"deadline": "2016-09-21",
					"relateCourse": "MySQL数据库管理",
					"relateTextbook": "MySQL数据库管理",
					"relateChapter": "第1-4章",
					"isNew": true,
				},
					{
						"bankId": 2,
						"bankName": "Java面向对象-21",
						"creatorId": 2,
						"creatorName": "张三",
						"managerId": 2,
						"managerName": "李四",
						"submitProgress": "30%",
						"auditProgress": "50%",
						"deadline": "2016-09-21",
						"relateCourse": "MySQL数据库管理",
						"relateTextbook": "MySQL数据库管理",
						"relateChapter": "第1-4章",
						"isNew": true,
					},
					{
						"bankId": 3,
						"bankName": "Java面向对象-22",
						"creatorId": 1,
						"creatorName": "张三",
						"managerId": 2,
						"managerName": "李四",
						"submitProgress": "100%",
						"auditProgress": "100%",
						"deadline": "2016-09-21",
						"relateCourse": "MySQL数据库管理",
						"relateTextbook": "MySQL数据库管理",
						"relateChapter": "第1-4章",
						"isNew": true,
					},
					{
						"bankId": 4,
						"bankName": "Java面向对象-23",
						"creatorId": 1,
						"creatorName": "张三",
						"managerId": 2,
						"managerName": "李四",
						"submitProgress": "30%",
						"auditProgress": "50%",
						"deadline": "2016-09-21",
						"relateCourse": "MySQL数据库管理",
						"relateTextbook": "MySQL数据库管理",
						"relateChapter": "第1-4章",
						"isNew": true,
					},
					{
						"bankId": 5,
						"bankName": "Java面向对象-24",
						"creatorId": 1,
						"creatorName": "张三",
						"managerId": 2,
						"managerName": "李四",
						"submitProgress": "30%",
						"auditProgress": "50%",
						"deadline": "2016-09-21",
						"relateCourse": "MySQL数据库管理",
						"relateTextbook": "MySQL数据库管理",
						"relateChapter": "第1-4章",
						"isNew": true,
					}
				]

			}
		}
	}


});

//完成建设的题库
Mock.mock(RegExp('/v1/ques-banks/my/complete' + ".*"),'get',(option)=>{
	return {
		"status": 200,
		"message": "succeed",
		"data": {
			"pageNum": 1,
			"pageSize": 10,
			"totalRow": 11,
			"totalPage": 2,
			"result": {
				"1": [{
					"bankId": 1,
					"bankName": "Java面向对象-2021",
					"creatorId": 1,
					"creatorName": "张三",
					"managerId": 2,
					"managerName": "李四",
					"createDate": "2016-09-21",
					"state": 0,
					"quesCount": 1000,
					"relateCourse": "MySQL数据库管理",
					"relateTextbook": "MySQL数据库管理",
					"relateChapter": "第1-4章",

				},
					{
						"bankId": 2,
						"bankName": "Java面向对象-2021",
						"creatorId": 2,
						"creatorName": "张三",
						"managerId": 2,
						"managerName": "李四",
						"createDate": "2016-09-21",
						"state": 1,
						"quesCount": 1001,
						"relateCourse": "MySQL数据库管理",
						"relateTextbook": "MySQL数据库管理",
						"relateChapter": "第1-4章",

					}
				]

			}
		}
	}


});

//结项
Mock.mock(RegExp('/v1/ques-banks/'+'.*'+'/doComplete'),'put',(option)=>{
	console.log(JSON.parse(option.body))
	return {
		"status": 200,
		"message": "succeed",
		"data": {

		}
	}
});
//启用
Mock.mock(RegExp('/v1/ques-banks/'+'.*'+'/doEnable'),'put',(option)=>{
	console.log(JSON.parse(option.body))
	return {
		"status": 200,
		"message": "succeed",
		"data": {

		}
	}
});
//禁用
Mock.mock(RegExp('/v1/ques-banks/'+'.*'+'/doDisable'),'put',(option)=>{
	console.log(JSON.parse(option.body))
	return {
		"status": 200,
		"message": "succeed",
		"data": {

		}
	}
});

//新建题库
Mock.mock(RegExp('/v1/ques-banks/part1' + ".*"),'post',(option)=>{
 console.log(JSON.parse(option.body))
 return {
   "status": 200,
       "msg": "OK",
       "data": {
           "bankId": 1,//输出题库id
     
       }

 }
});


//编辑题库
Mock.mock(RegExp('/v1/ques-banks/' + ".*?" + '/part1' + ".*"),'put',(option)=>{
 console.log(JSON.parse(option.body))
 return {
    "status": 200,
    "msg": "OK",
    "data": {
    }
}
});

// 查看题库-基本信息
Mock.mock(RegExp('/v1/ques-banks/' + ".*?" + '/part1' + ".*"), 'get', (option) => {
 console.log(JSON.parse(option.body))
 return {
  "status": 200,
  "msg": "OK",
  "data": {
   "bankId": 1,
   "bankName": "Java面向对象-2021",
	 "creatorId": 1,
   "manager": "李四",
   "intro": "Java面向对象-2021",
   "quesCount": 1000,
   "deadline": "2016-09-21",
   "bankType": 1,
   "addToPublicPool": 1,
   "relateCourse": 1,
   "relateTextbook": 1,
   "beginChapter": 1,
   "endChapter": 4,
   "relateUsage": 1,

  }

 }
});

// 查找人员
Mock.mock(RegExp('/v1/users' + ".*"), 'get', (option) => {
 console.log(JSON.parse(option.body))
 return {
  "status": 200,
    "message": "succeed",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "totalRow": 11,
        "totalPage": 2,
        "result": {
            "1": [{
						"userId": 1,
						"userName": "李四",
						"courseName": "MySQL数据库管理",
						"task": [
							{"val1": "", "val2": "", "val3":null,}
						]
					},
					{
						"userId": 2,
						"userName": "张三",
						"courseName": "java编程",
					},
					{
						"userId": 3,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},
					{
						"userId": 4,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},
					{
						"userId": 5,
						"userName": "张二",
						"courseName": "java编程",
					},
					{
						"userId": 6,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					}, {
						"userId": 7,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},
					{
						"userId": 8,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},
					{
						"userId": 9,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},
					{
						"userId": 10,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},
					{
						"userId": 11,
						"userName": "张三",
						"courseName": "MySQL数据库管理",
					},]
        }
    }
		
 }
});

// 获取课程列表
Mock.mock(RegExp('/v1/courses' + ".*"), 'get', (option) => {
 console.log(JSON.parse(option.body))
 return {
    "status": 200,
    "message": "succeed",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "totalRow": 11,
        "totalPage": 2,
        "result": {
            "1": [{
                "courseId": 1,
                "courseName": "MySQL数据库管理",
            }]
        }
    }
 }
});

//获取关联教材列表
Mock.mock(RegExp('/v1/textbooks'+ ".*"),'get',(option)=>{
 console.log(JSON.parse(option.body))
 return {
    "status": 200,
        "message": "succeed",
        "data": {
            "pageNum": 1,
            "pageSize": 10,
            "totalRow": 11,
            "totalPage": 2,
            "result": {
                "1": [{
                    "textbookId": 1,
                    "textbookName": "MySQL数据库管理从入门到精通",
                    "chapterCount": 16,
                }]
            }
        }
}
});

// 获取用途列表
Mock.mock(RegExp('/v1/usages' + ".*"), 'get', (option) => {
 console.log(JSON.parse(option.body))
 return {
   "status": 200,
    "message": "succeed",
    "data": {
        "pageNum": 1,
        "pageSize": 10,
        "totalRow": 11,
        "totalPage": 2,
        "result": {
            "1": [{
                "usageId": 1,
                "usageName": "考试",
            }]
        }
    }
 }
});

// 事件日志

Mock.mock(RegExp('/v1/ques-banks/' + ".*?" + '/part4' + ".*"), 'get', (option) => {
 return {
  "status": 200,
  "message": "succeed",
  "data": {
   "pageNum": 1,
   "pageSize": 10,
   "totalRow": 11,
   "totalPage": 2,
   "result": {
    "1": [{
     "createDate": "2016-09-21",
     "operator": "张三",
     "log": "增加初级-选择题-20题，初级-填空题-20题。",
    }, {
     "createDate": "2016-09-21",
     "operator": "张三",
     "log": "增加初级-选择题-20题，初级-填空题-20题。",
    }, {
     "createDate": "2016-09-21",
     "operator": "张三",
     "log": "增加初级-选择题-20题，初级-填空题-20题。",
    }, {
     "createDate": "2016-09-21",
     "operator": "张三",
     "log": "增加初级-选择题-20题，初级-填空题-20题。",
    }, {
     "createDate": "2016-09-21",
     "operator": "张三",
     "log": "增加初级-选择题-20题，初级-填空题-20题。",
    }]
   }
  }
 }
});

Mock.mock(RegExp('/v1/ques-banks/' + ".*?" + 'part3'),'get',(option)=>{
	return {
	    "status": 200,
	    "message": "succeed",
	    "data": {
	        "result": {
	            "1": [{
	                "jobId": 1,
	                "userId": 1,
	                "userName": "张三",
	                "state": 0,
	                "completionRate": "50%",
	                "items": [{
	                    "diffId": 1,
	                    "diffName": "初级",
	                    "quesTypeId": 1,
	                    "quesTypeName": "选择题",
	                    "quesCount": 20,
	                },
					{
					    "diffId": 1,
					    "diffName": "初级",
					    "quesTypeId": 1,
					    "quesTypeName": "选择题",
					    "quesCount": 20,
					}]
	            }]
	        }
	    }
	}
});

Mock.mock(RegExp('/v1/diffs' + ".*"), 'get', (option) => {
	return {
		"code": 200,
		"msg": "OK",
		"data": {
			"list": [{
				"diffId": 1,
				"val1": "初级",
			}, {
				"diffId": 2,
				"val1": "中级",
			}, {
				"diffId": 3,
				"val1": "高级",
			}]
		}
	}
});

Mock.mock(RegExp('/v1/ques-types' + ".*"), 'get', (option) => {
	return {
		"code": 200,
		"msg": "OK",
		"data": {
			"list": [{
				"quesTypeId": 1,
				"val2": "选择题",
			}, {
				"quesTypeId": 2,
				"val2": "填空题",
			}, {
				"quesTypeId": 3,
				"val2": "阅读题",
			}]
		}
	}

});
Mock.mock(RegExp('/v1/ques-banks/'+".*"+'/part2'+ ".*"), 'get', (option) => {
	return {
		status: 200,
		msg: 'OK',
		data: {
			
			subjects: [{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			},{
				id1: '1001',
				name1: "学科1",
				id2: '1002',
				name2: "学科2",
			}],
			abilities: [{
				id1: '1001',
				name1: "能力1",
				id2: '1002',
				name2: "能力2"
			}, {
				id1: '1002',
				name1: "能力1",
				id2: '1002',
				name2: "能力2"
			}, {
				id1: '1001',
				name1: "能力1",
				id2: '1002',
				name2: "能力2",
			},  {
				id1: '1001',
				name1: "能力1",
				id2: '1002',
				name2: "能力2",
			},  {
				id1: '1001',
				name1: "能力1",
				id2: '1002',
				name2: "能力2",
			},  {
				id1: '1001',
				name1: "能力1",
				id2: '1002',
				name2: "能力2",
			},  {
				id1: '1001',
				name1: "能力1",
				id2: '1002',
				name2: "能力2",
			
			}]
		}
	}
});

// RegExp('/v1/test' + ".*")
Mock.mock(RegExp('/v1/subject1s'+ ".*"), 'get', (option) => {
	return {
		status: 200,
		msg: 'OK',
		data: {
			pageNum: 1,
			pageSize: 10,
	        totalRow: 11,
	        totalPage: 2,
	        result:{
	        	1:[{
				id1: "1001",
				name1: "一级学科1",
			}, {
				id1: "1002",
				name1: "一级学科2",
			}, {
				id1: "1003",
				name1: "一级学科3",
			}, {
				id1: "1004",
				name1: "一级学科4",
			}, {
				id1: "1005",
				name1: "一级学科5",
			}, {
				id1: "1006",
				name1: "一级学科6",
			}, {
				id1: "1007",
				name1: "一级学科7",
			}]
	       }
		}
	}
});

Mock.mock(RegExp('/v1/subject2s'+ ".*"), 'get', (option) => {
	return {
		status: 200,
		msg: 'OK',
		data: {
			pageNum: 1,
			pageSize: 10,
	        totalRow: 11,
	        totalPage: 2,
	        result:{
	        	1:[{
				id2: "2001",
				name2: "二级学科1",
			}, {
				id2: "2002",
				name2: "二级学科2",
			}, {
				id2: "2003",
				name2: "二级学科3",
			}, {
				id2: "2004",
				name2: "二级学科4",
			}, {
				id2: "2005",
				name2: "二级学科5",
			}, {
				id2: "2006",
				name2: "二级学科6",
			}, {
				id2: "2007",
				name2: "二级学科7",
			}]
	       }
		}
	}
});

Mock.mock(RegExp('/v1/ability1s'+ ".*"), 'get', (option) => {
	return {
		status: 200,
		msg: 'OK',
		data: {
			pageNum: 1,
			pageSize: 10,
	        totalRow: 11,
	        totalPage: 2,
	        result:{
	        	1:[{
				id1: "1001",
				name1: "一级能力1",
			}, {
				id1: "1002",
				name1: "一级能力2",
			}, {
				id1: "1003",
				name1: "一级能力3",
			}, {
				id1: "1004",
				name1: "一级能力4",
			}, {
				id1: "1005",
				name1: "一级能力5",
			}, {
				id1: "1006",
				name1: "一级能力6",
			}, {
				id1: "1007",
				name1: "一级能力7",
			}]
	       }
		}
	}
});

Mock.mock(RegExp('/v1/ability2s'+ ".*"), 'get', (option) => {
	return {
		status: 200,
		msg: 'OK',
		data: {
			pageNum: 1,
			pageSize: 10,
	        totalRow: 11,
	        totalPage: 2,
	        result:{
	        	1:[{
				id2: "2001",
				name2: "二级能力1",
			}, {
				id2: "2002",
				name2: "二级能力2",
			}, {
				id2: "2003",
				name2: "二级能力3",
			}, {
				id2: "2004",
				name2: "二级能力4"
			}, {
				id2: "2005",
				name2: "二级能力5",
			}, {
				id2: "2006",
				name2: "二级能力6",
			}, {
				id2: "2007",
				name2: "二级能力7",
			}]
	       }
		}
	}
});