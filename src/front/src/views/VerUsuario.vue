<template>
  <div class="col">
    <h2 class="m-4">{{ user.username }}</h2>
    <ul>
      <li class="m-2">Nombre: {{ user.name }}</li>
      <li class="m-2">Apellidos: {{ user.surname }}</li>
      <li class="m-2" v-if="user.password != undefined">
        Contraseña: {{ Array(user.password.length).join("*") }}
      </li>
      <li class="m-2">Rol: {{ user.role }}</li>
    </ul>
    <button @click="editarUsuario" type="button" class="btn btn-info ml-4 mt-4">
      Editar
    </button>
    <button
      @click="eliminarUsuario"
      type="button"
      class="btn btn-info ml-4 mt-4"
    >
      Eliminar
    </button>
  </div>
</template>

<script>
export default {
  name: "ver-usuario",
  data() {
    return {
      user: {},
    };
  },
  props: {
    id: String,
  },
  methods: {
    getUser(id) {
      fetch(`http://localhost:8080/users/${id}`)
        .then((response) => response.json())
        .then((data) => {
          this.user = data;
        });
    },
    editarUsuario() {
      console.log("modificando");
    },
    eliminarUsuario() {
      fetch(`http://localhost:8080/users/${this.user.id}`, {
        method: "DELETE",
      })
        .then((response) => response.text())
        .then(() => {
          this.$router.go(-1);
        });
    },
  },
  mounted() {
    this.getUser(this.id);
  },
};
</script>

<style scoped>
</style>