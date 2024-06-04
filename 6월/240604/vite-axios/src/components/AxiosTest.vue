<template>
    <div>
        <h1>AxiosTest</h1>

        <h3>{{ test }}</h3>
        <h3>{{ human }}</h3>
        <h3>{{ conn_param }}</h3>
    </div>
</template>
<script>
import axios from 'axios';

export default {
    name: "AxiosTest",
    data(){
        return{
            start: "",
            test: '',
            human: {},
            conn_param: ""
        }  
    },
    created() {
        
        // 1.
        /* axios.get('http://localhost:3000/',{})
            .then((response) => {
                alert('success');
                this.start=response.data;
            })
            .catch(err => {
                alert(err);
            }) */
        
        // 2.
        /* axios.get('http://localhost:3000/test',{})
            .then((response) => {
                this.test = response.data.test; // test는 key value
            })
            .catch(err => {
                alert(err);
            }) */
        
        // 3.
        /* axios.get('http://localhost:3000/human',{})
            .then((response) => {
                this.human = response.data.id;
                this.human += response.data.name;
                this.human += response.data.height;

                // this.human = response.body;
            })
            .catch(err => {
                alert(err);
            }) */
        
        // 4.
        /* axios.get('http://localhost:3000/conn_param', { params : { "number": 333, "name": "성춘향"}})
            .then((response) => {
                // params는 front-end에서 보낸 것임
                this.conn_param = response.data;
            })
            .catch(err => {
                alert(err);
            }) */
        

        // 5.
        axios.post('http://localhost:3000/conn_post_param', { "number": 787, "name": "성유리"} )
            .then((response) => {
                // params는 front-end에서 보낸 것임
                this.conn_param = response.data;
            })
            .catch(err => {
                alert(err);
            })
    },
}
</script>
<style lang="">
    
</style>