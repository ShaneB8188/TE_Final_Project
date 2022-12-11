<template>
  <div>
    <pizza-cards
      v-for="pizza in this.$store.state.specials"
      v-bind:key="pizza.id" v-bind:pizza="pizza"
    />
  </div>
</template>

<script>
import PizzaCards from "./PizzaCards.vue";
// import SpecialPizzaService from '@/services/SpecialPizzaService.js'
export default {
  components: {
    PizzaCards,
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