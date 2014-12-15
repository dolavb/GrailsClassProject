package com.blabha.bom

/**
 * Product
 * A domain class describes the data object and it's mapping to the database
 */
class Product {

    /* Default (injected) attributes of GORM */
    Long id
    Long version

    /* Automatic timestamping of GORM */
    Date dateCreated
    Date lastUpdated

    String name
    String description

    List<Item> itmes


    static hasMany = [items: Item]

    static mapping = {
    }

    static constraints = {
        name unique: true
        description nullable: true, blank: true

    }

    /*
     * Methods of the Domain Class
     */

    @Override
    // Override toString for a nicer / more descriptive UI
    public String toString() {
        return "${name}";
    }
}
