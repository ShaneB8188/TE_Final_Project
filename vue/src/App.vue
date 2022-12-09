

<template>
   <div id="app">
    <div id="nav" >
       
      <router-link class="menu-items" :to="{ name: 'menu' }">Menu</router-link>&nbsp;|&nbsp;
      <router-link class="menu-items" :to="{ name: 'checkout' }">Cart</router-link>&nbsp;|&nbsp;
      <router-link class="menu-items" v-bind:to="{ name: 'home' }">Employee Dashboard</router-link>
      <router-link
        v-bind:to="{ name: 'logout' }"
        v-if="$store.state.token != ''"
        >Logout</router-link
      > 

     <router-view></router-view>
    </div>
  </div>
</template>
<script>

// import Home from '@/views/Home';
// import Menu from '@/views/Menu';

export default {
  
  // components:
  // Menu,
  // Home,

};
</script>
<style>
#nav{
  background-color: #fff;
}
.menu-items{
  color: black;
  
}
.menu-items:hover{
  cursor: pointer;
  color: red;
}
</style>