<template>
    <div>
        X : <input v-model.number ="state.x" /><br/>
        Y : <input v-model.number = "state.y" /><br/>
        결과 : {{result}}
    </div>
</template>

<script>
import { reactive, computed } from 'vue'

export default {
    name : "CalcuBox",
    
    setup() {
        const state =reactive({x:10, y:20});
        const result = computed(() => {
            return state.x + state.y
        });

        return {state,result}
    }
    
    
}
</script>