<template>
    <el-container>
        <el-header>Header</el-header>
        <el-container>
            <el-aside class="aside" width="200px">
                <pe-menu :menuList="menuList"></pe-menu>
            </el-aside>
            <el-main class="main_container">
                <el-breadcrumb class="breadcrumb" separator="/">
                    <el-breadcrumb-item v-for="item in navList" :key="item.path">{{ item.name }}</el-breadcrumb-item>
                </el-breadcrumb>
				<div class="work_area">
					<el-scrollbar style="height:100%">
						<router-view></router-view>
					</el-scrollbar>
				</div>
            </el-main>
        </el-container>
    </el-container>
</template>

<script>
import PeMenu from "@/views/layout/components/PeMenu";
export default {
    name: "index",
    components:{
        PeMenu
    },
    data(){
        return {
            // menuList:[],    // 树形结构：{"path": "/func1", "title": "功能1" "children":[]} 菜单项所对应的路由路径 ,菜单项名称，是否有子菜单，若没有，则为[]
			menuList:[{"path": "/path1", "title": "我的资源管理", "children":[
						{"path": "/path1-1", "title": "待完成的事项", "children":[]},
						{"path": "/path1-2", "title": "我的操作记录", "children":[]}
			]},
					{"path": "/path2", "title": "我的审核管理", "children":[
						{"path": "/path2-1", "title": "待审核事项", "children":[]},
						{"path": "/path2-2", "title": "已审核事项", "children":[]}
					]},
						{"path": "/mybank", "title": "我的题库", "children":[
							{"path": "/mybank/manage", "title": "我管理的题库", "children":[]},
							{"path": "/path3-2", "title": "我参与的题库", "children":[]},
							{"path": "/path3-3", "title": "我关注的题库", "children":[]},
						]},
						{"path": "/path4", "title": "我的问题与评论", "children":[
							{"path": "/path4-1", "title": "待处理的问题", "children":[]},
							{"path": "/path4-2", "title": "我提出的问题", "children":[]},
						]},
						{"path": "/path5", "title": "题目查阅（高级）", "children":[]},
						{"path": "/path6", "title": "题库管理（高级）", "children":[]},
						{"path": "/path7", "title": "题库建设分析统计", "children":[]},],
        }
    },
	computed:{
		navList:function(){
			let nav = this.$route.matched.slice(0,4)
			return nav
		}
	}
}
</script>

<style scoped>
	.aside{
		background-color: #001529;
		height: calc(100vh - 60px);
	}
	.main_container {
		padding: 0;
		background-color: #f0f2f5;
		display: flex;
		flex-direction: column;
		
	}
	.breadcrumb {
		height: 60px;
		display: flex;
		align-items: center;
		padding-left: 20px;
		border-bottom: 1px solid #E9E9E9;
		background-color: #ffffff;
	}
	.work_area {
		flex-grow: 1;
		margin: 20px;
		background-color: #ffffff;
		border-radius: 4px;
		height: 100px;
		overflow: auto;
		padding: 20px;
	}

</style>
<style>
	.work_area .el-scrollbar__wrap {
	  overflow-x: hidden;
	}
	.work_area .el-scrollbar {
		position: static;
	}
</style>