<template>
	<div>
		<!-- 伟铨 -->
		<div>
			<el-link :underline="false">分配任务</el-link>
			<div class="first">
				<span class="username">人员名称：</span>
				<el-autocomplete v-model="state" @change="lchange()" :fetch-suggestions="querySearchAsync" @select="lhandleSelect"
				 placeholder="请输入内容">
				</el-autocomplete>
				<el-button type="primary" @click="query()" style="margin-left: 20px;">查询</el-button>
				<el-button @click="reset()">重置</el-button>
				<el-checkbox v-model="checked" class="visible">题库仅限于圈子人员可见</el-checkbox>
				<el-button class="add" @click="axios()">+&nbsp;邀请人员加入圈子</el-button>
			</div>
			<div class="second">
				<el-table :data="kkdstableList" class="el-table" color="#fafafa">
					<el-table-column prop="userName" label="姓名" width="180">
					</el-table-column>
					<el-table-column prop="items" label="任务" width="670">
						<template slot-scope="scope">
							<div v-for="item in scope.row.items" v-if="item.diffId != null && item.diffName != null && item.quesTypeId != null && item.quesTypeName != null && item.diffName != null && item.quesCount != null">{{item.diffName}}-{{item.quesTypeName}}-{{item.quesCount}}</div>
							<div v-else>未分配任务</div>
						</template>
					</el-table-column>
					<el-table-column label="操作" width="140">
						<template slot-scope="scope">
							<el-button type="text" @click="jjclick(scope.row);JJdialogVisible = true">任务设置</el-button>
						</template>
					</el-table-column>
					<el-table-column width="250">
						<el-button @click="deleteRow()" type="text" size="medium">
							移除
						</el-button>

					</el-table-column>
				</el-table>
			</div>
			<div class="third">
				<el-pagination background layout="total, sizes, prev, pager, next, jumper" :page-sizes="[5,10,15]" :page-size="5"
				 :current-page="currentPage" :total="total" @size-change="handleSizeChange" @current-change="handleCurrentChange">
				</el-pagination>
			</div>
			<div class="fourth">
				<el-button>取消</el-button>
				<el-button type="primary">提交</el-button>
			</div>
		</div>
		<!-- 志斌 -->
		<div>
			<el-dialog :visible.sync="zbdialogVisible" :before-close="handleClose" width="60%">
				<div class="zb_header">
					<div class="zb_input">
						<div class="zb_findName">
							<div class="zb_text_input">人员:</div>
							<!-- <el-input placeholder="请输入" id="zbfindName" type="text"  /> -->
							<el-autocomplete v-model="zbfindName" id="zb_findName" :fetch-suggestions="userNamequerySearchAsync" placeholder="请输入内容"
							 @select="handleSelect"></el-autocomplete>
						</div>
						<div class="zb_findClass">
							<div class="zb_text_input">课程名称:</div>
							<!-- <el-input placeholder="请输入" id="zbfindClass" type="text" v-model="zbfindClass" /> -->
							<el-autocomplete v-model="zbfindClass" id="zb_findClass" :fetch-suggestions="classNamequerySearchAsync"
							 placeholder="请输入内容" @select="handleSelect"></el-autocomplete>
						</div>
					</div>
					<div>
						<el-button type="primary" id="zb_find" size="mini" @click="find()">查询</el-button>
						<el-button id="zb_reset" size="mini" @click="Reset()">重置</el-button>
					</div>
				</div>
				<br>
				<br>
				<el-table :data="zbtableList" :height="zbtableHeight" :header-cell-style="{background:'#E4E4E4'}" @select="change"
				 @select-all="changeAll" ref="elTable">

					<el-table-column type="selection" width="160"></el-table-column>
					<el-table-column property="userName" label="姓名" width="120"></el-table-column>
					<el-table-column property="courseName" label="教授课程"></el-table-column>
				</el-table>

				<div class="zb_block">
					<el-pagination background :page-size="5" :page-sizes="[zbSizes]" :total="zbtotal" :current-page="zbcurrentPage"
					 layout="total,prev, pager, next, sizes, jumper" @size-change="zbhandleSizeChange" @current-change="zbhandleCurrentChange">
					</el-pagination>
				</div>
				<hr size="1" class="zb_hr">
				<div id="zb_el-dialog_footer">
					<el-button id="zb_congirm" size="mini" @click="handleClose">取消</el-button>
					<el-button type="primary" id="zb_cancel" size="mini" @click="defindclick()">确认</el-button>
				</div>

			</el-dialog>
		</div>
		<!-- 俊杰 -->
		<div>
			<el-dialog :visible.sync="JJdialogVisible" width="49%" :before-close="handleClose">
				<span style="margin-right: 10%; margin-left: 2%;">姓名：<span v-model="JJuserName">{{JJuserName}}</span></span>
				<span>课程名称：<span v-model="JJcourseName">{{JJcourseName}}</span></span>

				<div style="margin-left: 1%;">
					<el-table :data="JJtableData" style="width: 100% " :height="335">
						<el-table-column label="等级" width="200">
							<template slot-scope="scope">
								<el-select v-model="scope.row.JJvalue1" placeholder="请选择" @visible-change="getLevel()" @change="getJJvalue1(scope.row)"
								 style="margin-right: 12%;margin-left: 2%; width: 50%;" clearable>
									<el-option v-for="item in JJlistLevel" :key="item.val1" :label="item.label1" :value="item.val1">
									</el-option>
								</el-select>
							</template>
						</el-table-column>
						<el-table-column label="题型" width="240">
							<template slot-scope="scope">
								<el-select v-model="scope.row.JJvalue2" placeholder="请选择" @visible-change="getType()" @change="getJJvalue2(scope.row)"
								 style="margin-right: 20%; width: 70%;" clearable>
									<el-option v-for="item in JJlistType" :key="item.val2" :label="item.label2" :value="item.val2">
									</el-option>
								</el-select>
							</template>
						</el-table-column>
						<el-table-column label="数量" width="190">
							<template slot-scope="scope">
								<el-input-number v-model="scope.row.JJnum" controls-position="right" :min="1" :max="30" @change="getNum(scope.row)"
								 style="width: 50%;">
								</el-input-number>
							</template>
						</el-table-column>
						<el-table-column width="70">
							<template slot-scope="scope">
								<el-button @click.native.prevent="JJdeleteRow(scope.$index, JJtableData)" type="text" icon="el-icon-remove-outline"
								 style="font-size: 20px;">
								</el-button>
							</template>
						</el-table-column>
					</el-table>
				</div>

				<div>
					<el-button @click="JJadd()" style="margin-left: 6%; width: 86%; margin-top: 2%; border: 1px dashed lightgray;">
						+&nbsp;&nbsp;添加
					</el-button>
				</div>
				<span slot="footer" class="dialog-footer">
					<el-button @click="quxiao;JJdialogVisible = false">取 消</el-button>
					<el-button type="primary" @click="JJqueding();JJdialogVisible = false" @focus="judge()">确 定</el-button>
				</span>
			</el-dialog>
		</div>
	</div>

