package com.blabha

import com.blabha.bom.Material
import com.blabha.bom.Product
import spock.lang.Specification

/**
 *
 */
class ProductEditionSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    def productService

    def materialService

    void "test that a product item can be created in a product and removed from a product"() {
        given: 'an existing product and amaterial'
        def productName = 'NAME'
        def material = new Material(number: "NUMBER")
        material = materialService.save(material)

        def product = new Product(name: productName)
        productService.save(product)

        when: 'a product item is created'
        def productItem = productService.createItem(product, material)

        product = Product.findByName(productName)

        then: 'the item is saved and added to the product'
        productItem.id != 0
        product.items.contains(productItem)
        productItem.product != null

        and: 'the saved productItem'

        when: 'it is deleted'
        productService.deleteProductItem(productItem)

        product = Product.findByName(productName)

        then: 'it is also removed from the product'
        !product.hasErrors()
        !product.items.contains(productItem)

    }

    void "test that the order of product is maitained"() {
        given: 'an existing product, material and 3 productItems'
        def productName = 'ORDERED_PRODCUT'
        def material = new Material(number: "NUMBER")
        material = materialService.save(material)

        def product = new Product(name: productName)
        productService.save(product)

        when: 'productItems are saved'
        def productItem1 = productService.createItem(product, material)
        def productItem2 = productService.createItem(product, material)
        def productItem3 = productService.createItem(product, material)

        product = Product.findByName(productName)

        then: 'there order is maintained'
        !product.hasErrors()
        productItem1.itemIndex == 0
        productItem2.itemIndex == 1
        productItem3.itemIndex == 2

        and:

        when: 'deleting a product item'
        productService.deleteProductItem(productItem2)

        then: 'the order is adjusted'
        productItem1.itemIndex == 0
        productItem3.itemIndex == 1

    }

    void "test that a product item can be reodored at a specific index"() {
        given: 'a product with several product item'
        def productName = 'ORDERING'
        def material = new Material(number: "NUMBER")
        material = materialService.save(material)

        def product = new Product(name: productName)
        productService.save(product)

        def productItem1 = productService.createItem(product, material)
        def productItem2 = productService.createItem(product, material)
        def productItem3 = productService.createItem(product, material)

        when: 'a product item is reodered'
        productItem1 = productService.changeProductItemPosition(productItem1, 2)

        product = Product.findByName(productName)



        then: 'the order of product items is adapted'
        !product.hasErrors()
        productItem2.itemIndex == 0
        productItem3.itemIndex == 1
        productItem1.itemIndex == 2
    }

    def "test that the product item number increments"() {
        given: 'a product and a material'
        def productName = 'INCREMENT'
        def material = new Material(number: "NUMBER")
        material = materialService.save(material)

        def product = new Product(name: productName)
        productService.save(product)

        when: '2 product items are created with the same materiel'
        def productItem1 = productService.createItem(product, material)
        def productItem2 = productService.createItem(product, material)

        then: 'then the first one as item number 1'
        productItem1.itemNumber == 1
        and: 'the second one as item number 2'
        productItem2.itemNumber == 2

    }


}
