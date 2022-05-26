<template>
  <Recipes_component />
</template>

<script>
import Recipes_component from './components/recipe/Recipe.vue'

export default {
  name: 'App',
  components: {
    Recipes_component
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
