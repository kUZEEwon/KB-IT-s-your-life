<template>
    <div id="bbsdetail">
        <h1 class="text-center">글보기</h1>
        <br/>
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8">
                    <table class="table table-bordered">
                        <col width="200">
                        <col width="500">
                        <tr>
                            <th class="text-center">작성자</th>
                            <td>{{ id }}</td>
                        </tr>
                        <tr>
                            <th class="text-center">제목</th>
                            <td>{{ title }}</td>
                        </tr>
                        <tr>
                            <th class="text-center">작성일</th>
                            <td>{{ wdate }}</td>
                        </tr>
                        <tr>
                            <th class="text-center">조회수</th>
                            <td>{{ readcount }}</td>
                        </tr>
                        <tr>
                            <td colspan="2">
                                <textarea rows="15" v-model="content" class="form-control"></textarea>
                            </td>
                        </tr>
                    </table>
                    <div class="text-center">
                        <button v-on:click="bbslist" class="btn btn-primary">글목록</button>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import axios from "axios";

export default {
    name: "bbsdetailComp",
    data() {
        return {
            seq: this.$route.params.seq,
            id: '',
            title: '',
            wdate: '',
            readcount: '',
            content: '',
            isShow: false
        }
    },
    mounted() {
        axios.get('http://localhost:3000/bbsdetail', {
            params: {
                seq: this.$route.params.seq
            }
        }).then(res => {
            var bbs = res.data;
            this.seq = bbs.seq;
            this.id = bbs.id;
            this.title = bbs.title;
            this.wdate = bbs.wdate;
            this.readcount = bbs.readcount;
            this.content = bbs.content;

            let login = localStorage.getItem("login");
            let json = JSON.parse(login);

            if (this.id == json[0].id) {
                this.isShow = true;
            }
        })

    },
    methods: {
        bbslist() {
            this.$router.push({ name: "bbslist" });
        }
    }
}
</script>

<style scoped>
textarea {
    width: 100%;
}

.btn-primary {
    margin-top: 20px;
}
</style>