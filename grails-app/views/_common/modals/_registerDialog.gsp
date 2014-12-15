<div class="modal fade" id="RegisterModal" role="dialog">
    <div class="modal-dialog">
        <div class="modal-content">
            <g:form controller="register" action="register" class="form-horizontal" method="post" name="register_form">
                <div class="modal-body">
                    <div class="modal-header">
                        <button type="button" class="close" data-dismiss="modal">x</button>

                        <h3><g:message code="security.register.title"/></h3>
                    </div>
                    <g:render template="/register/registerForm"/>
                    <div class="modal-footer">
                        <div class="form-group">
                            <input type='button' id="cancel" data-dismiss="modal" class="btn btn-info"
                                   value="${message(code: 'default.button.delete.cancel', default: 'Cancel')}"/>
                            <input type='submit' id="register" class="btn btn-success"
                                   value="${message(code: 'security.register.label', default: 'Register')}"/>
                        </div>
                    </div>
                </div>
            </g:form>
        </div>
    </div>
</div>
