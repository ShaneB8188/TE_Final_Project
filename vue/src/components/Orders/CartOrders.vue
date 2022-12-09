<template>
  <div class="content">
  <div id="login" class="text-center">
    
      <h1 class="h3 mb-3 font-weight-normal" align="center">Cart</h1>
     
      <p>Order Total: ${{this.order.price}}</p>
     <div v-for="pizza in $store.state.Cart.pizzas" :key="pizza.pizzaId">
      <p>Pizza: {{pizza.name}}</p>
      <div>Toppings: 
        <p v-for="topping in pizza.toppings" :key="topping.toppingId">{{topping.name}}</p>
      </div>
      <p>Price: {{pizza.price}}</p>

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
  created() {
    this.generateOrderTotal();
  },

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
     this.order.orderStatus = "Pending";
     OrderPizzaService.addOrder(this.order);
     this.resetOrder();
  },
  resetOrder() {
    this.order = this.newOrder;
  },
  generateOrderTotal() {
    this.$store.commit('UPDATE_CART_TOTAL')
    this.order.price = this.$store.state.Cart.price;
  }
  
}
}
</script>

<style>

</style>