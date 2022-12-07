<template>
  <div>
      <h1>Active Orders</h1>
      <div
      v-for="order in orders"
      v-bind:key="order.id"
      >

      </div>

  </div>
</template>

<script>
import OrderPizzaService from '@/services/OrderPizzaService';
export default {
    data() {
        return {
            orders: [],
        };
    },
    created() {
        OrderPizzaService.getAllOrders().then(response => {
            this.orders = response.data;
        });
    }

}
</script>

<style>

</style>