<template>
  <div class="habitaciones">
    <div class="row">
      <div class="col-12"><h1>Habitaciones</h1></div>
    </div>
    <hr />
    <form @submit.prevent="addHab" class="form-group row pl-3 justify-content-center">
      <label for="number" class="col-form-label mr-1">Nº Habitación: </label>
      <input v-model="numero" min="1" oninput="validity.valid||(value='');" type="number" 
            class="form-control col-5 col-sm-2 m-2" id="number"  />
      <div class="d-sm-none w-100"></div>
      <label for="beds" class="col-form-label ml-2 mr-1">Nº Camas: </label>
      <input v-model="beds" type="number" min="1" oninput="validity.valid||(value='');" 
            class="form-control col-5 col-sm-2 m-2" id="beds"/>

      <div class="d-block d-sm-block d-lg-none w-100"></div>

      <label for="type" class="col-form-label ml-2 mr-1">Tipo: </label>
      <select class="form-select col-5 col-sm-2 m-2" v-model="selected">
        <option disabled value="">Seleccione un tipo</option>
        <option value="1">Individual</option>
        <option value="2">Doble</option>
        <option value="3">Triple</option>
        <option value="4">Suite</option>
      </select>
      <div class="d-sm-none w-100"></div>
      <button type="submit" class="btn btn-info ml-4">Añadir</button>
    </form>
    <div class="alert alert-danger" v-if="error">Debe rellenar todos los campos</div>
    <div class="row">
      <div
        class="col-12 col-sm-6 col-md-4 mb-3"
        v-for="habitacion in habitaciones"
        :key="habitacion.id"
      >
        <div class="card">
          <div class="class-divider p-3">
            <div class="num offset-1">Habitación {{ habitacion.number }}</div>
            <div class="type offset-1" v-if="habitacion.type == 1">Individual</div>
            <div class="type offset-1" v-else-if="habitacion.type == 2">Doble</div>
            <div class="type offset-1" v-else-if="habitacion.type == 3">Triple</div>
            <div class="type offset-1" v-else-if="habitacion.type == 4">Suite</div>
            <div class="beds offset-1" v-if="habitacion.bedsNumber == 1">
              {{ habitacion.bedsNumber }} cama
            </div>
            <div class="beds offset-1" v-if="habitacion.bedsNumber > 1">
              {{ habitacion.bedsNumber }} camas
            </div>
          </div>
          <div class="card-footer text-center">
            <button
              @click="modificarHabitacion"
              type="button"
              class="btn btn-sm text-left mr-3"
            >
              <img src="../assets/edit.png" />
            </button>
            <button
              @click="eliminarHabitacion"
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
  name: "Habitaciones",
  el: '#alerta',
  data() {
    return {
      habitaciones: [],
      numero:'',
      beds:'',
      selected:'',
      error:false,
    };
  },
  methods: {
    getHabitaciones() {
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
    addHab(){
      if(this.numero == "" || this.beds =="" || this.selected=="" ){
        this.error=true;
      }else{
        this.error=false;
      }
    },
    modificarHabitacion(){
      console.log("modificando...");
    },
    eliminarHabitacion(){
      console.log("eliminando...");
    },
  },
  mounted() {
    this.getHabitaciones();
  },
};
</script>

<style scoped>
/* si no lo pongo siempre.. se mueve el diseño al pasar el ratón x encima*/
input[type=number]::-webkit-inner-spin-button {
    opacity: 1
}
.card{
  min-width: 130px;
}
/* .celeste {
  background-color: #e3f2fd;
} */
</style>