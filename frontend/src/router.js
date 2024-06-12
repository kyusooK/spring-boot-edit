
import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router);


import OrderOrderManager from "./components/listers/OrderOrderCards"
import OrderOrderDetail from "./components/listers/OrderOrderDetail"

import InventoryProductManager from "./components/listers/InventoryProductCards"
import InventoryProductDetail from "./components/listers/InventoryProductDetail"


export default new Router({
    // mode: 'history',
    base: process.env.BASE_URL,
    routes: [
            {
                path: '/orders/orders',
                name: 'OrderOrderManager',
                component: OrderOrderManager
            },
            {
                path: '/orders/orders/:id',
                name: 'OrderOrderDetail',
                component: OrderOrderDetail
            },

            {
                path: '/inventories/products',
                name: 'InventoryProductManager',
                component: InventoryProductManager
            },
            {
                path: '/inventories/products/:id',
                name: 'InventoryProductDetail',
                component: InventoryProductDetail
            },



    ]
})
