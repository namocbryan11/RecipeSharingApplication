<template>
    <div class="page">
        <navHeader />
        <div class="loginForm shadow">
            <h3>Register</h3>
            <form method="post">
                <div class="form-floating">
                    <input type="email" id="emailInput" class="form-control" />
                    <label for="emailInput">
                        Email
                    </label>
                </div>
                <div class="form-floating">
                    <input type="password" name="passwordInput" class="form-control" />
                    <label for="emailInput">
                        Password
                    </label>
                </div>
                <button type="button" class="btn btn-success loginBtns">Submit</button>
                <a type="button" class="btn btn-primary loginBtns" href="/login">Login</a>
            </form>
        </div>
    </div>
</template>

<script>
    import navHeader from '../../common/navbars/Header.vue'
    export default{
        name:'LoginRegister',
        components:{
            navHeader
        },
    }
</script>
    
<style>
.loginForm{
    width: 40%;
    vertical-align: center;
    margin:auto;
    margin-top: 20px;
    padding:10px;
    border-radius: 5px;
}
.form-control{
    margin-bottom: 10px;
}
.loginBtns{
    width: 100%;
    margin-bottom: 5px;
}
</style>
