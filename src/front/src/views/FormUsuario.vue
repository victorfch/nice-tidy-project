<template>
  <div id="container">
    <h2>Nuevo usuario</h2>
    <hr />
    <div>
      <div class="alert alert-success" v-if="exito">
        Usuario {{ id ? "editado" : "añadido" }} con éxito
      </div>
      <form @submit.prevent="enviar">
        <input type="hidden" v-model="user.id" />
        <div class="form-group">
          <label for="username">Nombre de usuario</label>
          <input
            type="text"
            class="form-control"
            v-model="user.username"
            id="username"
            required
          />
        </div>
        <div class="form-group">
          <label for="password">Contraseña</label>
          <input
            type="password"
            class="form-control"
            v-model="user.password"
            id="password"
            required
          />
        </div>
        <div class="form-group">
          <label for="name">Nombre</label>
          <input
            type="text"
            class="form-control"
            v-model="user.name"
            id="name"
            required
          />
        </div>
        <div class="form-group">
          <label for="surname">Apellidos</label>
          <input
            type="text"
            class="form-control"
            v-model="user.surname"
            id="surname"
            required
          />
        </div>
        <div class="form-group">
          <label for="role">Rol</label>
          <select id="role" v-model="user.role">
            <option value="ROLE_ADMIN">ADMIN</option>
            <option value="ROLE_RECEPCIONIST">RECEPCIONISTA</option>
            <option value="ROLE_CHAMBERMAIDS">CAMARERO DE PISO</option>
            <option value="ROLE_GOVER">GOBERNANTA</option>
          </select>
          <span> 
            <button type="submit" class="btn btn-primary">Guardar</button>
            <button @click="$router.replace('/usuarios')" class="btn btn-secondary ml-4"> Cancelar </button>
          </span>
        </div>
        <!-- <div class="buttons">
        </div> -->
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "form-usuario",
  data() {
    return {
      user: {},
      exito: false,
    };
  },
  props: {
    id: String,
  },
  mounted() {
    this.id &&
      fetch(`http://localhost:8080/users/${this.id}`)
        .then((response) => response.json())
        .then((data) => (this.user = data));
  },
  methods: {
    enviar() {
      const options = {
        method: "post",
        body: JSON.stringify(this.user),
        headers: {
          "Content-Type": "application/json",
        },
      };
      const url = this.id
        ? `http://localhost:8080/users/${this.id}`
        : "http://localhost:8080/users";
      fetch(url, options)
        .then((response) => response.json())
        .then(() => {
          this.alertExito();
          setTimeout(() => this.$router.go(-1), 2500);
        });
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
input{
  width: 80%;
}
select{
  margin-top: 10px;
  margin-left: 57px;
  height: 35px;
  border-radius: 5px;
}
span{
  margin-top: 10px;
  float: right;
  margin-right: 10%;  
}
.btn:nth-child(){
  float:right;
}
div.form-group{
  margin-left: 5%;
}
</style>