<template>
<<<<<<< HEAD
  <div>
      <pizza-cards v-for="pizza in $store.state.specialtyPizza" v-bind:key="pizza.id"/>

=======
  <div class="main-container">
    <create-pizza id="create-pizza"/>
    <pizza-cards
      v-for="pizza in this.$store.state.specials"
      v-bind:key="pizza.id" v-bind:pizza="pizza" id="pizza"
    />
>>>>>>> 8bca6f1da5f471abd2acb43ba46afc5bbda15be5
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
  .main-container {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr;
  grid-template-areas:
    "#create-pizza #pizza #pizza"
    "#pizza #pizza #pizza"
    "#pizza #pizza #pizza";

  grid-gap: 40px;
}
</style>