

<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Employee Login</router-link>&nbsp;|&nbsp;
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      <router-link v-bind:to="{ name: 'menu' }">Menu</router-link>&nbsp;|&nbsp;
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
