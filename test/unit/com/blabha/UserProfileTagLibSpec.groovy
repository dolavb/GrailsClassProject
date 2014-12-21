package com.blabha

import com.blabha.profile.UserProfile
import com.blabha.security.User
import grails.plugin.springsecurity.SpringSecurityService
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.GroovyPageUnitTestMixin} for usage instructions
 */
@TestFor(UserProfileTagLib)
class UserProfileTagLibSpec extends Specification {

    def setup() {
        tagLib.springSecurityService = Mock(SpringSecurityService) {
             1 * getCurrentUser() >> {new User(userProfile: new UserProfile(firstName: "FN", lastName: "LN"))}
        }
    }

    def cleanup() {
    }

    void "that the user full name is returned"() {
        when: 'the tag method is called'

        def resultString = tagLib.fullusername()

        then: 'The full name of the user is returned'

        resultString == "LN, FN"
    }

    void "that the tag is rendered"() {
        when: 'the tag is used'

        def result = applyTemplate('<bb:fullusername />')

        then: 'the full name of the user get rendered'

        result == "LN, FN"
    }
}
