<template>
    <h3>{{ count }}</h3>
    <button @click="increment">++</button>
</template>

<script>
export default {
    data(){
        return{
            count:0,
        }
    },
    methods:{
        increment(){
            this.count++;
        }
    },
    mounted(){
        console.log(this.count);
    }
}
</script>
