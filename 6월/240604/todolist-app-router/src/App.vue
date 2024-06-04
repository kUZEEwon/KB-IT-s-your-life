<script setup>
import AxiosBox from "./components/AxiosBox.vue";
import AsyncBoxVue from './components/AsyncBox.vue';
import PostBox from './components/PostBox.vue'


</script>
<template>
  <div>
      <h2>콘솔을 확인합니다.</h2>
      <AxiosBox/>
      <AsyncBoxVue/>
      <PostBox/>
  </div>
</template>


<script>

export default{
  components:{AxiosBox,AsyncBoxVue,PostBox}
}

</script>