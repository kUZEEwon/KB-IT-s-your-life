<template>
    <div>
        
        name : <span>{{ nameData.name }}</span>
        <br/>
        x : <span>{{ calcData.x }}</span>
        <br/>
        y : <span>{{ calcData.y }}</span>


    </div>
</template>

<script>
import { reactive, onMounted } from 'vue'; // computed
export default {
    name: "compositionApi2",
    setup(){
        const nameData = reactive({name: ""});
        onMounted(() => {
            nameData.name = 'John'
        });

        const calcData =reactive({ x:0, y:0});
        onMounted(() => {
            calcData.x=10;
            calcData.y=10;
        })

        return{
            nameData,
            calcData
        }
    }
}
</script>

