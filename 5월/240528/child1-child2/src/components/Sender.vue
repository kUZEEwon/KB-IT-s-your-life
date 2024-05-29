<template>
    <div>
        <h3>Sender</h3>
        <button @click="sendMessage">이벤트를 발신해요.</button>
    </div>
</template>

<script>
export default{
    name:'Sender',
    methods:{
        sendMessage(){
            // this.emitter.emit('이벤트 이름', data); <- 데이터 전송
            this.emitter.emit("message", Date.now() + "에 발신한 메세지에요.");
        }
    }
}
</script>