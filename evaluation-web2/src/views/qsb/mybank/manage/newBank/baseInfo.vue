<template>
	<!-- 	<el-tabs v-model="activeName1" @tab-click="handleClick1">
		<el-tab-pane label="正在建设的题库" name="first">用户管理</el-tab-pane>
		<el-tab-pane label="完成建设的题库" name="second">配置管理</el-tab-pane>
		<el-tab-pane label="新建我的题库" name="third"> -->
	<div class="major">
		<el-tabs v-model="activeName2" @tab-click="handleClick2">
			<el-tab-pane label="基本信息" name="one">


				<el-form ref="form" :rules="rules" :model="form" label-width="130px" class="demo-ruleForm">
					<el-form-item label="题库名称:" prop="name">
						<el-input v-model="form.name" placeholder="输入题库名称"></el-input>
					</el-form-item>

					<el-form-item label="负责人:" prop="region">
						<el-select v-model="form.region" filterable placeholder="请选择" @focus="select_users()">
							<el-option v-for="(item,index) in form.options_users" :key="index" :label="item.userName" :value="item.userId">
							</el-option>
						</el-select>
					</el-form-item>
					<el-form-item label="简介:" prop="desc">
						<el-input type="textarea" v-model="form.desc" placeholder="请输入内容"></el-input>
					</el-form-item>
					<el-form-item label="计划数量:" prop="input">
						<el-input type="text" oninput="value=value.replace(/[^\d]/g,'')" v-model="form.input" placeholder="请输入数字"
						 clearable></el-input>
					</el-form-item>
					<el-form-item label="计划完成时间" required>
						<el-col :span="11">
							<el-form-item prop="date1">
								<el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
							</el-form-item>
						</el-col>
					</el-form-item>

					<el-form-item label="题库类型:" prop="type">
						<el-radio-group v-model="form.type">
							<el-radio label="公开" name="type"></el-radio>
							<el-radio label="私有" name="type"></el-radio>
						</el-radio-group>
					</el-form-item>
					<el-form-item label="是否加入公共池:" prop="type2">
						<el-radio-group v-model="form.type2">
							<el-radio label="是" name="type2"></el-radio>
							<el-radio label="否" name="type2"></el-radio>
						</el-radio-group>
					</el-form-item>
					<!-- 关联课程-->
					<el-form-item label="关联课程:" prop="course">
						<el-select v-model="form.course" filterable placeholder="请选择" @focus="select_course()">
							<el-option v-for="(item,index) in form.options_course" :key="index" :label="item.courseName" :value="item.courseId">
							</el-option>
						</el-select>
					</el-form-item>
					<!-- 关联教材 -->
					<el-form-item label="关联教材:" prop="textBook">
						<el-select v-model="form.textBook" filterable placeholder="请选择" @focus="select_book()">
							<el-option v-for="(item,index) in form.options_book" :key="index" :label="item.textbookName" :value="item.textbookId">
							</el-option>
						</el-select>
					</el-form-item>
					<!-- 章节范围 -->
					<el-form-item label="章节范围:" prop="range">
						<el-select v-model="form.range" placeholder="请选择">
							<el-option label="张三" value="zhangsan"></el-option>
							<el-option label="李四" value="lisi"></el-option>
						</el-select>
					</el-form-item>
					<!-- 关联用途 -->
					<el-form-item label="关联用途:" prop="purpose">
						<el-select v-model="form.purpose" filterable placeholder="请选择" @focus="select_purpose()">
							<el-option v-for="(item,index) in form.options_purpose" :key="index" :label="item.usageName" :value="item.usageId">
							</el-option>
						</el-select>
					</el-form-item>


					<el-divider></el-divider>
					<el-form-item style="margin-left: 220px;">
						<el-button>取消</el-button>
						<el-button type="primary" v-if="condition === 1" @click="onSubmit('form')">提交</el-button>
						<el-button type="primary" v-else-if="condition === 2" @click="onEdit()">编辑</el-button>
					</el-form-item>
				</el-form>
			</el-tab-pane>
			<el-tab-pane label="关联学科/能力分类设置" name="two">
				<relationTab :bankId="bankId" :condition="condition"></relationTab>
			</el-tab-pane>
			<el-tab-pane label="分配任务" name="three">
				<taskAss :bankId="bankId" :condition="condition"></taskAss>
			</el-tab-pane>
			<el-tab-pane label="事件日志" name="four">
				<eventLog :bankId="bankId" :condition="condition"></eventLog>
			</el-tab-pane>
		</el-tabs>
	</div>

	</el-tab-pane>

	<!-- </el-tabs> -->
