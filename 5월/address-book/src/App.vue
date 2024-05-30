<template>
  <div>
    <button 
    v-for="tab in tabs"
    :key="tab.index"
    :class="['tab-button', { active: currentTab === tab }]"
    @click="currentTab = tab">{{ tab }}</button>

    <component :is="currentTab" class="tab"/>
  </div>
</template>

<script>
import create from "./components/create.vue";
import remove from "./components/delete.vue";
import select from "./components/select.vue";
import update from "./components/update.vue";

export default {
  name:"App",
  components:{
    create,
    remove,
    select,
    update
  },
  data(){
    return{
      currentTab: "create",
      tabs:[ 'create', 'remove', 'select', 'update']
    }
  }
}
</script>