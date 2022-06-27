import axios from 'axios'
var CONST_VARIABLES = require('../common/constants/variables.js')

class UserService{
    registerUser(User){
        axios.post(CONST_VARIABLES.REGISTER_USER_URL, User);
    }
    isUserExist(email,password){
        let payload ={
            email: email,
            password: password,
        }
        return axios.post(CONST_VARIABLES.LOGIN_USER_URL,payload)
    }
    getUserByEmail(email){
        return axios.get(CONST_VARIABLES.USER_BASE + "/" + email)
    }
    saveProfile(Id, User){
        return axios.post(CONST_VARIABLES.EDIT_PROFILE_URL + "/" + Id, User)
    }
    // getAllUsers(){
    //     return axios.get(CONST_VARIABLES.RECIPE_URL)
    // }
    // addNewRecipe(Recipe){
    //     return axios.post(CONST_VARIABLES.RECIPE_URL, Recipe)
    // }
    // deleteRecipe(id){
    //     return axios.post(CONST_VARIABLES.RECIPE_URL+"/"+id)
    // }
    // updateRecipe(recipe,id){
    //     return axios.post(CONST_VARIABLES.UPDATE_RECIPE_URL+"/"+id, recipe)
    // }
}
export default new UserService()