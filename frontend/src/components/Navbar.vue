<template>

<nav class="navbar">

<div class="logo">
Factory System
</div>

<div class="links">

<router-link to="/">Raw Materials</router-link>

<router-link to="/products">Products</router-link>

<router-link to="/composition">Composition</router-link>

<router-link to="/production">Production</router-link>

</div>

</nav>

</template>

<style>

.navbar{
  background:#1e293b;
  padding:15px;
  display:flex;
  justify-content:space-between;
  align-items:center;
}

.logo{
  color:white;
  font-size:18px;
  font-weight:bold;
}

.links a{
  color:white;
  margin-left:15px;
  text-decoration:none;
}

.links a:hover{
  text-decoration:underline;
}

</style>