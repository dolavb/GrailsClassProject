package com.blabha.bom

/**
 * ProductEditorController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ProductEditorController {

    static scaffold = false

    def index(Product product) {
        product = new Product(name: "TEST")
        render view: 'index', model: [product: product]
    }


}
