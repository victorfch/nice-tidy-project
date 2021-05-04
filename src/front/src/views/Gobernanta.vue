<template>
  <div>
    <h2>Organización limpieza</h2>
    <hr />
    {{ today }}
    <div class="header">
      <button class="btn btn-primary">Enviar</button>
      <input type="date" id="today" v-model="today" />
    </div>
    <div class="table">
      <table>
        <thead>
          <tr>
            <td>Camarera</td>
            <td>nº hab</td>
            <td>Ocupada</td>
            <td>Checkout</td>
            <td>Urgente</td>
          </tr>
        </thead>
      </table>
    </div>
    {{ chambermaids }}
  </div>
</template>

<script>
export default {
  name: "gobernanta",
  data() {
    return {
      today: new Date().toISOString().substr(0, 10),
      chambermaids: [],
      reserves: [],
    };
  },
  methods: {
    getChambermaids() {
      fetch("http://localhost:8080/chambermaids")
        .then((res) => res.json())
        .then((data) => (this.chambermaids = data));
    },
    getReserves() {
      fetch("http://localhost:8080/today/reserves")
        .then((res) => res.json())
        .then((data) => (this.reserves = data));
    },
  },
  mounted() {
    this.getChambermaids();
    this.getReserves();
  },
};
</script>

<style scoped>
.header {
  display: flex;
  justify-content: space-between;
  margin: 20px;
}

table {
  width: 90%;
}

.table {
  display: flex;
  justify-content: center;
}

table,
th,
td {
  border: 1px solid black;
  padding: 5px;
}
</style>