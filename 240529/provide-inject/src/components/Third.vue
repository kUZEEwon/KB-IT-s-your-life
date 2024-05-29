
<template>
    <div>
        <h3>Third Component</h3>
        <p>props : {{ name }}</p>

        inject : {{ injectProps }} 
    </div>
</template>

<script>

export default {
    name: "Third",
    props: {
        name: String
    },
    inject:['injectProps']
}

</script>