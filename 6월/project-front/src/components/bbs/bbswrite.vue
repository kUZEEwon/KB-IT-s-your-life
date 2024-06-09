<template>
    <div>
        <h2>글작성</h2>

        <table class="table table-bordered">
        <col width="150"/><col width="500"/>    
        <tr>
            <th>아이디</th>
            <td>
                <input v-model="id" class="form-control" readonly/>
            </td>
        </tr>
        <tr>
            <th>제목</th>
            <td>
                <input v-model="title" class="form-control" placeholder="제목을 입력" />
            </td>
        </tr>
        <tr>
            <th>내용</th>
            <td>
                <textarea rows="15" cols="50" v-model="content" class="form-control"></textarea>
            </td>
        </tr>
        </table>
        <br/>
        <button @click="bbswrite" class="btn btn-primary">글쓰기</button>
    </div>
</template>
<script>
import axios from "axios";

export default {
    name:"bbswriteComp",
    data(){
        return{
            id:"",
            title:"",
            content:""
        }
    },
    mounted(){
        const login = JSON.parse(localStorage.getItem("login"));
        this.id = login.id;
    },
    methods:{
        bbswrite(){
            axios.get("http://localhost:3000/bbswrite", 
                { params:{ "id":this.id, "title":this.title, "content":this.content } })
                .then(res=>{
                    alert("글 올리기 성공");

                    if(res.data === "OK"){
                        this.$router.push({ name:"bbslist" });
                    }else{
                        alert('추가되지 않았습니다');
                    }
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
td{
    padding: 2px;       
    height: 50px;
}
th{	
	background: rgb(234, 235, 255);
    color: black;    
}
</style>