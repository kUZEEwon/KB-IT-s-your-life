<template>
    <div>
        <h2>Board List</h2>

        <router-link to="/create">
            <button class="btn btn-primary me-2">Create New Post</button>
        </router-link>
        <br /><br />

        <table class="table table-striped">
            <thead>
                <tr>
                    <th>id</th>
                    <th>first_name</th>
                    <th>last_name</th>
                    <th>email</th>
                    <th>gender</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="(mem, i) in member" :key="i">
                    <td>{{ mem.id }}</td>
                    <td>{{ mem.first_name }}</td>
                    <td>{{ mem.last_name }}</td>
                    <td>{{ mem.email }}</td>
                    <td>{{ mem.gender }}</td>
                </tr>
            </tbody>
        </table>
    </div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import axios from 'axios';

const member = ref([]);

const fetchData = () => {
    let url = "http://localhost:3001/youth";

    axios.get(url)
        .then(response => {
            console.log(response.data);
            member.value = response.data;
        })
        .catch(error => {
            console.error('Error:', error);
        });
}

onMounted(fetchData);

// Props 정의
const props = defineProps({
    member: {
        type: Array,
        default: () => []
    }
});
</script>
