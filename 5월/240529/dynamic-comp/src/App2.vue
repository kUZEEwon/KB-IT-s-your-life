<template>
    <div>
        <button v-for="tab in tabs" 
        :key="tab.index"
        :class="['tab-button',{ active: currentTab === tab }]"
        @click="currentTab = tab">
        {{ tab }}</button>
        

        <!-- component 호출 -->
        <component :is="currentTab" class="tab"/>

    </div>
</template>

<script>
import First from './components/First.vue';
import Second from './components/Second.vue';
import Third from './components/Third.vue';

export default {
    components: {
        First,
        Second,
        Third
    },
    data(){
        return {
            currentTab: "First",
            tabs:['First', 'Second', 'Third']
        }
    }
}
</script>


<style scoped>
.tab-button{
    padding: 6px 10px;
    cursor: pointer;
    background-color: #f6cece;
}
.tab-button:hover{
    background-color: #f6cece;
}
.tab-button.active{
    background-color: #a57e7e;
}

.tab{
    margin-top: 20px;
    width: 1000px;
    height: 600px;
    padding: 10px;
    background-color: rgb(239, 239, 239);
}

</style>
