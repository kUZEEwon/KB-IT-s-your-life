<template>
    <div id="BasicVue">
        <p>{{ str }}</p>
        <p>{{ name }}</p>
        <p>{{ message }}</p>
        <p v-html="message"></p>
        <p v-text="message"></p>
    </div>
</template>

<script>
    export default{
        name : "BasicVue",
        props : {   // (매개) 변수  ==  property ->  외부로부터 값을 설정   function(props)
            str: {
                default:`안녕하세요 Vue 반갑습니다`
            }
        },
        data(){     
            // 변수 지정
            return{
                name: `홍길동`,
                message: `나는 반드시 <strong>성공</strong>한다.`
            }
        }
    }
</script>