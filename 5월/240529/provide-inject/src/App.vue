
<template>
  <div>
    provide : {{ sendMessage }}

    <br/>

    <!-- props로 전달 -->
    <First name="props로 전달한 메시지"/>
  </div>
</template>

<script>

import First from "./components/First.vue";


export default {
  name:"App",
  components:{ First },
  data(){
    return{
      sendMessage:"provide로 전달할 메시지", // provide로 전달할 메세지
    }
  },
  provide(){
    return{
      injectProps: this.sendMessage
    }
  }
}

</script>