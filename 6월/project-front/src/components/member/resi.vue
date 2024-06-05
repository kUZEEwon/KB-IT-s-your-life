<template>
    <div>
        <h3>회원 가입</h3>

        <table border="1">
            <tr>
                <td>아이디</td>
                <td>
                    <input v-model="id" placeholder="아이디 입력" size="20"/>
                    <p>{{ message }}</p>
                    <button @click="idcheck">중복확인</button>
                </td>
            </tr>
            <tr>
                <td>패스워드</td>
                <td>
                    <input type="password" v-model="pw" placeholder="패스워드입력" size="20"/>
                </td>
            </tr>
            <tr>
                <td>이름</td>
                <td>
                    <input v-model="name" placeholder="이름입력" size="20"/>
                </td>
            </tr>
            <tr>
                <td>이메일</td>
                <td>
                    <input v-model="email" placeholder="이메일입력" size="20"/>
                </td>
            </tr>

        </table>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    name:"resi",
    data(){
        return{
            id:null,
            pw:'',
            name:'',
            email:"",
            message:''  // 아이디 체크용
        }
    },
    methods:{
        idcheck(){

            let params= new URLSearchParams();
            params.append("id",this.id);
            axios.post("http://localhost:3000/idcheck",params)
                .then((res) => {
                    if(res.data.result == "NO"){
                        this.message="사용 중인 아이디입니다";
                        this.id='';
                    }
                    else{
                        this.message = "이 아이디는 사용가능합니다";
                    }
                })
                .catch((err) => {
                    alert(err);
                })
            
        }
    }
    
}
</script>
<style lang="">
    
</style>