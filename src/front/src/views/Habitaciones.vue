<template>
  <div class="habitaciones">
    <div class="row">
      <div class="col-12"><h3>Habitaciones</h3></div>
    </div>
    <hr />
    <form class="form-group row pl-3 justify-content-center" >
      <label for="number" class="col-form-label mr-2">Nº Habitación: </label>
      <input type="number" class="form-control col-1" id="number" />
      <label for="beds" class="col-form-label ml-4 mr-2">Nº Camas: </label>
      <input type="number" class="form-control col-1" id="beds" />
      <label for="type" class="col-form-label ml-4 mr-2">Tipo: </label>
      <select class="form-select">
        <option selected value="1">Individual</option>
        <option value="2">Doble</option>
        <option value="3">Triple</option>
        <option value="4">Suite</option>
      </select>
      <button type="submit" class="btn celeste ml-4">Añadir</button>
    </form>
    <div class="row">
      <div
        class="col-3 mb-3"
        v-for="habitacion in habitaciones"
        :key="habitacion.id"
      >
        <div class="card">
          <div class="class-divider p-3">
            <div class="num">Habitación {{ habitacion.number }}</div>
            <div class="type" v-if="habitacion.type == 1">Individual</div>
            <div class="type" v-else-if="habitacion.type == 2">Doble</div>
            <div class="type" v-else-if="habitacion.type == 3">Triple</div>
            <div class="type" v-else-if="habitacion.type == 4">Suite</div>
            <div class="beds" v-if="habitacion.bedsNumber == 1">
              {{ habitacion.bedsNumber }} cama
            </div>
            <div class="beds" v-if="habitacion.bedsNumber > 1">
              {{ habitacion.bedsNumber }} camas
            </div>
          </div>
          <div class="card-footer text-center">
            <button
              @click="$emit('modificar-habitacion', habitacion)"
              type="button"
              class="btn btn-sm text-left mr-3"
            >
              <img src="../assets/edit.png" />
            </button>
            <button
              @click="$emit('eliminar-habitacion', habitacion)"
              type="button"
              class="btn btn-sm text-left"
            >
              <img src="../assets/cross.png" />
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "lista-habitaciones",
  data() {
    return {
      habitaciones: [],
    };
  },
  methods: {
    recibirHabitaciones() {
      fetch("http://localhost:8080/rooms")
        .then((response) => response.json())
        .then((data) => {
          this.habitaciones = data;
          this.habitaciones.sort((a, b) => {
            if (a.number > b.number) {
              return 1;
            } else {
              return -1;
            }
          });
        });
    },
  },
  mounted() {
    this.recibirHabitaciones();
  },
};
</script>

<style scoped>
.celeste{
  background-color: #E3F2FD;
}
</style>