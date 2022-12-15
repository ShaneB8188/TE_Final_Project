<template>
  <div class="contenty">
    <div id="flex-box" class="text-center">
      <div class=""></div>

      <h1
        id="cart"
        class="h3 mb-3 font-w eight-normal has-text-white"
        align="center"
      >
        Cart
      </h1>
      <h3 id="flexbox-total" class="has-text-white">Order Total: ${{ cartTotal }}</h3>
      <label class="has-text-white" id="flexbox-delivery" for="isDelivery">Delivery </label>
      <input id="flexbox-delivery" type="checkbox" name="isDelivery" v-model="isDelivery" />
      <br />
      <div id="flexbox">
        <div id="pizza-for" class="card-content">
          <div class="spacer">
            <div id="flexbox-pizza" v-for="pizza in $store.state.Cart.pizzas" :key="pizza.pizzaId">
              <br />
              Pizza Name: {{ pizza.name }} &nbsp;
              
              <br />
              {{ pizza.crust }} Crust, {{ pizza.sauce }} Sauce,
              {{ pizza.toppings.map((topping) => topping.name).join(", ") }}
              <div class="is-divider"></div>
              <button id="flexbox-remove"
                class="delete"
                @click="deleteFromCart(pizza.pizzaId)"
              ></button>
            </div>
          </div>
        </div>
      </div>

      <form v-show="isDelivery">
        <label for="Address">Street Address for Delivery</label> <br />
        <input type="text" name="Address" /><br />
        <label for="City">City</label><br />
        <input type="text" name="City" /><br />
        <label for="State">State</label><br />
        <input type="text" name="State" /><br />
        <label for="ZipCode">ZipCode</label><br />
        <input type="text" name="ZipCode" /><br />
      </form>

      <router-link
        :to="{ name: 'menu' }"
        @click.native="$store.state.showCart = !$store.state.showCart"
        >Return to Menu</router-link
      >
      <br />

      <router-link :to="{ name: 'menu' }"></router-link>
      <button type="submit" class="checkoutBtn" @click="createOrder()">
        Checkout
      </button>
    </div>
  </div>
  <!-- </div> -->
</template>

<script>
import OrderPizzaService from "@/services/OrderPizzaService.js";

export default {
  computed: {
    cartTotal() {
      let sum = 0;
      this.$store.state.Cart.pizzas.forEach((pizza) => {
        sum += pizza.price;
      });
      return sum;
    },
  },

  data() {
    return {
      isDelivery: false,
      order: {
        orderId: "",
        price: "",
        isDelivery: false,
        orderStatus: "",
        pizzas: [],
      },
      newOrder: {
        orderId: "",
        price: "",
        isDelivery: false,
        orderStatus: "",
        pizzas: [],
      },
      filteredCart: [],
    };
  },
  methods: {
    createOrder() {
      if (confirm("Are you sure you're ready to place the order?")) {
        this.$store.commit("SET_CART_TOTAL", this.cartTotal1());
        this.order = this.$store.state.Cart;
        this.order.orderStatus = "Pending";
        this.$store.state.Cart.isDelivery = this.isDelivery;
        OrderPizzaService.addOrder(this.order);
        this.resetOrder();
        this.$store.state.showCart = !this.$store.state.showCart;
        this.$store.state.Cart = this.newOrder;
      }
    },
    deleteFromCart(id) {
      this.filteredCart = this.$store.state.Cart.pizzas.filter((pizza) => {
        if (pizza.pizzaId != id) {
          return pizza;
        }
      });
      this.$store.state.Cart.pizzas = this.filteredCart;
    },
    resetOrder() {
      this.order = this.newOrder;
    },
    cartTotal1() {
      let sum = 0;
      this.$store.state.Cart.pizzas.forEach((pizza) => {
        sum += pizza.price;
      });
      return sum;
    },
    // modifyCart() {
    //   this.$store.state.showCart = !this.$store.state.showCart;
    // }
  },
};
</script>

<style>
#flexbox {
  display: flex;
  flex-direction: column;

 justify-self: center;
 justify-content: space-around;
}
#flexbox-remove{
display: flex;
justify-content: flex-end;
align-items: center;
}

#flexbox-total{
  display: flex;
  justify-content: space-between;
  align-items: center;
}
#flexbox-delivery{
  display: flex;
  justify-content: space-between;
  align-items: center;

}
#flexbox-pizza{
  display: flex;
  justify-content: space-between;
  align-items: center;
  background-color: white;
  border-radius: 5px;
  min-width: 100%;
  

}

.contenty {
  background: linear-gradient(to right, #27b055, #064d15);
}

h3 {
  color: white;
}

.text-center {
  display: inline;
  justify-content: center;
}
.isDelivery {
  display: flex;
  flex-direction: row;
}
.checkoutBtn {
  display: flex;
  flex-direction: row;
  align-items: center;
  justify-content: space-evenly;
  justify-items: center;
}

.delete {
  color: crimson;
  background-color: rgb(212, 92, 116);
}

</style>