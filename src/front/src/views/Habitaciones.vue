<template>
  <div class="habitaciones">
    <div class="row">
      <div class="col-12"><h1>Habitaciones</h1></div>
    </div>
    <hr />
    <div class="alert alert-danger" v-if="errorCampos">
      Debe rellenar todos los campos
    </div>
    <div class="alert alert-danger" v-if="errorNumber">
      El número de habitación introducida ya existe
    </div>
    <div class="alert alert-success" v-if="exito">
      Habitación añadida con éxito
    </div>
    <form
      ref="form"
      @submit.prevent="addHab"
      class="form-group row pl-3 justify-content-center"
    >
      <label for="number" class="col-form-label mr-1">Nº Habitación: </label>
      <input
        v-model="numero"
        min="1"
        type="number"
        class="form-control col-5 col-sm-2 m-2"
        id="number"
      />
      <div class="d-sm-none w-100"></div>
      <label for="beds" class="col-form-label ml-2 mr-1">Nº Camas: </label>
      <input
        v-model="beds"
        type="number"
        min="1"
        oninput="validity.valid||(value='');"
        class="form-control col-5 col-sm-2 m-2"
        id="beds"
      />

      <div class="d-block d-sm-block d-lg-none w-100"></div>

      <label for="type" class="col-form-label ml-2 mr-1">Tipo: </label>
      <select class="form-select col-5 col-sm-2 m-2" v-model="selected">
        <option value="1">Individual</option>
        <option value="2">Doble</option>
        <option value="3">Triple</option>
        <option value="4">Suite</option>
      </select>
      <div class="d-sm-none w-100"></div>
      <button type="submit" class="btn btn-info ml-4">Añadir</button>
    </form>

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
export default {
  name: "Habitaciones",
  data() {
    return {
      habitaciones: [],
      numero: "",
      beds: "",
      selected: "1",
      errorCampos: false,
      errorNumber: false,
      exito: false,
    };
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
    check(array, key, value) {
      return array.some((object) => object[key] == value);
    },
    addHab() {
      this.errorCampos = false;
      this.errorNumber = false;
      if (this.numero == "" || this.beds == "") {
        this.errorCampos = true;
      }
      if (!this.errorCampos) {
        if (this.check(this.habitaciones, "number", this.numero)) {
          this.errorNumber = true;
        } else {
          const room = {
            number: parseInt(this.numero),
            bedsNumber: parseInt(this.beds),
            type: parseInt(this.selected),
          };
          const options = {
            method: "post",
            body: JSON.stringify(room),
            headers: {
              "Content-Type": "application/json",
            },
          };
          fetch("http://localhost:8080/rooms", options)
            .then((response) => response.json())
            .then(() => this.getHabitaciones());
        }
      }
      this.alertExito();
      this.borrarRegistro();
    },
    borrarRegistro() {
      this.numero = undefined;
      this.beds = undefined;
      this.selected = undefined;
    },
    modificarHabitacion() {
      console.log("modificando...");
    },
    eliminarHabitacion(id) {
      fetch(`http://localhost:8080/rooms/${id}`, {
        method: "DELETE",
      })
        .then((response) => response.text())
        .then(() => this.getHabitaciones());
    },
    alertExito() {
      this.exito = true;
      setTimeout(() => {
        this.exito = false;
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