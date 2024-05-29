<template>
    <div>
        <span>{{ num }}</span>
        <div>
            <button @click="increment">증가</button>
            <button @click="decrement">감소</button>
        </div>
    </div>
</template>

<script>
    export default {
        data(){
            return {
                num: 0
            }
        },
        methods:{
            increment(){
                this.num++;
            },
            decrement(){
                this.num--;
            }
        }
    }
</script>