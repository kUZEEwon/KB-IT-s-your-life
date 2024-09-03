<template>
    <div id="mar">
        <div id="login">
            <br />
            <h1>log-in</h1>
            <table class="table">
                <tr>
                    <th>아이디</th>
                    <td>
                        <input v-model="username" class="form-control" placeholder="아이디입력" size="20" />
                    </td>
                </tr>
                <tr>
                    <th>패스워드</th>
                    <td>
                        <input type="password" v-model="password" class="form-control" placeholder="패스워드입력" size="20" />
                    </td>
                </tr>

                <tr>
                    <td colspan="2"><input type="checkbox" v-model='sid' @click="saveId" />&nbsp;id저장<br /><br /></td>
                </tr>
            </table>

            <!-- <input type="checkbox" v-model='sid' @click="saveId" />&nbsp;id저장<br /><br /> -->

            <button v-on:click="login" class="btn btn-primary">login</button>&nbsp;&nbsp;&nbsp;&nbsp;
            <!-- <button @click='account()'>회원가입</button> -->
            <a :href="'/regi'">회원가입</a>

            <br /><br />
        </div>
    </div>
</template>

<script>
import { useCookies } from 'vue3-cookies';
const { cookies } = useCookies();

import axios from 'axios';

export default {
    name: 'login',
    data() {
        return {
            username: '',
            password: '',
            sid: false // id 저장할지 말지
        }
    },
    mounted() {
        // vue가 들어 왔을 때 제일 먼저 실행됨
        let userId = cookies.get('userId');
        if (userId != null) {
            this.sid = true;
            this.username = userId;
        } else {
            this.sid = false;
            this.username = "";
        }
    },
    methods: {
        saveId: function () {
            if (this.sid == false && this.username.trim() != "") {
                // id 저장
                cookies.set("userId", this.username);
            } else {
                // id 없애기
                cookies.remove("userId");
            }
        },

        login: function () {
            // backend와 연동해야 함
            let param = {
                params : {
                    username : this.username,
                    password : this.password
                }
            };

            axios.post("http://localhost:9000/member/login", null, param)
                .then(res => {
                    let login_msg = res.data;

                    if(login_msg === "NO_USER"){
                        alert('회원 정보를 찾을 수 없습니다.');
                        return;
                    } else if(login_msg === "WRONG_PASSWORD"){
                        alert('비밀번호를 확인해 주십시오.');
                        return;
                    } 

                    //  alert(login_msg);token

                    // login 성공시

                    // 1. 세션 스토리지 사용
                    sessionStorage.setItem("token", login_msg); // token 저장
                    sessionStorage.setItem("username", this.username);

                    this.$router.push('/');

                    // 2. 로컬 스토리지 사용


                })
                .catch(err => {
                    alert(err);
                })
        }
    },
}
</script>

<style>
#mar {
    /* 위아래 여백 */
    margin-top: 60px;
    margin-bottom: 60px;
}

#login {
    margin: 0 auto;
    width: 600px;
    border: 1px solid #9d9d9d;
    /* padding: 30px; */
    border-radius: 20px;
}

table {
    margin: auto;
    width: 400px;
    height: 140px;
}

tr {
    height: 30px;
}

th {
    width: 140px;
    vertical-align: middle;
}

.left {
    text-align: left;
}
</style>