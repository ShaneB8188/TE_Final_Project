<template>
  <div>
      <home-banner />
      <pizza-card />
      <create-pizza-footer/>
  </div>
</template>

<script>
import HomeBanner from "../components/HomeBanner";
import CreatePizzaFooter from '../components/LandingPage/CreatePizzaFooter.vue';
import PizzaCard from "../components/LandingPage/PizzaCards.vue";
export default {
  components: {
    HomeBanner,
    PizzaCard,
    CreatePizzaFooter,
  
  },
};
</script>


<style>
</style>