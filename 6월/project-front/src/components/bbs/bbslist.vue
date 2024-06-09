<template lang="">
    <div>
        <h1>게시판</h1>

        <br/><br/>
        <div class="d-flex justify-content-center align-items-center">
            <select v-model="choice" class="form-select" style="width: auto">
                <option v-for="(op, idx) in options"
                        v-bind:value="op.value"
                        v-bind:key="idx">
                    {{ op.text }}
                </option>
            </select>&nbsp;

            <div class="col-sm-3 my-1" style="width: auto">
                <input v-model="search" placeholder="검색어" class="form-control"/>
            </div>&nbsp;

            <button @click="searchBbs" class="btn btn-primary">검색</button>
        </div>

        <br/><br/><br/>

        <div>
            <table class="table table-hover">
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성자</th>
                </tr>
            </thead>

            <tbody>
                <tr v-for="(bbs, index) in bbslist" :key="index">
                    <td>{{ index + 1 }}</td>
                    <td @click="detailBbs(bbs.seq)" align="left">
                        {{ bbs.title }}
                    </td>
                    <td>{{ bbs.readcount }}</td>
                    <td>{{ bbs.id }}</td>
                </tr>
            </tbody>

            </table>
        </div> 

        <br/><br/>

        <button @click="writeBbs">글쓰기</button>
        
    </div>
</template>

<script>
import axios from 'axios';

export default {
    name:"bbslistComp",
    data(){
        return{
            bbslist:[],
            search:"",
            choice:"sel",
            options:[
                { text:"선택", value:"sel" },
                { text:"제목", value:"title" },
                { text:"내용", value:"content" },
                { text:"작성자", value:"writer" },
            ]
        }
    },
    mounted(){
        this.getBbslist();
    },  
    methods:{
        getBbslist(){
            axios.get("http://localhost:3000/bbslist", { params:{ "search":this.search, "choice":this.choice } })
                .then(res=>{
                    //alert(res.data);
                    this.bbslist = res.data;
                })
                .catch(err=>alert(err));
        },
        searchBbs(){
            this.getBbslist();
        },
        writeBbs(){
            this.$router.push({ name:"bbswrite" });
        },
        detailBbs(seq){            
            this.$router.push({ name: "bbsdetail", params: { seq: seq } });
        }
    }
}
</script>

<style scoped>
table {
  margin: auto;
  width: 1000px;
  height: 140px;  
}
tr {
  height: 40px;
}
</style>