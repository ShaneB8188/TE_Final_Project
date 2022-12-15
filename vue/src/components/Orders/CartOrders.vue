<template>
  <div class="contenty">
    <div id="flex-box" class="text-center">
      <div class=""></div>

      <h1 id="cart" class="h3 mb-3 font-w eight-normal" align="center">Cart</h1>
      <h3 id="flexbox-total">Order Total: ${{ cartTotal }}</h3>

      <div id="flexbox-delivery">
        <label for="isDelivery">Delivery? &nbsp;</label>
        <input type="checkbox" name="isDelivery" v-model="isDelivery" />
      </div>

      <br />

      <div id="flexbox">
        <div id="pizza-for" class="card-content">
          <div class="spacer">
            <div
              id="flexbox-pizza"
              v-for="pizza in $store.state.Cart.pizzas"
              :key="pizza.pizzaId"
            >
              <br />
              Pizza Name: {{ pizza.name }} &nbsp;

              <br />
              {{ pizza.crust }} Crust, {{ pizza.sauce }} Sauce,
              {{ pizza.toppings.map((topping) => topping.name).join(", ") }}
              <div class="is-divider"></div>
              <button
                id="flexbox-remove"
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
      <div id="flex-menu">
        <router-link
          :to="{ name: 'menu' }"
          @click.native="$store.state.showCart = !$store.state.showCart"
          >Return to Menu</router-link
        >
      </div>

      <br />
      <div id="flexbox-checkout">
        <router-link :to="{ name: 'menu' }"></router-link>
        <button type="submit" class="checkoutBtnB" @click="createOrder()">
          Checkout
        </button>
      </div>
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

<style scoped>
#flex-menu {
  display: flex;
  justify-content: center;
  color: black;
}
#cart {
  font-weight: 700;
  font-size: 26px;
}
#flexbox-checkout {
  display: flex;
  justify-content: center;
}
form {
  text-align: center;
}

#flexbox {
  display: flex;
  flex-direction: column;

  justify-self: center;
  justify-content: space-around;
}
#flexbox-remove {
  display: flex;
  justify-content: flex-end;
  align-items: center;
}

#flexbox-total {
  display: flex;
  justify-content: space-around;
  align-items: center;
}
#flexbox-delivery {
  display: flex;
  justify-content: center;
}
#flexbox-pizza {
  display: flex;
  justify-content: space-between;
  
  align-items: center;
  background-color: white;
  border-radius: 5px;
  margin-bottom: 10px;
  padding-left: 10px;
  padding-right: 10px;
  margin-left: 15%;
  margin-right: 15%;
  flex-wrap: none;
  min-height: 50%;

  box-shadow: 1px 1px 2.5px 2.5px rgba(192, 227, 250, 0.884);
}

.contenty {
  background: white;
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
.checkoutBtnB {
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

.delete {
  color: crimson;
  background-color: rgb(212, 92, 116);
}

h1 {
}
</style>