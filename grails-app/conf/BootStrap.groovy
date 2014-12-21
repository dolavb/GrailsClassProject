import com.blabha.profile.UserProfile
import com.blabha.security.User


class BootStrap {

    def springSecurityService


    def init = { servletContext ->
        environments {
            development {
                def sysAdmin = User.findByUsername("blabhaAdmin")
                if (!sysAdmin) {
                    def userProfile = new UserProfile(firstName: 'Dominique', lastName: 'Lavoie')

                    User user = new User(username: "blabhaAdmin", password: 'admin',
                            accountExpired: false, accountLocked: false, passwordExpired: false,
                            email: 'test@test.com', userProfile: userProfile)

                    if (!user.save()) {
                        log.error('Failed to save default user')
                    }
                }
            }
            production {

            }
        }

    }
    def destroy = {
    }
}
