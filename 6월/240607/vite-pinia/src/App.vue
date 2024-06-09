<template>
  <div>
    <CounterComp/>
    <br />
    <AsideComp/>
  </div>
</template>
<script>
import CounterComp from '@/components/CounterComp.vue';
import AsideComp from '@/components/AsideComp.vue';

export default {
  components: { CounterComp,AsideComp  }
}
</script>