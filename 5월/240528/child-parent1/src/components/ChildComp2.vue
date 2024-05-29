<template>
    <div>
        <h3>ChildComp 2</h3>

        <input type="number" v-model="propNum" />
        <button @click="updateNumber">clild click</button>
    </div>
</template>

<script>
export default{
    name: "ChildComp2",
    data(){
        return{
            propNum: 0
        }
    },
    methods:{
        updateNumber(){

            this.$emit('updatePNum', this.propNum);
        }
    }

}
</script>