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

    Product product

    Material material
    Double quantity


    static belongsTo = [product: Product]

    static mapping = {
    }

    static constraints = {

    }


    @Override
    public String toString() {
        return "${product.name}.${material.number}";
    }
}
