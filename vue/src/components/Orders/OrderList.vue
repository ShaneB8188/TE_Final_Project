<template>
  <div>
    <h1>Active Orders</h1>
    <div v-for="order in orders" v-bind:key="order.id">
      <div class="card">
        <header class="card-header">
          <p class="card-header-title"> Order #:{{order.id}}</p>
          <button class="card-header-icon" aria-label="more options">
            <span class="icon">
              <i class="fas fa-angle-down" aria-hidden="true"></i>
            </span>
          </button>
        </header>
        <div class="card-content">
          <div class="content">
            Order Details Here
            <a href="#">@bulmaio</a>. <a href="#">#css</a>
            <a href="#">#responsive</a>
            <br />
            <time datetime="2016-1-1">11:09 PM - 1 Jan 2016</time>
          </div>
        </div>
        <footer class="card-footer">
          <a href="#" class="card-footer-item">Save</a>
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
  created() {
    OrderPizzaService.getAllOrders().then((response) => {
      this.orders = response.data;
    });
  },
};
</script>

<style>
</style>