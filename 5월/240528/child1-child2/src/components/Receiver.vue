<template>
    <div>
        <h3>Receiver</h3>

        <h2>받은 메시지: {{ recMsg }}</h2>
    </div>
</template>

<script>
export default {
    name:"Receiver",
    data(){
        return{
            recMsg:'',
        }
    },

    created()
    {
        // 시작되자 마자 호출됨
        this.emitter.on("message",this.receiveHandler);
    },
    methods:{
        receiveHandler(msg){
            this.recMsg = msg;
        }
    }

}
</script>