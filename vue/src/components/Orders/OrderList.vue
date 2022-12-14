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
            </div>
            <label > Pending </label>
            <input type="radio" v-model="order.orderStatus" value="Pending">
            <label > Completed </label>
            <input type="radio" v-model="order.orderStatus" value="Completed">
            {{order.pizzas}}
          
            <br />
            
          
        </div>
        <footer class="card-footer">
          
          
          <a href="#" class="card-footer-item">Delete</a>
        </footer>
      </div>

    </div>
    
    <button type="button"  @click="saveOrderChanges()">Save Changes</button>
    
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
  methods: {
    saveOrderChanges() {
      // call pizzaOrderService to update DB as data is being pulled from db so updating the db will complete functionality
      this.orders.forEach(order => {
          OrderPizzaService.updateOrderStatus(order.orderId,order.orderStatus)
      });
      alert("Orders Updated");
    },
    deleteOrder() {}
    
  },
  created() {
    OrderPizzaService.getAllOrders().then((response) => {
      this.orders = response.data;
    });
    
  },
};
</script>

<style>
#saveOrderChanges{
  /* position: fixed;
  z-index: 3;
  display: flex;
  align-content: flex-end; */
  
}
</style>