import { createApp } from 'vue'
import App from './App.vue'

import router from './router/index'

// 부트 스트랩
import BootstrapVue from 'bootstrap-vue-3'
import 'bootstrap/dist/css/bootstrap.css'
import 'bootstrap-vue-3/dist/bootstrap-vue-3.css'
// https://bootstrap-vue.org/docs/components/button

// createApp(App).mount('#app')

const app = createApp(App)

app.use(BootstrapVue)
app.use(router)

app.mount('#app')