<template>
	<div>
		<el-tabs v-model="activeName" @tab-click="handleClick">
			<el-tab-pane label="正在建设的题库" name="second">
				达到结项条件：
				<el-radio v-model="btn_canComplete" label="true">是</el-radio>
				<el-radio v-model="btn_canComplete" label="false">否</el-radio>
				题库名称：
				<el-input style="width:200px" v-model="btn_bankName" placeholder="请输入内容"></el-input>
				负责人：
				<el-input style="width:200px" v-model="btn_managerName" placeholder="请输入内容"></el-input>
				<el-button type="primary" @click="getResult">查询</el-button>
				<el-button class="mo" style="margin:10px">重置</el-button>
				<el-button type="primary" @click="createBank" style="margin-left:135px">新建我的题库</el-button>

				<el-table :data="tableData" border style="width: 100%;margin-top:10px">
					<el-table-column prop="bankName" label="题库名称" width="180">
					</el-table-column>
					<el-table-column label="创建人/负责人" width="120">
						<template slot-scope="scope">
							{{scope.row.creatorName}}/{{scope.row.managerName}}
						</template>
					</el-table-column>
					<el-table-column label="提交/审核进度" width="120">
						<template slot-scope="scope">
							{{scope.row.submitProgress}}/{{scope.row.auditProgress}}
						</template>
					</el-table-column>
					<el-table-column prop="deadline" label="计划完成时间" width="120">
					</el-table-column>
					<el-table-column prop="relateCourse" label="关联课程" width="150">
					</el-table-column>
					<el-table-column prop="relateTextbook" label="关联教材" width="150">
					</el-table-column>
					<el-table-column prop="relateChapter" label="关联章节" width="150">
					</el-table-column>
					<el-table-column fixed="right" label="操作" width="160">
						<template slot-scope="scope">
							<el-button @click="viewBank(scope.row)" type="text" size="small">查看</el-button>
							<el-button v-if="scope.row.auditProgress=='100%'" type="text" size="small" @click="getdoComplete(scope.row)">结项</el-button>
						</template>
					</el-table-column>
				</el-table>

				<div class="block" style="margin-top:10px">
					<el-pagination background layout="total, prev, pager, next, sizes, jumper" :total="totalData" @size-change="handleSizeChange"
					 @current-change="getData" :current-page.sync="currentPage1" :page-sizes="[10, 20, 30, 40, 50, 60, 70, 80]"
					 :page-size.sync="pagesizes">
					</el-pagination>
				</div>
			</el-tab-pane>
			<el-tab-pane label="完成建设的题库" name="first">
				题库名称：
				<el-input style="width:200px" v-model="btn_bankName" placeholder="请选择">
				</el-input>
				负责人：
				<el-input style="width:200px" v-model="btn_managerName" placeholder="请输入内容"></el-input>
				<el-button type="primary" @click="getResult">查询</el-button>
				<el-button class="mo">重置</el-button>
				<el-table :data="tableData2" border style="width: 100%;margin-top:20px">
					<el-table-column prop="bankName" label="题库名称" width="180">
					</el-table-column>
					<el-table-column prop="createDate" label="创建日期" width="180">
					</el-table-column>
					<el-table-column prop="state" label="状态" width="100">
						<template slot-scope="scope">
							{{scope.row.state==0?"禁用":"启用"}}
						</template>
					</el-table-column>
					<el-table-column prop="quesCount" label="题库量" width="100">
					</el-table-column>
					<el-table-column prop="relateCourse" label="关联课程" width="150">
					</el-table-column>
					<el-table-column prop="relateTextbook" label="关联教材" width="150">
					</el-table-column>
					<el-table-column prop="relateChapter" label="关联章节" width="150">
					</el-table-column>
					<el-table-column fixed="right" label="操作" width="200">
						<template slot-scope="scope">
							<el-button @click="viewBank(scope.row)" type="text" size="small">查看</el-button>
							<el-button type="text" size="small">导出</el-button>
							<el-button type="text" size="small" @click="getstate(scope.row)">{{scope.row.state==0?"启用":"禁用"}}</el-button>

						</template>
					</el-table-column>

				</el-table>

				</el-pagination>
				<div class="block" style="margin-top:15px">
					<el-pagination background layout="total, prev, pager, next, sizes, jumper" :total="totalData" @size-change="handleSizeChange"
					 @current-change="getData_two" :current-page.sync="currentPage2" :page-sizes="[10, 20, 30, 40, 50, 60, 70, 80]"
					 :page-size="10">
					</el-pagination>
				</div>
			</el-tab-pane>

		</el-tabs>
	</div>
