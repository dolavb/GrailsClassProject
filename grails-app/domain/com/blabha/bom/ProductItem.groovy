package com.blabha.bom
/**
 * Item
 * A domain class describes the data object and it's mapping to the database
 */
class ProductItem {

    /* Default (injected) attributes of GORM */
//	Long	id
//	Long	version

    /* Automatic timestamping of GORM */
//	Date	dateCreated
//	Date	lastUpdated


    Material material
    Integer itemNumber = 1

    Double quantity = 1.0d

    Product product
    static hasOne = [product: Product]
    static belongsTo = [product: Product]


    ProductItem(Product product, Material material) {
        this.product = product
        this.material = material
        List<ProductItem> items = product.items
        def filteredItems = items.findAll { it.material == material }
        if (filteredItems) {
            def maxItemNumber = filteredItems.max { it.itemNumber }.itemNumber
            this.itemNumber = ++maxItemNumber
        }
        this.product.items << this
    }

    static mapping = {
    }

    static constraints = {
        product nullable: false
        material nullable: false
    }

    int getItemIndex() {
        product.items.indexOf(this)
    }

    boolean equals(o) {
        if (this.is(o)) return true
        if (getClass() != o.class) return false

        ProductItem that = (ProductItem) o

        if (itemNumber != that.itemNumber) return false
        if (product != that.product) return false

        return true
    }

    int hashCode() {
        int result
        result = (itemNumber != null ? itemNumber.hashCode() : 0)
        result = 31 * result + (product != null ? product.hashCode() : 0)
        return result
    }

    public String toString() {
        "${material.number}"."${itemNumber}"
    }

}


