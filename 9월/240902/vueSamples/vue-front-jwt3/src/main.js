
import { createApp } from 'vue'
import App from './App.vue'

import router from './router/index';

import BootstrapVue from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
// https://bootstrap-vue.org/docs/components/button

//createApp(App).mount('#app')

const app = createApp(App)

app.use(router)

app.use(BootstrapVue)

app.mount('#app')
