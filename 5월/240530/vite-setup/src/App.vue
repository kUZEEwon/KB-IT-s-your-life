<script setup>
import OpenApi from './components/OpenApi.vue'
import ViteSetup from './components/ViteSetup.vue'
import CompositionApi from './components/CompositionApi.vue'
import Watch from './components/Watch.vue';

</script>

<template>
  <div>
    <ViteSetup/>
    <br/><hr/>

    <OpenApi/>
    <br/><hr/>
    
    <CompositionApi/>
    <br/><hr/>

    <Watch/>
  </div>

</template>
