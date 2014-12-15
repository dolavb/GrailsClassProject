package com.blabha.profile
/**
 * Created by dom on 14-12-02.
 */
class UserProfile {

    String firstName
    String lastName


    static constraints = {
        firstName blank: false
        lastName blank: false
    }

}
