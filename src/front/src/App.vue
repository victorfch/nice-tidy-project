<template>
  <div v-if="loged">
    <div class="row">
      <navbar />
      <div class="container col-md-9 mt-3">
        <router-view />
      </div>
    </div>
  </div>
  <div v-else>
    <login />
  </div>
</template>
<script>
import Navbar from "./components/Navbar.vue";
import Login from "./views/Login.vue";
export default {
  components: {
    Navbar,
    Login,
  },
  name: "App",
  computed: {
    loged() {
      return localStorage.login;
    },
  },
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  width: 98.4%;
}
* {
  box-sizing: border-box;
}
</style>