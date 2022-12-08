<template>
  <div>
      
      <pizza-card />
      <create-pizza-footer/>
  </div>
</template>

<script>

import CreatePizzaFooter from '../components/LandingPage/CreatePizzaFooter.vue';
import PizzaCard from "../components/LandingPage/PizzaCards.vue";
export default {
  components: {
    PizzaCard,
    CreatePizzaFooter,

  
  },
};
</script>


<style>
</style>