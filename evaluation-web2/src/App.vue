<template>
  <div id="app">
    <router-view/>
  </div>
</template>

<script>
	export default {
	    name: "App",
	    created(){
			//在页面加载时读取localStorage里的状态信息
			// if(sessionStorage.getItem("userState")){
			// 	this.$store.replaceState(Object.assign(this.$store.state,JSON.parse(sessionStorage.getItem("userState"))));
			// }
			// window.addEventListener("beforeunload",()=>{
			// 	sessionStorage.setItem("userState",JSON.stringify(this.$store.state))
			// })
		}
	}
</script>

<style lang="stylus">
#app
  font-family Avenir, Helvetica, Arial, sans-serif
  -webkit-font-smoothing antialiased
  -moz-osx-font-smoothing grayscale
  color #2c3e50
</style>
