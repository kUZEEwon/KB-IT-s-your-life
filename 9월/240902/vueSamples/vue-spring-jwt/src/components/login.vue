<template>
    <div id="login">
        <h1>login</h1>

        <table border="1">
            <tr>
                <td>아이디</td>
                <td>
                    <input v-model="username" placeholder="아이디 입력"/>
                </td>
            </tr>

            <tr>
                <td>비밀번호</td>
                <td>
                    <input v-model="password" placeholder="비밀번호 입력"/>
                </td>
            </tr>

            <tr>
                <td colspan="2">
                    <button @click="login">로그인</button>
                </td>
            </tr>
        </table>

        <br/>
        <input v-model="token" size="50"/>

        <br/><br/>

        <button @click="send">테스트 화면 이동</button>
    </div>
</template>
<script>
import axios from 'axios';


export default {
    name:'login',
    data() {
        return {
            username:'', // <- id
            password:'',
            token:''
        }
    },
    methods: {
        login: function() {
            axios.post("http://localhost:9000/login",  
           // axios.post("api/login",      // cors
                        null, 
                        { params: {username : this.username , password: this.password}})
                .then(resp => {
                    this.token = resp.data;
                })
                .catch(err => {
                    alert(err);
                })
        },
        send: function() { // 용량이 많이 큰 데이터는 비동기로 보내기(async await)
            // token 보내기
            let config = {
                headers : {
                    "Authorization" : 'Bearer ' + this.token,
                }
            }

            axios.post("http://localhost:9000/test", config)
           // axios.get("api/test", config)
                .then(resp => {
                    alert(resp.data);
                })
                .catch(err => {
                        alert(err);
                    })
        }
    }
}
</script>
<style>
#login {
    text-align: center;
}
table {
    margin: auto;
}
    
</style>