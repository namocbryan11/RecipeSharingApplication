<template>
    <div class="container">
        <h1 class="text-center"> RECIPE LIST </h1>
        <div class="action_buttons text-end">
            <button 
            type="button" 
            class="btn btn-primary"
            @click="openModal(1,null)">
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
        <div id="modContent" class="modal-content">

            <div class="modal_dialog">
                <div class="modal-header">
                    <h5 class="modal-title" id="exampleModalLabel">{{modalTitle}}</h5>
                </div>
                <div class="modal-body">
                    <div class="form-floating mb-3">
                        <input type="text" v-model="recipeName" class="form-control" id="floatingInput" placeholder="name@example.com" v-on:change="changeRecipeNameHandler">
                        <label for="floatingInput">Recipe Name</label>
                    </div>
                    <div class="form-floating">
                        <textarea v-model="recipeDescription" class="form-control" id="floatingPassword" placeholder="Description" v-on:change="changeRecipeDescriptionHandler">
                        </textarea>
                        <label for="floatingPassword">Description</label>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" @click="closeModal">Close</button>
                    <button type="button" v-if="isEditMode" class="btn btn-success" @click="updateRecipe">Save</button>
                    <button type="button" v-else class="btn btn-success" @click="saveRecipe">Save</button>
                </div>
            </div>
        </div>
    </div>
    </div>    
</template>

<script>
import recipeService from '../../utils/RecipeAPIService'

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
        changeRecipeNameHandler: function(event){ 
            this.recipeName = event.target.value;
        },
        changeRecipeDescriptionHandler: function(event){ 
            this.recipeDescription = event.target.value;
        },
        saveRecipe: function(){
            let recipe ={
                name: this.recipeName,
                description: this.recipeDescription,
                votes: this.recipeVote,
            }
            recipeService.addNewRecipe(recipe).then(() => {
                this.getRecipes();
            });
            this.closeModal();
        },
        updateRecipe: function(){
            let recipe ={
                name: this.recipeName,
                description: this.recipeDescription,
                votes: this.recipeVote,
            }
            recipeService.updateRecipe(recipe,this.recipeId).then(() => {
                this.getRecipes();
            });
            this.closeModal();
        },
        deleteRecipe: function(recipe){
            recipeService.deleteRecipe(recipe.id).then(() =>{
                this.getRecipes();
            });
        },
        resetInputs: function(){
            this.recipeId = -1;
            this.recipeName = "";
            this.recipeDescription = "";
            this.recipeVote = "";
        },
    },

    created(){
        this.getRecipes()
    }

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
#modContent{
    max-width: 40%;
    min-width: 250px;
    background: white;
    margin: auto;
    padding: 20px;
}
.modal_dialog{
    width: 90%;
    margin: auto;
}
#td-Description{
    max-width: 200px;
}
#floatingPassword{
    height: 350px;
}
</style>
