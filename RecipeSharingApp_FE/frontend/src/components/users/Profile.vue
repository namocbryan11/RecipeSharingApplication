<template>
    <div class="page">
        <navHeader />
        <div class="div-base">
            <div class="div-header">
                <text class="page-title"> EDIT PROFILE </text>
            </div>
            <div class="div-body">
                <div class="form-floating form-inputs">
                    <input id="email" class="form-control" v-on:change="emailChangeHandler" :value='email'/>
                    <label for="email">Email</label> 
                </div>
                <div class="form-floating form-inputs">
                    <input id="fname" class="form-control" v-on:change="fnameChangeHandler" :value='firstname'/>
                    <label for="fname">First Name</label> 
                </div>
                <div class="form-floating form-inputs">
                    <input id="lname" class="form-control" v-on:change="lnameChangeHandler" :value='lastname'/>
                    <label for="lname">Last Name</label> 
                </div>
                <div class="form-floating form-inputs">
                    <input id="password" class="form-control" type="password" v-on:change="passwordChangeHandler" :value='password'/>
                    <label for="password">Password</label> 
                </div>
            </div>
            <div class="div-footer">
                <button class="btn btn-secondary" @click="cancelEdit">Cancel</button>
                <button class="btn btn-success" @click="saveProfile">Save</button>
            </div>
        </div>
    </div>
</template>
<script>
import navHeader from '../../common/navbars/Header.vue';
import userService from '../../utils/UserAPIService';

export default{
    name: 'userProfile',
    data(){
        return {
            firstname:'',
            lastname:'',
            password:'',
            email:'',
        }
    },
    components:{
        navHeader
    },
    methods: {
        cancelEdit: function(){
            location.href="/recipes";
            console.log("default val" + this.default);
        },
        emailChangeHandler: function(event){
            this.email = event.target.value;
            console.log(this.email);
        },
        passwordChangeHandler: function(event){
            this.password = event.target.value;
            console.log(this.password);
        },
        fnameChangeHandler: function(event){
            this.firstname = event.target.value;
            console.log(this.firstname);
        },
        lnameChangeHandler: function(event){
            this.lastname = event.target.value;
            console.log(this.lastname);
        },
        saveProfile: function(){
            userService.getUserByEmail(sessionStorage.getItem('email')).then((response) => {
                console.log(response.data.id);
                var Id = response.data.id;
                let user = {
                    email: this.email,
                    fname: this.firstname,
                    lname: this.lastname,
                    password: this.password,
                }
                try{
                    userService.saveProfile(Id, user);
                    alert("Successfully changed!");
                    location.href="/recipes";
                }catch(err){
                    alert(err.message);
                }
                
            });
        },
        loadDefaults: function(){
            userService.getUserByEmail(sessionStorage.getItem('email')).then((response) => {
                console.log(response.data.email)
                this.email = response.data.email;
                this.firstname = response.data.fname;
                this.lastname = response.data.lname;
                this.password = response.data.password;
            });
        },
    },
    mounted() {
        this.loadDefaults();
    }   
}

</script>
<style src="../../css/EditProfile.scss" lang="scss"/>