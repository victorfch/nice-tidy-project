<template>
  <div>
    <h1>Reservas</h1>
    <hr />
    <div class="reservas">
      <div class="reserva" v-for="reserva in reservas" :key="reserva.id">
        <h2>Habitación {{ reserva.number }} {{ bedType(reserva.type) }}</h2>
        <span>camas {{ reserva.bedsNumber }}</span>
        <span>
          <input type="date" :value="reserva.checkInDate" id="check_in" />
        </span>
        <span>
          <input type="date" :value="reserva.checkOutDate" id="check_out" />
        </span>
        <span>
          <input type="checkbox" :checked="reserva.clean" id="clean" />
          Limpia
        </span>
        <span>
          <input type="checkbox" :checked="reserva.occupied" id="clean" />
          Ocupada
        </span>
        <span>
          <button @click="eliminarReserva(reserva.id)">
            Eliminar reserva
          </button></span
        >
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: "Reservas",
  data() {
    return {
      reservas: [],
    };
  },
  methods: {
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
}
span {
  margin: 1em;
}
</style>