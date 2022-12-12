<template>

  
  <router-link :to="{ name: 'customPizza' }" class="pizza" id="body">
  
    <div class="card" id="meat-lover" @click="populateSpecialtyPizza(pizza.pizzaId)">
      <header class="card-header">
        <p class="card-header-title">{{ pizza.name }}</p>
      </header>
      <figure class="image is-4by3">
        <img src="\Assests\meaty.jfif" alt="Place Holder Image for Pizza" />
      </figure>
      <div class="card-content">
        {{pizza.pizzaSize}}
      </div>
      <div class = "card-content">
        {{pizza.crust}}
      </div>
      <div class="card-content">
        {{pizza.sauce}}
      </div>
      <div class="card-content" id = 'toppings'>
        <div class="content" v-for="topping in pizza.toppings" v-bind:key="topping.name">
          {{ topping.name }}
        </div>
      </div>
    </div>
  </router-link>
</template>

<script>
export default {
  // data() {
  //   return {
  //     specialtyPizza: this.setPizza,
  //   };
  // },
  computed: {
    setPizza() {
      return this.pizza;
    }
  },

  

  props: [
    'pizza'
    ],

  components: {},

  methods: {
    populateSpecialtyPizza(pizzaId) {

      this.$store.commit("SET_TEMP_PIZZA",this.$store.state.specials.filter(obj => {
        return obj.pizzaId == pizzaId;
      })[0]); 
      
    }
  },  
};
</script>

<style>



header:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}


header {
  background: linear-gradient(to right, #27b055, #064d15);
  color: white;
}


#meat-lover {
  grid-area: meat;
  background-color: #f3ebf6;
}

#meat-lover:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}


.pizza:hover {
  cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}
</style>