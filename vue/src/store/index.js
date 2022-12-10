import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';
import ToppingsService from '../services/ToppingsService';

Vue.use(Vuex)

/*
 * The authorization header is set for axios when you login but what happens when you come back or
 * the page is refreshed. When that happens you need to check for the token in local storage and if it
 * exists you should set the header so that it will be attached to each request
 */
const currentToken = localStorage.getItem('token')
const currentUser = JSON.parse(localStorage.getItem('user'));

if (currentToken != null) {
  axios.defaults.headers.common['Authorization'] = `Bearer ${currentToken}`;
}

export default new Vuex.Store({
  state: {
    token: currentToken || '',
    user: currentUser || {},
    toppings: [],

    Cart: {
      orderId: '',
      price: '',
      isDelivery: false,
      orderStatus: '',
      pizzas: []
    },

    specialtyPizza:{
      pizzaId: '',
      name: '',
      pizzaSize:'',
      crust: '',
      sauce: '',
      toppings: []
    }
  },
  mutations: {
    SET_AUTH_TOKEN(state, token) {
      state.token = token;
      localStorage.setItem('token', token);
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
    },
    SET_USER(state, user) {
      state.user = user;
      localStorage.setItem('user', JSON.stringify(user));
    },
    LOGOUT(state) {
      localStorage.removeItem('token');
      localStorage.removeItem('user');
      state.token = '';
      state.user = {};
      axios.defaults.headers.common = {};
    },
    ADD_TO_CART(state, pizza) {
      state.Cart.pizzas.push(pizza);
    },
    ADD_TOPPING(state,topping) {
      state.toppings.push(topping);
    },
    UPDATE_CART_TOTAL(state){
      let sum = 0;
    state.Cart.pizzas.forEach(pizza => {
      sum += pizza.price;
    });
    state.Cart.price = sum;
    },
  
    UPDATE_PIZZA_LIST(state, pizza){
       state.specialtyPizza.push(pizza)
    },
    SET_TOPPINGS_LIST(state, theToppings) {
      state.toppings = theToppings;
    }
  },
  actions: {
    setToppings({commit}) {
      ToppingsService.getAllToppings().then((response) => {
        commit('SET_TOPPINGS_LIST', response.data);
      })
    }
  },
})

