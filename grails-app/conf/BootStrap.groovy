import com.blabha.profile.UserProfile
import com.blabha.security.Role
import com.blabha.security.User
import com.blabha.security.UserRole


class BootStrap {

    def springSecurityService


    def init = { servletContext ->
        def authorities = ['ROLE_ADMIN', 'ROLE_VIEWER', 'ROLE_EDITOR']
        for (def roleName : authorities) {
            def role = Role.findByAuthority(roleName)
            if (!role) {
                role = new Role(authority: roleName)
                role.save(flush: true)
            }
        }
        environments {
            development {
                def sysAdmin = createDemoUser("Admin")
                UserRole.create(sysAdmin, Role.findByAuthority('ROLE_ADMIN'), true)
                UserRole.create(sysAdmin, Role.findByAuthority('ROLE_EDITOR'), true)


                def editor = createDemoUser("Editor")
                UserRole.create(editor, Role.findByAuthority('ROLE_EDITOR'), true)

                def viewer = createDemoUser("Viewer")
                UserRole.create(viewer, Role.findByAuthority('ROLE_VIEWER'), true)
            }
            production {
                def sysAdmin = User.findByUsername("blabhaAdmin")
                if (!sysAdmin) {
                    def userProfile = new UserProfile(firstName: 'ADMIN', lastName: 'BLABHA')

                    User user = new User(username: "blabhaAdmin", password: 'admin',
                            accountExpired: false, accountLocked: false, passwordExpired: true,
                            email: 'test@test.com', userProfile: userProfile)

                    if (!user.save()) {
                        log.error('Failed to save default user')
                    }
                }
                sysAdmin.authorities(Role.findAll())
            }
        }

    }
    def destroy = {
    }

    def createDemoUser(def userName) {
        User user = User.findByUsername("blabha${userName}")
        if (!user) {
            def userProfile = new UserProfile(firstName: userName, lastName: 'BLABHA')

            user = new User(username: "blabha${userName}", password: userName,
                    accountExpired: false, accountLocked: false, passwordExpired: false,
                    email: "${userName}@test.com", userProfile: userProfile)
            if (!user.save()) {
                log.error("Could not create demo user ${userName}")
            }
        }
        user
    }
}
