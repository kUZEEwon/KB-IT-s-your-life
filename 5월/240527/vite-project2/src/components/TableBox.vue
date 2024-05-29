<template>
    <table border="1">
        <thead>
        <tr>
            <th scope="col">속성</th>
            <th scope="col">값</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>아기 이름</td>
            <td>{{ babyInfo.name }}</td>
        </tr>
        <tr>
            <td>아기 성별</td>
            <td>{{ babyInfo.gender }}</td>
        </tr>
        <tr>
            <td>아기 나이</td>
            <td>{{ babyInfo.age }}</td>
        </tr>
        </tbody>
    </table>
</template>

<script>

export default{
    name: "BabyBox",
    data(){
        return{
            babyInfo: {
                name: 'baby kim',
                gender: "woman",
                age: 1
            }
        }
    }
}
</script>

