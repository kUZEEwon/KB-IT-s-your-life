<template>
  <div>
    <h1>Hello World</h1>
    <p>Hello World</p>
    <h3>{{ msg }}</h3>
    <p>{{ str }}</p>
    <h4>{{ str2 }}</h4>
    <h3>{{ num }}</h3>
  </div>  
</template>

<script>
export default {
  name: 'HelloWorld',

  props: {    // (매개)변수    
    /*
    msg: String,
    
    str: {    // String str = "안녕하세요";
      type: String,
      default: "안녕하세요"
    },
    str2:{
      default: "반드시 성공합시다" 
    },
    num: {
      default: 1024
    }
    */
  },

  data() {
    return {
      msg: '',      
      str: "안녕하세요",
      str2: "반드시 성공합시다" ,
      num: 1024
    }
  }
}
</script>


<style scoped>
</style>
