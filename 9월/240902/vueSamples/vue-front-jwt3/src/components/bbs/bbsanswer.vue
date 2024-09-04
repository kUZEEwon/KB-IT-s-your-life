<template>
    <div id="bbsanswer">                
        <br/>        
        <div class="center">
            <table class="table table-bordered">
                <col width="200"><col width="500">		
                <tr>
                    <th>작성자</th>
                    <td class="left">{{ username }}</td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td class="left">{{ title }}</td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td class="left">{{ wdate }}</td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td class="left">{{ readcount }}</td>
                </tr>		
                
                <tr>                    
                    <td colspan="2">
                        <textarea rows="15" cols="50" v-model="content" class="form-control" readonly></textarea>
                    </td>
                </tr>
            </table>            
        </div>
        <br/>        
        <div class="center">
            <table class="table table-bordered">
            <col width="150"><col width="500">
            <tr>
                <th>아이디</th>
                <td>
                    <input v-model="answer_username" class="form-control" readonly>
                </td>
            </tr>	
            
            <tr>
                <th>제목</th>
                <td>
                    <input v-model="answer_title" placeholder="제목을 입력" class="form-control">		
                </td>
            </tr>
            <tr>
                <th>내용</th>
                <td>
                    <textarea rows="15" cols="50" v-model="answer_content" class="form-control" placeholder="내용을 입력"></textarea>		
                </td>
            </tr>                
            </table>

            <button v-on:click="bbsanswer" class="btn btn-primary">답글쓰기</button>
        </div>

    </div>
</template>

<script>
import axios from "axios";

export default {
    name:"bbsanswerComp",
    data(){
        return{
            seq: this.$route.params.seq,
            username: '',
            title: '',
            wdate: '',
            readcount: '',
            content: '',
            answer_username: sessionStorage.getItem("username"),
            answer_title: '',
            answer_content: ''
        }
    },
    mounted(){      
        //alert(this.$route.params.seq);    

        axios.post('http://localhost:9000/bbs/bbsdetail', 
            { 
                seq:this.$route.params.seq
            }, 
            {
                headers: { 
                    "Authorization": 'Bearer ' + sessionStorage.getItem("token")
                }
            } 
        ).then(res => {    	        
        //    alert("getbbs 통신성공");	   
            // alert(JSON.stringify(res.data)); 
            
            var bbs = res.data;		// 받아온 데이터를 삽입
            this.seq = bbs.seq;
            this.username = bbs.username;
            this.title = bbs.title;
            this.wdate = bbs.wdate;
            this.readcount = bbs.readcount;
            this.content = bbs.content;                         
        }).catch(err=>{
            alert('error' + err);
        })

    },    
    methods:{   
        bbsanswer:function(){

            axios.post('http://localhost:9000/bbs/bbsanswer',  
                {
                    seq: this.seq,
                    username: this.answer_username,
                    title: this.answer_title,
                    content: this.answer_content
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
            }).catch(err=>{
                alert('error' + err);
            })

        }
    }
}
</script>

<style>
.left{
    text-align: left;
}
</style>