<template>
<form id="toppingForm">
    <div id="redDiv"></div>
    <div id='main'>
    <div v-for="topping in toppings" :key="topping.name">
            <label :for="isAvailable"> {{topping.name}} availability. Checked for true Unchecked for false </label>
            <input type="checkbox" :v-model="topping.isAvailable">
    </div>
    <!-- not sure how to tackle. should each button have a submit? ideally submit should submit them all but sending all of the toppings would be awkward -->
    <button type="submit" @click.prevent="updateTopping(updatedToppings)">Update these Toppings</button>
    <button @click="clearForm">Clear form</button>
    </div>
    <div id="greenDiv"></div>
</form>
</template>

<script>
export default {
    data() {
        return{
            
                
            
        }
    },
    computed: {
        toppings(){
            return this.$store.state.toppings;
        }
    },
    methods: {
        updateTopping(){
            // this.toppings.forEach(element => {
                // create update toppings in service and controller
                // this.$store.commit
            // });
          
    },
    }
}
</script>

<style>

</style>