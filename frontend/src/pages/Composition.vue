<script setup>

import { ref, onMounted } from "vue"
import api from "../api/api"

const products = ref([])
const materials = ref([])

const form = ref({
  productId: "",
  materialId: "",
  quantityRequired: 0
})

const loadData = async () => {

  const p = await api.get("/products")
  const m = await api.get("/materials")

  products.value = p.data
  materials.value = m.data
}

const saveComposition = async () => {

  await api.post("/product-materials", {

    product: { id: form.value.productId },

    rawMaterial: { id: form.value.materialId },

    quantityRequired: form.value.quantityRequired
  })

  alert("Saved")

}

onMounted(loadData)

</script>

<template>

<h1>Product Composition</h1>

<select v-model="form.productId">

<option disabled value="">
Select Product
</option>

<option v-for="p in products" :value="p.id">

{{p.name}}

</option>

</select>

<select v-model="form.materialId">

<option disabled value="">
Select Material
</option>

<option v-for="m in materials" :value="m.id">

{{m.name}}

</option>

</select>

<input v-model="form.quantityRequired" type="number" placeholder="Quantity"/>

<button @click="saveComposition">

Save

</button>

</template>