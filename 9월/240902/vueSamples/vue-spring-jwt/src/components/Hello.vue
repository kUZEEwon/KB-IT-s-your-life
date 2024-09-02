<template>
    <div id="hello">
        <h1>{{ name }}</h1>

        <br/>
        <button v-on:click="myfunc">클릭</button>
    </div>
</template>

<script>
export default {
    name : "hello",
    data() {
        return{
            name : 'I am VUE' // 변수 선언
        }
    },
    methods: {
        myfunc: function(){
            console.log('myfunc 호출');
        }
    },
}
</script>
<style >
    
</style>