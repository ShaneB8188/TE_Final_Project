<template>
  <div>
    <div>
      <h2>Topping: {{ topping.name }}</h2>
    </div>
    <div>
      Amount(grams):
      {{ nutritionPull.serving_weight_grams }}
    </div>

    <div>
      Calories:
      {{ nutritionPull.nf_calories }}
    </div>
    <div>
      Total Fat(grams):
      {{ nutritionPull.nf_total_fat }}
    </div>
    <div>
      Saturated Fat(grams):
      {{ nutritionPull.nf_saturated_fat }}
    </div>
    <div>
      Cholesterol(milligrams):
      {{ nutritionPull.nf_cholesterol }}
    </div>
    <div>
      Sodium(milligrams):
      {{ nutritionPull.nf_sodium }}
    </div>
    <div>
      Total Carbs(grams):
      {{ nutritionPull.nf_total_carbohydrate }}
    </div>
    <div>
      Dietary Fiber(grams):
      {{ nutritionPull.nf_dietary_fiber }}
    </div>
    <div>
      Sugars(grams):
      {{ nutritionPull.nf_sugars }}
    </div>
    <div>
      Protein(grams):
      {{ nutritionPull.nf_protein }}
    </div>
    <div>
      Potassium(milligrams):
      {{ nutritionPull.nf_potassium }}
    </div>
  </div>
</template>

<script>
import NutritionService from "../services/NutritionService.js";

export default {
  created() {
    NutritionService.getToppingNutrition(this.topping.name).then((response) => {
      this.nutrition = response.data;
    });
  },
  data() {
    return {
      nutrition: [],
    };
  },
  computed: {
    // pulls information out of returned nested array of size 1
    // <div>
    //   {{ nutrition["foods"][0] }}
    // </div>
    nutritionPull() {
      return this.nutrition["foods"][0];
    },
  },
  props: ["topping"],
};
</script>

<style>
</style>