<template>
    <div>
        <select v-model="selected">
            <option disabled="disabled" value="">Please selectOne</option>
            <option>A</option>
            <option value="b">B</option>    <!-- value를 작성하면 그 값이 나온다. -->
            <option>C</option>
        </select>

        <span>선택 : {{ selected }}</span>

        <br/><br/>

        <label>이름</label>
        <input type="text" v-model="name"/>

        <br/>
        <span> 안녕하세요 {{ name }}님</span>
    </div>
</template>

<script>
/* 
    v-model == id -> value document.getElementById(`id`).value
*/

export default {
    data(){
        return {
            selected: '',
            name: ''
        }
    }
}

</script>
