package com.blabha.bom

import grails.transaction.Transactional

/**
 * ProductService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class ProductService {

    def save(Product product) {
        product.save()
    }

    def delete(Product product) {
        product.delete()
    }
}
