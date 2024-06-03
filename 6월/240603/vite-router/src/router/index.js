
import { createWebHistory, createRouter } from 'vue-router'
import member from '@/router/link/member.js'

const routes = [
    ...member
]

const router = createRouter(
    {
        history: createWebHistory(),
        routes
    }
)

export default router;