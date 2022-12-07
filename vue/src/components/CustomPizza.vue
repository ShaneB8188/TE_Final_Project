<template>
  
    <form >
    <label for="PizzaSize"> Select a Pizza Size</label>
    <input id="pizzaSizeSmall" type="radio" v-model="newPizza.size" autocomplete="off" required value="Small" >
    <label for="pizzaSizeSmall">Small</label>
    <input id="pizzaSizeMedium" type="radio" v-model="newPizza.size" autocomplete="off" required value="Medium">
    <label for="pizzaSizeMedium">Medium</label>
    <input id="pizzaSizeLarge" type="radio" v-model="newPizza.size" autocomplete="off" required value="Large">
    <label for="pizzaSizeLarge">Large</label>
    <input id="pizzaSizeExLarge" type="radio" v-model="newPizza.size" autocomplete="off" required value="ExLarge">
    <label for="pizzaSizeExLarge">Extra Large</label>
    <br>
  
    <label for="PizzaCrust"> Select a Crust Type</label>
    <input id="pizzaCrustReg" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Regular" >
    <label for="pizzaCrustReg">Regular</label>
    <input id="pizzaCrustThin" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Thin">
    <label for="pizzaCrustThin">Thin</label>
    <input id="pizzaCrustDeep" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Deep Dish">
    <label for="pizzaCrustDeep">Deep Dish</label>
    <br>

  </form>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";
export default {
  data() {
    return {
      newPizza: {
        pizzaId: 1,
        size: "",
        crust: "",
        sauce: "",
      },
    };
  },
  methods: {
    createNewPizza(Pizza) {
      OrderPizzaService.addPizza(Pizza);
    },
  },
};
</script>

<style>
</style>