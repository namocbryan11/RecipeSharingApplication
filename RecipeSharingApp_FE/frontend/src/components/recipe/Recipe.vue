<template>
    <div>
        <!--Header-->
        <navHeader />
        <div id="page">
            <h1 class="text-center"> RECIPE LIST </h1>
            <div class="action_buttons text-end" >
                <button type="button" class="btn btn-primary" @click="openModal(1,null)">
                    New recipe 
                </button>
            </div>
            <table class="table table-striped">
                <thead>
                    <th> ID </th>
                    <th> NAME </th>
                    <th> DESCRIPTION </th>
                    <th> VOTES </th>
                    <th> OPTIONS </th>
                </thead>
                <tbody>
                    <tr v-for="recipe in recipes" v-bind:key="recipe.id">
                        <td>{{recipe.id}}</td>
                        <td>{{recipe.name}}</td>
                        <td id="td-Description">{{recipe.description}}</td>
                        <td>{{recipe.vote}}</td>
                        <td>
                            <button type="button" class="btn btn-primary" @click="openModal(0,recipe)">EDIT</button>
                            <button type="button" class="btn btn-danger" @click="deleteRecipe(recipe)">DELETE</button>
                        </td>
                    </tr>
                </tbody>
            </table>
            <!--MODAL FOR CREATING AND EDITING RECIPE-->
            <div id="id01" class="modal">
                <modal_createRecipe 
                    :modalkey='modalKey'
                    :recipeId='recipeId'
                    :name='recipeName'
                    :description='recipeDescription'
                    :votes='recipeVote'
                    :editMode='isEditMode'
                    :modalTitle='modalTitle'
                    @closeModal='closeModal'
                    @getRecipes='getRecipes'
                /> 
            </div>
        </div>
    </div>    
</template>

<script>
import recipeService from '../../utils/RecipeAPIService'
import navHeader from '../../common/navbars/Header.vue'
import modal_createRecipe from '../../common/modals/createRecipe.vue';

export default {
    name:'RecipesComponent',
    data(){
        return{
            recipes: [],
            modalTitle: "",
            recipeId: -1,
            recipeName: "",
            recipeDescription: "",
            recipeVote: 0,
            isEditMode: false,
            modalKey:0,
        } 
    },
    methods:{
        getRecipes(){
            recipeService.getAllRecipe().then((response) =>{
                this.recipes = response.data;
            });
        },
        openModal: function(modal_key,recipe){
            document.getElementById('id01').style.display = 'block';
            this.modalKey = modal_key;
            if (modal_key == 1){
                this.modalTitle = "Add New Recipe";
                this.isEditMode = false;
            }
            else{
                this.modalTitle = "Edit Recipe";
                this.recipeName = recipe.name;
                this.recipeDescription = recipe.description;
                this.recipeVote = recipe.vote;
                this.isEditMode = true;
                this.recipeId = recipe.id;
            }
        },
        closeModal: function(){
            document.getElementById('id01').style.display = 'none';
            this.resetInputs();
        },
        resetInputs: function(){
            this.recipeId = -1;
            this.recipeName = "";
            this.recipeDescription = "";
            this.recipeVote = "";
        },
        deleteRecipe: function(recipe){
            recipeService.deleteRecipe(recipe.id).then(() =>{
                this.getRecipes();
            });
        },
    },
    created(){
        this.getRecipes()
    },
    components: {
        navHeader,
        modal_createRecipe,
    },

}
</script>

<style>
.action_buttons{
    margin: 10px;
}
#exampleModal{
    border: 1px solid black;
}
#id01{
  display: none; /* Hidden by default */
  position: fixed; /* Stay in place */
  z-index: 1; /* Sit on top */
  padding-top: 100px; /* Location of the box */
  left: 0;
  top: 0;
  width: 100%; /* Full width */
  height: 100%; /* Full height */
  overflow: auto; /* Enable scroll if needed */
  background-color: rgb(0,0,0); /* Fallback color */
  background-color: rgba(0,0,0,0.4); /* Black w/ opacity */
}
#page{
    width: 100%;
   padding: 20px;
}
html,body{
    margin: 0px !important;
    padding: 0px !important;
}
</style>
