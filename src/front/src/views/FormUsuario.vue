<template>
  <div>
    <h2>Nuevo usuario</h2>
    <hr />
    <div>
      <div class="alert alert-success" v-if="exito">
        Usuario añadido con éxito
      </div>
      <form @submit.prevent="enviar">
        <div class="form-group">
          <label for="nickname">Nombre de usuario</label>
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
      errorCamposVacios: false,
      username: "",
      name: "",
      password: "",
      surname: "",
      role: "",
      exito: false,
    };
  },
  methods: {
    enviar() {
      this.errorCamposVacios = false;
      if (
        this.username == "" ||
        this.password == "" ||
        this.name == "" ||
        this.surname == "" ||
        this.role == ""
      ) {
        this.errorCamposVacios = true;
      }
      if (!this.errorCamposVacios) {
        const user = {
          name: this.name,
          username: this.username,
          password: this.password,
          role: this.role,
          surname: this.surname,
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
      }
      this.alertExito();
      this.borraRegistros();
      /* poner un alert que desaparezca a los 2 segundos -> tengo una pagina localizada */
    },
    borraRegistros() {
      this.name = "";
      this.nickname = "";
      this.password = "";
      this.role = "";
      this.surname = "";
    },
    alertExito() {
      this.exito = true;
      setTimeout(() => {
        this.exito = false;
      }, 1000);
    },
  },
};
</script>

<style scoped>
</style>