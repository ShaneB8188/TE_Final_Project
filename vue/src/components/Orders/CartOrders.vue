<template>
  <div class="content">
  <div id="login" class="text-center">
    
      <h1 class="h3 mb-3 font-weight-normal" align="center">Cart</h1>
     

     <div v-for="pizza in this.$store.state.Cart" :key="pizza.pizzaId">
      {{ pizza }}

      <p>{{ pizza.size }} </p>
     </div>
      
      
      <router-link :to="{ name: 'menu' }">Return to Menu</router-link>
      <button type="submit" class="checkoutBtn" onClick="return confirm('Confirm Order')" @click="createOrder()">Checkout</button>
      
    
  </div>
  </div>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService.js"

export default {
  data() {
    return {
      order: {
        orderId: '',
        price: '',
        isDelivery: false,
        orderStatus: '',
        pizzas: []
    },
    newOrder: {
      orderId: '',
      price: '',
      isDelivery: false,
      orderStatus: '',
      pizzas: []
    }
  }
  },
  methods: {
    createOrder() {
     this.order = this.$store.state.Cart;
     OrderPizzaService.addOrder(this.order);
     this.resetOrder();

  },
  resetOrder() {
    this.order = this.newOrder;
  }
}

}
</script>

<style>

</style>