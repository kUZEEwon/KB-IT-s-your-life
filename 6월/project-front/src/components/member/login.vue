<template>
    <div>
        <h1>Login</h1>

        <!-- login 화면 -->
        <label>아이디</label>
        <input v-model="id"/>
        <br/>
        <label>비밀번호</label>
        <input v-model="pw"/>
        <br/>
        <button>login</button>
    </div>
</template>

<script>
export default {
    name:"login",
    data(){
        return{
            id:"",
            pw:""
        }
    },
    methods: {
        
    },
}
</script>