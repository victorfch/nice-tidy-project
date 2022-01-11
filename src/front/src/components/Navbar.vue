<template>
  <nav
    class="navbar navbar-expand-lg navbar-light col-lg-3 col-sm-12"
    style="background-color: #e3f2fd"
  >
    <router-link class="navbar-brand m-2" to="/">
      <span class="d-block d-lg-none">Nice & Tidy</span>
    </router-link>
    <button
      class="navbar-toggler"
      type="button"
      data-toggle="collapse"
      data-target="#navbarSupportedContent"
      aria-controls="navbarSupportedContent"
      aria-expanded="false"
      aria-label="Toggle navigation"
    >
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse p-2" id="navbarSupportedContent">
      <ul class="navbar-nav">
        <li class="nav-item">
          <router-link
            v-if="user.role === 'ROLE_CHAMBERMAIDS'"
            class="nav-link"
            to="/camarera"
            >Inicio</router-link
          >
        </li>

        <li v-if="user.role === 'ROLE_GOVER'" class="nav-item">
          <router-link class="nav-link" to="/gobernanta">Inicio</router-link>
        </li>

        <li
          v-if="user.role === 'ROLE_ADMIN' || user.role === 'ROLE_RECEPCIONIST'"
          class="nav-item"
        >
          <router-link class="nav-link" to="/">Inicio</router-link>
        </li>

        <li
          v-if="user.role === 'ROLE_RECEPCIONIST' || user.role === 'ROLE_ADMIN'"
          class="nav-item"
        >
          <router-link class="nav-link" to="/reservas">Reservas</router-link>
        </li>

        <li v-if="user.role === 'ROLE_ADMIN'" class="nav-item">
          <router-link class="nav-link" to="/usuarios">Usuarios</router-link>
        </li>

        <li v-if="user.role === 'ROLE_ADMIN'" class="nav-item">
          <router-link class="nav-link" to="/habitaciones"
            >Habitaciones</router-link
          >
        </li>

        <button @click="logout" class="btn btn-info mt-auto">
          Cerrar sesión
        </button>
      </ul>
    </div>
  </nav>
</template>

<script>
export default {
  name: "Navbar",
  data() {
    return {
      user: JSON.parse(localStorage.login),
    };
  },
  methods: {
    logout() {
      localStorage.removeItem("login");
      window.location.href = "http://localhost:3000/#";
      location.reload();
    },
  },
};
</script>

<style scoped>
nav .navbar-collapse .navbar-nav a.router-link-exact-active {
  color: #42b983;
}
nav .navbar-collapse .navbar-nav a {
  font-weight: bold;
  color: #2c3e50;
}
@media (min-width: 990px) {
  nav {
    position: sticky;
    top: 0;
    text-align: center;
    display: flex;
    height: 100vh;
  }
  nav .navbar-brand {
    display: flex;
    margin: auto auto 0;
    padding: 0.5rem;
  }
  nav .navbar-collapse {
    display: flex;
    align-items: flex-start;
    flex-grow: 0;
    width: 100%;
    margin-bottom: auto;
  }
  nav .navbar-collapse .navbar-nav {
    flex-direction: column;
    width: 100%;
  }
  nav .navbar-collapse .navbar-nav .nav-item,
  nav .navbar-collapse .navbar-nav .nav-item .nav-link {
    display: block;
  }
  nav .navbar-collapse .navbar-nav {
    height: 95vh;
  }
}
</style>