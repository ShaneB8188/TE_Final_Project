<template>
  <div>
    <router-link id="create" :to="{ name: 'customPizza' }">
      <div class="card" id="create">
        <header class="card-header">
          <p class="card-header-title">Create Your Own Pizza</p>
        </header>
        <figure class="image is-4by3">
          <img
            class="pizza-photo"
            src="\Assests\create.jfif"
            alt="Place Holder Image for Pizza"
          />
        </figure>
        <div class="card-content">
          <div class="content">
            Customize your pizza how you like with any number of cheeses,
            toppings, sauce, and crust
          </div>
        </div>
      </div>
    </router-link>
  </div>
</template>

<script>
export default {
  
};
</script>

<style>


#create{
   background-color: #f3ebf6;
}
#create:hover{
  cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}
.content {
   min-height: 10vw;

}

#create-pizza{
    
  text-align: center;
  
}
header:hover{
 cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);
}

@media (min-width: 720px) {
  .content{
    min-height: 100px;
  }

}

min
</style>