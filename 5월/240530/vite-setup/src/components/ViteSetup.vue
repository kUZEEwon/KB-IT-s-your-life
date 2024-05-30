<!-- setup 함수 실습 -->

<template>
    <div class="ViteSetup">
        <button @click="plus">{{ count }}</button>
    </div>
</template>

<script>

import {ref} from 'vue';

export default {
    name: "ViteSetup",
/*     data(){
        return{
            count:0
        }
    },
    methods: {
        plus(){this.count++;}
    }, */

    setup(){ // hook
        const count = ref(0);
        
        function plus(){
            count.value++;
        }

        return{
            count,plus  // 반환된 객체 속성
        }

    },
    mounted(){ // 1 번만 한다
        console.log(this.count);
    }
}

</script>
