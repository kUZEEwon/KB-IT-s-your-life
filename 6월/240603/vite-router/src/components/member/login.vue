<template>
    <div>
        <h1>Login</h1>

        <button @click="account">회원 가입</button>
    </div>
</template>

<script>
export default {
    name : "login",
    methods: {
        account(){
            this.$router.push('/account');
        }
    },
}
</script>