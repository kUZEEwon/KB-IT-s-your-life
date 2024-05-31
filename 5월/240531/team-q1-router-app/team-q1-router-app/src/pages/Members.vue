<!-- Members.vue
  vue.js를 사용하여 멤버 목록을 표시하는데, 
  v-for 디렉티브를 사용하여 각 멤버를 반복하고, 
  router-link를 통해 각 멤버를 클릭하면 해당 멤버의 상세 정보 페이지로 이동 -->


<template>
    <!-- 멤버 목록을 표시하기 위한 템플릿 -->
    <div>
        <!-- 제목 -->
        <h2 class="m-4">이날치 멤버</h2>
        <!-- 그리드 레이아웃을 위한 컨테이너 -->
        <div class="container">
            <!-- 반복문을 통해 멤버 목록을 표시하는 로우 -->
            <div class="row">
                <!-- 각 멤버 정보를 반복적으로 표시 -->
                <div v-for="m in members" :key="m.id"
                    class="col-6 col-xs-6 col-sm-4 col-md-3 col-lg-2">
                    <!-- 멤버 상세 페이지로 이동하는 링크 -->
                    <router-link :to="'/members/'+m.id">
                        <!-- 멤버의 사진 및 이름을 표시 -->
                        <img class="img-thumbnail"
                            style="width:90px; height:110px;"
                            :src="m.photo" :title="m.name" /><br/>
                        <h6 class="display-7">{{m.name}}</h6>
                    </router-link>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
import members from '@/members.json'

export default {
    // 컴포넌트의 이름 정의
    name : "Members",
    setup() {
        // 멤버 데이터 가져오기
        return { members };
    }
}
</script>
<!--  -->