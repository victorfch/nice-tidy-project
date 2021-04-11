<template>
  <div>
    <h1>Habitaciones</h1>
    <hr />
        <div class="alert alert-success" v-if="exitoEliminar">
            Habitación eliminada con éxito
        </div>
    <form-habitaciones :habitaciones="habitaciones" />

    <div class="card-columns">
      <div
        class="card pt-2"
        v-for="habitacion in habitaciones"
        :key="habitacion.id"
      >
        <div class="class-divider">
          <div class="ml-5">
            <div>Habitación {{ habitacion.number }}</div>
            <div>
              {{ getRoomType(habitacion.type) }}
            </div>
            <div>
              {{ habitacion.bedsNumber }} cama{{
                habitacion.bedsNumber > 1 ? "s" : null
              }}
            </div>
          </div>
          <div class="card-footer text-center">
            <button @click="modificarHabitacion" type="button" class="btn">
              <i class="fas fa-pencil-alt"></i>
            </button>
            <button
              @click="eliminarHabitacion(habitacion.id)"
              type="button"
              class="btn"
            >
              <i class="far fa-trash-alt"></i>
            </button>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import FormHabitaciones from '../components/FormHabitaciones.vue'
export default {
  name: "Habitaciones",
  data() {
    return {
      habitaciones: [],
      exitoEliminar:false,
    };
  },
  components:{
    FormHabitaciones
  },
  methods: {
    getHabitaciones() {
      fetch("http://localhost:8080/rooms")
        .then((response) => response.json())
        .then((data) => {
          this.habitaciones = data;
          this.habitaciones = this.habitaciones.sort((a, b) => {
            if (a.number > b.number) {
              return 1;
            } else {
              return -1;
            }
          });
        });
    },
    getRoomType(type) {
      if (type == 1) {
        return "Individual";
      }
      if (type == 2) {
        return "Doble";
      }
      if (type == 3) {
        return "Triple";
      }
      return "Suite";
    },
    modificarHabitacion() {
      console.log("modificando...");
    },
    eliminarHabitacion(id) {
      this.exitoEliminar=false;
      fetch(`http://localhost:8080/rooms/${id}`, {
        method: "DELETE",
      })
        .then((response) => response.text())
        .then(() => {
          this.alertExitoEliminar();
          this.getHabitaciones()
        });
    },
    alertExitoEliminar() {
        this.exitoEliminar = true;
        setTimeout(() => {
            this.exitoEliminar = false;
        }, 2000);
    },
  },
  mounted() {
    this.getHabitaciones();
  },
};
</script>

<style scoped>
/* si no lo pongo siempre.. se mueve el diseño al pasar el ratón x encima*/
input[type="number"]::-webkit-inner-spin-button {
  opacity: 1;
}
/* .celeste {
  background-color: #e3f2fd;
} */
</style>