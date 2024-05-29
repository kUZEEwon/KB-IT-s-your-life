
<template>
  <div class="header">
    <h3 class="headerText">태평양 전쟁의 해전</h3>
    <nav>
      <ul>
        <li v-for="tab in tabs" :key="tab.id">
          <a style="cursor: pointer;" 
          :class="{ active: tab.id === currentTab }"
            @click="changeTag(tab.id)">
            {{ tab.label }}
          </a>
        </li>
      </ul>
    </nav>
  </div>

  <div>
    <component :is="currentTab"></component>
  </div>

</template>

<script>
import Coral from "./components/Coral.vue";
import Leyte from "./components/Leyte.vue";
import Midway from "./components/Midway.vue";

export default{
  name: "App",
  components: { Coral, Leyte, Midway },
  data(){
    return{
      currentTab : "Coral",
      tabs :[   // 제목 요소를 나타내기 json
        { id:"Coral", label:"산호해 해전" },
        { id:"Leyte", label:"레이테만 해전" },
        { id:"Midway", label:"미드웨이 해전" },
      ]
    }
  },
  methods:{
    changeTag(tab){
      this.currentTab = tab;
    }
  }
}
</script>


<style scoped>
.header{ padding: 20px 0px 0px 20px; }

.headerText{ padding: 0px 20px 40px 20px; }

.tab{ padding: 30px; }
</style>
