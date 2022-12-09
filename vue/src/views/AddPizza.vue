<template>
  <div>
      <add-special />
      <list-special />
  </div>
</template>

<script>

import AddSpecial from '../components/Specialty/AddSpecial.vue';
import ListSpecial from '../components/Specialty/ListSpecial.vue';

export default {
    components: {
        AddSpecial,
        ListSpecial
    }

}
</script>

<style>

</style>