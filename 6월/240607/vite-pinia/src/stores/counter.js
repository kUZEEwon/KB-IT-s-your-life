
import { defineStore } from 'pinia'

// 공통의 변수를 정의!

export const useCounterStore = defineStore("counter", {
    state:() => ({ // global 변수
        counter: 0,
        message: 'hi'
    }),

    getters: {  // 반드시 필요한 것은 아니다
        doubleCount: state => state.counter * 2,
    },

    actions: {      // (원하는 처리) 함수
        increment(){
            this.counter++;
        }
    }
})