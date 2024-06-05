<template>
    <div class="container mt-5">
        <h2>Create Post</h2> <br />
        <div class="mb-3 mt-3">
            <label for="firstname" class="form-label">First Name</label>
            <input type="text" id="firstname" class="form-control" v-model="firstName" required />
        </div>
        <div class="mb-3">
            <label for="lastname" class="form-label">Last Name</label>
            <input type="text" id="lastname" class="form-control" v-model="lastName" required />
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Email</label>
            <input type="email" id="email" class="form-control" v-model="email" required />
        </div>
        <div class="mb-3">
            <label for="gender" class="form-label">Gender</label>
            <select id="gender" class="form-select" v-model="selectedGender">
                <option value="" disabled hidden>Unknown</option>
                <option value="unknown">Unknown</option>
                <option value="male">Male</option>
                <option value="female">Female</option>
            </select>
        </div>
        <button class="btn btn-primary me-2" @click="validateForm">Create</button>
        <button class="btn btn-secondary" @click="cancelForm">Cancel</button>
        <hr />
        <router-link to="/">
            <button class="btn btn-link">Board_list</button>
        </router-link>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data() {
        return {
            firstName: '',
            lastName: '',
            email: '',
            selectedGender: '',
            // 임시 ID 변수
            tempId: 0
        }
    },
    methods: {
        validateForm() {
            if (!this.firstName || !this.lastName || !this.email || !this.selectedGender) {
                alert('All fields are required.');
            } else {
                this.submitPost();
            }
        },
        submitPost() {
            const newData = {
                id: this.generateTempId(), // 임시 ID 사용
                first_name: this.firstName,
                last_name: this.lastName,
                email: this.email,
                gender: this.selectedGender
            };

            // 서버로 데이터를 전송
            axios.post('http://localhost:3001/youth', newData)
                .then(response => {
                    console.log('Data successfully sent to server:', response.data);
                })
                .catch(error => {
                    console.error('Error sending data to server:', error);
                });
        },
        // 임시 ID 생성 함수
        generateTempId() {
            this.tempId++; // ID를 증가시킴
            return Date.now() + this.tempId; // 현재 시간과 ID를 조합하여 유일한 ID 생성
        },
        cancelForm() {
            this.firstName = '';
            this.lastName = '';
            this.email = '';
            this.selectedGender = '';
        }
    }
}
</script>
