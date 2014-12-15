package com.blabha.bom

/**
 * Material
 * A domain class describes the data object and it's mapping to the database
 */
class Material {


    Date dateCreated
    Date lastUpdated


    String number
    String description

    static mapping = {
    }

    static constraints = {
        description nullable: true, blank: true
    }
    /*
     * Methods of the Domain Class
     */

    @Override
    // Override toString for a nicer / more descriptive UI
    public String toString() {
        return "${number}";
    }
}
