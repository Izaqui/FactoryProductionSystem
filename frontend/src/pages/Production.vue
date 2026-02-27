<template>

<h1 class="text-2xl font-bold mb-6">
Production Suggestion
</h1>

<button
@click="calculate"
class="bg-green-600 text-white px-4 py-2 rounded mb-6"
>
Calculate Production
</button>

<table class="w-full bg-white shadow rounded">

<thead class="bg-gray-200">

<tr>
<th class="p-3">Product</th>
<th>Quantity</th>
<th>Total Value</th>
</tr>

</thead>

<tbody>

<tr v-for="p in production" :key="p.productName">

<td class="p-3">{{p.productName}}</td>
<td>{{p.quantity}}</td>
<td>{{p.totalValue}}</td>

</tr>

</tbody>

</table>

</template>