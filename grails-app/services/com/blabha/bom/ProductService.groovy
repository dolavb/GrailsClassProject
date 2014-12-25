package com.blabha.bom

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

/**
 * ProductService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class ProductService {

    @Secured(['ROLE_EDITOR'])
    def save(Product product) {
        product.save()
    }

    @Secured(['ROLE_EDITOR'])
    def delete(Product product) {
        product.delete()
    }

    @Secured(['ROLE_EDITOR'])
    def createItem(Product product, Material material) {
        def productItem = new ProductItem(product, material)
        productItem.save()
        productItem
    }

    @Secured(['ROLE_EDITOR'])
    def createItem(Product product, Material material, int index) {
        def productItem = createItem(product, material)
        changeProductItemPosition(productItem, index)
    }

    @Secured(['ROLE_EDITOR'])
    def deleteProductItem(ProductItem productItem) {
        productItem.product.items.remove(productItem)
        productItem.delete()
    }

    @Secured(['ROLE_EDITOR'])
    def changeProductItemPosition(ProductItem productItem, int index) {
        def product = productItem.product
        List<ProductItem> items = product?.items

        if (!items)
            throw new IllegalStateException('WRONG state of Product') //This sould never happen with the actual logig

        //Making it safe for index out of bound
        if (index >= items.size()) {//It the value is bigger then the list, it will be set at the end
            index = items.size() - 1
        }
        def previousIndex = productItem.itemIndex
        if (previousIndex >= index) {
            index = index - 1
        }
        if (index < 0) {//If the value is negative, will be set at the begining
            index = 0
        }
        items.remove(previousIndex)
        items.add(index, productItem)

        product.save()
        productItem.save()
    }


}
