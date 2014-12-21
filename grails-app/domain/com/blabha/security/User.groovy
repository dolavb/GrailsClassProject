package com.blabha.security

import com.blabha.profile.UserProfile

class User {

    transient springSecurityService


    String username
    String password
    String email

    UserProfile userProfile
    static hasOne = [userProfile: UserProfile]

    boolean enabled = true
    boolean accountExpired
    boolean accountLocked
    boolean passwordExpired

    static transients = ['springSecurityService']

    static constraints = {
        username blank: false, unique: true
        password blank: false
        email blank: false, unique: true
        userProfile nullable: true, blank: true
    }

    static mapping = {
        password column: '`password`'
    }


    Set<Role> getAuthorities() {
        UserRole.findAllByUser(this).collect { it.role }
    }

    def beforeInsert() {
        encodePassword()
    }

    def beforeUpdate() {
        if (isDirty('password')) {
            encodePassword()
        }
    }

    protected void encodePassword() {
        password = springSecurityService?.passwordEncoder ? springSecurityService.encodePassword(password) : password
    }
}
