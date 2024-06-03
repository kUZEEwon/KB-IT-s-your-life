/* 경로를 설정하는 부분 */
import loginView from '@/views/member/loginView.vue';
import account from "@/components/member/account.vue";

export default [
    {
        path: '/',
        name: "loginView",
        component : loginView
    },
    {
        path: "/account",
        name: "account",
        component: account
    }
]