import { createRouter, createWebHashHistory } from 'vue-router'
import Home from '../views/Home.vue'
import Usuarios from '../views/Usuarios.vue'
import Habitaciones from '../views/Habitaciones.vue'

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
    path: '/habitaciones',
    name: 'Habitaciones',
    component: Habitaciones
  }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
