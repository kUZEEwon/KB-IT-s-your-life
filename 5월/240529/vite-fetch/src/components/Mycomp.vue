<template>
    <div>
        <h1>Members</h1>
        <div v-if="loading">Loading...</div>
        <div v-else>
            <table border="1">
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>Name</th>
                        <th>Email</th>
                        <th>Phone</th>
                    </tr>
                </thead>
                <tbody>
                    <tr v-for="(user,index) in members.slice(0,3)" :key="user.id">
                        <td>{{ index }}</td>
                        <td>{{ user.name }}</td>
                        <td>{{ user.email }}</td>
                        <td>{{ user.phone }}</td>
                    </tr>
                </tbody>
            </table>
        </div>
    </div>
</template>
<script>

export default {
    name: "Mycomp",
    data() {
        return {
            members: [],
            loading: true,
        };
    },
    created() {
        // 비동기 통신
        let url = "https://jsonplaceholder.typicode.com/users/";
        /**
         * fetch( url, { method, headers } )
         *      .then((response) => {})     // 성공여부
         *      .then((json) => {})         // 넘어온 데이터
         *      .catch((error) => {})       // 예외 처리
         */

        fetch(url, { method: "GET", headers: { 'Content-Type': 'application/json' } })
            .then((response) => {
                if (response.ok) {
                    console.log(`response OK`);
                    return response.json();
                }
                throw new Error("Network")
            })
            .then((json) => { // 넘어온 데이터를 받는다.
                this.members = json;
                this.loading = false;
                console.log(json);
            })
            .catch(err => {
                console.log("error: ", err);
            });
    },
}
</script>
<style>
table {
    width: 100%;
    border-collapse: collapse;
}

th,
td {
    border: 1px solid #ddd;
    padding: 8px;
}

th {
    background-color: #f2f2f2;
    text-align: center;
}

tr:hover {
    background-color: #ddd;
}
</style>