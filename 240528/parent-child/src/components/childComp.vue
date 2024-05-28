<template>
    <div>
        <h3>Child Component</h3>

        <p>{{ propsdata }}</p>
    </div>
</template>

<script>

export default{
    name:'childComp',

    
    // props:[ 'propsdata' ]

    props:{
        propsdata: String
    }

}

</script>