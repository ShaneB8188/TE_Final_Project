<template>
  <div>
    <div class="card" id="create-card">
      <header class="card-header">
        <!-- implement real method later -->
        <div class="card-header-title" id="create" @click="testPizza(Pizza)">
          Create Your Own
        </div>
        <!-- implement real method later -->
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
  flex-grow: 1;
}
#create {
  background: linear-gradient(to right, #27b055, #064d15);
  color: white;
}
</style>