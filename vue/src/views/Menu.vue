<template>
  <div>
      <home-banner/>
      <pizza-card />
    
  </div>
</template>

<script>
import HomeBanner from '../components/HomeBanner.vue';
import PizzaCard from "../components/LandingPage/PizzaCards.vue";
export default {
  components: {
    PizzaCard,
    
    HomeBanner,

  
  },
};
</script>


<style>
</style>