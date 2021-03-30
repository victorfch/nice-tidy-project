<template>
  <div class="habitaciones">
    <div class="row">
      <div class="col-12"><h3>Habitaciones</h3></div>
    </div>
    <hr />
    <div class="row">
      <div
        class="col-2"
        v-for="habitacion in habitaciones"
        :key="habitacion.id"
      >
        <div class="card">
          <div class="class-divider p-2">
            <div class="num">Habitación {{ habitacion.number }}</div>
            <div class="type" v-if="habitacion.type==1">Individual </div>
            <div class="type" v-else-if="habitacion.type==2">Doble </div>
            <div class="type" v-else-if="habitacion.type==3">Triple </div>
            <div class="type" v-else-if="habitacion.type==4">Suite </div>
            <div class="beds" v-if="habitacion.bedsNumber==1">{{ habitacion.bedsNumber }} cama</div>
            <div class="beds" v-if="habitacion.bedsNumber>1">{{ habitacion.bedsNumber }} camas</div>
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