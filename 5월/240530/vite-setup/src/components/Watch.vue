

<!-- 
    Watch : 데이터의 변화를 감지해서 자동으로 특정 처리를 수행하는 속성
            == useEffect
-->


<template>
    <h3>{{ count }}</h3>
    <button @click="increment">증가</button>
</template>

<script>
export default {
    data(){
        return{
            count : 0
        }
    },
    methods:{
        increment(){
            this.count++;
        }
    },
    watch:{
        count:function(value, oldValue){ // count 값이 변경될 때마다 함수 호출
            console.log("watch count : ", value);
        }
    }

}
</script>