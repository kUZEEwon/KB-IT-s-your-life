<template>
    <div>
        <h1>Login</h1>

        <!-- login 화면 -->
        <table>
            <tr>
                <td>ID</td>
                <td>
                    <input v-model="id" placeholder="아이디입력" size="20"/>
                </td>
            </tr>
            <tr>
                <td>PW</td>
                <td>
                    <input type="password" v-model="pw" placeholder="패스워드입력" size="20"/>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button @click="login">log-in</button>
                    <a :href="'/regi'">회원가입</a>
                </td>
            </tr>
        </table>
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
        login(){

        }
    },
}
</script>