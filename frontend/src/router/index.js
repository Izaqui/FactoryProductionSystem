import { createRouter, createWebHistory } from "vue-router"

import RawMaterials from "../pages/RawMaterials.vue"
import Products from "../pages/Products.vue"
import Composition from "../pages/Composition.vue"
import Production from "../pages/Production.vue"

const routes = [
  { path: "/", component: RawMaterials },
  { path: "/products", component: Products },
  { path: "/composition", component: Composition },
  { path: "/production", component: Production }
]

const router = createRouter({
  history: createWebHistory(),
  routes
})

export default router