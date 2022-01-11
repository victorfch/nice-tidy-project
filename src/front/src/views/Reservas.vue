<template>
  <div>
    <h1>Reservas</h1>
    <hr />
    <p>
      <button
        class="btn btn-primary ml-3"
        data-toggle="collapse"
        ref="btn_new"
        data-target="#collapseForm"
      >
        <i class="fas fa-plus mr-1"></i>
        Nueva
      </button>
    </p>
    <div class="alert alert-success" v-if="exito">
      Operación realizada con éxito
    </div>
    <div class="alert alert-danger" v-if="error">
      La operación no pudo realizarse
    </div>
    <div class="collapse ml-3" id="collapseForm">
      <label for="number">Numero: </label>
      <input type="number" min="1" id="number" v-model="reserve.number" /> <br />
      <label for="checkin">Fecha checkin:</label>
      <input type="date" id="checkin" v-model="reserve.checkInDate" /> <br />
      <label for="checkout">Fecha checkout:</label>
      <input type="date" id="checkout" v-model="reserve.checkOutDate" /> <br />
      <button class="btn btn-info mt-4" @click="newReserva">Guardar</button>
    </div>

    <div class="reservas">
      <div class="reserva" v-for="reserva in reservas" :key="reserva.id">
        <div>
          <h2>Habitación {{ reserva.number }} &nbsp;&nbsp;&nbsp;&nbsp; {{ bedType(reserva.type) }}
          <button class="btn btn-success" id="actualizar" @click="actualizar(reserva)"> Actualizar </button>
          </h2>
          <input type="hidden" :value="reserva.id" />
        </div>
        <div>
          <span>{{ reserva.bedsNumber }} cama{{ reserva.bedsNumber > 1 ? "s" : null }}</span>
          <input type="date" v-model="reserva.checkInDate" id="check_in" />
          <input type="date" v-model="reserva.checkOutDate" id="check_out" />
          <input type="checkbox" class="limpio" v-model="reserva.clean" id="clean" /> Limpia
          <input type="checkbox" class="ocupado" v-model="reserva.occupied" id="clean" /> Ocupada
          <button class="btn btn-danger" id="eliminar" @click="eliminarReserva(reserva.id)"> Eliminar</button>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Reservas",
  data() {
    return {
      reserve: {},
      reservas: [],
      exito:false,
      error: false,
    };
  },
  methods: {
    newReserva() {
      const options = {
        method: "post",
        body: JSON.stringify(this.reserve),
        headers: {
          "Content-Type": "application/json",
        },
      };
      fetch(`http://localhost:8080/reserves`, options)
        .then((res) => {
          if(res.status == 200){
            this.alertaExito();
          }else{
            this.alertaError();
          }
          return res.json()
        })
        .then(() => {
          this.$refs.btn_new.click();
          this.getReservas();
          this.reserve = {};
          
        });
    },
    alertaExito(){
      this.exito = true;
        setTimeout(() => {
            this.exito = false;
        }, 2000);
    },
    alertaError(){
      this.error = true;
        setTimeout(() => {
            this.error = false;
        }, 2000);
    },
    actualizar(reserva) {
      const options = {
        method: "post",
        body: JSON.stringify(reserva),
        headers: {
          "Content-Type": "application/json",
        },
      };
      fetch(`http://localhost:8080/rooms/${reserva.id}`, options)
        .then((res) =>{
          if(res.status == 200){
            this.alertaExito();
          }else{
            this.alertaError();
          }
          return res.json()
        })
        .then(() => this.getReservas());
    },
    eliminarReserva(id) {
      fetch(`http://localhost:8080/reserve/${id}`, { method: "delete" })
        .then((res) => res.text())
        .then(() => this.getReservas());
    },
    getReservas() {
      fetch("http://localhost:8080/reserves")
        .then((res) => {
          if(res.status == 200){
            this.alertaExito();
          }else{
            this.alertaError();
          }
          return res.json()
        })
        .then((data) => (this.reservas = data));
    },
    bedType(type) {
      if (type == 1) return "Individual";
      if (type == 1) return "Doble";
      if (type == 1) return "Triple";
      return "Suite";
    },
  },
  mounted() {
    this.getReservas();
  },
};
</script>

<style scoped>
.reserva {
  border: 1px solid black;
  padding: 2em;
  margin: 1em;
  width: 70vw;
}
#actualizar{
  float: right;
}
#eliminar{
  float:right;
}
#eliminar, #actualizar{
  width: 90px;
}
#checkin, #checkout{
  float:right;
}
.collapse {
  width: max-content;
  padding: 1em;
  box-shadow: 2px 2px 2px 2px rgb(98, 98, 98);
}
input[type="date"]{
  width: 150px;
  margin-right: 5px;
}
input[type="date"]:nth-child(3){
  margin-right: 20px;
}
.limpio{
  margin-left: 10px;
}
.ocupado{
  margin-left: 10px;
}
.reserva{
  display: flex-row;
}
</style>