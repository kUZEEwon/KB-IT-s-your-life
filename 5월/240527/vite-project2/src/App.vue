<script setup>
import ImageBox from './components/ImageBox.vue';
import BabyBox from './components/TableBox.vue';
</script>

<template>
  <div>
    <ImageBox />
    <hr>

    <BabyBox />
  </div>  
</template>

<style scoped>
.logo {
  height: 6em;
  padding: 1.5em;
  will-change: filter;
  transition: filter 300ms;
}
.logo:hover {
  filter: drop-shadow(0 0 2em #646cffaa);
}
.logo.vue:hover {
  filter: drop-shadow(0 0 2em #42b883aa);
}
</style>
