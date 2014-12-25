package com.blabha.bom

import grails.plugin.springsecurity.annotation.Secured
import grails.transaction.Transactional

/**
 * MaterialService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class MaterialService {

    @Secured(['ROLE_EDITOR'])
    def save(Material material) {
        material.save()
    }

    @Secured(['ROLE_EDITOR'])
    def delete(Material material) {
        material.delete()
    }
}
