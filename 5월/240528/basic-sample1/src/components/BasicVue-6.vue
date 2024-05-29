<template>
    <div>
        <table border="1">
            <tr>
                <th>no</th><th>id</th><th>title</th><th>content</th>
            </tr>
            <tr v-for="(bbs, index) in bbslist" :key="index">
                <th>{{ index + 1 }}</th>
                <th>{{bbs.id}}</th>
                <th>{{bbs.title}}</th>
                <th>{{bbs.content}}</th>
            </tr>
        </table>
    </div>
</template>

<script>
export default {
    data(){
        return {
            bbslist:[
                { id:"abc", title:'html', content:"front-end" },
                { id:"udw", title:'mysql', content:"database" },
                { id:"isb", title:'node.js', content:"back-end" }
            ]
        }
    }
}
</script>