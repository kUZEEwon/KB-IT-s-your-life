<template>
    <div>
        <Child>
            <template v-slot:header>
                <h2>나는 헤더 부분!</h2>
            </template>
        </Child>

        <Child>
            <h3>나는 메인 부분!</h3>
        </Child>

        <Child>
            <template v-slot:footer>
                <h2>나는야 푸터 부분이야!</h2>
            </template>
        </Child>
    </div>
</template>

<script>
import Child from './Child.vue';

export default {
    name: "Parent",
    components: {
        Child,
    }
}
</script>