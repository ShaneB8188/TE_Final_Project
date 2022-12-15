<template>
  <aside class="menu">
  <p class="menu-label">
    Order Status
  </p>
  <ul class="menu-list">
    <li>
      <ul>
        <router-link :to="{name: 'Orders'}">
        View and Edit all Orders
        </router-link>
      </ul>
    </li>
  </ul>
  <p class="menu-label">
    Menu Creation
  </p>
  <ul class="menu-list">
    <li>
      <ul>
        <li><router-link :to="{name: 'AddPizza'}">Add/Update A Pizza</router-link></li>
        <li><router-link :to="{name: 'DeleteSpecial'}">Remove Pizza From Menu</router-link></li>
        <li>
          <router-link :to="{name:'Toppings'}">
          Add Topping to Menu
          </router-link>
        </li>
        <li>
          <router-link :to="{name:'Toppings avail'}">
            Update Topping Availability
            </router-link>
          </li>
        <li>
           <!-- <router-link :to="{name:'Toppings delete'}">
          Remove Topping From Menu
          </router-link> -->
          </li>
      </ul>
    </li>
  </ul>

</aside>
</template>


<script>
// import { component } from 'vue/types/umd';
// import HomeBanner from '@/components/HomeBanner.vue';
export default {
  created() {
    this.$store.dispatch("setSpecials");
    this.$store.dispatch("setToppings");
  },
  name: "home",
  components: {
    // homeBanner,
  },
};
  
</script>

<style>
.menu{
  size: 6rem;
  font-weight: 500;
  display: flex;
  flex-direction: column;
  padding-left: 1.5rem;
  position: sticky;
  width: 100%;
  background-color: #f3ebf6;
  font-family: "Ubuntu", sans-serif;
  /* height: 10%; */
  padding-bottom: 25%; 
  border-right: 1px solid black;
}

</style>