<template>
  <div class="pizza" id="body">
    <div class="card" id="meat-lover">
      <header class="card-header">
        <p class="card-header-title">{{ pizza.name }}</p>
      </header>
      <figure class="image is-4by3">
        <img src="\Assests\meaty.jfif" alt="Place Holder Image for Pizza" />
      </figure>
      <div>
        {{pizza.pizzaSize}}
      </div>
      <div>
        {{pizza.crust}}
      </div>
      <div>
        {{pizza.sauce}}
      </div>
      <div class="card-content">
        <div class="content" v-for="topping in pizza.toppings" v-bind:key="topping.name">
          {{ topping.name }}
        </div>
      </div>
    </div>
  </div>
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

  props: ['pizza'],

  components: {},
};
</script>

<style>
header:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

#body {
  display: grid;
  grid-template-columns: 20px 1fr 1fr 1fr 20px;
  grid-template-areas:
    ". pepperoni supreme meat ."
    ". veggie neopolitan cheese ."
    ". create . . . ";

  grid-gap: 40px;
}
#create {
  grid-area: create;
  background-color: #f3ebf6;
}
#supreme {
  grid-area: supreme;
  background-color: #f3ebf6;
}

#pepperoni {
  grid-area: pepperoni;
  background-color: #f3ebf6;
}

#veggie {
  grid-area: veggie;
  background-color: #f3ebf6;
}
header {
  background: linear-gradient(to right, #27b055, #064d15);
  color: white;
}

#neopolitan {
  grid-area: neopolitan;
  background-color: #f3ebf6;
}

#meat-lover {
  grid-area: meat;
  background-color: #f3ebf6;
}
#cheese {
  grid-area: cheese;
  background-color: #f3ebf6;
}

#supreme:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

#pepperoni:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

#veggie:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

#neopolitan:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

#meat-lover:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}
#cheese:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}
#create:hover {
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

.pizza {
  display: grid;
  grid-template-areas: 10px 1fr 1fr 1fr 10px;
  text-align: center;
}
.pizza:hover {
  cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}
</style>