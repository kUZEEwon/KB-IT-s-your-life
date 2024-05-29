
<template>
  <div>
    <!-- <BasicVue str="Hello"/> -->
    <!-- <BasicVue2 /> -->
    <!-- <BasicVue3 /> -->
    <!-- <BasicVue4 /> -->
    <!-- <BasicVue5 /> -->
    <!-- <BasicVue6 /> -->
    <LoginTest/>
  </div>
</template>

<script>
import BasicVue from "./components/BasicVue.vue";
import BasicVue2 from "./components/BasicVue-2.vue";
import BasicVue3 from "./components/BasicVue-3.vue";
import BasicVue4 from "./components/BasicVue-4.vue";
import BasicVue5 from "./components/BasicVue-5.vue";
import BasicVue6 from "./components/BasicVue-6.vue";
import LoginTest from "./components/LoginTest.vue";

export default{
  name: `App`,
  components: {
    BasicVue,
    BasicVue2,
    BasicVue3,
    BasicVue4,
    BasicVue5,
    BasicVue6,
    LoginTest
  }
}

</script>

<style>

</style>
