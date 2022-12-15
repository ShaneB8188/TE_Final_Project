<template>
  <div id="section-banner">
    &nbsp;&nbsp;
    <div id="banner">
      &nbsp;&nbsp;
      <button
        class="fa-icon-btn"
        @click="$store.state.showCart = !$store.state.showCart, scrollToTop()"

      >
        <div class="fa-icon">
          <font-awesome-icon icon="fas fa-shopping-cart" />Cart
        </div>
      </button>

      <button class="fa-icon-btn" @click="$router.push({ name: 'menu' })">
        <div class="fa-icon">
          <font-awesome-icon icon="fa fa-bars" />&nbsp;Menu
          <!-- <router-link class="menu-items" :to="{ name: 'menu' }">Menu</router-link
          >&nbsp;&nbsp; -->
        </div>
      </button>
        
      
      <!-- <router-link class="menu-items" :to="{ name: 'checkout' }"
          >Cart</router-link -->
      <!-- >&nbsp;|&nbsp; -->
      <button class="fa-icon-btn" @click="$router.push({ name: 'AboutUs' })">
        <div class="fa-icon">
          <font-awesome-icon icon="fas fa-circle-info" />&nbsp;About Us
          <!-- <router-link class="menu-items" v-bind:to="{ name: 'AboutUs' }"
            > About Us</router-link
          > -->
        </div>
      </button>

      <!-- <router-link class="menu-items" v-bind:to="{ name: 'home' }"> -->
      <button class="fa-icon-btn" @click="$router.push({ name: 'home' })">
        <div class="fa-icon">
          <font-awesome-icon icon="fas fa-hotel" />&nbsp;Home
        </div>
      </button>

      <!-- </router-link>&nbsp;&nbsp; -->
      <button class="fa-icon-btn" @click="$router.push({ name: 'logout' })"  v-if="$store.state.token != ''">
        <div class="fa-icon">
          <font-awesome-icon icon="fas fa-right-from-bracket" />&nbsp;Logout
        </div>
        <!-- <router-link
          v-bind:to="{ name: 'logout' }"
          v-if="$store.state.token != ''"
          ><button class="fa-icon-btn">
            <font-awesome-icon icon="fas fa-right-from-bracket" />
            Logout
          </button></router-link
        > -->
      </button>
      <div class="spacer"></div>

      <div id="pizza-name-title">Speziata's Pizzeria</div>
    </div>

    <checkout v-show="$store.state.showCart" id="checkout" />
  </div>
</template>

<script>
import Checkout from "@/views/Checkout.vue";

export default {
  methods: {
    scrollToTop(){
      window.scrollTo(0,0);
    }
  },
  components: {
    Checkout,
  },
};
</script>

<style>
#pizza-name-title {
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
  background: linear-gradient(to right, rgb(241, 227, 227), #be162c);
  color: white;
  z-index: 2;
  position: fixed;
  top: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  width: 50%;
  
  /* justify-content: space-around; */
  height: 2.5rem;
  width: 100vw;
}
.fa-icon {
  color: black;
  display: flex;
  justify-content: center;
  /* width: 3rem; */
}
.fa-icon-btn {
  display: flex;
  min-width: 100px;
  width: 100px;
  justify-content: center;
  flex-direction: row;
  font: icon;
  font-family: Impact, Haettenschweiler, 'Arial Narrow Bold', sans-serif;
  align-items: center;
  align-content: center;
  color: black;
  align-items: center;
  margin: 0;
border-radius: 4px;
  /* width: 20%; */
  height: 2.5rem;
  cursor: pointer;
  width: 4em;
  color: black;
  background: linear-gradient(to right, #5dbea3, #5adbb5);
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
/* a {
  color: black;
} */
/* .menu-items {
  color: black;
}
.menu-items:hover {
  cursor: pointer;
  color: red;
} */
/* #pizza-name-title {
 justify-items: end;
 justify-content: end;
} */
</style>