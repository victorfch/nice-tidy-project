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
    <div class="collapse ml-3" id="collapseForm">
      <label for="number">Numero: </label>
      <input type="number" id="number" v-model="reserve.number" /> <br />
      <label for="checkin">Fecha checkin:</label>
      <input type="date" id="checkin" v-model="reserve.checkInDate" /> <br />
      <label for="checkout">Fecha checkout:</label>
      <input type="date" id="checkout" v-model="reserve.checkOutDate" /> <br />
      <button class="btn btn-info mt-4" @click="newReserva">Guardar</button>
    </div>

    <div class="reservas">
      <div class="reserva" v-for="reserva in reservas" :key="reserva.id">
        <h2>Habitación {{ reserva.number }} {{ bedType(reserva.type) }}</h2>
        <input type="hidden" :value="reserva.id" />
        <span>camas {{ reserva.bedsNumber }}</span>
        <span>
          <input type="date" v-model="reserva.checkInDate" id="check_in" />
        </span>
        <span>
          <input type="date" v-model="reserva.checkOutDate" id="check_out" />
        </span>
        <span>
          <input type="checkbox" v-model="reserva.clean" id="clean" />
          Limpia
        </span>
        <span>
          <input type="checkbox" v-model="reserva.occupied" id="clean" />
          Ocupada
        </span>
        <span>
          <button class="btn btn-success" @click="actualizar(reserva)">
            Actualizar
          </button>
        </span>
        <span>
          <button class="btn btn-danger" @click="eliminarReserva(reserva.id)">
            Eliminar reserva
          </button>
        </span>
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
        .then((res) => res.json())
        .then(() => {
          this.$refs.btn_new.click();
          this.getReservas();
          this.reserve = {};
        });
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
        .then((res) => res.json())
        .then(() => this.getReservas());
    },
    eliminarReserva(id) {
      fetch(`http://localhost:8080/reserve/${id}`, { method: "delete" })
        .then((res) => res.text())
        .then(() => this.getReservas());
    },
    getReservas() {
      fetch("http://localhost:8080/reserves")
        .then((res) => res.json())
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
span {
  margin: 1em;
}

.collapse {
  width: 71vw;
  padding: 1em;
  box-shadow: 2px 2px 2px 2px rgb(98, 98, 98);
}
</style>