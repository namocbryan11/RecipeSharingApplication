<template>
    <div>
        <!--Header-->
        <navHeader />
        <div class="row">
            <p> Users page </p>
        </div>
    </div>
</template>

<script>
import navHeader from "../../common/navbars/Header.vue";
export default {
    name: "viewUsers",
    components: {
        navHeader
    }
}
</script>

<style>
</style>