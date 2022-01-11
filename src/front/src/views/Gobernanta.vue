<template>
    <div>
        <h2>Organización limpieza</h2>
        <hr />
        <div class="header">
        <button @click="send" class="btn btn-primary">Enviar</button>
        <input type="date" id="today" v-model="today" />
        </div>
        <div class="alert alert-success" v-if="exito">
        Operación realizada con éxito
        </div>
        <div class="alert alert-danger" v-if="error">
        La operación no pudo realizarse
        </div>
        <div class="table-responsive text-center">
        <table>
            <thead>
            <tr>
                <th scope="col">Camarera</th>
                <th scope="col">nº hab</th>
                <th scope="col">Limpia</th>
                <th scope="col">Ocupada</th>
                <th scope="col">Checkout</th>
                <th scope="col">Urgente</th>
            </tr>
            </thead>
            <tbody>
            <tr v-for="reserve in reserves" :key="reserve.id">
                <td scope="row">
                <select v-model="reserve.user_id">
                    <option
                    v-for="chambermaid in chambermaids"
                    :key="chambermaid.id"
                    :value="chambermaid.id"
                    >
                    {{ chambermaid.name }}
                    </option>
                </select>
                </td>
                <td>
                {{ reserve.number }}
                </td>
                <td>
                <input type="checkbox" v-model="reserve.clean" />
                </td>
                <td>
                <input type="checkbox" v-model="reserve.occupied" />
                </td>
                <td>
                <input type="date" disabled v-model="reserve.checkOutDate" />
                </td>
                <td>
                <input type="checkbox" v-model="reserve.urgent" />
                </td>
            </tr>
            </tbody>
        </table>
        </div>
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
        exito:false,
        error: false,
        };
    },
    methods: {
        send() {
        const options = {
            method: "post",
            body: JSON.stringify(this.reserves),
            headers: {
            "Content-Type": "application/json",
            },
        };
        fetch("http://localhost:8080/send-to-chambers", options)
            .then((res) =>{
                if(res.status == 200){
                this.alertaExito();
                }else{
                this.alertaError();
                }
                return res.json()
            }
        );
        },
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