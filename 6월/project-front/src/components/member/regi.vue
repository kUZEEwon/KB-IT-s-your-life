<template>
    <div class="container">
      <h1 class="heading">회원가입</h1>
  
      <form @submit.prevent="account" class="registration-form">
        <div class="form-group">
          <label for="id" class="label">아이디</label>
          <input type="text" v-model="id" class="input" id="id" placeholder="아이디를 입력하세요" required>
          <small class="message" v-if="message">{{ message }}</small>
          <button type="button" @click="idcheck" class="btn-secondary">중복확인</button>
        </div>
        <div class="form-group">
          <label for="pw" class="label">패스워드</label>
          <input type="password" v-model="pw" class="input" id="pw" placeholder="패스워드를 입력하세요" required>
        </div>
        <div class="form-group">
          <label for="name" class="label">이름</label>
          <input type="text" v-model="name" class="input" id="name" placeholder="이름을 입력하세요" required>
        </div>
        <div class="form-group">
          <label for="email" class="label">이메일</label>
          <input type="email" v-model="email" class="input" id="email" placeholder="이메일을 입력하세요" required>
        </div>
        <div class="form-group">
          <button type="submit" class="btn-primary">회원가입</button>
        </div>
      </form>
    </div>
  </template>
  
  <script>
  import axios from 'axios';
  
  export default {
    name: "Regi",
    data() {
      return {
        id: null,
        pw: '',
        name: '',
        email: '',
        message: '' // id check용
      }
    },
    methods: {
      idcheck() {
        axios.post("http://localhost:3000/idcheck", { "id": this.id })
          .then((res) => {
            if (res.data.result === "NO") {
              this.message = "사용중인 아이디입니다";
              this.id = "";
            } else {
              this.message = "이 아이디는 사용가능합니다";
            }
          })
          .catch(err => alert(err));
      },
      account() {
        const mem = { id: this.id, pw: this.pw, name: this.name, email: this.email };
        axios.post("http://localhost:3000/regi", mem)
          .then(res => {
            if (res.data.result === "YES") {
              alert("가입을 환영합니다");
              this.$router.push({ name: 'login' });
            }
          })
          .catch(err => alert(err));
      }
    }
  }
  </script>
  
  <style scoped>
  .container {
    max-width: 800px;
    margin: 0 auto;
    padding: 20px;
  }
  
  .heading {
    text-align: center;
    margin-bottom: 20px;
  }
  
  .registration-form {
    background-color: #f8f9fa;
    padding: 20px;
    border-radius: 5px;
  }
  
  .form-group {
    margin-bottom: 20px;
  }
  
  .label {
    display: block;
    font-weight: bold;
  }
  
  .input {
    width: calc(100% - 120px);
    padding: 8px;
    border: 1px solid #ced4da;
    border-radius: 5px;
  }
  
  .message {
    color: #dc3545;
  }
  
  .btn-primary,
  .btn-secondary {
    padding: 8px 20px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
  }
  
  .btn-primary {
    background-color: #007bff;
    color: #fff;
  }
  
  .btn-secondary {
    background-color: #6c757d;
    color: #fff;
  }
  </style>
  