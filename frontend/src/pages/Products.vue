<script setup>

import { ref, onMounted } from "vue"
import api from "../api/api"

const products = ref([])

const form = ref({
  name: "",
  code: "",
  price: 0
})

const loadProducts = async () => {

  const res = await api.get("/products")

  products.value = res.data
}

const saveProduct = async () => {

  await api.post("/products", form.value)

  form.value = {
    name: "",
    code: "",
    price: 0
  }

  loadProducts()
}

const deleteProduct = async (id) => {

  await api.delete(`/products/${id}`)

  loadProducts()

}

onMounted(loadProducts)

</script>

<template>

<h1>Products</h1>

<h3>Add Product</h3>

<input v-model="form.name" placeholder="Name"/>
<input v-model="form.code" placeholder="Code"/>
<input v-model="form.price" type="number" placeholder="Price"/>

<button @click="saveProduct">
Add
</button>

<hr>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Code</th>
<th>Price</th>
<th>Action</th>
</tr>

<tr v-for="p in products" :key="p.id">

<td>{{p.id}}</td>
<td>{{p.name}}</td>
<td>{{p.code}}</td>
<td>{{p.price}}</td>

<td>
<button @click="deleteProduct(p.id)">
Delete
</button>
</td>

</tr>

</table>

</template>