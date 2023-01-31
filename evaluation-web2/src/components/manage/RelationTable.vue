<!-- 
	@Author: SongTC
	@E-mail: 690259811@qq.com
	@CreateTime: 2022/5/24 02:30
 -->
<template>
	<div id="relTable">
		<el-container>
			<el-header height="30px">
				<el-row>
					<el-col id="span1" :span="4">
						<span>关联{{name}}</span>
					</el-col>
					<el-col id="span2" :span="6" :push="14" v-if="condition!=3">
						<el-button type="text" @click="dialogFormVisible = true" style="color: #001529;">
							&nbsp; 添加关联{{name}}
						</el-button>
						<!-- rel_table_add 的弹窗  -->
						<el-dialog title="" :visible.sync="dialogFormVisible" width="90%">
							<div slot="footer">
								<!-- 使用 rel_table_add控件 -->
								<rel_table_add :name="name" :type="type" @transmit="appendData">
								</rel_table_add>
							</div>
						</el-dialog>

					</el-col>
				</el-row>
			</el-header>
			<el-main>
				<el-row>
					<el-table :data="data" height="420" style="border:1px solid #000000;">
						<el-table-column :label="`关联${name}名称`" width="300" align="center">
							<template slot-scope="scope">
								{{scope.row.name1}}/{{scope.row.name2}}
							</template>
						</el-table-column>
						<el-table-column prop="" label="操作" width="200" align="center" v-if="condition!=3">
							<!--
								 @click.native 调用父组件
								 @click.native.prevent 调用父组件,阻止子组件默认事件(a标签的跳转事件,button的提交事件...)的发生
								 
								 <template slot="son" slot-scope="scope"> 
								 slot: 指定的插槽名称
								 slot-scope: 使用数据的变量名
								 
								 @click="removeData(scope.$index) 
								 scope.$index: 数据的下标
							 -->
							<el-link type="primary" slot-scope="scope" @click="removeData(scope.$index)" :underline="false">移除
							</el-link>
						</el-table-column>
					</el-table>
				</el-row>
			</el-main>
		</el-container>
	</div>
</template>

<script>
	import rel_table_add from '@/components/manage/RelationTable_add.vue'
	export default {
		name: "relationTable",
		components: {
			rel_table_add
		},
		/* 两个具体数据 两个要传入的地址 */
		props: {
			name: {
				type: String,
				defautl: "",
				requited: true
			},
			data: {
				type: Array,
				defautl: [],
				requited: true
			},
			type:{
				type: String,
				required: true
			},
			bankId: {
				type: String,
				default: "1234",
				requited: true
			},
			condition: {
				type: Number,
				default: 2,
				required: true
			}
		},
		data() {
			return {
				dialogFormVisible: false
			}
		},
		methods: {
			removeData: function(ind) {
				this.$confirm('此操作将永久删除该文件, 是否继续?', '提示', {
					confirmButtonText: '确定',
					cancelButtonText: '取消',
					type: 'warning'
				}).then(() => {
					// 使用splice方法删除下标为index的元素
					var i = this.data.splice(ind, 1);
					this.$message({
						type: 'success',
						message: '删除成功!'
					});
				}).catch(() => {
					this.$message({
						type: 'info',
						message: '已取消删除'
					});
				});
			},
			appendData(data) {
				let newData = data.concat(this.data) //追加data数组
				this.$emit("update:data", newData)
				this.dialogFormVisible = false //关闭弹窗
			}
		}
	}
</script>

<style scoped>
	#relTable {
		width: 500px;
		display: inline-block;
	}

	#span1 {
		line-height: 2.5;
	}

	#span2 {
		border: 1px dashed #909399;
		border-radius: 3px
	}
</style>
