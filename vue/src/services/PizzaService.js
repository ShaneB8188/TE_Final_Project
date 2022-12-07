import axios from 'axios'

export default {
    createSpecialtyPizza(pizza){
        axios.post('/pizzas', pizza )
    },

    getPizzaById(pizzaId){
        axios.get( `/pizzas/${pizzaId}`)
    },

    getAllPizzas(){
        axios.get('pizzas')
    }
}