
import bbslist from '@/components/bbs/bbslist.vue';
import bbswrite from '@/components/bbs/bbswrite.vue';
import bbsdetail from '@/components/bbs/bbsdetail.vue';
import bbsanswer from '@/components/bbs/bbsanswer.vue';

export default [
    {
        path:"/bbslist",
        name:'bbslist',
        component:bbslist
    },
    {
        path: '/bbswrite',
        name: 'bbswrite',
        component: bbswrite
    },
    {
        path: '/bbsdetail/:seq',
        name: 'bbsdetail',
        component: bbsdetail
    },
    {
        path: '/bbsanswer/:seq',
        name: 'bbsanswer',
        component: bbsanswer
    },
]