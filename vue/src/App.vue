<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
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
