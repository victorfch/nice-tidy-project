<template>
    <div>
        <div class="alert alert-danger" v-if="errorNumber">
            El número de habitación introducida ya existe
        </div>
        <div class="alert alert-success" v-if="exito">
            Habitación añadida con éxito
        </div>
        <div class="alert alert-danger" v-if="errorCampos">
            Debe rellenar todos los campos
        </div>
        <form ref="form" @submit.prevent="addHab"
            class="form-group row pl-3 justify-content-center">
            <label for="number" class="col-form-label mr-1">Nº Habitación: </label>
            <input
                v-model="numero"
                min="1"
                type="number"
                class="form-control col-5 col-sm-2 m-2"
                id="number"
            />
            <div class="d-sm-none w-100"></div>
            <label for="beds" class="col-form-label ml-2 mr-1">Nº Camas: </label>
            <input
                v-model="beds"
                type="number"
                min="1"
                oninput="validity.valid||(value='');"
                class="form-control col-5 col-sm-2 m-2"
                id="beds"
            />

            <div class="d-block d-sm-block d-lg-none w-100"></div>

            <label for="type" class="col-form-label ml-2 mr-1">Tipo: </label>
            <select class="form-select col-5 col-sm-2 m-2" v-model="selected">
                <option value="1">Individual</option>
                <option value="2">Doble</option>
                <option value="3">Triple</option>
                <option value="4">Suite</option>
            </select>
            <div class="d-sm-none w-100"></div>
            <button type="submit" class="btn btn-info ml-4">Añadir</button>
        </form>
    </div>
</template>
<script>
    export default {
        name: "form-habitaciones",
        props:{
            habitaciones: Array,
        },
        data(){
            return{
                errorNumber: false,
                errorCampos: false,
                exito: false,
                numero: "",
                beds: "",
                selected: 1,
            }
        },
        methods:{
            addHab() {
                this.errorCampos = false;
                this.errorNumber = false;
                this.exito=false;
                if (this.numero == "" || this.beds == "") {
                    this.errorCampos = true;
                }
                if (!this.errorCampos) {
                    if (this.check(this.habitaciones, "number", this.numero)) {
                    this.errorNumber = true;
                    } else {
                    const room = {
                        number: parseInt(this.numero),
                        bedsNumber: parseInt(this.beds),
                        type: parseInt(this.selected),
                    };
                    const options = {
                        method: "post",
                        body: JSON.stringify(room),
                        headers: {
                        "Content-Type": "application/json",
                        },
                    };
                    fetch("http://localhost:8080/rooms", options)
                        .then((response) => response.json())
                        .then(() => {
                            this.alertExito();
                            this.borrarRegistro();
                            this.$router.go();
                        });
                    }
                }
            },
            check(array, key, value) {
              return array.some((object) => object[key] == value);
            },
            alertExito() {
                this.exito = true;
                setTimeout(() => {
                    this.exito = false;
                }, 2000);
            },
            borrarRegistro() {
                this.numero = undefined;
                this.beds = undefined;
                this.selected = 1;
            },
        }  
    }
</script>

<style scoped>
</style>