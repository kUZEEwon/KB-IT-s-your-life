<template>
    <div>
        <h2>Parent Component</h2>

        <p>{{ message }}</p>
        <p>{{ height }}</p>

        <ChildComp @send-message="setMessage" />

    </div>
</template>

<script>
import ChildComp from "./ChildComp.vue";

export default{
    components: { ChildComp },
    data(){
        return{
            message:'',
            height:'0',
        }
    },
    methods:{
        setMessage( prop ){
            this.message = prop.msg;
            this.height = prop.height;
        }
    }
}


</script>