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
  
    <label for="PizzaCrust"> Select a crust type</label>
    <input id="pizzaCrustReg" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Regular" >
    <label for="pizzaCrustReg">Regular</label>
    <input id="pizzaCrustThin" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Thin">
    <label for="pizzaCrustThin">Thin</label>
    <input id="pizzaCrustDeep" type="radio" v-model="newPizza.crust" autocomplete="off" required value="Deep Dish">
    <label for="pizzaCrustDeep">Deep Dish</label>
    <br>

    <label for="PizzaSauce"> Select which sauce you'd like</label>
    <input id="pizzaSauceRed" type="radio" v-model="newPizza.sauce" autocomplete="off" required value="Red" >
    <label for="pizzaSauceRed">Red</label>
    <input id="pizzaSauceWhite" type="radio" v-model="newPizza.sauce" autocomplete="off" required value="White" >
    <label for="pizzaSauceWhite">White</label>
    <input id="pizzaSauceExRed" type="radio" v-model="newPizza.sauce" autocomplete="off" required value="Extra Red" >
    <label for="pizzaSauceExRed">Extra red</label>
    <br>

    Select which toppings you'd like
    <div v-for="topping in toppings" :key="topping.name">
        <label for="PizzaTopping"> </label>
        <input :id="`PizzaTopping${topping.name}`" type="checkbox" v-model="newPizza.toppings" :value="topping.toppingId" >
        <label :for="topping.name">{{topping.name}}</label>
    </div>

    <br>
    <button type="submit" class="btn btn-submit" @click.prevent="createNewPizza(newPizza)"> Order </button>
    <button type="button" class="btn btn-cancel" @click="resetForm"> Clear Choices </button>
  </form>
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService";
export default {
  computed: {
    // pizzaToppingSetter() {
    //   return this.toppings.filter(obj => obj.added == true);
    // },
  },
  data() {
    return {
      toppings: [
        {
          name: "Cheese",
          toppingId: 1,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
        {
          name: "Pepperoni",
          toppingId: 2,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
        {
          name: "Basil",
          toppingId: 3,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
        {
          name: "Black Olives",
          toppingId: 4,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
        {
          name: "Sausage",
          toppingId: 5,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
        {
          name: "Ham",
          toppingId: 6,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
        {
          name: "Banana Peppers",
          toppingId: 7,
          price: 1,
          isPremium: false,
          isAvailable: true,
          added: false
        },
      ],
      newPizza: {
        pizzaId: 1,
        size: "",
        crust: "",
        sauce: "",
        toppings: []
      },
    };
  },
  methods: {
    createNewPizza(Pizza) {
      const newPizza = { ...Pizza };

      newPizza.toppings = Pizza.toppings.map(toppingId => {
        return this.toppings.find(topping => topping.toppingId === toppingId);
      })

      OrderPizzaService.addPizza(newPizza);
    },
    resetForm() {
      this.newPizza = {
        size: '',
        crust: '',
        sauce: '',
        topping: [],
      }
    }
  },
};
</script>

<style>
button {
  
  align-content: space-around;
  
  width: 50%;
  cursor: pointer;
  border-radius: 5em;
  color: #fff;
  background: linear-gradient(to right, #27b055, #064d15);
  border: 0;
  padding-left: 40px;
  padding-right: 40px;
  padding-bottom: 10px;
  padding-top: 10px;
  font-family: "Ubuntu", sans-serif;
  font-size: 13px;
  box-shadow: 0 0 20px 1px rgba(0, 0, 0, 0.04);
  align-items: center;
  align-self: center;
  margin-top: 10px;
  margin-bottom: 24px;
}
</style>