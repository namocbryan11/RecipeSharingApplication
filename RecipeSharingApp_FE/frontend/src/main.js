import { createApp } from 'vue';
import App from './App.vue';
import Recipes from "./components/recipe/Recipe.vue";
import Users from "./components/users/Users.vue";
import Login from './components/loginRegister/Login.vue';
import Register from './components/loginRegister/Register.vue';

import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/css/bootstrap.css'

import { createRouter, createWebHistory } from 'vue-router';

const router = createRouter({
    history: createWebHistory(),
    routes:[
        {
            path: "/",
            component: Login,
        },
        {
            path: "/recipes",
            component: Recipes,
        },
        {
            path: "/users",
            component: Users,
        },
        {
            path: "/login",
            component: Login,
        },
        {
            path: "/register",
            component: Register,
        }
    ],
});

const app = createApp(App);
app.use(router);
app.mount('#app');
