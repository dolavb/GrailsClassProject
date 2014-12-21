package com.blabha.bom

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


    @Override
    public String toString() {
        return "${number}";
    }
}

