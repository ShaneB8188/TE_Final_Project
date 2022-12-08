<template>
  <div class="pizza" id="body">
    <div class="card" id="meat-lover">
      <header class="card-header">
        <p class="card-header-title">Meat Lovers Pizza</p>
      </header>
          <figure class="image is-4by3">
            <img src="\Assests\meaty.jfif" alt="Place Holder Image for Pizza">
          </figure>

      <div class="card-content">
        <div class="content">
          Sausage, Bacon, Ham, Pepperoni, hand shredded mozzarella cheese, house made red tomato sauce and a hand made crust
        </div>
      </div>
    </div>
    <div class="card" id="neopolitan">
      <header class="card-header">
        <p class="card-header-title">Neopolitan</p>
      </header>
        <figure class="image is-4by3">
            <img src="\Assests\neo2.jfif" alt="Place Holder Image for Pizza">
        </figure>
      <div class="card-content">
        <div class="content">
         Large Rolls of mozzarella cheese, red tomato sauce made from Pomodorino del Piennolo del vesuvio tomatoes all on top of a fluffy hand made crust
        </div>
      </div>
    </div>
    <div class="card" id="supreme">
      <header class="card-header">
        <p class="card-header-title">Supreme</p>
      </header>
      <figure class="image is-4by3">
            <img class="pizza-photo" src="\Assests\supreme.jfif" alt="Place Holder Image for Pizza">
      </figure>
      <div class="card-content">
        <div class="content">
         Diced tomatoes, black olives, mushrooms, red peppers, green peppers, house made tomato sauce and a homemade crust
        </div>
      </div>
    </div>
    <div class="card" id="veggie">
      <header class="card-header">
        <p class="card-header-title">Veggie</p>
      </header>
      <figure class="image is-4by3">
            <img class="pizza-photo"  src="\Assests\Vegetarian-Pizza-720x720.jpg" alt="Place Holder Image for Pizza">
      </figure>
      <div class="card-content">
        <div class="content">
          Black and green olives, mushrooms, sliced zucchini, sliced squash, shredded carrots, shredded mozzarella cheese, homemade garlic based sauce , homemade crust
      
        </div>
      </div>
    </div>
    <div class="card" id="cheese">
      <header class="card-header">
        <p class="card-header-title">Cheese</p> 
      </header>
      <figure class="image is-4by3">
            <img class="pizza-photo"  src="\Assests\cheese.jfif" alt="Place Holder Image for Pizza">
      </figure>
      <div class="card-content">
        <div class="content">
          Gorgonzola cheese, Parmigiano Reggiano, fresh goat cheese, mozzarella cheese, house made tomato sauce, homemade crust
                  </div>
      </div>
    </div>
    <div class="card" id="pepperoni">
      <header class="card-header">
        <p class="card-header-title">Pepperoni</p>
      </header>
      <figure class="image is-4by3">
            <img class="pizza-photo"  src="\Assests\pepperoni.jpeg" alt="Place Holder Image for Pizza">
      </figure>
      <div class="card-content">
        <div class="content">
         Tons of pepperoni slices, Gorgonzola and mozzarella cheeses, house made tomato sauce, homemade crust
        
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
    grid-template-columns:  20px 1fr 1fr 1fr 20px;
    grid-template-areas: ". pepperoni supreme meat ."
                            ". veggie neopolitan cheese .";

    grid-gap: 40px;

}
#supreme{
grid-area: supreme;
background-color: #f3ebf6;

}

#pepperoni{
grid-area: pepperoni;
background-color: #f3ebf6;
}

#veggie{
grid-area: veggie;
background-color: #f3ebf6;
}

#neopolitan{
grid-area: neopolitan;
background-color: #f3ebf6;
}

#meat-lover{
grid-area: meat;
background-color: #f3ebf6;
}
#cheese{
grid-area: cheese;
background-color: #f3ebf6;
}


#supreme:hover{
 cursor: pointer;
  background-color: rgba(252, 101, 101, 0.644);

}

#pepperoni:hover{
   cursor: pointer;
background-color: rgba(252, 101, 101, 0.644);
}

#veggie:hover{
   cursor: pointer;
background-color: rgba(252, 101, 101, 0.644);
}

#neopolitan:hover{
   cursor: pointer;
background-color: rgba(252, 101, 101, 0.644);
}

#meat-lover:hover{
   cursor: pointer;
background-color: rgba(252, 101, 101, 0.644);
}
#cheese:hover{
   cursor: pointer;
background-color: rgba(252, 101, 101, 0.644);
    
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