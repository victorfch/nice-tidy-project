<template>
  <div>
    <h2>Nuevo usuario</h2>
    <hr />
    <div>
      <form @submit.prevent="enviar" ref="form">
        <div class="form-group">
          <label for="username">Nombre de usuario</label>
          <input
            type="text"
            class="form-control"
            v-model="username"
            id="username"
          />
        </div>
        <div class="form-group">
          <label for="password">Contraseña</label>
          <input
            type="password"
            class="form-control"
            v-model="password"
            id="password"
          />
        </div>
        <div class="form-group">
          <label for="name">Nombre</label>
          <input type="text" class="form-control" v-model="name" id="name" />
        </div>
        <div class="form-group">
          <label for="surname">Apellidos</label>
          <input
            type="text"
            class="form-control"
            v-model="surname"
            id="surname"
          />
        </div>
        <div class="form-group">
          <label for="role">Rol</label>
          <input type="text" class="form-control" v-model="role" id="role" />
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "form-usuario",
  data() {
    return {
      username: "",
      name: "",
      password: "",
      surname: "",
      role: "",
    };
  },
  methods: {
    enviar() {
      const user = {
        username: this.username,
        password: this.password,
        name: this.name,
        surname: this.surname,
        role: this.role,
      };
      const options = {
        method: "post",
        body: JSON.stringify(user),
        headers: {
          "Content-Type": "application/json",
        },
      };
      fetch("http://localhost:8080/users", options)
        .then((response) => response.json())
        .then((data) => console.log(data));
    },
  },
};
</script>

<style scoped>
</style>