<template>
    <div>
        <h3>AsideComp</h3>

        <p>counter: {{ store.counter }}</p>
    </div>
</template>

<script>  /* setup 주의!! */
import { useCounterStore } from "@/stores/counter.js";

export default{
    setup(){
        const store = useCounterStore();

        return {store}
    }
}

</script>
