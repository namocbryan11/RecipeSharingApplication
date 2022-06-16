<template>
    <div class="page">
        <div class="loginForm shadow">
            <h3>Register</h3>
            <form method="post">
                <div class="form-floating">
                    <input required type="email" id="emailInput" class="form-control" v-on:change="emailOnChangeHandler"/>
                    <label for="emailInput" >
                        Email
                    </label>
                </div>
                <div class="form-floating">
                    <input required type="password" name="passwordInput" class="form-control" v-on:change="passwordOnchangeHandler"/>
                    <label for="emailInput" >
                        Password
                    </label>
                </div>
                <button type="button" class="btn btn-success loginBtns" @click="createUser">Submit</button>
                <span>Already have an account? </span>
                <a type="button" href="/login">Login</a>
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
            return {
                email: '',
                password: '',
            }
        },
        components:{
            // navHeader
        },
        methods:{
            emailOnChangeHandler: function(event){
                this.email = event.target.value;
            },
            passwordOnchangeHandler: function(event){
                this.password = event.target.value;
            },
            createUser: function(){
                 // Regular expression to check if string is email
                const regexExp = /^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$/gi;
                try {
                    if(regexExp.test(this.email)){
                        let User= {
                                email: this.email,
                                password: this.password,
                                fname: null,
                                lname: null,
                            }
                        //check if the user exist
                        userService.isUserExist(this.email,this.password).then((response)=>{
                                if(response.data == true){
                                    alert("User already exist!");
                                }else{
                                    userService.registerUser(User);
                                    alert("Successfully saved!");
                                    location.href="/login";
                                }
                            });
                    }else{
                        alert("Please enter a valid email address!");
                    }
                } catch (error) {
                    console.error(error);
                    alert("Something went wrong!");
                }
            }
        },
    }
</script>
    
<style src="../../css/LoginRegister.scss" lang="scss" />
