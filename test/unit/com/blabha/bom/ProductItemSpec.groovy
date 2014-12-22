package com.blabha.bom

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ProductItem)
class ProductItemSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "a productItem needs a product"() {
        given: 'a productItem without a product'
        def productItem = new ProductItem(material: Mock(Material))


        expect: 'the product Item is invalid'
        !productItem.validate()
    }

    void "a productItem needs a material"() {
        given: 'a productItem without a material'
        def productItem = new ProductItem(product: Mock(Product))


        expect: 'the product Item is invalid'
        !productItem.validate()
    }

    void "a productItem with a material and product is valid"() {
        given: 'a productItem without a material'
        def productItem = new ProductItem(product: Mock(Product), material: Mock(Material))


        expect: 'the product Item is valid'
        !productItem.hasErrors()
    }
}
