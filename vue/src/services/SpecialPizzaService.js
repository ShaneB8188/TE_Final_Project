import axios from 'axios';

export default {

    getPizzaById(specialId) {
        return axios.get(`/SpecialtyPizzas/${specialId}`);
      },

      getAllSpecialtyPizzas() {
          return axios.get("/SpecialtyPizzas");
      },
    
      createNewSpecialtyPizza(pizza) {
        return axios.post('/SpecialtyPizzas', pizza);
      }
    

}