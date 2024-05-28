<template>
    <div>
        <h2>Parent Component</h2>

        <input v-model="message" placeholder="입력"/>
        <button @click="updateMsg">click</button>

        <ChildComp v-bind:propsdata="sendMsg" />
    </div>
</template>

<script>

import ChildComp from "./childComp.vue";

export default{
    name:'parentComp',
    components: { ChildComp },
    data(){
        return{
            message:'',
            sendMsg:'부모컴퍼넌트에서 전달할 메시지'
        }
    },
    methods:{
        updateMsg(){
            this.sendMsg = this.message;
        }
    }
}


</script>