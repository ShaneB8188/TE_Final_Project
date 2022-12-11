<template>
  <div>
    <h1>Specialty Pizzas</h1>
    <div v-for="pizza in pizzas" :key="pizza.id" class="card-container">
      <div class="card">
        <header class="content">
          <p class="card-header-title">{{ pizza.name }}</p>
        </header>
        <div class="card-content">
          <div class="content">
            <p>Size: {{ pizza.pizzaSize }}</p>
            <p>Crust: {{ pizza.crust }}</p>
            <p>Sauce: {{ pizza.sauce }}</p>
            <div>
              Toppings:
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
  </div>
</template>

<script>
  //import SpecialPizzaService from "@/services/SpecialPizzaService";

export default {
  data() {
    return {
      pizzas: [],
      toppings: [],
    };
  },
  created() {
    this.$store.dispatch("setSpecials");
    this.pizzas = this.$store.state.specials;
    this.$store.dispatch("setToppings");
    this.toppings = this.$store.state.toppings;
  },
};
</script>
<style>
.card-container {
  display: grid;
  grid-column: 1fr, 1fr, 1fr;
}
</style>