<!-- 
	@Author: SongTC
	@E-mail: 690259811@qq.com
	@CreateTime: 2022/5/24 02:30
 -->
<template>
	<div>
		<el-container>
			<el-header>
				<el-row>
					<el-col :span='6'>一级{{name}}:
						<el-select v-model="searchValue.id1" filterable placeholder="请选择">
							<el-option v-for="item in list1" :key="item.id1" :label="item.name1" :value="item.id1">{{item.name}}
							</el-option>
						</el-select>
					</el-col>
					<el-col :span='6' :offset='12'>
						<el-button type="primary" @click="search()">查询</el-button>
						<el-button type="infor" @click='searchValue = ""'>重置</el-button>
					</el-col>
				</el-row>
			</el-header>

			<el-main>
				<!-- 
					指定 ref="elTable" 可通过 this.$refs.elTable.selection获取被选中的值
					list2.slice((currentPage-1)*pageSize,currentPage*pageSize) 
					数组对象.slice(起始页,结束页)
				 -->
				<el-table ref="elTable" :data="list2" style="width: 100%">
					<el-table-column type="selection" width="55">
					</el-table-column>
					<el-table-column prop="name2" label="关联课程">
					</el-table-column>
				</el-table>
				<div class="block" style="margin-top:15px;">

					<!-- 选择分页个数和跳页功能 -->
					<!--
					<el-pagination
						align='center' # 元素居中
						@size-change="handleSizeChange" # 每页条数改变时触发
						@current-change="handleCurrentChange" # 当前页改变时触发
						:current-page="currentPage" # 当前页数
						:page-sizes="[1,5,10,20]"  # 分页个数
						:page-size="pageSize" #每页个数
						layout="total, sizes, prev, pager, next, jumper" # 条数,下拉,往左,页码,往右,跳转 
						:total="list.length"> # 数组长度
					</el-pagination> 
					 -->
					<!--<el-pagination 
						align='center' 
						@size-change="handleSizeChange" 
						@current-change="handleCurrentChange"
						:current-page="currentPage" 
						:page-sizes="[1,5,10,20]" 
						:page-size="pageSize"
						layout="total, sizes, prev, pager, next, jumper" 
						:total="list2.length">
					</el-pagination>-->
					<el-pagination background layout="total, prev, pager, next, sizes, jumper" :total="total" @size-change="handleSizeChange"
					 @current-change="handleCurrentChange" :current-page.sync="currentPage" :page-sizes="[10, 20, 30, 40, 50, 60, 70, 80]"
					 :page-size.sync="pageSize">
					</el-pagination>

				</div>
			</el-main>
			<el-footer>
				<hr />
				<div>
					<el-button @click="unSubmit()">取 消</el-button>
					<el-button type="primary" @click="submit()">确 定</el-button>
				</div>
			</el-footer>
		</el-container>
	</div>
</template>

<script>
	import {
		getSubject1,
		getSubject2,
		getAbility1,
		getAbility2
	} from "@/api/qsb.js"
	export default {
		// 两个地址
		props: {
			type: {
				type: String,
				required: true
			},
			name: {
				type: String,
				defautl: "",
				requited: true
			},
		},
		// 获取一级菜单
		mounted: function() {
			let initData
			if (this.type == "subject") {
				initData = getSubject1()
			} else if (this.type == "abilitie") {
				initData = getAbility1()
			}
			initData.then((res) => {
				this.list1 = res.data.result['1'];
			}).catch((res) => {
				console.log(res)
			})
		},
		data() {
			return {
				searchValue: {
					id1: '',
					name1: ''
				},
				currentPage: 1, // 当前页码
				total: 20, // 总条数
				pageSize: 5, // 每页的数据条数
				list1: [],
				list2: [],

				//				list2: [{
				//					id2: "2001",
				//					name2: "本地数据1",
				//				}, {
				//					id2: "2002",
				//					name2: "本地数据2",
				//				}, {
				//					id2: "2003",
				//					name2: "本地数据3",
				//				}, {
				//					id2: "2004",
				//					name2: "本地数据4",
				//				}, {
				//					id2: "2005",
				//					name2: "本地数据5",
				//				}, {
				//					id2: "2006",
				//					name2: "本地数据6",
				//				}, {
				//					id2: "2007",
				//					name2: "本地数据7",
				//				}],
			}
		},
		methods: {
			selectChange(data) {
				this.searchValue.id1 = data.id1
				this.searchValue.name1 = data.name1
			},
			// 只是修改弹窗状态,不传入参数
			unSubmit: function() {
				this.$emit("transmit", []);
			},
			// 改变弹窗状态,并追加 被选中的数据
			submit: function() {
				this.$confirm('此操作将添加该文件, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					
					
					
					console.log(this.searchValue)
					for (let item of this.$refs.elTable.selection) {
						item.id1 = this.searchValue.id1
						this.list1.forEach((row)=>{
							if(row.id1 == this.searchValue.id1){
								item.name1 = row.name1
							}
						})
						
					}
					this.$emit('transmit', this.$refs.elTable.selection);
					this.$message({
						type: 'success',
						message: '添加成功!'
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消添加'
					});
				});
			},
			//每页条数改变时触发 选择一页显示多少行
			handleSizeChange(val) {
				this.currentPage = 1;
				this.pageSize = val;
				this.getData()
			},
			//当前页改变时触发 跳转其他页
			handleCurrentChange(val) {
				this.currentPage = val;
				this.getData()
			},
			// 使用一级菜单并传入指定id2 获取二级菜单
			search: function() {
				this.currentPage = 1
				this.getData()
			},
			getData: function() {
				let findData
				let params = {
					id1: this.searchValue.id1,
					pageNum: this.currentPage,
					pageSize: this.pageSize
				}
				if (this.type == "subject") {
					findData = getSubject2(params)
				} else if (this.type == "abilitie") {
					findData = getAbility2(params)
				}
				findData.then((res) => {
					this.list2 = res.data.result['1'];
					this.total = res.data.totalRow
				}).catch((res) => {
					console.log(res)
				})
			}
		}
	}
</script>

<style>
</style>
