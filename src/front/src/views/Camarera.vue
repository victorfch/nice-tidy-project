<template>
    <div>
        <h1>Listado del día: {{ user.fullName }}</h1>
        <hr />
        <div class="reservas">
            <div class="alert alert-success" v-if="alerta">Actualización realizada con éxito</div>
            <div class="reserva" v-for="habitacion in habitaciones" :key="habitacion.id">
                <h5>Habitación {{ habitacion.number }}</h5>
                <input type="hidden" :value="habitacion.id" />
                <input type="hidden" :value="habitacion.user_id">
                <div>
                    <br>
                    <input type="checkbox" checked disabled> <span>Checkout</span>
                    <input type="checkbox"  v-model="habitacion.occupied"> <span>Ocupado</span> 
                    <input type="checkbox"  v-model="habitacion.clean"> <span>Limpio</span>
                    <input type="checkbox"  v-model="habitacion.urgent" disabled> <span>Urgente</span>
                    <button class="btn btn-info" @click="actualizar(habitacion)">Actualizar</button>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
export default {
    name: "Camarera",
    data() {
        return {
        user: JSON.parse(localStorage.getItem("login")),
        habitaciones: [],
        alerta:false,
        };
    },
    methods: {
        getReservas() {
            fetch(`http://localhost:8080/reserve/${this.user.id}`)
            .then((res) => res.json())
            .then((data) => (this.habitaciones = data));
        },
        actualizar(habitacion){
            const options = {
                method: "post",
                body: JSON.stringify(habitacion),
                headers:{
                    "Content-Type": "application/json",
                },
            };
            fetch(`http://localhost:8080/rooms/${habitacion.id}`, options)
            .then((res)=> res.json())
            .then(()=> this.getReservas());
            this.alertaExito();
        },
        alertaExito(){
            this.alerta = true;
            setTimeout(() => {
                    this.alerta = false;
                }, 2000);
        }
    },
    mounted() {
        this.getReservas();
    },
};
</script>

<style>
.reservas {
    display: flex;
    flex-direction: column;
    justify-content: center;
}
.reserva {
    border: 1px solid black;
    padding: 1em;
    margin: 1em;
    width: max-content;
}
input:first-of-type {
    margin-left: 5em;
}
input[type="Checkbox"] + span {
    margin-right: 25px;
}
</style>