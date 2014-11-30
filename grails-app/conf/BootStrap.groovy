import com.blabha.security.User


class BootStrap {

    def springSecurityService


    def init = { servletContext ->
        environments {
            development {
                def sysAdmin = User.findByUsername("blabhaAdmin")
                if (!sysAdmin) {


                }
            }
            production {

            }
        }

    }
    def destroy = {
    }
}
