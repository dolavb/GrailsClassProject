<%@ page import="com.blabha.bom.Product" %>



<div class="${hasErrors(bean: productInstance, field: 'name', 'error')} ">
    <label for="name" class="control-label"><g:message
            code="product.name.label"
            default="Name"/></label>

    <div>
        <g:textField class="form-control" name="name" value="${productInstance?.name}"/>
        <span class="help-inline">${hasErrors(bean: productInstance, field: 'name', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: productInstance, field: 'description', 'error')} ">
    <label for="description" class="control-label"><g:message
            code="product.description.label"
            default="Description"/></label>

    <div>
        <g:textField class="form-control" name="description" value="${productInstance?.description}"/>
        <span class="help-inline">${hasErrors(bean: productInstance, field: 'description', 'error')}</span>
    </div>
</div>

<div class="${hasErrors(bean: productInstance, field: 'items', 'error')} ">
    <label for="items" class="control-label"><g:message
            code="product.items.label"
            default="Items"/></label>

</div>

