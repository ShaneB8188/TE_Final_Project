<template>
  <div>
    <h1>Active Orders</h1>
    <div v-for="order in activeOrders" v-bind:key="order.orderId">
      
      <div class="card">
        <header class="card-header">
          <p class="card-header-title"> Order #{{order.orderId}}</p>
          <button class="card-header-icon" aria-label="more options">
            <span class="icon">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </header>
        <div class="card-content">
          <div class="content">
            ${{order.price}}
            <br>
            Is this a Delivery: {{order.delivery}} <br>
            {{order.pizzas}}
          
            <br />
            
          </div>
        </div>
        <footer class="card-footer">
          
          <a href="#" class="card-footer-item">Edit</a>
          <a href="#" class="card-footer-item">Delete</a>
        </footer>
      </div>
    </div>
  </div>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";
export default {
  data() {
    return {
      orders: [],
    };
  },
  computed:{
    activeOrders(){
      return this.orders.filter(order => {
         return order.orderStatus == 'Pending'
           
      
      })
    }
  },
  created() {
    OrderPizzaService.getAllOrders().then((response) => {
      this.orders = response.data;
    });
    // need to manually add pizzas to orders otherwise pizzas in orders are null 
  },
};
</script>

<style>
</style>