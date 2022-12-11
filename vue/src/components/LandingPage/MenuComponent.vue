<template>
  <div>
    <create-pizza />
    <pizza-cards
      v-for="pizza in this.$store.state.specials"
      v-bind:key="pizza.id" v-bind:pizza="pizza"
    />
  </div>
</template>

<script>
import PizzaCards from "./PizzaCards.vue";
import CreatePizza from "./CreatePizza.vue";
// import SpecialPizzaService from '@/services/SpecialPizzaService.js'
export default {
  components: {
    PizzaCards,
    CreatePizza
  },
  pizzas: [],
  toppings: [],

  created() {
    this.$store.dispatch("setSpecials");
    this.pizzas = this.$store.state.specials;
    this.$store.dispatch("setToppings");
    this.toppings = this.$store.state.toppings;
  },
};
</script>

<style>
</style>