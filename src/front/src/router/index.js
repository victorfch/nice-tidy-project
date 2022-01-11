import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Usuarios from '../views/Usuarios.vue'
import Habitaciones from '../views/Habitaciones.vue'
import VerUsuario from '../views/VerUsuario.vue'
import FormUsuario from '../views/FormUsuario.vue'
import Reservas from '../views/Reservas.vue'
import Camarera from '../views/Camarera.vue'
import Gobernanta from '../views/Gobernanta.vue'

const routes = [
  {
    path: '/usuarios',
    name: 'Usuarios',
    component: Usuarios
  },
  {
    path: '/reservas',
    name: 'Reservas',
    component: Reservas
  },
  {
    path: '/nuevo-usuario',
    name: 'form-usuario',
    component: FormUsuario
  },
  {
    path: '/edit-user/:id',
    name: 'edit-usuario',
    component: FormUsuario,
    props: true
  },
  {
    path: '/habitaciones',
    name: 'Habitaciones',
    component: Habitaciones
  },
  {
    path: '/usuarios/:id',
    name: 'ver-usuario',
    component: VerUsuario,
    props: true
  },
  {
    path: '/camarera',
    name: 'Camarera',
    component: Camarera
  },
  {
    path: '/gobernanta',
    name: 'Gobernanta',
    component: Gobernanta
  },
  {
    path: '/',
    name: 'Home',
    component: Home
  },
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router