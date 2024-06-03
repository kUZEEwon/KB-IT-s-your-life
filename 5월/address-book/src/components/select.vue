<template>
    <div class="container mt-3">
        <h3 class="mb-3">지인검색</h3>

        <div class="input-group mb-3">
            <input v-model="name" class="form-control" placeholder="이름을 입력하세요" />
            <div class="input-group-append">
                <button @click="search" class="btn btn-primary">검색</button>
            </div>
        </div>

        <br />

        <table class="table table-bordered">
            <thead class="thead-light">
                <tr class="table-info">
                    <th>이름</th>
                    <th>나이</th>
                    <th>전화번호</th>
                    <th>주소</th>
                    <th>메모</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(mem, i) in member" :key="i">
                    <td>{{ mem.name }}</td>
                    <td>{{ mem.age }}</td>
                    <td>{{ mem.phone }}</td>
                    <td>{{ mem.address }}</td>
                    <td>{{ mem.memo }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script>
export default {
    name: "select",
    data() {
        return {
            member: []
        }
    },
    methods: {
        search() {
            let url = "http://localhost:3000/memberSelect";

            let params = {
                "name": this.name
            }

            const options = {
                method: 'POST',
                body: JSON.stringify(params),
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            fetch(url, options)
                .then((res) => res.json())
                .then((json) => {
                    console.log(json);
                    this.member = json.result; // 변경된 부분
                })
                .catch(err => console.log(err));
        }
    }
}
</script>
