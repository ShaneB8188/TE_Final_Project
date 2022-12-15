<template>
  <div>
    <nav id="orderSearchBar">
      <div>
    <label >Search by Order Status</label>
          <select id="statusFilter" v-model="search.orderStatus">
            <option value="">Show All</option>
            <option value="Pending">Active</option>
            <option value="Completed">Completed</option>
            <option value="Cancelled">Cancelled</option>
          </select>
          </div>
          <div>
      <label > Search by Delivery</label>
        <select id="statusFilter" v-model="search.Delivery">
            <option value="">Show All</option>
            <option value="true">Is a Delivery</option>
            <option value="false">is not a Delivery</option>
           
          </select>
          </div>
          <div>
          <label > Search by Order Id</label>
          <input type="number"  min="0" v-model="search.orderId">
           </div>
    </nav>
      <h1>{{search.orderStatus}}</h1>
    <div v-for="order in filteredOrders" v-bind:key="order.orderId">
      
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
            <div id="card-price-delivery">
            Price: ${{order.price}}
            <br>
            Is this a Delivery: 
            <br>
            
            {{order.delivery}} <br>
            </div>
            </div>
            <div id="order-status-select">
              <div>
            <label > Pending </label>
            <input type="radio" v-model="order.orderStatus" value="Pending">
            </div>
            <div>
            <label > Completed </label>
            <input type="radio" v-model="order.orderStatus" value="Completed">
            </div>
            <div>
            <label > Cancelled </label>
            <input type="radio" v-model="order.orderStatus" value="Cancelled">
            </div>
            </div>
            <br />
            <div  v-for="pizza in order.pizzas" v-bind:key="pizza.pizzaId" id="pizza-content">
              <br>
              <div>
                Pizza Name: {{pizza.name}} 
                </div>
                <div>
                Toppings: 
                  <div v-for="topping in pizza.toppings" v-bind:key="topping.toppingId">
                    {{topping.name}}
                  </div>
                </div>
                <br>
              </div>
          
        </div>
      
      </div>
    </div>
    <button type="button"  @click="saveOrderChanges()">Save Changes</button>
    
  </div>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";
import PizzaService from "@/services/PizzaService";
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
    
      this.orders.forEach(order => {
        OrderPizzaService.getPizzasByOrderId(order.orderId).then(orderResponse => {
          order.pizzas = orderResponse.data.pizzas;

          order.pizzas.forEach(pizza => {
            PizzaService.getToppingsByPizzaId(pizza.pizzaId).then(pizzaResponse => {
              pizza.toppings = pizzaResponse.data.toppings;
            })
          })
        })
      })
    });
  },
  };
</script>

<style>
#orderSearchBar{
  display: flex;
  justify-content: space-around; 
  padding: 10px;
}
.card{
  padding-bottom: 20px;

  background: #f3ebf6;
  border-radius: 10px;
  margin: 10px;
  font-size: 120%;
}
#card-content{
  display: flex;
  justify-content: space-between;
  
}

#pizza-content {
  display: flex;
  flex-direction: column;
  flex-grow: 3;
  outline: 2px solid black;
  padding: 5px;
  border-radius: 10px;
  margin: 5px;
  background: white;
}
#order-status-select {
  display: flex;
  flex-direction: column;
  padding: 10px;
  flex-grow: 1;
  margin-top: 16px;
}
#card-price-delivery{
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  padding: 5px;
  
}
</style>