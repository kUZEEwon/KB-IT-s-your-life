<template>
    <div class="Home">
        <h1>Home</h1>
        <img alt="" src="../assets/logo.png" />

        <br />

        <a href="/article/hi">Article로 이동(hi)</a>

        <br/><br/>

        <button @click="articleMove">Article로 이동(안녕)</button>

        <br/><br/>

        <button @click="InfoMove">Info로 이동</button>


    </div>
</template>

<script>
export default {
    name: 'Home',
    methods:{
        articleMove(){
            this.$router.push({ name:"article", params:{ msg:"안녕" } })
        },
        InfoMove(){
            this.$router.push({name:'info',params:{num:1, str:"I'm info page"} })
        }
    }
}
</script>

<style scoped>
.Home {
    background-color: rgba(21, 247, 247, 0.164);
}
</style>