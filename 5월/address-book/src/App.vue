<template>
  <div class="container mt-3">
    <div>
      <button 
        v-for="tab in tabs"
        :key="tab.index"
        :class="['btn', 'btn btn-outline-info', 'me-2', 'mb-2', { 'active': currentTab === tab }]"
        @click="currentTab = tab">{{ tab }}</button>

      <br/>

      <component :is="currentTab" class="tab"/>
    </div>
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