</template>

<script>
	// 帮你们改了一些，实在是改不下去了
	// todo: 从头到尾在仔细过一遍，有用的代码留下，无用的删除
	// todo: 不同condition下的页面变化
	import {
		getAss,
		getUsers
	} from "@/api/qsb.js"
	export default {
		props:{
			bankId:String,
			condition:Number
		},
		
		data() {
			return {
				JJaddList: [],
				JJuserName: '',
				JJcourseName: '',
				state: '',
				checked: null,
				rzbcheckList: [],
				buskTableData: [],
				choose: null,
				kkdstableList: [],
				restaurants: [],
				tableData: [],
				elTable: [],
				currentPage: 1,
				//每页的容量
				Sizes: "5",
				timeout: null,
				total: 1,
				JJdialogVisible: false,
				JJvalue1: '',
				JJvalue2: '',
				JJnum: '',
				JJdata1: [],
				JJdata2: [],
				JJdata3: [],
				JJtableData: [{}],
				JJlistLevel: [],
				JJlistType: [],
				zbdialogVisible: null,
				zbfindName: '',
				zbfindClass: '',
				zbtableHeight: "500",
				zbcurrentPage: null,
				zbtableList: [],
				zbfindTableList: [],
				zbuserNamerestaurants: [],
				zbclassNamerestaurants: [],
				zbtimeout: null,
				zbSizes: "",
				zbtotal: 1,
				zbtableData: [],
				typeData: []
			}
		},
		methods: {
			JJqueding() {
				var addList = {
					"diffName": this.JJvalue1,
					"quesTypeName": this.JJvalue2,
					"quesCount": this.JJnum
				}
				console.log(addList)
				this.JJaddList.push(addList)
				console.log(this.JJaddList.length)
			},
			jjclick(row) {
				console.log(row.items[0].diffName)
				this.JJcourseName = row.courseName
				this.JJuserName = row.userName
			},
			loaduserNameAll() {
				var selectList = [];
				getUsers().then(res => {
					for (var i = 0; i < res.data.result['1'].length; i++) {
						var select = {
							value: res.data.result['1'][i].userName,
							courseName: res.data.result['1'][i].courseName
						};
						selectList.push(select);
					}
				});
				return selectList;
			},
			loadcourseNameAll() {
				var selectList = [];
				getUsers().then(res => {
					for (var i = 0; i < res.data.result['1'].length; i++) {
						var select = {
							value: res.data.result['1'][i].courseName,
							courseName: res.data.result['1'][i].userName
						};
						selectList.push(select);
					}
					return selectList;
				});
				
			},
			handleClose(done) {
				this.$confirm('确认关闭？').then(_ => {
					this.zbdialogVisible = false;
					done();
				}).catch(_ => {});
			},
			defindclick() { //点击确认，邀请人员添加进主页面 				
				this.zbdialogVisible = false;
				for (var i = 0; i < this.rzbcheckList.length; i++) {
					var select = {
						userName: this.rzbcheckList[i].userName,
						items: [{
							"diffId": null,
							"diffName": 'null',
							"quesTypeId": null,
							"quesTypeName": null,
							"quesCount": null
						}], ///////////
						userId: this.rzbcheckList[i].userId,
						courseName: this.rzbcheckList[i].courseName
					};
					this.tableData.push(select)
					this.buskTableData = this.tableData;
				}
				this.rzbcheckList = [];
				this.kkdstableList = this.tableData.slice(0, this.Sizes);
				this.total = this.tableData.length
				this.currentPage = 1
			},
			change(sess, val) { //选中邀请的人员
				let selected = sess.length && sess.indexOf(val) !== -1
				if (selected) {
					this.rzbcheckList.push(val);
				}
			},
			changeAll() {
				this.rzbcheckList = this.zbtableData;
				console.log(this.rzbcheckList);
			},
			zbhandleSizeChange(val) {
				console.log(`每页 ${val} 条`); //当前页条数
				this.zbSizes = val;
				this.handleCurrentChange(1);
			},
			zbhandleCurrentChange(val) {
				console.log(`当前页: ${val}`);
				this.zbcurrentPage = val;
				var size = this.zbSizes;
				console.log(size); //当前页码
				if (this.zbfindTableList.length == 0) {
					this.zbtableList = this.zbtableData.slice(val * size - size, val * size);
				} else {
					this.zbtableList = this.zbfindTableList.slice(val * size - size, val * size);
				}
			},
			userNamequerySearchAsync(queryString, cb) {
				var zbuserNamerestaurants = this.zbuserNamerestaurants;
				var zbuserNamerestaurants = queryString ? zbuserNamerestaurants.filter(this.userNamecreateFindClassFilter(
					queryString)) : zbuserNamerestaurants;
				clearTimeout(this.zbtimeout);
				this.zbtimeout = setTimeout(() => {
					cb(zbuserNamerestaurants);
				}, 3000 * Math.random());
			},
			userNamecreateFindClassFilter(queryString) {
				return (zbfindClass) => {
					return (zbfindClass.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
				return (zbfindClass) => {
					return (zbfindClass.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
			},
			classNamequerySearchAsync(queryString, cb) {
				var zbclassNamerestaurants = this.zbclassNamerestaurants;
				var classNameresults = queryString ? zbclassNamerestaurants.filter(this.classNamecreateFindClassFilter(
					queryString)) : zbclassNamerestaurants;
				clearTimeout(this.zbtimeout);
				this.zbtimeout = setTimeout(() => {
					cb(classNameresults);
				}, 3000 * Math.random());
			},
			classNamecreateFindClassFilter(queryString) {
				return (zbfindClass) => {
					return (zbfindClass.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
				return (zbfindClass) => {
					return (zbfindClass.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
			},
			handleSelect(item) {
				console.log(item);
			},
			axios() {
				this.zbtotal = this.zbtableData.length;
				this.zbdialogVisible = true;
				this.getUsersData()
				this.zbcurrentPage = 1;
				this.created();
			},
			created() {
				this.zbtableList = this.zbtableData.slice(0, this.zbSizes);
				console.log("成功");
			},
			find() {
				this.getUsersData()
				// this.zbtableList = [];
				// this.zbfindTableList = [];
				// if (this.zbfindName == null && this.zbfindClass == null || this.zbfindName == '' && this.zbfindClass ==
				// 	'' || this.zbfindName == '' && this.zbfindClass == null || this.zbfindName == null && this
				// 	.zbfindClass == '') {
				// 	alert("查询条件不能为空");
				// 	this.created();
				// 	this.zbcurrentPage = 1;
				// 	return;
				// }
				// if (this.zbfindName == " " || this.zbfindClass == " " || this.zbfindName == " " && this.zbfindClass ==
				// 	" ") {
				// 	alert("输入值不能为“ ”,请正确输入查询条件");
				// 	this.created();
				// 	this.zbcurrentPage = 1;
				// 	return;
				// }
				// if (this.zbfindName != '' && this.zbfindClass != '') {
				// 	for (var i = 0; i < this.zbtableData.length; i++) {
				// 		if (this.zbtableData[i].userName == this.zbfindName && this.zbtableData[i].courseName == this
				// 			.zbfindClass) {
				// 			this.zbfindTableList.push(this.zbtableData[i]);
				// 			this.zbtotal = this.zbfindTableList.length;
				// 		}
				// 	}
				// 	if (this.zbfindTableList.length <= 0) {
				// 		alert("1没有这条记录");
				// 		this.handleCurrentChange(1);
				// 	}
				// 	this.zbtableList = this.zbfindTableList.slice(0, this.zbSizes);
				// 	this.zbcurrentPage = 1;
				// 	return;
				// }
				// if (this.zbfindName == '' && this.zbfindClass != '') {
				// 	for (var i = 0; i < this.zbtableData.length; i++) {
				// 		if (this.zbtableData[i].courseName == this.zbfindClass) {
				// 			this.zbfindTableList.push(this.zbtableData[i]);
				// 			this.zbtotal = this.zbfindTableList.length;
				// 		}
				// 	}
				// 	if (this.zbfindTableList.length <= 0) {
				// 		alert("3没有这条记录");
				// 		this.handleCurrentChange(1);
				// 	}
				// 	this.zbtableList = this.zbfindTableList.slice(0, this.zbSizes);
				// 	this.zbcurrentPage = 1;
				// 	return;
				// }
				// if (this.zbfindName != null || this.zbfindName != '') {
				// 	for (var i = 0; i < this.zbtableData.length; i++) {
				// 		if (this.zbtableData[i].userName == this.zbfindName) {
				// 			this.zbfindTableList.push(this.zbtableData[i]);
				// 			this.zbtotal = this.zbfindTableList.length;
				// 		}
				// 	}
				// 	if (this.zbfindTableList.length <= 0) {
				// 		alert("2没有这条记录");
				// 		this.handleCurrentChange(1);
				// 	}
				// 	this.zbtableList = this.zbfindTableList.slice(0, this.zbSizes);
				// 	this.zbcurrentPage = 1;
				// 	return;
				// }
			},
			Reset() {
				this.rzbcheckList = [];
				this.zbfindTableList = [];
				this.zbfindName = '';
				this.zbfindClass = '';
				this.zbtableList = this.zbtableData.slice(0, this.zbSizes);
				this.zbtotal = this.zbtableData.length;
				this.handleCurrentChange(1);
				alert("重置成功");
			},
			loadAll() {},
			querySearchAsync(queryString, cb) {
				this.restaurants = this.buskTableData
				var results = queryString ? this.restaurants.filter(this.createStateFilter(queryString)) : this
					.restaurants;
				clearTimeout(this.timeout);
				this.timeout = setTimeout(() => {
					cb(results);
				}, 100 * Math.random());
			},
			createStateFilter(queryString) {
				return (state) => {
					return (state.value.toLowerCase().indexOf(queryString.toLowerCase()) === 0);
				};
			},
			lhandleSelect(item) {
				console.log(item);
			},
			query() {
				if (this.state == '') {
					// todo:使用elementUI的消息提示组件
					alert("请输入要查询的内容！！")
				} else if (this.state == this.stateData) {
					alert("请更改查询内容！！")
				} else {
					this.getAssData()
					// let newTableData = []
					// let stateData = []
					// console.log(this.tableData)
					// this.tableData.forEach((row) => {
					// 	if (this.state == row.value || this.state == row.task) newTableData.push(row)
					// 	this.stateData = this.state
					// })
					// this.buskTableData = this.tableData
					// this.tableData = newTableData
					// this.kkdstableList = this.tableData.slice(0, this.Sizes);
					// this.total = this.tableData.length
				}
			},
			reset() {
				console.log(this.buskTableData)
				this.kkdstableList = this.buskTableData.slice(0, this.Sizes);
				this.tableData = this.buskTableData
				this.total = this.buskTableData.length
				this.currentPage = 1
				this.state = ''
				this.stateData = []
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`); //当前页条数
				this.Sizes = val;
				this.handleCurrentChange(1);
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`); //当前页码
				this.currentPage = val;
				var size = this.Sizes;
				console.log(size); //当前页码
				this.kkdstableList = this.tableData.slice(val * size - size, val * size);
				console.log(this.kkdstableList)
				this.tableData = this.buskTableData
			},
			deleteRow(userId) { //移除
				this.$confirm('确定删除该内容吗！！', '删除显示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
				}).then(() => { //确认删除
					this.$axios({
						url: '/ v1/ques-banks/{题库id}/jobs/{任务id}',
						method: 'delete',
					}).then(res => {
						console.log(res.data)
					})
				});
			},
			getJJvalue1(row) {
				console.log(row.JJvalue1)
				this.JJvalue1 = row.JJvalue1
				console.log(this.JJvalue1)

				this.JJdata1.push(0)
			},
			getJJvalue2(row) {
				console.log(row.JJvalue2)
				this.JJvalue2 = row.JJvalue2
				console.log(this.JJvalue2)
				this.JJdata2.push(0)
			},
			getNum(row) {
				console.log(row.JJnum)
				this.JJnum = row.JJnum
				console.log(this.JJnum)
				this.JJdata3.push(0)
			},
			JJdeleteRow(index, rows) {
				rows.splice(index, 1);
				this.JJdata1.push(0)
				this.JJdata2.push(0)
				this.JJdata3.push(0)
			},
			JJadd() {
				if (this.JJdata1 == '') {
					alert("请选择等级")
				} else if (this.JJdata2 == '') {
					alert("请选择题型")
				} else if (this.JJdata3 == '') {
					alert("请选择题目数量")
				} else if (this.JJnum == undefined) {
					alert("题目数量至少为1！")
				} else {
					let JJnewlist = {}
					this.JJtableData.push(JJnewlist)
					this.JJdata1 = []
					this.JJdata2 = []
					this.JJdata3 = []
					this.JJque
				}
			},
			getLevel() {
				this.$axios.get("/v1/diffs")
					.catch(res => {
						this.JJlistLevel = res.data.list
					})
			},
			getType() {
				this.$axios.get("/v1/ques-types")
					.catch(res => {
						this.JJlistType = res.data.list
					})
			},
			quxiao() {
				console.log(this.JJvalue1);
			},
			// 获取任务数据
			getAssData(){
				// 题库id this.bankId
				// 原本任务分配
				//2.3.11.“查看题库-分配任务”接口
				getAss(this.bankId,{
						userName: this.state,
						pageNum: this.currentPage,
						pageSize: this.Sizes
					}
				).then((res) => {
					this.tableData = res.data.result['1']
					this.buskTableData = this.tableData;
					this.total = this.tableData.length;
					this.kkdstableList = this.tableData.slice(0, this.Sizes);
				
				
				}).catch((res) => {
					console.log(res)
				});
			},
			// 获取人员数据
			getUsersData(){
				getUsers({
					userName:zbfindName,
					courseName:zbfindClass,
					pageNum: this.zbcurrentPage,
					pageSize: this.zbSizes
				}).then(res => {
					console.log(res.data);
					this.zbtableData = res.data.result['1'];
					this.typeData = res.data.result['1'].task;
					this.zbcurrentPage = res.data.pageNum;
					this.zbSizes = res.data.pageSize;
					console.log(this.zbtableData);
				});
			}
		},
		mounted() {
			this.zbclassNamerestaurants = this.loadcourseNameAll();
			this.zbuserNamerestaurants = this.loaduserNameAll();
			this.restaurants = this.loadAll();
		},
		created() {
			this.getAssData()
		}
	}
</script>

<!-- 伟铨 -->
<style scoped>
	/deep/.el-table th.el-table__cell {
		background-color: #FAFAFA;
	}

	.operation {
		color: #1890FF;
	}

	.first {
		display: flex;
		align-items: center;
		margin-top: 20px;
	}

	.username {
		width: 100px;
		text-align: center;
	}

	.el-input {
		width: 225px;
	}

	.query {
		margin-left: 30px;
	}

	.visible {
		margin-left: 60px;
	}

	.add {
		border: 2px dashed #DCDFE6;
		margin-left: 250px;
		color: #1890ff;
	}

	.second {
		margin-top: 20px;
	}

	.third {
		margin-top: 20px;
	}

	.button1 {
		width: 32px;
		margin-left: 300px;
		border-radius: 6px;
	}

	.el-select {
		width: 100px;
		margin-left: 10px;
	}

	.el-input1 {
		width: 50px;
	}

	.span {
		margin-left: 20px;
	}

	.jump {
		display: flex;
		align-items: center;
		margin-left: 140px;
	}

	.fourth {
		margin-top: 20px;
		float: right;
	}

	.remove {
		border: none;
		color: #1890FF;
	}
</style>

<!-- 志斌 -->
<style scoped>
	.zb_header {
		display: flex;
		justify-content: space-between;
	}

	.zb_input {
		display: flex
	}

	.zb_text_input {
		margin-top: 5px;
	}

	.zb_findName>div {
		width: 70px;
	}

	.zb_findClass>div {
		width: 70px;
	}

	/deep/#zb_findClass,
	/deep/#zb_findName {
		height: 30px;
		width: 400%;
	}

	.zb_findClass,
	.zb_findName {
		display: flex;
		vertical-align: middle;
	}

	.zb_findClass {
		margin-left: 250px;
	}

	.zb_block {
		width: 80%;
		margin-top: 20px;
	}

	.zb_block /deep/.number,
	.zb_block /deep/.btn-prev,
	.zb_block /deep/.btn-next {
		/* border: 1px silver solid; */
		border-radius: 5px;
		margin-left: 5px;
		margin-right: 2.5px;
		background-color: #E4E7ED;
	}

	.zb_block /deep/.el-pagination__total {
		margin-right: 400px;
	}

	.zb_block /deep/.el-pagination__sizes {
		margin-left: 10px;
	}

	.zb_block /deep/.el-pagination__jump {
		padding-right: 30px;
	}

	.zb_block /deep/.el-icon-d-arrow-right:before,
	.zb_block /deep/.el-icon-d-arrow-left:before {
		content: "\e794"
	}

	.zb_hr {
		color: #EBEEF5;
	}

	#zb_el-dialog_footer {
		display: flex;
		justify-content: flex-end;
		padding-top: 10px;
	}
</style>

<!-- 俊杰 -->
<style scoped>
	/deep/.el-input-number__decrease,
	/deep/.el-input-number__increase {
		width: 20px;
	}
</style>