</template>
<script>
	// todo:启用与禁用的颜色变化
	import {
		getBuildingBank,
		getCompletedBank,
		doComplete,
		doEnable,
		doDisable
	} from "@/api/qsb.js"
	export default {
		created() {
			//调用函数
			this.getResult() //获取数据的函数
			this.getResult_two()
		},
		methods: {
			//1正在建设-分页功能
			getResult() {
				this.currentPage1 = 1
				this.getData()
			},
			//正在建设的数据请求
			getData() {
				//请求数据
				console.log(this.btn_canComplete, this.btn_bankName, this.btn_managerName, this.currentPage1);
				getBuildingBank({
					canComplete: this.btn_canComplete,
					bankName: this.btn_bankName,
					manager: this.btn_managerName,
					pageNum: this.currentPage1,
					pageSize: this.pagesizes
				}).then((res) => {
					console.log('-------------------------------')
					console.log(res.data.result['1'])
					this.tableData = res.data.result['1']
					this.totalData = res.data.totalRow
				}).catch((res) => {})
			},
			//2完成建设页面数据--分页
			getResult_two() {
				this.getData_two()
				this.currentPage2 = 1
			},
			//2完成建设的题库的请求
			getData_two() {
				console.log(this.btn_canComplete, this.btn_bankName, this.btn_managerName, this.currentPage2, this.pagesizes);
				getCompletedBank({
					canComplete: this.btn_canComplete,
					bankName: this.btn_bankName,
					manager: this.btn_managerName,
					pageNum: this.currentPage2,
					pageSize: this.pagesizes
				}).then((res) => {
					console.log('-------------------------------')
					console.log(res.data.result['1'])
					this.tableData2 = res.data.result['1']
					this.totalData = res.data.totalRow
				}).catch((res) => {})
			},
			//结项请求
			getdoComplete(row) {
				debugger
				console.log(row.bankId)
				doComplete(row.bankId).then((res) => {
					console.log('-------------------------------')
					this.getData()
					//console.log(res.data.result['1'])
					//this.tableData2=res.data.result['1']
				}).catch((res) => {})
			},
			//启用禁用按钮
			getstate(row) {
				if (row.state == 0) {
					doEnable(row.bankId).then((res) => {
						row.state = 1
						console.log('-------------------------------')
						//console.log(res.data.result['1'])
						//this.tableData2=res.data.result['1']
					}).catch((res) => {})
				} else {
					doDisable(row.bankId).then((res) => {
						row.state = 0
						console.log('-------------------------------')
						//console.log(res.data.result['1'])
						//this.tableData2=res.data.result['1']
					}).catch((res) => {})
				}
			},
			//查看
			viewBank(row) {
				console.log(row.bankId);
				this.$router.push({
					path: 'baseInfo',
					query: {
						bankId: row.bankId
					}
				})
			},
			//新建题库按钮
			createBank() {
				this.$router.push({
					path: 'baseInfo'
				})
			},
			handleClick(tab, event) {
				console.log(tab, event);
			},
			handleClick(row) {
				console.log(row);
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
			},
			handleCurrentChange(val) {
				console.log(`当前页: ${val}`);
			}
		},
		data() {
			return {
				options: '',
				currentPage1: 1,
				currentPage2: 1,
				btn_bankName: '',
				btn_managerName: '',
				activeName: 'second',
				btn_canComplete: 'false',
				pagesizes: 10,
				tableData: [],
				tableData2: [],
				totalData: 0
			}
		}
	}
</script>

<style scoped>
</style>
