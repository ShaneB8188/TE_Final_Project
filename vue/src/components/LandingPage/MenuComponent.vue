<template>
  <div>
      <pizza-cards v-for="pizza in $store.state.specialtyPizza" v-bind:key="pizza.id"/>

  </div>
</template>

<script>
import PizzaCards from './PizzaCards.vue'
import SpecialPizzaService from '@/services/SpecialPizzaService.js'
export default {
  components: { 
      PizzaCards,
      },
      pizzas:[],
      

      created() {
        
           SpecialPizzaService.getAllSpecialtyPizzas().then((response) => {
      this.pizzas = response.data.specialtyPizza;
       });
  
       
     
    
  },
      }


</script>

<style>

</style>