<template>
  <div>
    <h2>{{ user.nickname }}</h2>
    <ul>
      <li>Nombre: {{ user.name }}</li>
      <li>Apellidos: {{ user.surname }}</li>
      <li>Contraseña: {{ user.password }}</li>
      <li>Rol: {{ user.role }}</li>
    </ul>
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
          console.log(data);
        });
    },
  },
  mounted() {
    this.getUser(this.id);
  },
};
</script>

<style lang="scss" scoped>
</style>