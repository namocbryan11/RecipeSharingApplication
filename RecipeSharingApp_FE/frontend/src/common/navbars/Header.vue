<template>
    <div class="d-flex align-items-center bg-dark" id="navheader">
        <nav class="nav">
            <a class="nav-link active" aria-current="page" href="/recipes">Home</a>
            <a class="nav-link" href="/users">Users</a>
            <a class="nav-link" href="/profile">Profile</a>
            <a class="nav-link" href="/login">Logout</a>
        </nav>
    </div>
</template>

<script>
    export default{
        name: "navHeader"
    }
</script>

<style>
#navheader{
    height: 70px;
    padding-left: 10px;
}

</style>
