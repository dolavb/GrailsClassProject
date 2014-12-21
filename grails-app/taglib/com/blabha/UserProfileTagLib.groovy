package com.blabha

/**
 * UserProfileTagLib
 * A taglib library provides a set of reusable tags to help rendering the views.
 */
class UserProfileTagLib {

    static final namespace = "bb"

    static defaultEncodeAs = 'html'

    def springSecurityService

    def fullusername = { args ->
        def user =springSecurityService.currentUser
        def userProfile = user.userProfile
        out << "${userProfile.lastName}, ${userProfile.firstName}"
    }

}
