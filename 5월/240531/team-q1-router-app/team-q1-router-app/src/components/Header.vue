<template>
    <!-- 네비게이션 바를 감싸는 nav 요소 -->
    <nav class="navbar navbar-expand-md bg-dark navbar-dark mt-2">
        <!-- 네비게이션 바의 브랜드 이름 -->
        <span class="navbar-brand">이날치(LeeNalChi)</span>
        <!-- 네비게이션 바를 토글하는 버튼 -->
        <button class="navbar-toggler" type="button" @click="changeIsNavShow">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- 네비게이션 바의 메뉴 항목들을 감싸는 div -->
        <div :class="navClass">
            <!-- 네비게이션 바의 메뉴 항목들 -->
            <ul class="navbar-nav">
                <li class="nav-item">
                    <!-- 홈으로 이동하는 링크 -->
                    <router-link class="nav-link" to="/">홈</router-link>
                </li>
                <li class="nav-item">
                    <!-- 소개 페이지로 이동하는 링크 -->
                    <router-link class="nav-link" to="/about">소개</router-link>
                </li>
                <li class="nav-item">
                    <!-- 멤버 페이지로 이동하는 링크 -->
                    <router-link class="nav-link" to="/members">멤버</router-link>
                </li>
                <li class="nav-item">
                    <!-- 영상 페이지로 이동하는 링크 -->
                    <router-link class="nav-link" to="/videos">영상</router-link>
                </li>
            </ul>
        </div>
    </nav>
</template>

<script>
import { reactive, computed } from 'vue';

export default {
    setup() {
        // 상태를 관리하기 위한 reactive 객체
        const state = reactive({
            isNavShow: false // 네비게이션 바의 표시 여부를 나타내는 속성
        })
        // 네비게이션 바의 클래스를 동적으로 결정하기 위한 computed 속성
        const navClass = computed(() => state.isNavShow
            ? "collapse navbar-collapse show" : "collapse navbar-collapse")
        // 네비게이션 바의 표시 여부를 토글하는 함수
        const changeIsNavShow = () => {
            state.isNavShow = !state.isNavShow;
        }

        // 외부에 노출할 객체를 반환
        return { state, changeIsNavShow, navClass };
    }
}
</script>
