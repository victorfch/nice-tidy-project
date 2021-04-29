<template>
  <div class="col">
    <h2 class="m-4">{{ user.username }}</h2>
    <ul>
      <li class="m-2">Nombre: 
        <input v-if="update" type="text" v-model="user.name">
        <span v-else>{{ user.name }}</span>
      </li>
      <li class="m-2">Apellidos: 
        <input v-if="update" type="text" v-model="user.surname">
        <span v-else>{{ user.surname }}</span>
      </li>
      <li class="m-2" v-if="user.password != undefined">
        Contraseña: 
        <!-- pensar cómo hacer para modificar la contraseña, porque al entrar tiene el valor del code  -->
        <!-- quizá dejar el campo vacío en user ???? quizás con un watch?? no sé usarlo bien..-->
        <!-- <input v-if="update" type="text" v-model="user.password"> -->
        <span>********</span>
      </li>
      <li class="m-2">Rol: 
        <input v-if="update" type="text" v-model="user.role">
        <span v-else>{{ user.role }}</span>
      </li>
    </ul>
    <button v-if="update" @click="confirmEdit" type="button" class="btn btn-info ml-4 mt-4">Aceptar</button>
    <button v-else @click="editUser" type="button" class="btn btn-info ml-4 mt-4">Editar</button>
    <button v-if="update" @click="cancelEdit" type="button" class="btn btn-info ml-4 mt-4">Cancelar</button>
    <button v-else @click="deleteUser" type="button" class="btn btn-info ml-4 mt-4">Eliminar</button>
    <button @click="back"  type="button" class="btn btn-info ml-4 mt-4">Volver</button>
  </div>
</template>

<script>
export default {
  name: "ver-usuario",
  data() {
    let update=false;
    return {
      user: {},
      update,
      errorCamposVacios: false,
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
    editUser() {
      this.update=true;
    },
    cancelEdit(){
      this.update=false;
    },
    checkFillInputs(){
      this.errorCamposVacios = false;
      if (
        this.username == "" ||
        //this.password == "" ||  de momento sin este campo, hay que solucionarlo
        this.name == "" ||
        this.surname == "" ||
        this.role == ""
      ) {
        this.errorCamposVacios = true;
      }
    },
    //no funciona por error de CORS
    confirmEdit(){
      this.checkFillInputs();
      if(!this.errorCamposVacios){
        const user = {
          name: this.name,
          username: this.username,
          //password: this.password,  de momento sin este campo, hay que solucionarlo
          role: this.role,
          surname: this.surname,
        };
        const options = {
          method: "put",
          body: JSON.stringify(user),
          headers: {
            "Content-Type": "application/json",
          },
        };
        fetch(`http://localhost:8080/users/${this.user.id}`, options)
        .then((response)=> response.json())
        .then(()=>{
          this.alertExito();
          setTimeout(() => this.$router.go(-1), 2500);
        })
      } 
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
    back(){
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

<style scoped>
/* modificar el stilo del span para que no se mueva al editar y meter nputs */
</style>