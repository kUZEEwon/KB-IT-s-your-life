<template>
    <div id="hello">
        <h1>{{ name }}</h1>
        <br/>
        <button @click="myfunc">클릭</button>
    </div>
</template>

<script>
export default {
    name:"hello",
    data() {
        return {
            name:'I am vue'     // 변수선언
        }
    },
    methods: {
        myfunc:function() {
            alert('myfunc');            
        }
    },
}
</script>

<style>
    
</style>