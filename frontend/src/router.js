
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import DeliveryDeliveryManager from "./components/listers/DeliveryDeliveryCards"
import DeliveryDeliveryDetail from "./components/listers/DeliveryDeliveryDetail"

import UserOrderManager from "./components/listers/UserOrderCards"
import UserOrderDetail from "./components/listers/UserOrderDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/deliveries/deliveries',
                name: 'DeliveryDeliveryManager',
                component: DeliveryDeliveryManager
            },
            {
                path: '/deliveries/deliveries/:id',
                name: 'DeliveryDeliveryDetail',
                component: DeliveryDeliveryDetail
            },

            {
                path: '/users/orders',
                name: 'UserOrderManager',
                component: UserOrderManager
            },
            {
                path: '/users/orders/:id',
                name: 'UserOrderDetail',
                component: UserOrderDetail
            },



    ]
})
