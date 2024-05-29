<template>
    <div>
        <h1>{{ value }}</h1>
        <input id="input" :value="value" @keypress="setValue()"/>
        <button @click="setDefault()">기본값</button>

        <br/><br/>

        <input v-model="inVal"/><br/>
        <input v-model="outVal"/>{{ outVal }}<br/>
        <button @click="setVal()">값 셋팅</button>
    </div>
</template>

<script>
export default{
    data(){
        return{
            value:`기본값`,
            inVal: 0,
            outVal: 0
        }
    },
    methods:{
        setValue(){
            this.value = document.getElementById(`input`).value;
        },
        setDefault(){
            this.value = "default value";
        },
        setVal(){
            this.outVal = this.inVal;
        }
    }
}
</script>