<template>
    <div id="bbswrite">
        <br/>
        <div class="center">
            <table class="table table-bordered">
            <col width="150"><col width="500">
            <tr>
                <th>아이디</th>
                <td>
                    <input v-model="username" class="form-control" readonly>
                </td>
            </tr>	
            
            <tr>
                <th>제목</th>
                <td>
                    <input v-model="title" placeholder="제목을 입력" class="form-control">		
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="15" cols="50" v-model="content" class="form-control"></textarea>		
                </td>
            </tr>                
            </table>

            <button v-on:click="bbswrite" class="btn btn-primary">글쓰기</button>
        </div>
    </div>
</template>
<script>
import axios from "axios";

export default {
    name:"bbswriteComp",
    data(){
        return{                    
            username:'',
            title: '',
            content: ''            
        }
    }, 
    mounted(){
        this.username = sessionStorage.getItem("username");
    },
    methods:{
        bbswrite:function(){
            //alert("bbswrite()");
            //alert(sessionStorage.getItem("token"));
            axios.post('http://localhost:9000/bbs/bbswrite',  
                {
                    username: this.username,
                    title: this.title,
                    content: this.content
                },
                {
                    headers: { 
                        "Authorization": 'Bearer ' + sessionStorage.getItem("token")
                    }
                } 
            ).then(res => {
                //alert("통신성공");	   
                alert(res.data);
                
                if(res.data == 'YES'){
                    // bbs로 이동
                    this.$router.push({ name: "bbslist" });
                }else{
                    alert("추가되지 않았습니다");				   		
                }
            })
        }
    }
}
</script>
<style>
.center{
	margin: auto;
	width: 800px;
	text-align: center;
}
td{
    padding: 2px;    
}
th{	
	background: rgb(234, 235, 255);
    color: black;    
}
</style>