</template>

<script>
	// todo:condition为3时控件为不可输入状态
	import eventLog from '@/views/qsb/mybank/manage/newBank/eventLog.vue'
	import taskAss from '@/views/qsb/mybank/manage/newBank/taskAss.vue'
	import relationTab from '@/views/qsb/mybank/manage/newBank/relationTab.vue'
	import {
		getBankInfo,
		createBank,
		editBank,
		getUsers,
		getTextbooks,
		getCourses,
		getUsages
	} from "@/api/qsb.js"
	export default {
		name: 'baseInfo',
		components: {
			eventLog,
			taskAss,
			relationTab
		},
		data() {
			return {
				activeName1: 'third',
				//在提交按钮后要跳到关联页面
				activeName2: 'one',
				creatorId: '',
				"bankName": "Java面向对象-2021",
				"manager": 2,
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
				condition: 2,
				bankId: '',
				"userName": "王",
				"courseName": "",
				form: {
					textBook: '',
					name: '',
					region: '',
					date1: '',
					input: '',
					delivery: false,
					type: '',
					type2: '',
					yesOrno: [],
					resource: '',
					desc: '',
					course: '',
					book: '',
					range: '',
					purpose: '',
					// num: ''
					options_book: [{
						textbookId: '',
						textbookName: '',
					}],
					options_course: [{
						courseId: '',
						courseName: '',
					}],
					options_purpose: [{
						usageId: '',
						usageName: '',
					}],
					options_users: [{
						userId: '',
						userName: '',
					}],
					textBook: '',
					course: '',

				},

				rules: {
					name: [{
						required: true,
						message: '请输入题库名称',
						trigger: 'blur'
					}],
					region: [{
						required: true,
						message: '请选择负责人',
						trigger: 'change'
					}],
					date1: [{
						type: 'date',
						required: true,
						message: '请选择日期',
						trigger: 'change'
					}],
					type: [{
						required: true,
						message: '请选择题库类型',
						trigger: 'change'
					}],
					type2: [{
						required: true,
						message: '请选择是否加入公共池',
						trigger: 'change'
					}],
					course: [{
						required: true,
						message: '请选择关联课程',
						trigger: 'change'
					}],
					textBook: [{
						required: true,
						message: '请选择关联教材',
						trigger: 'change'
					}],
					range: [{
						required: true,
						message: '请选择章节范围',
						trigger: 'change'
					}],
					purpose: [{
						required: true,
						message: '请选择关联用途',
						trigger: 'change'
					}],
					input: [{
						required: true,
						message: '请选择计划数量',
						trigger: 'change'
					}],
					desc: [{
						required: true,
						message: '请填写简介',
						trigger: 'blur'
					}]
				},

			}
		},
		methods: {
			handleClick1(tab, event) {
				console.log(tab, event);
			},
			handleClick2(tab, event) {
				console.log(tab, event);
			},
			handleChange(value) {
				console.log(value);
			},
			onSubmit(formName) {
				createBank({
						bankName: this.bankName,
						manager: this.manager,
						intro: this.intro,
						quesCount: this.quesCount,
						deadline: this.deadline,
						bankType: this.bankType,
						addToPublicPool: this.addToPublicPool,
						relateCourse: this.relateCourse,
						relateTextbook: this.relateTextbook,
						beginChapter: this.beginChapter,
						endChapter: this.endChapter,
						relateUsage: this.relateUsage
					}).then((res) => {
						console.log(res.data)
				});
				// todo:注意，请求成功的回调实在then中，失败的回调是在catch中
				this.$refs[formName].validate((valid) => {
					if (valid) {
						alert('submit!');
						this.activeName2 = "two"
					} else {
						console.log('error submit!!');
						this.activeName2 = "one"
						return false;

					}
				});

			},
			onEdit() {
				editBank(this.bankId,{
						bankName: this.bankName,
						manager: this.manager,
						intro: this.intro,
						quesCount: this.quesCount,
						deadline: this.deadline,
						bankType: this.bankType,
						addToPublicPool: this.addToPublicPool,
						relateCourse: this.relateCourse,
						relateTextbook: this.relateTextbook,
						beginChapter: this.beginChapter,
						endChapter: this.endChapter,
						relateUsage: this.relateUsage
					}).then((res) => {
					console.log(res)
				})
			},
			//负责人
			select_users() {
				getUsers().then((res) => {
					console.log(res.data.result['1'])
					this.form.options_users = res.data.result['1']

					this.form.region = res.data.result['1'].userName
					console.log('submit success!')
				})
			},
			//关联教材
			select_book() {
				console.log('submit!');
				console.log(this.form.options);
				getTextbooks().then((res) => {
					//返回表格数据
					this.form.options_book = res.data.result['1']
					this.form.textBook = res.data.result['1'].textbookName
					console.log("submit success")
				}).catch((res) => {
					console.log(res)
				});
			},
			//课程
			select_course() {
				getCourses().then((res) => {
					console.log(res.data.result['1'])
					this.form.options_course = res.data.result['1']
					this.form.course = res.data.result['1'].courseName
					console.log('submit success!')
				})
			},
			//用途
			select_purpose() {
				getUsages().then((res) => {
					console.log(res.data.result['1'])
					this.form.options_purpose = res.data.result['1']
					this.form.purpose = res.data.result['1'].usageName
					console.log('submit success!')
				})
			},

		},

		created() {
			//应该是点击查看按钮之后就进行判断是否创建人与用户是同一个
			/*这是一个组件，先判断路由中是否有传入题库若无则是新建状态，有则是查看或编辑状态，再发送一个请求，用以判断是否创建人与登入用户是同一个人，
			若是则发送编辑请求掉取数据,若不是则发送查看请求调取数据*/
			//需要给个变量
			// 1.判断题库id
			// 有，2.3。9，获得题库信息
			// 判断创建人是否用户
			//查看题库
			//判断题库id this.$route.query.bankId
			this.bankId = this.$route.query.bankId

			var condition; //题库状态 1是新建状态 2是编辑状态 3是查看状态

			if (this.bankId) { //此时的bankId
				//用以判断是否创建人与登入用户是同一个人
				getBankInfo(this.bankId).then((res) => {
					this.creatorId = res.data.creatorId
					let userId = this.$store.state.userInfo.userId
					// todo：信息需要写入页面
					if (userId == this.creatorId) {
						//可编辑状态
						this.condition = 2
					} else {
						//查看状态
						this.condition = 3
						// 意义不明
						// this.$axios({
						// 	url: '/v1/ques-banks/1234/part1',
						// 	method: "get",
						// 	params: {}
						// }).then((res) => {
						// 	console.log(res)
						// })
					}
				}).catch((res) => {
					console.log(res)
				})
			} else { //此时的bankId为uninformed
				//新建题库
				this.condition = 1;

			}
		}


	};
</script>

<style>
	.el-link {
		padding-right: 50px;
	}

	.major .el-tabs__nav-wrap::after {
		width: 0px !important;
	}

	.major .el-tabs__active-bar {
		height: 0px !important;
	}

	el-form-item__content {
		/* margin-left: 220px; */
		display: flex;
		justify-content: flex-end !important;
	}
</style>
