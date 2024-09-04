<template>
    <div id="bbslist">
        <br /><br />

        <table class="table table-hover">
            <colgroup>
                <col width="50"/>
                <col width="500"/>
                <col width="50"/>
                <col width="50"/>
            </colgroup>
            <thead>
                <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>조회수</th>
                    <th>작성자</th>
                </tr>
            </thead>

            <tbody v-for="(data, index) in bbslist" v-bind:key="data">
                <tr>
                    <td>{{ index + 1 }}</td>

                    <td @click="bbsdetail(data.seq)" align="left">
                        <!-- 댓글의 여백 -->
                        <span v-for="(d, idx) in Number(data.depth)" :key="idx">
                            &nbsp;&nbsp;&nbsp;&nbsp;
                        </span>

                        <!-- 댓글이미지 -->
                        <img v-if="data.depth > 0" src="../../assets/arrow.png" width="20px" height="20px" />

                        {{ data.title }}
                    </td>

                    <td>{{ data.readcount }}</td>
                    <td>{{ data.username }}</td>
                </tr>
            </tbody>
        </table>

        <br />
        <!-- paging -->
        <div class="overflow-auto">
            <b-pagination v-model="pageNumber" :total-rows="cnt" :per-page="10" align="center"
                @page-click="pageClick" aria-controls="my-table">
            </b-pagination>
        </div>

        <br />

        <!-- 검색 -->
        <div class="d-flex justify-content-center align-items-center">
            <!-- 검색선택 -->
            <select v-model="category" class="form-select" style="width: auto">
                <option v-for="(option, idx) in options" v-bind:value="option.value" v-bind:key="idx">
                    {{ option.text }}
                </option>
            </select>&nbsp;

            <!-- 검색창 -->
            <div class="col-sm-3 my-1" style="width: auto">
                <input v-model="keyword" placeholder="검색어입력" class="form-control" />
            </div>
            &nbsp;

            <!-- 검색버튼 -->
            <button v-on:click="searchBbs()" class="btn btn-primary">검색</button>
        </div>

        <br />
        <button v-on:click="writeBbs()" class="btn btn-primary">글추가</button>
        <br /><br />


    </div>
</template>

<script>
import axios from "axios";

export default {
    name: 'bbslist',
    data() {
        return {
            bbslist: [],
            category: '',
            keyword: '',
            options: [
                { text: "선택", value: "sel" },
                { text: "제목", value: "title" },
                { text: "내용", value: "content" },
                { text: "작성자", value: "writer" },
            ],
            pageNumber: 1,
            cnt: 0      // 글의 총수
        }
    },
    mounted() {
        this.getBbsList();
    },
    methods: {
        getBbsList() {

            let param = {
                category: this.category,
                keyword: this.keyword,
                pageNumber: this.pageNumber - 1
            };

            let auth = {
                headers: {
                    "Authorization": "Bearer " + sessionStorage.getItem("token")
                }
            }

            // 글목록 취득
            axios.post("http://localhost:9000/bbs/bbsList", param, auth)
                .then(res => {

                    // 토큰 만료
                    if (res.data === "EXPIRED_TOKEN") {
                        alert('토큰이 만료되었습니다 로그인 해 주십시오');

                        sessionStorage.setItem("username", "");
                        this.$router.push({ name: "login" });
                    }

                    this.bbslist = res.data.bbslist;
                    this.cnt = res.data.cnt;
                })
                .catch(err => {
                    alert(err);
                })
        },
        // 검색 함수
        searchBbs() {            
            this.pageNumber = 1;
            this.getBbsList();
        },

        // 페이지를 클릭
        pageClick: function (button, page) {
            // alert(page);
            this.pageNumber = page;
            this.getBbsList();
        },

        // 글 추가 view로 이동
        writeBbs() {
            // alert("글추가");
            this.$router.push({ name: "bbswrite" });
        },

        bbsdetail: function (seq) {
            //    alert(seq);      
            this.$router.push({ name: "bbsdetail", params: { seq: seq } });
        },
    }
}
</script>

<style>
#bbslist {
    margin: 0 auto;
    width: 1400px;
}
</style>