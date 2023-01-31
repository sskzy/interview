<template>
	<div>
		<el-form ref="form" :model="form" label-width="60px">
			<div class="main">
				<el-form-item label="操作人:">
					<el-input v-model="form.operator" placeholder="请输入"></el-input>
					<el-button type="primary" @click="search">查询</el-button>
					<el-button @click="reset">重置</el-button>
				</el-form-item>
			</div>
		</el-form>

		<el-table :data="tableData" style="width: 100%">
			<el-table-column prop="createDate" label="创建日期" width="180"></el-table-column>
			<el-table-column prop="operator" label="操作人" width="180"></el-table-column>
			<el-table-column prop="log" label="日志列表"></el-table-column>
		</el-table>
		<div class="block">
			<el-pagination @size-change="handleSizeChange" @current-change="handleCurrentChange" :current-page.sync="pageNum"
			 background layout="total, sizes, prev, pager, next, jumper" :page-size.sync="pageSize" :total="totalRow">
			</el-pagination>
		</div>
	</div>
</template>

<script>
	import {
		getEventLog
	} from "@/api/qsb.js"
	export default {
		name: 'eventLog',
		data() {
			return {
				activeName1: 'third',
				activeName2: 'four',
				tableData: [],
				pageNum: 1,
				pageSize: 10,
				totalRow: 10,
				form: {
					operator: '',
					region: '',
					date: '',
					delivery: false,
					type: [],
					yesOrno: [],
					resource: '',
					desc: '',
					course: '',
					book: '',
					range: '',
					purpose: '',
					// num: ''
				},
			}
		},
		methods: {
			search() {
				this.pageNum = 1
				this.select()
			},
			select: function() {
				console.log('submit!');
				console.log(this.form.operator, this.pageNum, this.pageSize);
				getEventLog(this.bankId,{
						operator: this.form.operator,
						pageNum: this.pageNum,
						pageSize: this.pageSize
					}
				).then((res) => {
					this.tableData = res.data.result['1']
					this.totalRow = res.data.totalRow
					console.log('submit success!')
				}).catch((res) => {
					console.log(res)
				});
			},
			handleSizeChange(val) {
				console.log(`每页 ${val} 条`);
			},
			handleCurrentChange() {
				this.select()
			},
			//重置
			reset() {
				this.form.operator = ''
				// this.select()
				// this.handleCurrentChange()
			}
		},
		created() {
			this.select();
			// this.handleCurrentChange();
		}
		// created: function(){
		//      this.$axios.get('/v1/ques-banks/' + ".*?" + '/part4' + ".*").then(res=>{
		//        console.log(res)
		//        this.tableData = res.data.result['1']
		//      })
		//    },
	};
</script>

<style>
	/* .el-table__header {
		border: 1px solid #EBEEF5;
		border-bottom: none;
	}
	.el-table th.el-table__cell {
		background: #F9F9F9 !important;
	}
	.el-table thead {
		color: #000000 !important;
	}
	.cell {
		padding-left: 65px !important;
	}
	.el-table .el-table__cell {
		height: 60px;
	} */
	.main .el-input__inner {
		width: 200px !important;
	}

	.main .el-input {
		width: 26% !important;
	}
</style>
