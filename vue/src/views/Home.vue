<template>
  <aside class="menu">
  <p class="menu-label">
    Order Status
  </p>
  <ul class="menu-list">
    <li>
      <ul>
        <li><a>Open All Open Orders</a></li>
        <li><a>Update Order Status</a></li>
        <li><a>View All Orders</a></li>
      </ul>
    </li>
  </ul>
  <p class="menu-label">
    Menu Creation
  </p>
  <ul class="menu-list">
    <li>
      <ul>
        <li><a>Add A Pizza to Menu</a></li>
        <li><a>Update Pizza on Menu</a></li>
        <li><a>Remove Pizza From Menu</a></li>
        <li>
          <router-link :to="{name:'Toppings'}">
          Add Topping to Menu
          </router-link>
        </li>
        <li><a>Update Topping Availability</a></li>
        <li><a>Remove Topping From Menu</a></li>
      </ul>
    </li>
  </ul>

</aside>
</template>


<script>
export default {
  name: "home",
};
</script>

<style>
.menu{
  display: flex;
  flex-direction: column;
  width: 18%;
  background-color: #f3ebf6;
  font-family: "Ubuntu", sans-serif;
  height: 100%;
  padding-bottom: 100%; 
  border-right: 1px solid black;
}

</style>