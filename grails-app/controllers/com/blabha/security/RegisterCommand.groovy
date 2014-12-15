package com.blabha.security

/**
 * RegisterCommand
 * A domain class describes the data object and it's mapping to the database
 */
class RegisterCommand extends grails.plugin.springsecurity.ui.RegisterCommand {

    String firstName
    String lastName

}