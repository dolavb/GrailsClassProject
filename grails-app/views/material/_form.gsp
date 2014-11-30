<%@ page import="com.blabha.bom.Material" %>



<div class="${hasErrors(bean: materialInstance, field: 'description', 'error')} ">
    <label for="description" class="control-label"><g:message code="material.description.label"
                                                              default="Description"/></label>

    <div>
        <g:textField class="form-control" name="description" value="${materialInstance?.description}"/>
        <span class="help-inline">${hasErrors(bean: materialInstance, field: 'description', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: materialInstance, field: 'number', 'error')} ">
    <label for="number" class="control-label"><g:message code="material.number.label" default="Number"/></label>

    <div>
        <g:textField class="form-control" name="number" value="${materialInstance?.number}"/>
        <span class="help-inline">${hasErrors(bean: materialInstance, field: 'number', 'error')}</span>
    </div>
</div>

