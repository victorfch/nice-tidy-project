<template>
  <div class="col">
    <h2 class="m-4">{{ user.username }}</h2>
    <ul>
      <li class="m-2">
        Nombre:
        <span>{{ user.name }}</span>
      </li>
      <li class="m-2">
        Apellidos:
        <span>{{ user.surname }}</span>
      </li>
      <li class="m-2">
        Contraseña:
        <span>********</span>
      </li>
      <li class="m-2">
        Rol:
        <span>
          <select id="role" v-model="user.role" disabled>
            <option value="ROLE_ADMIN">ADMIN</option>
            <option value="ROLE_RECEPCIONIST">RECEPCIONISTA</option>
            <option value="ROLE_CHAMBERMAIDS">CAMARERO DE PISO</option>
            <option value="ROLE_GOVER">GOBERNANTA</option>
          </select>
        </span>
      </li>
    </ul>

    <router-link
      class="btn btn-info ml-4 mt-4"
      :to="{ name: 'edit-usuario', params: { id: user.id } }"
    >
      Editar
    </router-link>

    <button @click="deleteUser" type="button" class="btn btn-info ml-4 mt-4">
      Eliminar
    </button>
    <button @click="back" type="button" class="btn btn-info ml-4 mt-4">
      Volver
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
        .then((data) => (this.user = data));
    },
    deleteUser() {
      fetch(`http://localhost:8080/users/${this.user.id}`, {
        method: "DELETE",
      })
        .then((response) => response.text())
        .then(() => {
          this.$router.go(-1);
        });
    },
    back() {
      this.$router.go(-1);
    },
    alertExito() {
      this.exito = true;
      setTimeout(() => {
        this.exito = false;
      }, 1000);
    },
  },
  mounted() {
    this.getUser(this.id);
  },
};
</script>