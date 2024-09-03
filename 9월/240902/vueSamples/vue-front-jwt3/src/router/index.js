import { createWebHistory, createRouter } from 'vue-router' // npm i vue-router@next
import member from './member/member.js';

const router = createRouter({
    history: createWebHistory(),
    routes: [
        ...member
    ]
})

export default router;