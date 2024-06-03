
<template>
    <div class="container mt-3">
        <h3>지인추가</h3>

        <br />
        <div class="table-responsive">
            <table class="table">
                <colgroup>
                    <col width="150">
                    <col width="500">
                </colgroup>
                <tbody>
                    <tr>
                        <th>이름</th>
                        <td>
                            <input v-model="name" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <th>나이</th>
                        <td>
                            <input v-model="age" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <th>전화번호</th>
                        <td>
                            <input v-model="phone" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <th>주소</th>
                        <td>
                            <input v-model="address" class="form-control" />
                        </td>
                    </tr>
                    <tr>
                        <th>메모</th>
                        <td>
                            <textarea rows="15" cols="50" v-model="memo" class="form-control"></textarea>
                        </td>
                    </tr>
                </tbody>
            </table>
        </div>

        <button @click="add" class="btn btn-primary">추가</button>

    </div>
</template>


<script>

export default {
    name: "create",
    data() {
        return {
            name: "",
            age: 0,
            phone: "",
            address: "",
            memo: ""
        }
    },
    methods: {
        add() {
            // alert('add()');
            let url = "http://localhost:3000/memberAdd";

            let params = {
                "name": this.name,
                "age": parseInt(this.age, 10),
                "phone": this.phone,
                "address": this.address,
                "memo": this.memo
            }

            const options = {
                method: 'POST',
                body: JSON.stringify(params),
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            fetch(url, options)
                .then(res => res.json())
                .then(res => {
                    alert(res.result);
                })
                .catch(err => console.log(err));

        }
    }

}

</script>