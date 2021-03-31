<template>
  <div>
    <h2>Nuevo usuario</h2>
    <hr />
    <div>
      <form @submit.prevent="enviar">
        <div class="form-group">
          <label for="nickname">Nombre de usuario</label>
          <input type="text" class="form-control" id="nickname" />
        </div>
        <div class="form-group">
          <label for="password">Contraseña</label>
          <input type="password" class="form-control" id="password" />
        </div>
        <div class="form-group">
          <label for="name">Nombre</label>
          <input type="text" class="form-control" id="name" />
        </div>
        <div class="form-group">
          <label for="surname">Apellidos</label>
          <input type="text" class="form-control" id="surname" />
        </div>
        <div class="form-group">
          <label for="role">Rol</label>
          <input type="text" class="form-control" id="role" />
        </div>
        <button type="submit" class="btn btn-primary">Guardar</button>
      </form>
    </div>
  </div>
</template>

<script>
export default {
  name: "form-usuario",
  methods: {
    enviar() {
      console.log("enviar");
    },
  },
};
</script>

<style scoped>
</style>