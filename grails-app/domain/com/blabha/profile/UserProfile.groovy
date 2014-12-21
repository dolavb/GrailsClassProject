package com.blabha.profile

import com.blabha.security.User

/**
 * Created by dom on 14-12-02.
 */
class UserProfile {

    String firstName
    String lastName

    User user

    static belongsTo = [user: User]


    static constraints = {
        firstName blank: false
        lastName blank: false
    }

}
