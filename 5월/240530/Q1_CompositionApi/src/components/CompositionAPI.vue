<template>
    <div>
        <p>name:</p>
        <input type="text" v-model="name"/>

        <p>x:</p>
        <input type="number" v-model.number="x"/>

        <p>y:</p>
        <input type="number" v-model.number="y"/><br/>

        <hr/>
        name: <button class="name" @click="updateName">{{ name }}</button>
        <br/>
        x: <button class="x" @click="updateX">{{ x }}</button>
        <br/>
        y: <button class="y" @click="updateY">{{ y }}</button>
    </div>
</template>


<script>
import {ref} from 'vue';

export default {
    name:"CompositionAPI",
    setup() {
        const name = ref("");
        const x = ref(0);
        const y = ref(0);

        const updateX = () => {
            const parsedX = parseInt(x.value, 10);
            x.value = isNaN(parsedX) ? 0 : parsedX;
        };

        const updateY = () => {
            const parsedY = parseInt(y.value, 10);
            y.value = isNaN(parsedY) ? 0 : parsedY;
        };

        const updateName = () => {
            name.value = name.value.trim().length < 2 ? "" : name.value.trim();
        };

        
        // Initialize the values when the component is mounted
        name.value = "John";
        x.value = 10;
        y.value = 20;

        return {
            name,
            x,
            y,
            updateX,
            updateY,
            updateName
        };
    },
}
</script>

<style scoped>
.name{
    background-color: red;
    color:white;
}
.x{
    background-color: aqua;
}
.y{
    background-color: blue;
    color:white;
}
</style>