<template>
  <div>
    <input type="text" v-model="username" placeholder="nombre de usuario" />
    <input type="text" v-model="password" placeholder="contraseña" />
    <button @click="send">Enviar</button>
  </div>
</template>

<script>
export default {
  name: "Login",
  data() {
    return {
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
          localStorage.login = JSON.stringify(data);
          console.log(data);
          this.$router.go();
        });
    },
  },
};
</script>

<style scoped>
</style>