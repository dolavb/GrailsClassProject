package com.blabha.profile

import com.blabha.security.User
import grails.transaction.Transactional

/**
 * UserProfileService
 * A service class encapsulates the core business logic of a Grails application
 */
@Transactional
class UserProfileService {

    def createProfileForUser(String firstName, String lastName, String userName) {
        def user = User.findByUsername(userName)
        if (!user) {
            throw new IllegalArgumentException("Cannot create UserProfile for unexisting user ${username}")
        }
        def userProfile = new UserProfile(firstName: firstName, lastName: lastName, user: user)
        userProfile.save()
    }
}
