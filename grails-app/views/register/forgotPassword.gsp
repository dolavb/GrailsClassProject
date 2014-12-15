<html>

<head>
    <title><g:message code='spring.security.ui.forgotPassword.title'/></title>
    <meta name='layout' content='kickstart'/>
    <g:set var="layout_nomainmenu" value="${true}" scope="request"/>
    <g:set var="layout_nosecondarymenu" value="${true}" scope="request"/>
</head>

<body>

<g:if test='${emailSent}'>
    <br/>
    <g:message code='spring.security.ui.forgotPassword.sent'/>
</g:if>

<g:else>
    <section id="forgotPassword" class="first">
        <div class="row">
            <h4><g:message code='spring.security.ui.forgotPassword.description'/></h4>

            <div class="col-md-6">
                <g:form controller="register" action="forgotPassword" autocomplete="off" name="forgotPasswordForm">
                    <div class="form-group">
                        <label for="username"><g:message code='spring.security.ui.forgotPassword.username'/></label>

                        <div class="controls">
                            <g:textField name="username" size="25"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <g:submitButton
                                name='${message(code: 'spring.security.ui.forgotPassword.submit', default: 'Submit')}'
                                class='btn btn-success' form='forgotPasswordForm'/>
                    </div>
                </g:form>
            </div>
        </div>
    </section>
</g:else>

<script>
    $(document).ready(function () {
        $('#username').focus();
    });
</script>

</body>
</html>
