<template>
    <div>
        <h1>This id an about page</h1>
        <p>Welcome</p>

        <button v-on:click="move">Home으로 이동</button>

        <br/><br/>

        <a :href="'/'">Home으로 이동(anchor)</a>

    </div>
</template>
<script>
export default {
    name: 'About',
    methods: {
        move(){
            this.$router.push("/");
        }
    },
}
</script>
<style scoped>

</style>