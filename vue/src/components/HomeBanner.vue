<template>
  <div id="section-banner">
    <div id="banner">
      <button
        id="cart-btn"
        @click="$store.state.showCart = !$store.state.showCart"
      >
        <div id="fa-icon">
          <font-awesome-icon icon="fas fa-shopping-cart" />
        </div>
      </button>
      <div id="menu-icon"> <font-awesome-icon icon="fa-solid fa-bars" />
      <router-link class="menu-items" :to="{ name: 'menu' }">Menu</router-link
      >&nbsp;|&nbsp;</div>
      <!-- <router-link class="menu-items" :to="{ name: 'checkout' }"
          >Cart</router-link -->
      <!-- >&nbsp;|&nbsp; -->
      <router-link class="menu-items" v-bind:to="{ name: 'home' }"
        >Employee Dashboard</router-link
      >&nbsp;|&nbsp;

      <router-link class="menu-items" v-bind:to="{ name: 'AboutUs' }"
        >About Us</router-link
      >

      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      >

      <div class="spacer"></div>

      <div id="pizza-name-title">Speziata's Pizzeria</div>
    </div>

    <checkout v-show="$store.state.showCart" id="checkout" />
  </div>
</template>

<script>
import Checkout from "@/views/Checkout.vue";

export default {
  components: {
    Checkout,
  },
};
</script>

<style>
#pizza-name-title{
  font-size: 35px;
  margin-right: 90px;
}

.spacer {
  flex-grow: 1;
}
#checkout {
  margin-top: 3rem;
}

#home {
  margin: 10px;
}
#banner {
  background: linear-gradient(to right, white, #be162c);
  color: white;
  z-index: 2;

  position: fixed;
  top: 0;
  display: flex;
  align-items: center;
  height: 2.5rem;
  width: 100vw;
}
#cart-btn {
  display: flex;
  flex-direction: column;
  justify-content: center;
  margin:0;
  
  justify-content: center;
  width: 4em;
  background: linear-gradient(to right, #9fbcd6, #151d64);
}
.checkout {
  border: red;
  border-radius: 4px;
  width: 350px;
  position: fixed;
  
  top: 10px;
  right: 10px;
}
#nav {
  background-color: #fff;
}
.menu-items {
  color: black;
}
.menu-items:hover {
  cursor: pointer;
  color: red;
}
/* #pizza-name-title {
 justify-items: end;
 justify-content: end;
} */
</style>