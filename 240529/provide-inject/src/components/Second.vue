
<template>
    <div>
        <h3>Second Component</h3>

        <p>props : {{ name }}</p>

        <Third :name="name"/>
    </div>
</template>

<script>
import Third from "./Third.vue";

export default {
    name: 'Second',
    components:{
        Third
    },
    props: {
        name: String
    }
}

</script>