<script setup>
import { ref, onMounted } from "vue"
import api from "../api/api"

const materials = ref([])

const form = ref({
  name: "",
  code: "",
  stockQuantity: 0
})

const loadMaterials = async () => {
  const res = await api.get("/materials")
  materials.value = res.data
}

const saveMaterial = async () => {
  await api.post("/materials", form.value)

  form.value = {
    name: "",
    code: "",
    stockQuantity: 0
  }

  loadMaterials()
}

const deleteMaterial = async (id) => {
  await api.delete(`/materials/${id}`)
  loadMaterials()
}

onMounted(loadMaterials)
</script>

<template>

<h1>Raw Materials</h1>

<h3>Add Material</h3>

<input v-model="form.name" placeholder="Name"/>
<input v-model="form.code" placeholder="Code"/>
<input v-model="form.stockQuantity" type="number" placeholder="Stock"/>

<button @click="saveMaterial">
Add
</button>

<hr>

<table border="1">

<tr>
<th>ID</th>
<th>Name</th>
<th>Code</th>
<th>Stock</th>
<th>Action</th>
</tr>

<tr v-for="m in materials" :key="m.id">

<td>{{m.id}}</td>
<td>{{m.name}}</td>
<td>{{m.code}}</td>
<td>{{m.stockQuantity}}</td>

<td>
<button @click="deleteMaterial(m.id)">
Delete
</button>
</td>

</tr>

</table>

</template>