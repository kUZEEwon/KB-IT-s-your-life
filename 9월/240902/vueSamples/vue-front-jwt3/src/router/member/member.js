
import home from '@/components/home.vue';
import login from '@/components/member/login.vue';
import regi from '@/components/member/regi.vue';

export default [
    {
        path:'/',
        name:'home',
        component:home
    },
    {
        path:'/login',
        name:'login',
        component:login
    },
    {
        path:'/regi',
        name:'regi',
        component:regi
    }
]