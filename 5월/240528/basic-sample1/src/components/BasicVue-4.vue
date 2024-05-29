<template>
    <div>
        <ul>
            <li><a href="http://www.google.com">google</a></li>
            <li><a :href='url'>{{ url }}</a></li>
            <li><a v-bind:href=url>{{ url }}</a></li>
            <li><a :href='getUrl("google")''>구글</a></li>
        </ul>
        
        <p style="font-size: 24px;">style binding</p>
        <p :style="redfont">스타일 바인딩</p>
    </div>
</template>

<script>
export default {
    data() {
        return{
            url:`http://www.google.com`,
            redfont: "color: red;"
        }
    },
    methods:{
        getUrl(name){
            return "http://" + name + ".com";
        }
    }
}
</script>