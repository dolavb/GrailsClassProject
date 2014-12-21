package com.blabha.bom

import grails.transaction.Transactional

/**
 * MaterialService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class MaterialService {

    def save(Material material) {
        material.save()
    }

    def delete(Material material) {
        material.delete()
    }
}
