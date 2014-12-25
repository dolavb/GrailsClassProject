package com.blabha.bom

/**
 * ProductEditorController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */
class ProductEditorController {

    static scaffold = false

    static defaultAction = 'editor'

    static allowedMethods = [addItemToProduct: 'POST', updateProductItemOreder: 'POST', removeProductItemFromProduct: 'POST']

    def productService

    def editor(Product product) {
        if (!product) {
            def productList = Product.createCriteria().list {
                property('id')
                max('lastUpdated')
            }
            if (productList.size() > 0)
                product = productList.get(0)
        }
        model:
        [product: product]
    }

    def materialList() {
        def materials = Material.list()

        render(template: 'materialList', model: [materialList: materials])
    }

    def loadProductItems() {
        def product = Product.get(params.id)
        renderProductList(product)
    }

    def addItemToProduct() {
        def product = Product.get(params.productId)
        def material = Material.get(params.materialId)
        def index = Integer.parseInt(params.index)

        def productItem = productService.createItem(product, material, index)

        renderProductList(productItem.product)
    }

    def updateProductItemOrder() {
        def productItem = ProductItem.get(params.Id)
        def index = Integer.parseInt(params.index)

        productItem = productService.changeProductItemPosition(productItem, index)
        renderProductList(productItem.product)
    }

    def removeProductItemFromProduct() {
        def id = Integer.parseInt(params.id)
        def productItem = ProductItem.get(id)
        def product = productItem.product
        productService.deleteProductItem(productItem)
        product = Product.load(product.id)
        renderProductList(product)
    }

    def renderProductList(Product product) {
        if (product.items)
            render(template: 'productItemList', model: [product: product])
        else
            render(template: 'emptyProduct', model: [product: product])
    }


}
