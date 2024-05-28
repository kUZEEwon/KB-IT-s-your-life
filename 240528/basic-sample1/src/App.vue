
<template>
  <div>
    <!-- <BasicVue str="Hello"/> -->
    <!-- <BasicVue2 /> -->
    <BasicVue3 />
  </div>
</template>

<script>
import BasicVue from "./components/BasicVue.vue";
import BasicVue2 from "./components/BasicVue-2.vue";
import BasicVue3 from "./components/BasicVue-3.vue";

export default{
  name: `App`,
  components: {
    BasicVue,
    BasicVue2,
    BasicVue3
  }
}

</script>

<style>

</style>
