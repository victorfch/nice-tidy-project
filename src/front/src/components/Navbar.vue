<template>
  <div
    class="nav vh-100 flex-column navbar-light"
    style="background-color: #e3f2fd"
  >
    <li class="nav-item">
      <router-link class="nav-link" to="/">Home</router-link>
    </li>
    <li class="nav-item">
      <router-link class="nav-link" to="/habitaciones"
        >Habitaciones</router-link
      >
    </li>
    <li class="nav-item">
      <router-link class="nav-link" to="/usuarios">Usuarios</router-link>
    </li>

    <button class="btn btn-info mt-auto">Cerrar sesión</button>
  </div>
</template>

<script>
export default {
  name: "Navbar",
};
</script>

<style scoped>
.nav {
  padding: 30px;
}

.nav a {
  font-weight: bold;
  color: #2c3e50;
}

.nav a.router-link-exact-active {
  color: #42b983;
}
</style>