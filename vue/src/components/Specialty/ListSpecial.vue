<template>
  <section>
    <h1>Specialty Pizzas</h1>
    <div v-for="pizza in pizzas" :key="pizza">
      <div class="card">
        <header class="content">
          <p class="card-header-title">{{ pizza.name }}</p>
        </header>
        <div class="card-content">
          <div class="content">
            <p>Size: {{ pizza.pizzaSize }}</p>
            <p>Crust: {{ pizza.crust }}</p>
            <p>Sauce: {{ pizza.sauce }}</p>
            <div> Toppings: 
              <ul>
                <li v-for="topping in pizza.toppings" :key="topping">
                  {{ topping.name }}
                </li>
              </ul>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>

<script>
import SpecialPizzaService from "@/services/SpecialPizzaService";

export default {
  data() {
    return {
      pizzas: [],
    };
  },
  created() {
    SpecialPizzaService.getAllSpecialtyPizzas().then((response) => {
      this.orders = response.data;
    });
  },
};
</script>

<style>
</style>