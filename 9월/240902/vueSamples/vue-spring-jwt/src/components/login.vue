<template>
    <div id="login">
        <h1>login</h1>

        <table border="1">
            <tr>
                <td>id</td>
                <td>
                    <input v-model="username" placeholder="아이디입력" />
                </td>
            </tr>
            <tr>
                <td>password</td>
                <td>
                    <input v-model="password" placeholder="패스워드입력" />
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <button @click="login">login</button>
                </td>
            </tr>
        </table>

        <br />

        <input v-model="token" size="50" />
        <br /><br />
        <button @click="send">test</button>

    </div>
</template>

<script>
import axios from 'axios';

export default {
    name: 'login',
    data() {
        return {
            username: '',
            password: '',
            token: ''
        }
    },
    methods: {
        login: function () {

            axios.post("http://localhost:9000/login",
                null,
                { params: { username: this.username, password: this.password } })
                .then(resp => {
                    //alert(resp.data);

                    this.token = resp.data;
                })
                .catch(err => {
                    alert(err);
                })
        },
        send: function () {

            // 토큰 보내기
            let config = {
                headers: {
                    "Authorization": 'Bearer ' + this.token
                }
                /*   , get 일때는 묶어서 보내면 됨
                  params: { username : this.username } */

            }

            let param = { username: this.username }

            axios.post('http://localhost:9000/test', param, config)
                .then(resp => {
                    alert(resp.data);
                })
                .catch(err => {
                    alert(err);
                });

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