<template>
  <div class="main-containeras">
    <div class="card" id="about-us">
      <header class="card-header">
        <p class="card-header-title" id="about-us">About Us</p>
      </header>

      <div class="card-content" id="name">Speziata's Pizzaeria Values</div>

      <div class="card-content">
        The key to progress is similar to the key to improving a pizza –
        the more you put into it, the more you receive in return. Our pizza
        family is as eager for flawlessness today as we were the point at which
        we originally opened our entryways over 40 years back. Also, we’re
        headed to be the best at making creative new items and formulas. Quality
        is at our center. It’s the establishment we begun with, from the main
        Speziata's pizza that was made in a sweeper storage room in
        Tech Elevator, to now in excess of 5,000 areas in 45 nations and regions
        around the globe. We don’t utilize shabby or ready-made
        fixings. Regardless of whether it’s our signature sauce, fixings, our unique
        new flour, or even the cheese itself, we put resources into our fixings
        to guarantee that we give you the best quality pizza. For you,
        it’s not only a superior pizza. It’s a family assembling, building, and designing a true unique pizza creation. It’s our
        objective to ensure you absolutely have the best ingredients for each pizza.
      </div>
    </div>
    <div class="card" id="core-interest">
      <header class="card-header">
        <p class="card-header-title">Core Interest</p>
      </header>
      <div class="card-content">
        <div class="content">
          When it comes down to it, it's all about the Pizza. If we aren't talking pizza we don't wanna talk. From our local fresh ingredients to the love and care that our head chef Walt uses, every Pizza is a "pizza" of our hearts.
        </div>
      </div>
    </div>
    <div class="card" id="predominance">
      <header class="card-header">
        <p class="card-header-title">Predominance</p>
      </header>
      <div class="card-content">
        <div class="content">
          When we were founded we made a pledge to never again be at the bottom of the chain. Our local shop now dominates the field, thanks to our special touch.
          At Speziata's we anticipate perfection – the “Best in its
          Class” in all that we do.
        </div>
      </div>
    </div>
    <div class="card" id="thought-process">
      <header class="card-header">
        <p class="card-header-title">Customers</p>
      </header>
      <div class="card-content">
        <div class="content">
          Individuals Are Priority Always. Our prosperity relies on our
          capacity, as a group, to cooperate to accomplish our objectives and
          desires. And there's no one more important to us than our paying customers. We literally wouldn't in business without them.
        </div>
      </div>
    </div>
    <div class="card" id="disposition">
      <header class="card-header">
        <p class="card-header-title">Attitude</p>
      </header>
      <div class="card-content">
        <div class="content">
          When it comes to attitude I'm reminded of something my grandfather once told me on the beach in Sicily, "Never give up, and make the best damn Pizza place out there." He also mentioned that the Americans were fools and we could easily corner the market there since our business was failing in Italy. But I digress, we have the chops.
        </div>
      </div>
    </div>
    <div class="card" id="steady-improvement">
      <header class="card-header">
        <p class="card-header-title">Steady Improvement</p>
      </header>

      <div class="card-content">
        <div class="content">
          We try constantly to outperform our past best. We continually
          “Increase present expectations.” No issue how great we will be, we
          will dependably show signs of improvement. Nothing shows improvement like the story of our twin chefs Tom and Tom. Like a pizza, the were baked and developed under the care of our chef Walt and now they are running our booming Pizza truck business like pros.
        </div>
      </div>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style scoped>
.main-containeras {
  display: grid;
  grid-template-columns: 1fr 1fr;
  grid-template-areas:
    "about about"
    "name name"
    "core predom"
    "thought disposition "
    "steady .";

    gap: 25px;
}
#about-us {
  grid-area: about;
  text-align: center;
}
#core-interest {
  grid-area: core;
   text-align: center;
}
#predominance {
  grid-area: predom;
   text-align: center;
}
#thought-process {
  grid-area: thought;
   text-align: center;
}
#disposition {
  grid-area: disposition;
   text-align: center;
}
#steady-improvement {
   text-align: center;
  grid-area: steady;
  
}

#name {
  /* grid-area: name; */
  font-size: 30px;
  background: linear-gradient(to right, #27b055, #064d15);
  margin-top: 0px;
  margin-right: 0px;
  color: white;
   text-align: center;
}

#value {
  background: linear-gradient(to right, #27b055, #064d15);
  color: white;
}

.card-content {
  justify-content: center;
}
</style>