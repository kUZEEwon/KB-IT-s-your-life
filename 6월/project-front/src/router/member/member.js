import loginView from '@/views/member/loginView.vue';
import regi from '@/components/member/regi.vue';

export default[
    {
        path: '/',
        name: 'login',
        component: loginView
    },
    {
        path: '/regi',
        name: 'regi',
        component: regi
    },
    
]