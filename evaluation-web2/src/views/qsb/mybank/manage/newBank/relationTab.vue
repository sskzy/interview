<!-- 
	@Author: SongTC
	@E-mail: 690259811@qq.com
	@CreateTime: 2022/5/24 02:30
 -->
<template>
	<div>
		<el-row>
			<el-col :span='12'>
				<!-- 使用 rel_table控件并把数据向子控件传输 -->
				<rel_table :condition="condition" :name.sync='subjectName' :data.sync='subjects' type="subject">
				</rel_table>
			</el-col>
			<el-col :span='12'>
				<rel_table :condition="condition" :name.sync='abilityName' :data.sync='abilities' type="abilitie">
				</rel_table>
			</el-col>
		</el-row>
		<hr />
		<el-row v-if="condition!=3">
			<el-col :span="4" :offset="18">
				<el-button type="infor">取消</el-button>
				<el-button type="primary" @click="submit()">提交</el-button>
			</el-col>
		</el-row>
	</div>
</template>

<script>
	
	import rel_table from '@/components/manage/RelationTable.vue'
	import add_table from '@/components/manage/RelationTable_add.vue'
	import {
		getSubjectAbility,
		setSubjectAbility
	} from "@/api/qsb.js"
	export default {
		props: {
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
		components: {
			rel_table,
			add_table
		},
		mounted: function() {
			// 获取关联学科/能力
			getSubjectAbility(this.bankId).then((res) => {
				// 绑定rel-Table所需要的数据
				// console.log(res)
				//this.subjectName = res.data.subjectName
				this.subjects = res.data.subjects
				//this.abilityName = res.data.abilityName
				this.abilities = res.data.abilities
			}).catch((res) => {
				console.log(res)
			})
		},
		data() {

			return {
				subjectName: "学科",
				// rel-Table所需要数据
				//				subjectName: '',
				subjects: [],
				abilityName: '能力',
				abilities: [],
				
			}
		},
		methods: {
			submit: function() {
				setSubjectAbility(this.bankId,{
						subjects:this.subjects,
						abilities:this.abilities
					}).then((res) => {
					console.log("submit success")
				}).catch((res) => {
					console.log(res)
				});
			}
		}
	}
</script>

<style>
</style>
