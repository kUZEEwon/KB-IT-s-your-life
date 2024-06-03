

<template>
    <div>
        <login/>
        <br/>
        <info/>
    </div>
</template>

<script>
import login from '@/components/member/login.vue';
import info from '@/components/member/info.vue';


export default {
    name:"loginView",
    components:{
        login, info
    }
    
}
</script>
