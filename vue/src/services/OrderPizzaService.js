import axios from 'axios';

export default {
    addPizza(pizza) {
        return axios.post('/pizza',pizza);
    },
    
    getAllOrders() {
        return axios.get('/orders/');
    },
    getOrderById(orderId) {
        return axios.get(`/orders/${orderId}`);
    },

    addOrder(order) {
        return axios.post('/orders',order);
    },
    updateOrderStatus(id,orderDto) {
        return axios.put(`/orders/${id}`,orderDto);
    }
}