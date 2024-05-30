<!-- ref -->
<template>
    <button @click="increment">숫자 : <b>{{ count.num }}</b></button>
</template>

<script setup>
import {ref, onMounted} from 'vue';

const count = ref({ num:0, message:"hello" }); // 특정 변수를 보호한다는 개념도 존재함

function increment(){
    count.value.num++;
}

onMounted(() => {
    console.log(`숫자의 초기값은 ${ count.value.num } 입니다.`);
})
</script> 


<!-- reactive -->
<!-- <template>
    <button @click="increment">숫자 : {{ count.num }}</button>
</template>
<script setup>
    import {reactive, onMounted} from 'vue';

const count = reactive({ num:0, message:"hello" });  // 다수의 데이터(객체)

function increment(){
    count.num++;
}

onMounted(() => {
    console.log(`숫자의 초기값은 ${ count.num } 입니다.`);
})
</script> -->