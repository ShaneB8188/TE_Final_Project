

<template>
  <div id="app">
    <div id="nav">
      <div id="banner">
        <button id="cart-btn" @click="showCart = !showCart">
          <div id="fa-icon">
            <font-awesome-icon icon="fas fa-shopping-cart" />
          </div>
        </button>

        <router-link class="menu-items" :to="{ name: 'menu' }">Menu</router-link
        >&nbsp;|&nbsp;
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
      </div>

      <checkout v-show="showCart" />

      <router-view></router-view>
    </div>
  </div>
</template>
<script>
import Checkout from "@/views/Checkout.vue";
// import Home from '@/views/Home';
// import Menu from '@/views/Menu';

export default {
  name: "App",
  components: {
    Checkout,
  },
  methods: {},
  data() {
    return {
      showCart: false,
    };
  },
  
};
</script>
<style>
#banner {
  position: fixed;
  display: flex;
  align-items: center;
  z-index: 2;
}
#cart-btn {
  display: flex;
  margin:0;
  
  /* position: fixed; */
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
</style>