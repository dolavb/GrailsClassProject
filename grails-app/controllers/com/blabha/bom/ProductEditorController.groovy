package com.blabha.bom

/**
 * ProductEditorController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ProductEditorController {

    static scaffold = false

    static defaultAction = 'editor'

    def productService

    def editor(Product product) {
        product
    }


}
