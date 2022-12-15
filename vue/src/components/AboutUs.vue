<template>
  <div class="main-containeras">
    <div class="card" id="about-us">
      <header class="card-header">
        <p class="card-header-title" id="about-us">About Us</p>
      </header>

      <div class="card-content" id="name">Speziata's Pizzaeria Values</div>

      <div class="card-content">
        The key to progress is much similar to the key to improving a pizza –
        the more you put into it, the more you receive in return. Our pizza
        family is as eager for flawlessness today as we were the point at which
        we originally opened our entryways over 40 years back. Also, we’re
        headed to be the best at making creative new items and formulas. Quality
        is at our center. It’s the establishment we begun with, from the main
        Speziata's pizza that was made in a sweeper storage room in
        Tech Elevator, to now in excess of 5,000 areas in 45 nations and regions
        around the globe. We don’t utilize shabby and increasingly prepared
        fixings. Regardless of whether it’s our mark sauce, fixings, our unique
        new mixture, or even the case itself, we put resources into our fixings
        to guarantee that we generally give you the best quality pizza. For you,
        it’s not only a superior pizza. It’s a family assembling, important
        birthday, work festivity or basically an incredible supper. It’s our
        objective to ensure you generally have the best elements for each event.
      </div>
    </div>
    <div class="card" id="core-interest">
      <header class="card-header">
        <p class="card-header-title">Core Interest</p>
      </header>
      <div class="card-content">
        <div class="content">
          We should keep priority the main thing , The Main Thing which is
          pizza. We will reliably convey a conventional Speziata's
          unrivaled quality pizza.
        </div>
      </div>
    </div>
    <div class="card" id="predominance">
      <header class="card-header">
        <p class="card-header-title">Predominance</p>
      </header>
      <div class="card-content">
        <div class="content">
          Our consumer loyalty must be predictable, quantifiable and verifiable.
          At Speziata's we anticipate perfection – the “best in its
          class” in all that we do.
        </div>
      </div>
    </div>
    <div class="card" id="thought-process">
      <header class="card-header">
        <p class="card-header-title">Thought Process</p>
      </header>
      <div class="card-content">
        <div class="content">
          Individuals Are Priority Always. Our prosperity relies on our
          capacity, as a group, to cooperate to accomplish our objectives and
          desires.
        </div>
      </div>
    </div>
    <div class="card" id="disposition">
      <header class="card-header">
        <p class="card-header-title">Disposition</p>
      </header>
      <div class="card-content">
        <div class="content">
          On the off chance that you want to or you figure you can’t – you’re
          correct! The distinction among champs and failures is a positive
          mental frame of mind. Our frame of mind is an impression of what we
          esteem: fruitful colleagues must be perky, proactive and enthusiastic
          about all that they do.
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
          will dependably show signs of improvement.
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