<script setup>
import Receiver from './components/Receiver.vue'
import Sender from './components/Sender.vue'
</script>

<template>

  <div>
    <Sender />

    <hr/>
    
    <Receiver />
  </div>

</template>
<script>
export default {
  name: "App",
  components: {
    Sender,
    Receiver
  }
}
</script>
