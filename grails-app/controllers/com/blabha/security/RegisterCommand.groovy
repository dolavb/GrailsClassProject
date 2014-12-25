package com.blabha.security

import grails.validation.Validateable

/**
 * RegisterCommand
 * A domain class describes the data object and it's mapping to the database
 */
@Validateable
class RegisterCommand extends grails.plugin.springsecurity.ui.RegisterCommand {

    String firstName
    String lastName

}