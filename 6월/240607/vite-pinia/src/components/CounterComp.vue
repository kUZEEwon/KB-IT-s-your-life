
<template>
    <div>
        <h3>CounterComp</h3>

        <p>counter : {{ store.counter }}</p>

        <p>doublecount : {{ store.doubleCount }}</p>

        <button @click="store.increment">Click</button>
    </div>
</template>

<script>
import { useCounterStore } from "@/stores/counter";

// const store = useCounterStore();

export default{
    setup(){
        const store = useCounterStore();

        return {store}
    }
}


</script>