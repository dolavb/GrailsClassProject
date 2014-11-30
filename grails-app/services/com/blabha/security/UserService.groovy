package com.blabha.security

import grails.transaction.Transactional

/**
 * UserService
 * Business Logic for user creation
 */
@Transactional
class UserService {

    def createUser(params) {
        def user = new User(params)
        user.save()
    }
}
