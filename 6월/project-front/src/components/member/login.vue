<template>
    <div>
        <h1>log-in</h1>

        <table class="table">
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
                <button v-on:click="login" class="btn btn-primary">log-in</button>
                <a :href="'/regi'">회원가입</a>
            </td>
        </tr>
        </table>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    name: "login",
    data(){
        return{
            id:"",
            pw:""
        }
    },
    methods:{
        login(){
            // id, pw 의 빈칸을 검사

            axios.post("http://localhost:3000/login", { "id":this.id, "pw":this.pw })
                .then(res=>{
                    // alert(JSON.stringify(res.data));
                    // alert(res.data.id);

                    if(res.data.id === undefined){
                        alert('id나 패스워드가 틀렸습니다');
                        return;
                    }

                    //alert(res.data.id + "님 환영합니다");                                       
                    localStorage.setItem("login", JSON.stringify(res.data));

                    // 게시판으로 이동
                    this.$router.push('/bbslist');
                })
                .catch(err=>alert(err));            

        }
    }
}
</script>
<style scoped>
.center{
	margin: auto;
	width: 800px;
	text-align: center;
}
input{
    width: 200px;
}
td{
    padding: 2px;       
    height: 50px;
    width: 50px;
}


</style>