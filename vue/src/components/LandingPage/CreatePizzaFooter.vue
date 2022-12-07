<template>
  <div>
    <div class="card" id="create-card">
      <header class="card-header">
        <div class="card-header-title" id="create">
          <router-link v-bind:to="{ name: 'customPizza' }">
            Create Your Own
          </router-link>
        </div>
      </header>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
#create-card {
  display: flex;
  justify-content: center;
}
#create {
  background-color: green;
  color: white;
}
</style>