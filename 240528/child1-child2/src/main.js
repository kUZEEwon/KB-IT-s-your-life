import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import mitt from 'mitt'

const app = createApp(App); // 앱 인스턴스를 생성합니다.
const emitter = mitt(); // mitt 라이브러리로부터 이벤트 버스를 생성합니다.
app.config.globalProperties.emitter = emitter; // 전역으로 이벤트 버스를 설정합니다.
app.mount('#app'); // 앱을 마운트합니다.
