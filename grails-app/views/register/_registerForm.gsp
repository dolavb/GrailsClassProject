<div class="${hasErrors(bean: registerCommandInstance, field: 'username', 'error')} required">
    <label for="username" class="control-label"><g:message
            code="registerCommand.username.label"
            default="Username"/><span class="required-indicator">*</span></label>

    <div>
        <g:textField class="form-control" name="username" required="" value="${registerCommandInstance?.username}"/>
        <span class="help-inline">${hasErrors(bean: registerCommandInstance, field: 'username', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: registerCommandInstance, field: 'email', 'error')} required">
    <label for="email" class="control-label"><g:message
            code="registerCommand.email.label"
            default="Email"/><span class="required-indicator">*</span></label>

    <div>
        <g:field class="form-control" type="email" name="email" required="" value="${registerCommandInstance?.email}"/>
        <span class="help-inline">${hasErrors(bean: registerCommandInstance, field: 'email', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: registerCommandInstance, field: 'password', 'error')} required">
    <label for="password" class="control-label"><g:message
            code="registerCommand.password.label"
            default="Password"/><span class="required-indicator">*</span></label>

    <div>
        <g:passwordField class="form-control" name="password" required="" value="${registerCommandInstance?.password}"/>
        <span class="help-inline">${hasErrors(bean: registerCommandInstance, field: 'password', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: registerCommandInstance, field: 'password2', 'error')} required">
    <label for="password2" class="control-label"><g:message
            code="registerCommand.password2.label"
            default="Confirm Password"/><span class="required-indicator">*</span></label>

    <div>
        <g:passwordField class="form-control" name="password2" required=""
                         value="${registerCommandInstance?.password}"/>
        <span class="help-inline">${hasErrors(bean: registerCommandInstance, field: 'password2', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: registerCommandInstance, field: 'firstName', 'error')} ">
    <label for="firstName" class="control-label"><g:message
            code="registerCommand.firstName.label"
            default="First Name"/></label>

    <div>
        <g:textField class="form-control" name="firstName" value="${registerCommandInstance?.firstName}"/>
        <span class="help-inline">${hasErrors(bean: registerCommandInstance, field: 'firstName', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: registerCommandInstance, field: 'lastName', 'error')} ">
    <label for="lastName" class="control-label"><g:message
            code="registerCommand.lastName.label"
            default="Last Name"/></label>

    <div>
        <g:textField class="form-control" name="lastName" value="${registerCommandInstance?.lastName}"/>
        <span class="help-inline">${hasErrors(bean: registerCommandInstance, field: 'lastName', 'error')}</span>
    </div>
</div>

