<template>
    <div id="regi">
        <table class="table">
        <tr>
            <th>아이디</th>
            <td>
                <div class="row g-3 align-items-center">
                    <div class="col-auto">
                        <input v-model="username" class="form-control" aria-describedby="passwordHelpInline" placeholder="아이디입력">
                        
                    </div>
                    <div class="col-auto">                        
                        <button v-on:click="idcheck" class="btn btn-primary">중복확인</button> 
                    </div>
                    <div class="col-auto">
                        <span class="form-text">
                            {{ idmsg }}
                        </span>
                    </div>
                </div> 
            </td>
        </tr>
        <tr>
            <th>패스워드</th>
            <td>
                <input v-model="password" class="form-control" placeholder="패스워드입력" size="20">
            </td>
        </tr>
        <tr>
            <th>이름</th>
            <td>
                <input v-model="name" class="form-control" placeholder="이름입력" size="20">
            </td>
        </tr>
        <tr>
            <th>이메일</th>
            <td>
                <input v-model="email" class="form-control" placeholder="이메일입력" size="20">
            </td>
        </tr> 
        </table>
        <br/>
        <button class="btn btn-primary" v-on:click="regi">회원가입</button>
        <br/><br/>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name:'regi',
    data(){
        return{
            username:'',
            password:'',
            name:'',
            email:'',
            idmsg:''
        }
    },
    methods:{
        idcheck:function(){
            axios.post("http://localhost:9000/member/idCheck", null, { params:{ username:this.username }})
                 .then(res=>{
                    //alert('통신성공');
                    //alert(res.data);

                    if(res.data === "NO"){
                        this.idmsg = "사용중인 아이디입니다";
                        this.username = '';
                    }else{
                        this.idmsg = "이 아이디는 사용할 수 있습니다";
                    }

                 })
                 .catch(err=>{
                    alert(err);
                 })
        },
        regi:function(){

            let param = {
                params:{
                    username:this.username,
                    password:this.password,
                    name:this.name,
                    email:this.email
                }
            };

            axios.post("http://localhost:9000/member/regi", null, param)
                .then(res=>{
                    alert(res.data);
                    if(res.data === "YES"){
                        alert('가입을 환영합니다');

                        this.$router.push({ name:'login' });

                    }else{
                        alert('가입되지 않았습니다');
                    }
                })
                .catch(err=>{
                    alert(err);
                })

        }
    }
}
</script>

<style>
#regi{
	margin: auto;
	margin-top: 60px;
	width: 600px;
	/* border: 1px solid #848484; */
	padding: 30px;
}
table{
    margin: auto;
    width: 600px;
    height: 140px;
}
/* tr{
    height: 30px;
} */
th{
    width: 140px;
    vertical-align: middle;
}    
</style>