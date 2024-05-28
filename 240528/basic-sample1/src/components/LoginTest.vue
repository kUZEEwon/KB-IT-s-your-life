<template>
    <div id="app">
        <div class="container">
            <div v-if="isLoggedIn" class="welcome">
                <h1>Welcome, {{ username }}!</h1>
                <button @click="logout" class="btn btn-logout">Logout</button>
            </div>
            <div v-else class="login-form">
                <form @submit.prevent="login">
                    <h2>Login</h2>
                    <div v-if="error" class="error">{{ error }}</div>
                    <div class="input-group">
                        <label for="username">Username:</label>
                        <input type="text" id="username" v-model="username">
                    </div>
                    <div class="input-group">
                        <label for="password">Password:</label>
                        <input type="password" id="password" v-model="password">
                    </div>
                    <button type="submit" class="btn btn-login">Login</button>
                </form>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    data() {
        return {
            username: '',
            password: '',
            isLoggedIn: false,
            error: ''
        };
    },
    methods: {
        login() {
            if (this.username === 'user' && this.password === 'pass') {
                this.isLoggedIn = true;
                this.error = '';
            } else {
                this.error = 'Invalid username or password';
            }
        },
        logout() {
            this.isLoggedIn = false;
            this.username = '';
            this.password = '';
        }
    }
};
</script>

<style scoped>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f4;
    margin: 0;
    padding: 0;
    display: flex;
    justify-content: center;
    align-items: center;
    height: 100vh;
}

.container {
    background-color: white;
    padding: 2em;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    width: 300px;
    text-align: center;
}

h1,
h2 {
    margin-bottom: 1em;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 0.5em;
    margin: 0.5em 0 1em 0;
    border: 1px solid #ccc;
    border-radius: 5px;
}

button {
    padding: 0.5em 1em;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}

.btn {
    background-color: #007bff;
    color: white;
    font-size: 1em;
}

.btn:hover {
    background-color: #0056b3;
}

.btn-logout {
    background-color: #dc3545;
}

.btn-logout:hover {
    background-color: #c82333;
}

.error {
    color: red;
    margin-bottom: 1em;
}

.input-group {
    text-align: left;
    margin-bottom: 1em;
}

.input-group label {
    display: block;
    margin-bottom: 0.5em;
}
</style>