import axios from 'axios';

export default {

    getPizzaById(specialId) {
        return axios.get(`/SpecialtyPizza/${specialId}`);
      },

      getAllSpecialtyPizzas() {
          return axios.get("/specialtyPizza");
      },
    
      createNewSpecialtyPizza(pizza) {
        return axios.post('/SpecialtyPizza', pizza);
      }
    

}