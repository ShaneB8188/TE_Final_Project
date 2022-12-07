<template>
  <div>
    <div class="card" id="create-card">
      <header class="card-header">
        <div class="card-header-title" id="create">
          <router-link v-bind:to="{ name: 'customPizza' }">
            Create Your Own
          </router-link>
        </div>
      </header>
    </div>
  </div>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";

export default {
  data() {
    return {
      Pizza: {
        pizzaId: 1,
        size: 'medium',
        crust: 'normal',
        sauce: 'red',
        
      }, 
      Toppings:{}
    };
  },
  methods: {
    createNewPizza(Pizza) {
      OrderPizzaService.addPizza(Pizza);
    }
  },
};
</script>

<style>
#create-card {
  display: flex;
  justify-content: center;
}
#create {
  background-color: green;
  color: white;
}
</style>