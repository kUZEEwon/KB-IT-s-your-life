<template>
    <div id="bbsdetail">                
        <br/>
        <div class="center">
            <table class="table table-bordered">
                <col width="200"><col width="500">		
                <tr>
                    <th>작성자</th>
                    <td>{{ username }}</td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td>{{ title }}</td>
                </tr>
                <tr>
                    <th>작성일</th>
                    <td>{{ wdate }}</td>
                </tr>
                <tr>
                    <th>조회수</th>
                    <td>{{ readcount }}</td>
                </tr>		
                
                <tr>                    
                    <td colspan="2">
                        <textarea rows="15" cols="50" v-model="content" class="form-control"></textarea>
                    </td>
                </tr>
            </table>
            <br/>

            <button v-on:click="bbslist" class="btn btn-primary">글목록</button>&nbsp;  
            <button v-on:click="bbsanswer" class="btn btn-primary">답글달기</button>&nbsp;                               
            <button v-on:click="updatebbs" v-if="isShow" class="btn btn-primary">글수정</button>&nbsp;
            <button v-on:click="deletebbs" v-if="isShow" class="btn btn-primary">글삭제</button>&nbsp; 
            <br/><br/>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name:"bbsdetailComp",
    data(){
        return{
            seq: this.$route.params.seq,
            username: '',
            title: '',
            wdate: '',
            readcount: '',
            content: '',
            isShow: false
        }
    },
    async mounted(){      
        //alert(this.$route.params.seq);    

        await axios.post('http://localhost:9000/bbs/bbsdetail', 
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
            
            let username = sessionStorage.getItem("username");
            //let json = JSON.parse(login);
            //alert(username);
            
            // 작성자 == 로그인한 id
            if(this.username == username){
                this.isShow = true;
            }            
        }).catch(err=>{
            alert('error' + err);
        })

    },    
    methods:{   
        bbslist(){              // 함수를 추가 안하면 다음 태그가 실행되지 않는다  
            this.$router.push({ name: "bbslist" });
        },
        updatebbs(){                    
        },
        deletebbs(){
        },
        bbsanswer(){  
            this.$router.push({ name: "bbsanswer", params: { seq: this.seq } });          
        }
    }
}
</script>

<style scoped>
table{
	margin: auto;
	width: 800px;	
}
.center td{
    padding: 2px;
    text-align: left;
    padding: 10px;
}
</style>