import home from "@/components/Home.vue";
import Login from "@/components/member/Login.vue";
import regi from "@/components/member/regi.vue";

export default [
    {
        path:'/',
        name:'home',
        component: home
    },
    {
        path:'/login',
        name : 'login',
        component: Login
    },
    {
        path:'/regi',
        name: 'regi',
        component:regi
    }
]