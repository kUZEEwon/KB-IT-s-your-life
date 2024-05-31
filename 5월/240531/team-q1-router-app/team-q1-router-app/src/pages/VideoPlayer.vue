
<!-- VideoPlayer.vue

  이 코드는 YouTube 동영상을 재생하는 모달 창을 구현하고 있다. 
  동영상 플레이어를 제어하기 위해 YouTubeVue3 컴포넌트를 사용하고, 
  이전, 다음 동영상을 재생할 수 있도록 라우터를 활용하고 있다.
-->

<template>
  <!-- 모달 창을 표시하는 템플릿 -->
  <div class="modal">
    <div class="box">
      <!-- 동영상 제목과 카테고리를 표시하는 헤더 -->
      <div class="heading">
        <span class="title">:: {{ videoInfo.video.title }}</span>
        <span class="category"> ( {{ videoInfo.video.category }} ) </span>
        <!-- 동영상 종료 버튼 -->
        <span class="float-end badge bg-secondary pointer" @click="stopVideo">
          X
        </span>
      </div>

      <!-- YouTube 동영상 플레이어 -->
      <div class="player">
        <YoutubeVue3 ref="playerRef" :videoid="videoInfo.video.id" :autoplay="1" :controls="1" @ended="playNext" />
      </div>

      <!-- 플레이어 컨트롤 버튼 -->
      <div>
        <div>
          <i class="fa fa-backward ml-2 pointer" @click="playPrev"></i>
          <i class="fa fa-stop ml-2 pointer" @click="stopVideo"></i>
          <i class="fa fa-forward ml-2 pointer" @click="playNext"></i>
        </div>
      </div>

    </div>
  </div>
</template>

<script>
import { reactive, ref, inject } from 'vue'
import { useRoute, useRouter, onBeforeRouteUpdate } from 'vue-router'
import { YoutubeVue3 } from 'youtube-vue3'

export default {
  // 컴포넌트의 이름 정의
  name: "VideoPlayer",
  // YoutubeVue3 컴포넌트를 사용하기 위해 선언
  components: { YoutubeVue3 },
  setup() {
    // videos 데이터를 가져오기 위해 inject 사용
    const videos = inject('videos');

    // Youtube 플레이어를 제어하기 위한 ref
    const playerRef = ref(null)

    // 현재 라우트 정보 가져오기
    const currentRoute = useRoute()

    // 라우터 사용하기
    const router = useRouter();

    // 현재 동영상 정보, 이전 동영상 ID, 다음 동영상 ID 등의 변수 선언
    let videoInfo, currentIndex, prevVideoId, nextVideoId;

    // 동영상 정보를 반응적인 객체로 선언
    videoInfo = reactive({ video: videos.find((v) => v.id === currentRoute.params.id) })

    // 현재 라우트 정보를 통해 이전, 다음 동영상 ID 가져오기
    const getNavId = (to) => {
      videoInfo.video = videos.find((v) => v.id === to.params.id);
      currentIndex = videos.findIndex((v) => v.id === videoInfo.video.id)
      prevVideoId = videos[currentIndex - 1] ? videos[currentIndex - 1].id : null;
      nextVideoId = videos[currentIndex + 1] ? videos[currentIndex + 1].id : null;
    }

    // 마운트되었을 때 현재의 라우트 정보를 이용해 이전, 다음 ID 획득
    getNavId(currentRoute)
    
    // 동영상 정지 및 홈으로 이동하는 함수
    const stopVideo = () => {
      playerRef.value.player.stopVideo()
      router.push({ name: 'videos' });
    }
    
    // 다음 동영상 재생하는 함수
    const playNext = () => {
      if (nextVideoId)
        router.push({ name: 'videos/id', params: { id: nextVideoId } })
      else
        router.push({ name: 'videos/id', params: { id: videos[0].id } })
    }
    // 이전 동영상 재생하는 함수
    const playPrev = () => {
      if (prevVideoId)
        router.push({ name: 'videos/id', params: { id: prevVideoId } })
    }

    // 라우트 업데이트 전에 실행되는 훅을 사용하여 이전, 다음 동영상 ID 가져오기
    onBeforeRouteUpdate((to) => {
      getNavId(to)
    })

    // 템플릿으로 반환할 객체
    return { videoInfo, playerRef, playNext, stopVideo, playPrev };
  }
}
</script>


<style scoped>
.modal {
  display: block;
  position: fixed;
  z-index: 1;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  overflow: auto;
  background-color: rgba(0, 0, 0, 0.4);
}

.box {
  background-color: white;
  margin: 80px auto;
  max-width: 500px;
  min-width: 100px;
  min-height: 350px;
  font: 13px "verdana";
  padding: 10px 10px 10px 10px;
}

.box div {
  padding: 0;
  display: block;
  margin: 10px 0 0 0;
}

.box .heading {
  background: #33A17F;
  font-weight: 300;
  text-align: left;
  color: #fff;
  margin: 5px 0 5px 0;
  padding: 10px;
  min-width: 200px;
  max-width: 500px;
}

.box .player {
  background: white;
}

.pointer {
  cursor: pointer;
}
</style>