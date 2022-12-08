import axios from 'axios'

export default {
    createSpecialtyPizza(pizza){
        axios.post('/pizza', pizza )
    },

    getPizzaById(pizzaId){
        axios.get( `/pizza/${pizzaId}`)
    },

    getAllPizzas(){
        axios.get('pizza')
    }
}