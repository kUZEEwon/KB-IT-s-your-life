<template>
    <div>
        <h3>Parent</h3>
        <Child>slot content</Child>

        <Child></Child>
        
        <Child><Hello/></Child>
    </div>
</template>

<script>
import Child from "./Child.vue";
import Hello from "./Hello.vue";

export default {
    name: "Parent",
    components: {
        Child,
        Hello
    }
}
</script>