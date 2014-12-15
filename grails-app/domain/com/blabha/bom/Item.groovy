package com.blabha.bom

/**
 * Item
 * A domain class describes the data object and it's mapping to the database
 */
class Item {

    /* Default (injected) attributes of GORM */
//	Long	id
//	Long	version

    /* Automatic timestamping of GORM */
//	Date	dateCreated
//	Date	lastUpdated

    Product product

    Material material
    Double quantity

    static hasOne = [material: Material]

    static belongsTo = [product: Product]

//	static	belongsTo	= []	// tells GORM to cascade commands: e.g., delete this object if the "parent" is deleted.
//	static	hasOne		= []	// tells GORM to associate another domain object as an owner in a 1-1 mapping
//	static	hasMany		= []	// tells GORM to associate other domain objects for a 1-n or n-m mapping
//	static	mappedBy	= []	// specifies which property should be used in a mapping 

    static mapping = {
    }

    static constraints = {
    }


    @Override
    public String toString() {
        return "${product.name}.${material.number}";
    }
}
