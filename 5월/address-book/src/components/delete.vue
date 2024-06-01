<template>
    <div class="container mt-3">
        <h3 class="mb-3">지인삭제</h3>
        <br />
        <div class="input-group mb-3">
            <input type="text" v-model="name" class="form-control"/>
            <button @click="remove" class="btn btn-primary">삭제</button>
        </div>
        

    </div>
</template>

<script>

export default {
    name: "delete",
    data() {
        return {
            name: ""
        }
    },
    methods: {
        remove() {
            let url = "http://localhost:3000/memberRemove";

            let params = {
                "name": this.name,
            }

            const options = {
                method: 'POST',
                body: JSON.stringify(params),
                headers: {
                    'Content-Type': 'application/json'
                }
            }

            fetch(url, options)
                .then(res => res.json())
                .then(res => {
                    alert(res.result);
                })
                .catch(err => console.log(err));

        }
    }

}

</script>