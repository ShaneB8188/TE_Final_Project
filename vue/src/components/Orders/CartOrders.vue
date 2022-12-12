<template>
  <div class="content">
  <div id="login" class="text-center">
    
      <h1 class="h3 mb-3 font-weight-normal" align="center">Cart</h1>
     
      <h3>Order Total: ${{this.order.price}}</h3>
      <label for="isDelivery">Delivery  </label>
      <input type="checkbox" name="isDelivery" v-model="isDelivery">
      <br>
     <div v-for="pizza in $store.state.Cart.pizzas" :key="pizza.pizzaId">
        Pizza Name: {{pizza.name}} <br>
        {{pizza.crust}} Crust, {{pizza.sauce}} Sauce, {{pizza.toppings.map(topping => topping.name).join(", ")}}
     </div>
      
      
      <router-link :to="{ name: 'menu' }">Return to Menu</router-link>
      <br>
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
      isDelivery: false,
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
     this.$store.state.Cart.isDelivery = this.isDelivery;
    //  this.order.pizzas.forEach(pizza => {
    //    OrderPizzaService.addPizza(pizza);
    //  });
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