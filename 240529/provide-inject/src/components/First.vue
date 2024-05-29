
<template>
    <div>
        <h3>First Component</h3>
        <p>props : {{ name }}</p>

        <Second :name="name"/>
    </div>
</template>

<script>
import Second from "./Second.vue";

export default {
    name: 'First',
    components:{
        Second
    },
    props: {
        name : String
    }
}
</script>