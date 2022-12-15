<template>
  <div>
    <label >Search by Order Status</label>
          <select id="statusFilter" v-model="search.orderStatus">
            <option value="">Show All</option>
            <option value="Pending">Active</option>
            <option value="Completed">Completed</option>
            <option value="Cancelled">Cancelled</option>
          </select>
<label > Search by Delivery</label>
        <select id="statusFilter" v-model="search.Delivery">
            <option value="">Show All</option>
            <option value="true">Is a Delivery</option>
            <option value="false">is not a Delivery</option>
           
          </select>
          <label >Search by Order Id</label>
          <input type="number"  min="0" v-model="search.orderId">
  
    
      <h1>{{search.orderStatus}}</h1>
    <div v-for="order in filteredOrders" v-bind:key="order.orderId" >
      
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
            <label > Cancelled </label>
            <input type="radio" v-model="order.orderStatus" value="Cancelled">
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
      
      search: {
        orderId:'',
        Delivery: '',
        orderStatus: '',

      }
    };
  },
  computed:{
    filteredOrders() {
      return this.orders.filter((order) => {
        if (order.orderStatus.includes(this.search.orderStatus) && (this.search.Delivery === "" || (order.delivery && this.search.Delivery) || (!order.delivery && this.search.Delivery === 'false')) && (order.orderId==(this.search.orderId) || this.search.orderId=="")) {
          return order;
        }
      })
    }
  },
  methods: {
    saveOrderChanges() {
      // call pizzaOrderService to update DB as data is being pulled from db so updating the db will complete functionality
      this.orders.forEach(order => {
          OrderPizzaService.updateOrderStatus(order.orderId, order.orderStatus)
      });
      alert("Orders Updated");
    },
    deleteOrder() {}
    
  },
  created() {
    OrderPizzaService.getAllOrders().then((response) => {
      this.orders = response.data;
    });
    this.orders.forEach(order => {
      order.pizzas = OrderPizzaService.getPizzasByOrderId(order.orderId);
    })
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