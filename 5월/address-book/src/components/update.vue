<template>
    <div>
        <h3>지인수정</h3>


        <form @submit.prevent="updateMember">
            <div class="form-group">
                <label for="name">이름:</label>
                <input type="text" class="form-control" id="name" v-model="name">
            </div>
            <div class="form-group">
                <label for="age">나이:</label>
                <input type="text" class="form-control" id="age" v-model="age">
            </div>
            <div class="form-group">
                <label for="phone">전화번호:</label>
                <input type="text" class="form-control" id="phone" v-model="phone">
            </div>
            <div class="form-group">
                <label for="address">주소:</label>
                <input type="text" class="form-control" id="address" v-model="address">
            </div>
            <div class="form-group">
                <label for="memo">메모:</label>
                <input type="text" class="form-control" id="memo" v-model="memo">
            </div>
            <br/>
            <button type="submit" class="btn btn-primary">멤버 업데이트</button>
        </form>

        
        <div v-if="message" class="mt-3">
            <div class="alert alert-success" role="alert">{{ message }}</div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            name: '',
            age: 0,
            phone: '',
            address: '',
            memo: '',
            message: ''
        };
    },
    methods: {
        updateMember() {
            const data = {
                name: this.name,
                newData: {
                    age: this.age,
                    phone: this.phone,
                    address: this.address,
                    memo: this.memo
                }
            };

            fetch('http://localhost:3000/updateMember', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(data)
            })
                .then(response => response.text())
                .then(data => {
                    this.message = data;
                })
                .catch(error => {
                    console.error('Error:', error);
                });
        }
    }
}
</script>