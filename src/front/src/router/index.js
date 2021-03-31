import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Usuarios from '../views/Usuarios.vue'
import Habitaciones from '../views/Habitaciones.vue'
import VerUsuario from '../views/VerUsuario.vue'
import FormUsuario from '../views/FormUsuario.vue'

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/usuarios',
    name: 'Usuarios',
    component: Usuarios
  },
  {
    path: '/nuevo-usuario',
    name: 'form-usuario',
    component: FormUsuario

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
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
