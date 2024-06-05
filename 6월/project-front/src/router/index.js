import { createWebHistory, createRouter } from "vue-router";

import member from "@/router/member/member.js"

const router = createRouter({
    history: createWebHistory(),
    routes: [
        ...member
    ]
});

export default router;