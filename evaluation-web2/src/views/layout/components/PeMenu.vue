<template>
    <div>
        <el-menu
            router
            unique-opened
			background-color="#001529"
			text-color="#a5acb3"
			class="menu">
            <pe-menu-item v-for="menu in menuList" :key="menu.path" :item="menu" />
        </el-menu>
    </div>
</template>

<script>
import PeMenuItem from "@/views/layout/components/PeMenuItem";
import utils from "@/utils/utils.js"
export default {
    name: "PeMenu",
    components: {
        PeMenuItem
    },
    props:{
        menuList:{
            type: Array,
            required: true
        }
    },
    data(){
        return{}
    },
    methods:{
        // handleSelect(index,indexPath){
        //     let i = 0
        //     utils.createNav(indexPath,this.menuList,i,[])
        // },
        
    }
}
</script>

<style scoped>
	.menu.el-menu{
		border-right: none;
	}
</style>