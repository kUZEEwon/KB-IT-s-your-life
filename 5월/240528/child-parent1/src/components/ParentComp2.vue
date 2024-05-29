<template>
    <div>
        <h2>ParentComp 2</h2>
        <p>{{ pNum }}</p>

        <hr/>

        <ChildComp2 @updatePNum="updateParentNumber" />

    </div>
</template>

<script>
import ChildComp2 from "./ChildComp2.vue";

export default{
    components: { ChildComp2 },

    data(){
        return {
            pNum : 0
        }
    },

    methods:{
        updateParentNumber(num){
            this.pNum = num;
        }
    }
}

</script>