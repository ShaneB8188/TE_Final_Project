<template>
  <div>
    <section>
      <home-banner />
    </section>
    <section>
      <pizza-card/>
    </section>
  </div>
</template>

<script>
import HomeBanner from "../components/LandingPage/HomeBanner";
import PizzaCard from "../components/LandingPage/PizzaCards.vue";
export default {
  components: {
    HomeBanner,
    PizzaCard,
  },
};
</script>


<style>
</style>