package com.blabha.security

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {

    def userProfileService


    def register(RegisterCommand registerCommandInstance) {
        def response = super.register(registerCommandInstance)

        def emailSent = response?.model?.emailSent;

        if (emailSent) {
            userProfileService.createProfileForUser(registerCommand.firstName, registerCommand.lastName)
            flash.message = g.message(code: 'register.security.ui.mail.message', default: 'A mail was sent to your address')
            render 'index'
        } else {
            response
        }
    }
}


