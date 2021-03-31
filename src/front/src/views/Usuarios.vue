<template>
  <div>
    <h1>Página de usuarios</h1>
    <hr />
    <router-link class="btn btn-primary" to="/nuevo-usuario"
      ><i class="fas fa-plus"></i> Usuario</router-link
    >
    <div class="card-columns mt-2">
      <div v-for="user in users" :key="user.id" class="card">
        <div class="card-title p-2">{{ user.fullName }}</div>
        <div class="card-footer text-center">
          <router-link
            class="btn btn-info"
            :to="{ name: 'ver-usuario', params: { id: user.id } }"
            >Ver más</router-link
          >
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  name: "Usuarios",
  data() {
    return {
      users: [],
    };
  },
  methods: {
    getUsers() {
      fetch("http://localhost:8080/users")
        .then((response) => response.json())
        .then((data) => {
          this.users = data;
        });
    },
  },
  mounted() {
    this.getUsers();
  },
};
</script>