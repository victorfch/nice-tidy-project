<template>
  <div class="container">
    <img src="@/assets/logo.png" alt="logo" class="image mb-4" />
    <div class="text-container">
      <input type="hidden" />
      <input
        class="form-control"
        type="text"
        v-on:keyup.enter="send"
        v-model="user.username"
        placeholder="Username"
      />
      <input
        class="form-control"
        type="password"
        v-on:keyup.enter="send"
        v-model="user.password"
        placeholder="Password"
      />
      <button class="btn btn-lg btn-primary btn-block" @click="send">
        Enviar
      </button>
    </div>
    <div class="red" @click="messageOn">¿Olvidaste la contraseña?</div>
    <div class="alert alert-info" v-if="message">
      Para recuperar la contraseña, ponte en contacto con el mánager
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
      user: {},
      message: false,
    };
  },
  methods: {
    messageOn() {
      this.error = false;
      this.message = true;
    },
    send() {
      const options = {
        method: "post",
        body: JSON.stringify(this.user),
        headers: {
          "Content-Type": "application/json",
        },
      };
      fetch("http://localhost:8080/login", options)
        .then((response) => response.json())
        .then((data) => {
          if (data.status == 404) {
            this.error = true;
            this.message = false;
            this.errorMessage = data.message;
          } else {
            localStorage.login = JSON.stringify(data);
            if (data.role === "ROLE_GOVER") {
              window.location.href = "http://localhost:3000/#/gobernanta";
              location.reload();
            } else if (data.role === "ROLE_CHAMBERMAIDS") {
              window.location.href = "http://localhost:3000/#/camarera";
              location.reload();
            } else {
              this.$router.go();
            }
          }
        });
    },
  },
};
</script>

<style scoped>
.red {
  color: red;
  font-size: 14px;
}
input[type="text"] {
  margin-bottom: -1px;
  border-bottom-right-radius: 0;
  border-bottom-left-radius: 0;
}
input[type="password"] {
  margin-bottom: 10px;
  border-top-left-radius: 0;
  border-top-right-radius: 0;
}
.red:hover {
  cursor: pointer;
}
.container {
  display: flex;
  flex-direction: column;
  justify-content: center;
  height: max-content;
  align-items: center;
  padding-top: 3em;
  padding-left: 3em;
  padding-left: 3em;
}
.text-container,
.alert {
  display: flex;
  flex-direction: column;
  margin: 0 auto;
  width: max-content;
  min-width: 230px;
}
.image {
  margin: 15px;
  height: 40vh;
  width: 25vw;
}
input,
button {
  margin-bottom: 1em;
}
.alert {
  min-width: 230px;
}
</style>