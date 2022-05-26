import axios from 'axios'
var CONST_VARIABLES = require('../common/constants/variables.js')

class RecipeService{
    getAllRecipe(){
        return axios.get(CONST_VARIABLES.RECIPE_URL)
    }
    addNewRecipe(Recipe){
        return axios.post(CONST_VARIABLES.RECIPE_URL, Recipe)
    }
    deleteRecipe(id){
        return axios.post(CONST_VARIABLES.RECIPE_URL+"/"+id)
    }
    updateRecipe(recipe,id){
        return axios.post(CONST_VARIABLES.UPDATE_RECIPE_URL+"/"+id, recipe)
    }
}
export default new RecipeService()