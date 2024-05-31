<!-- MemberInfo : vue.js와 Vue Router를 사용하여 멤버 정보를 동적으로 표시하는 기능을 구현 -->

<template>
    <!-- 멤버 정보를 표시하기 위한 템플릿 -->
    <div className="mt-5">
        <!-- 멤버의 사진을 표시 -->
        <img :src="member.photo" class="img" />
        <!-- 멤버의 이름과 역할을 표시 -->
        <h4 class="mt-2">{{ member.name }}({{ member.role }})</h4>
        <!-- 멤버의 설명을 표시 -->
        <p>{{ member.desc }} </p>
        <!-- 멤버의 인스타그램, 페이스북, 유튜브 링크를 표시 (있을 경우) -->
        <a v-if="member.insta && member.insta !== ''" class="fa fa-instagram m-1" :href="member.insta"></a>
        <a v-if="member.facebook && member.facebook !== ''" class="fa fa-facebook m-1" :href="member.facebook"></a>
        <a v-if="member.youtube && member.youtube !== ''" class="fa fa-youtube m-1" :href="member.youtube"></a>
        <!-- 멤버 목록으로 돌아가는 링크 -->
        <br /><br />
        <router-link to="/members">멤버 목록으로</router-link>
    </div>
</template>

<script>
import { useRoute } from 'vue-router'
import members from '@/members.json'

export default {
    // 컴포넌트의 이름 정의
    name: "MemberInfo",
    setup() {
        // 현재 라우트 정보 가져오기
        const currentRoute = useRoute()
        // URL에서 ID 추출
        const id = parseInt(currentRoute.params.id, 10);
        // ID에 해당하는 멤버 정보 가져오기
        const member = members.find((m) => m.id === id)
        // 컴포넌트에 멤버 정보 전달
        return { member }
    }
}
</script>
