<template>
    <div>
        <div>
            <label>name</label>
            <input type="text" v-model="name" placeholder="name" />
        </div>

        <div>
            <label>x:</label>
            <input type="number" v-model.number="x" />
        </div>

        <div>
            <label>y:</label>
            <input type="number" v-model.number="y" />
        </div>

        <div>
            name : <span>{{ name }}</span>
            <br />
            x : <span>{{ x }}</span>
            <br />
            y : <span>{{ y }}</span>
        </div>
    </div>
</template>
<script>
import { reactive, onMounted } from 'vue'; // computed
export default {
    name: "OptionAPI",
    data() {
        return {
            name: "",
            x: 0,
            y: 0
        }
    },
    computed: {
        result() {
            return parseInt(this.x, 10) + parseInt(this.y, 10)
        }
    },
    mounted() {
        this.name = "John",
            this.x = 10,
            this.y = 20;
    },
    methods: {
        changeX(strX) {
            let x = parseInt(strX, 10);
            this.x = isNaN(x) ? 0 : x;
        },
        changeY(strY) {
            let y = parseInt(strY, 10);
            this.y = isNaN(y) ? 0 : y;
        },
        changeName(name) {
            this.name = name.trim().length < 2 ? "" : name.trim();
        }
    },
}
</script>
