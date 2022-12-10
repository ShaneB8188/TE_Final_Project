import axios from "axios";

export default {

    getAllToppings() {
        return axios.get('/toppings')
    },

    createToppings(topping) {
        return axios.post('/toppings/', topping)
    },

    getToppingsById(toppingId) {
        return axios.get(`/toppings/${toppingId}`)
    },


}


