<template>
    <div>
        <h3>Child Component</h3>

        <button @click="emitCustomEvent">전송</button>
    </div>
</template>

<script>
export default{
    methods:{
        emitCustomEvent(){

            // 한개의 데이터만을 전송
            // this.$emit('send-message', "안녕 방가방가");

            // 다중 데이터
            this.$emit('send-message', { msg:"건강하세요", height:172.1 });

        }
    }
}

</script>