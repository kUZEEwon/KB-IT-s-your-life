<template >
    <div>
        <h1>Article</h1>
    </div>
</template>

<script>
export default {
    
    mounted() {
        // alert('mounted');

        alert(this.$route.params.msg);
    },
}
</script>
<style scoped>
    
</style>