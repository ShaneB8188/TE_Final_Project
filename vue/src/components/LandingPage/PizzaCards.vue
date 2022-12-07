<template>
  <div class="pizza" id="body">
    <div class="card" id="meat-lover">
      <header class="card-header">
        <p class="card-header-title">Meat Lovers Pizza</p>
      </header>
      <div class="card-content">
        <div class="content">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magnam
          cumque eligendi nihil a animi reprehenderit laboriosam dolorem, sint
          beatae mollitia quam iste blanditiis possimus tempore natus doloribus.
          Rerum, rem. Voluptatem.
        </div>
      </div>
    </div>
    <div class="card" id="neopolitan">
      <header class="card-header">
        <p class="card-header-title">Neopolitan</p>
      </header>
      <div class="card-content">
        <div class="content">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magnam
          cumque eligendi nihil a animi reprehenderit laboriosam dolorem, sint
          beatae mollitia quam iste blanditiis possimus tempore natus doloribus.
          Rerum, rem. Voluptatem.
        </div>
      </div>
    </div>
    <div class="card" id="supreme">
      <header class="card-header">
        <p class="card-header-title">Supreme</p>
      </header>
      <div class="card-content">
        <div class="content">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magnam
          cumque eligendi nihil a animi reprehenderit laboriosam dolorem, sint
          beatae mollitia quam iste blanditiis possimus tempore natus doloribus.
          Rerum, rem. Voluptatem.
        </div>
      </div>
    </div>
    <div class="card" id="veggie">
      <header class="card-header">
        <p class="card-header-title">Veggie</p>
      </header>
      <div class="card-content">
        <div class="content">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magnam
          cumque eligendi nihil a animi reprehenderit laboriosam dolorem, sint
          beatae mollitia quam iste blanditiis possimus tempore natus doloribus.
          Rerum, rem. Voluptatem.
        </div>
      </div>
    </div>
    <div class="card" id="cheese">
      <header class="card-header">
        <p class="card-header-title">Cheese</p> 
      </header>
      <div class="card-content">
        <div class="content">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magnam
          cumque eligendi nihil a animi reprehenderit laboriosam dolorem, sint
          beatae mollitia quam iste blanditiis possimus tempore natus doloribus.
          Rerum, rem. Voluptatem.
        </div>
      </div>
    </div>
    <div class="card" id="pepperoni">
      <header class="card-header">
        <p class="card-header-title">Pepperoni</p>
      </header>
      <div class="card-content">
        <div class="content">
          Lorem ipsum, dolor sit amet consectetur adipisicing elit. Magnam
          cumque eligendi nihil a animi reprehenderit laboriosam dolorem, sint
          beatae mollitia quam iste blanditiis possimus tempore natus doloribus.
          Rerum, rem. Voluptatem.
        </div>
      </div>
    </div>

   
  </div>
</template>

<script>
export default {};
</script>

<style>
#body{
    display: grid;
    grid-template-columns:  1fr 1fr 1fr;
    grid-template-areas: "pepperoni supreme meat"
                            " veggie neopolitan cheese ";

    grid-gap: 5px;

}
#supreme{
grid-area: supreme;

}

#pepperoni{
grid-area: pepperoni;
}

#veggie{
grid-area: veggie;
}

#neopolitan{
grid-area: neopolitan;
}

#meat-lover{
grid-area: meat;
}
#cheese{
grid-area: cheese;
}


#supreme:hover{
 cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);

}

#pepperoni:hover{
   cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}

#veggie:hover{
   cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}

#neopolitan:hover{
   cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}

#meat-lover:hover{
   cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}
#cheese:hover{
   cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
    
}


.pizza {
  display: grid;
  grid-template-areas: 10px 1fr 1fr 1fr 10px;
  text-align: center;
}
.pizza:hover{
  cursor: pointer;
  background-color: rgba(255, 255, 255, 0.644);
}
</style>