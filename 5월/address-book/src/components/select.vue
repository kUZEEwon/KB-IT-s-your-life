<template>
    <div class="container mt-3">
        <h3 class="mb-3">지인검색</h3>
        <br />
        <div class="input-group mb-3">
            <input type="text" class="form-control" v-model="name"/>
            <button @click="getInfoByName" class="btn btn-primary">찾기</button>
        </div>
        <hr/>
        <h4>찾은 내용</h4>
        <div v-if="foundMember">
            <p><strong>이름:</strong> {{ foundMember.result.name }}</p>
            <p><strong>나이:</strong> {{ foundMember.result.age }}</p>
            <p><strong>전화번호:</strong> {{ foundMember.result.phone }}</p>
            <p><strong>주소:</strong> {{ foundMember.result.address }}</p>
            <p><strong>메모:</strong> {{ foundMember.result.memo }}</p>
            <!-- 필요한 정보를 추가로 보여줄 수 있음 -->
        </div>
        <div v-else>
            <p>멤버를 찾을 수 없습니다.</p>
        </div>
    </div>
</template>

<script>
export default {
    name: "select",
    data() {
        return {
            name: "",
            foundMember: null // 찾은 멤버 정보를 저장할 데이터 속성
        }
    },
    methods: {
        getInfoByName() {
            let name = this.name; // 가져올 정보의 이름
            fetch("http://localhost:3000/memberSelect", {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify({ name: name })
            })
                .then(response => response.json())
                .then(data => {
                    if (data) {
                        console.log("Found member:", data);
                        this.foundMember = data; // 찾은 멤버 정보 저장
                    } else {
                        console.log("Member not found");
                        this.foundMember = null; // 찾은 멤버가 없으면 null로 설정
                    }
                })
                .catch(error => {
                    console.error('Error:', error);
                    // 오류 처리
                });
        }
    }
}
</script>
