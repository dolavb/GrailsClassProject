<html>

<head>
    <meta name='layout' content='kickstart'/>
    <title><g:message code='spring.security.ui.register.title'/></title>
    <g:set var="layout_nomainmenu" value="${true}" scope="request"/>
    <g:set var="layout_nosecondarymenu" value="${true}" scope="request"/>
</head>

<body>

<p/>

<g:form action='register' name='registerForm'>

    <g:if test='${emailSent}'>
        <br/>
        <g:message code='spring.security.ui.register.sent'/>
    </g:if>
    <g:else>

        <br/>


        <g:render template="/register/registerForm"/>
        <div class="modal-footer">
            <div class="form-group">
                <input type="button" id="cancel" class="btn btn-info"
                       value="${message(code: 'default.button.delete.cancel', default: 'Cancel')}"/>
                <input href="#login" type='submit' id="register" class="btn btn-success"
                       value="${message(code: 'security.register.label', default: 'Register')}"/>
            </div>

        </div>

    </g:else>

</g:form>


<script>
    $(document).ready(function () {
        $('#username').focus();
    });
</script>

</body>
</html>
