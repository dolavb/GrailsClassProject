package com.blabha.security

class RegisterController extends grails.plugin.springsecurity.ui.RegisterController {

    def userProfileService


    def register(RegisterCommand registerCommandInstance) {
        def response = super.register(registerCommandInstance)

        def emailSent = response?.model?.emailSent;

        if (emailSent) {
            userProfileService.createProfileForUser(registerCommand.firstName, registerCommand.lastName)
            flash.message = "Check your email to activate your account"
            render 'index'
        } else {
            response
        }
    }
}


