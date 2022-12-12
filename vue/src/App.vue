

<template>
   <div id="app">
    <div id="nav" >
       
      <router-link class="menu-items" :to="{ name: 'menu' }">Menu</router-link>&nbsp;|&nbsp;
      <router-link class="menu-items" :to="{ name: 'checkout' }">Cart</router-link>&nbsp;|&nbsp;
      <router-link class="menu-items" v-bind:to="{ name: 'home' }">Employee Dashboard</router-link>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      > 

     <router-view></router-view>
    </div>
  </div>
</template>
<script>

// import Home from '@/views/Home';
// import Menu from '@/views/Menu';
// import ToppingService from '@/services/ToppingsService';
// import SpecialPizzaService from '@/services/SpecialPizzaService'
export default {
  
  // components:
  // Menu,
  // Home,
  // created() {
  //   // getAllPizza
  //   // getAllToppings
  //   // getAllOrders
  //   // getAllSpecials
  //   ToppingService.getAllToppings().forEach(topping => {
  //     this.$store.commit("ADD_TOPPING",topping);
  //   });
  //   SpecialPizzaService.getAllSpecialtyPizzas().forEach(pizza => {
  //     this.$store.commit("UPDATE_PIZZA_LIST", pizza);
  //   });
  // }
};
</script>
<style>
#nav{
  background-color: #fff;
}
.menu-items{
  color: black;
  
}
.menu-items:hover{
  cursor: pointer;
  color: red;
}
</style>