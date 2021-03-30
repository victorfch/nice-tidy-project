<template>
  <div class="row">
    <navbar />
    <div class="container mt-3">
      <router-view />
    </div>
  </div>
</template>
<script>
import Navbar from "./components/Navbar.vue";
export default {
  components: {
    Navbar,
  },
  data(){
    return{
      habitaciones: [],
    }
  },
  methods:{
    recibirHabitaciones(){
      fetch("http://localhost:8080/rooms")
      .then((response)=> response.json())
      .then((data)=>{
        console.log(data);
        this.habitaciones = data;
      } ); 
    }
  },
  name: "App",
  mounted(){
    this.recibirHabitaciones();
  }
};
</script>
<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
}
</style>
