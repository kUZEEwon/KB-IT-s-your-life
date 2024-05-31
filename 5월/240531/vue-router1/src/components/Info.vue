<template>
    <div>
        <h1>Info</h1>

        <hr/>

        <h4>넘어온 파라미터</h4>

        <p>num : {{ num }}</p>
        <p>str : {{ str }}</p>
    </div>
</template>
<script>
export default {
    mounted() {
        // alert('mounted');
        const num =  this.$route.params.num;
        const str = this.$route.params.str;
        this.num=num;
        this.str = str;

        alert("num : " + this.$route.params.num +"\nstr : " + this.$route.params.str);
    },
    data(){
        return{
            num:0,
            str:''
        }
    },
    
    
}
</script>
<style>
    
</style>