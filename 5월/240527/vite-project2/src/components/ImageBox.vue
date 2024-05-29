<template>
    <div>
        <img :src="imageSrc" alt="image" />
    </div>
</template>

<script>
export default{
    name: "ImageBox",
    data(){
        return {
            imageSrc: "https://cdn.pixabay.com/photo/2015/09/09/20/23/baby-933097_1280.jpg"
        }
    }
}
</script>

<style scoped>
img{
    width: 300px;
    height: 300px;
}
</style>