import manage from '@/views/qsb/mybank/manage/index.vue'


export default [
	{
	   path:'mybank',
	   name:'我的题库',
	   component:() => import('@/views/qsb/mybank/index.vue'),
	   children:[
		   {
		      path:'manage',
		      name:'我管理的题库',
		      component:manage,
			  children:[
				
				{
					path:'eventLog',
					name:'事件日志',
					component:() => import('@/views/qsb/mybank/manage/newBank/eventLog.vue'),
				}					
			  ]
		   },
		   {
		   	path:'baseInfo',
		   	name:'新建题库',	
		   	component:() => import('@/views/qsb/mybank/manage/newBank/baseInfo.vue'),
		   },
	   ]
	},
]