<template>
    <div class="page">
        <div class="loginForm shadow">
            <h3>Login</h3>
            <form method="post">
                <div class="form-floating">
                    <input type="email" id="emailInput" class="form-control" v-on:change="onEmailChangeHandler" />
                    <label for="emailInput">
                        Email
                    </label>
                </div>
                <div class="form-floating">
                    <input type="password" name="passwordInput" class="form-control" v-on:change="onPasswordChangeHandler"/>
                    <label for="emailInput">
                        Password
                    </label>
                </div>
                <a class="btn btn-success loginBtns" @click="loginUser"> Submit </a>
                <span>Don't have account? </span>
                <a class=" loginBtns" href="/register">Register</a>
            </form>
        </div>
    </div>
</template>

<script>
    // import navHeader from '../../common/navbars/Header.vue'
    import userService from '../../utils/UserAPIService';

    export default{
        name:'LoginRegister',
        data(){
            return{
                email: '',
                password: '',
            }
        },
        components:{
            // navHeader
        },
        methods: {
            onEmailChangeHandler: function(event){
                this.email = event.target.value;
            },
            onPasswordChangeHandler: function(event){
                this.password = event.target.value;
            },
            loginUser: function(){
                userService.isUserExist(this.email,this.password).then((response) => {
                    if(response.data == true){
                        location.href="/recipes";
                    }else{
                        alert("invalid credentials!");
                    }
                });
            }
        }
    }

</script>
    
<style src="../../css/LoginRegister.scss" lang="scss" />
