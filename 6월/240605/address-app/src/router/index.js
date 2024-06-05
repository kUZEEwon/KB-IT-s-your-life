import {createRouter, createWebHistory} from 'vue-router'

import Board_create from '../components/Board_create.vue';
import Board_read_list from '../components/Board_read_list.vue';


const router = createRouter({
    history: createWebHistory(),
    routes: [
        {
            path:"/",
            name: "read_list",
            component: Board_read_list
        },
        {
            path:"/create",
            name: "create",
            component: Board_create
        }

    ]
})


export default router;