<template>
  <div class="container">
    <div class="image-container">
      <img src="@/assets/logo.png" alt="logo" class="image">
    </div>
    <div class="text-container">
      <input type="text" v-model="username" placeholder="nombre de usuario" />
      <input type="password" v-model="password" placeholder="contraseña" />
      <button @click="send">Enviar</button>
    </div>
    <div class="alert alert-danger" v-if="error">
      {{ errorMessage }}
    </div>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
      error: false,
      errorMessage: "",
      username: "",
      password: "",
    };
  },
  methods: {
    send() {
      const user = {
        username: this.username,
        password: this.password,
      };
      const options = {
        method: "post",
        body: JSON.stringify(user),
        headers: {
          "Content-Type": "application/json",
        },
      };
      fetch("http://localhost:8080/login", options)
        .then((response) => response.json())
        .then((data) => {
          if (data.status == 404) {
            this.error = true;
            this.errorMessage = data.message;
          } else {
            localStorage.login = JSON.stringify(data);
            console.log(data);
            this.$router.go();
          }
        });
    },
  },
};
</script>

<style scoped>

.container{
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: max-content;
  align-items: center;
  padding-top: 3em;
  padding-left: 3em;
  padding-left: 3em;
}

.image-container, .text-container, .alert{
  display: flex;
  flex-direction: column;
  margin: 0 auto;
  width: max-content;
  min-width: 230px;
}

.image-container{
  width: 70%;
  margin-bottom: 2em;
}

.image{
  margin: 15px;
  width: 80%;
  margin: 0 auto;
}

input, button{
  margin-bottom: 1em;
}


.alert{
  min-width: 230px;
}
</style>