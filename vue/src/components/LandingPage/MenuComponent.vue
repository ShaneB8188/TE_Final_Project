<template>
  <div>
      <pizza-cards v-for="pizzas in SpecialtyPizzas" v-bind:key="pizzas"/>

  </div>
</template>

<script>
import PizzaCards from './PizzaCards.vue'
export default {
  components: { 
      PizzaCards 
      },

      computed: {}
      }


</script>

<style>

</style>