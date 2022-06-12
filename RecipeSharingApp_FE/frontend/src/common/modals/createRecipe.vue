<template>
     <div id="modContent" class="modal-content">
        <div class="modal_dialog">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">{{modalTitle}}</h5>
            </div>
            <div class="modal-body">
                <div class="form-floating mb-3">
                    <input type="text" :value="name" class="form-control" id="name" placeholder="name@example.com" v-on:change="changeRecipeNameHandler">
                    <label for="name">Recipe Name</label>
                </div>
                <div class="form-floating">
                    <textarea :value="description" class="form-control" id="description" placeholder="Description" v-on:change="changeRecipeDescriptionHandler">
                    </textarea>
                    <label for="description">Description</label>
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" v-if="editMode" class="btn btn-success" @click="updateRecipe">Save Changes</button>
                <button type="button" v-else class="btn btn-success" @click="saveRecipe">Save</button>
                <button type="button" class="btn btn-secondary" @click="closeModal">Close</button>
            </div>
        </div>
    </div>
</template>

<script>
import recipeService from '../../utils/RecipeAPIService';
export default {
    name:"createRecipe",
    data(){
        return{
            recipeName:"",
            recipeDescription:"",
            recipeVote:0,
            modalKey:this.modalkey,
        }   
    },
    props:[
        'modalkey',
        'name',
        'recipeId',
        'description',
        'votes',
        'editMode',
        'modalTitle',
    ],
    methods:{
        closeModal: function(){
            this.$emit('closeModal');
        },
        isValuesNotChanged: function(){
            var recipename = document.getElementById('name').value;
            var recipedescription = document.getElementById('description').value;

            if(recipename === this.name && recipedescription === this.description){
                return true;
            }else if(recipename ===  "" && recipedescription === ""){
                return true;
            }else{
                this.recipeName = recipename;
                this.recipeDescription = recipedescription;
                return false;
            }
        },
        saveRecipe: function(){
            let recipe ={
                name: this.recipeName,
                description: this.recipeDescription,
                votes: this.recipeVote,
            }
            recipeService.addNewRecipe(recipe).then(() => {
                this.$emit('getRecipes');
            });
            this.closeModal();
        },
        updateRecipe: function(){
            if(!this.isValuesNotChanged()){
                let recipe ={
                    name: this.recipeName,
                    description: this.recipeDescription,
                    votes: this.recipeVote,
                }
                recipeService.updateRecipe(recipe,this.recipeId).then(() => {
                    this.$emit('getRecipes');
                });
            }
            this.closeModal();
        },
        changeRecipeNameHandler: function(event){
            this.recipeName = event.target.value;
        },
        changeRecipeDescriptionHandler: function(event){ 
            this.recipeDescription = event.target.value;
            console.log(this.recipeDescription)
        },
    },

}

</script>

<style>
#modContent{
    max-width: 40%;
    min-width: 350px;
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
#description{
    height: 30vh;
}
</style>