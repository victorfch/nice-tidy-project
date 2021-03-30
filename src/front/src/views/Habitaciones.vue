<template>
  <div class="habitaciones">
    <div class="row">
      <div class="col-12"><h3>Habitaciones</h3></div>
    </div>
    <hr />
    <div class="row">
      <div
        class="col-4"
        v-for="habitacion in habitaciones"
        :key="habitacion.id"
      >
        <div class="card">
          <div class="class-divider p-3">
            <div class="num">Habitación {{ habitacion.number }}</div>
            <div class="type">Tipo de habitación: {{ habitacion.type }}</div>
            <div class="beds">{{ habitacion.bedsNumber }} camas</div>
          </div>
          <div class="card-footer">
            <button
              @click="$emit('modificar-habitacion', habitacion)"
              type="button"
              class="btn btn-warning btn-sm text-left"
            >
              <img src="../assets/edit.png" />
            </button>
            <button
              @click="$emit('eliminar-habitacion', habitacion)"
              type="button"
              class="btn btn-danger btn-sm text-left"
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
          this.habitaciones.sort((a,b)=>{
            if(a.number>b.number){
              return 1;
            }else{
              return -1;
            }
          })
        });
    },
  },
    mounted(){
    this.recibirHabitaciones();
  }
};
</script>

<style scoped>
</style>