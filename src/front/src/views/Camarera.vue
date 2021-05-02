<template>
  <div>
    <h1>Listado del día: {{ this.name.fullName }}</h1>
    <hr />


  </div>
</template>

<script>
export default {
  name: "Camarera",
  data(){
      return{
          name : JSON.parse(localStorage.getItem("login")),

      }
  },
  methods:{
    getReservas() {
    fetch("http://localhost:8080/reserves")
    .then((res) => res.json())
    .then((data) => (this.reservas = data));
},
  }

};
</script>
