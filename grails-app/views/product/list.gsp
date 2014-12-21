
<%@ page import="com.blabha.bom.Product" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="kickstart"/>
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>

<section id="list-product" class="first">

    <table class="table table-bordered margin-top-medium">
        <thead>
        <tr>
            
            <g:sortableColumn property="name"
                              title="${message(code: 'product.name.label', default: 'Name')}"/>
            
            <g:sortableColumn property="description"
                              title="${message(code: 'product.description.label', default: 'Description')}"/>
            
            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'product.dateCreated.label', default: 'Date Created')}"/>
            
            <g:sortableColumn property="lastUpdated"
                              title="${message(code: 'product.lastUpdated.label', default: 'Last Updated')}"/>
            
        </tr>
        </thead>
        <tbody>
        <g:each in="${productInstanceList}" status="i" var="productInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">
                
                <td><g:link action="show" id="${productInstance.id}">${fieldValue(bean: productInstance, field: "name")}</g:link></td>
                
                <td>${fieldValue(bean: productInstance, field: "description")}</td>
                
                <td><g:formatDate date="${productInstance.dateCreated}"/></td>
                
                <td><g:formatDate date="${productInstance.lastUpdated}"/></td>
                
            </tr>
        </g:each>
        </tbody>
    </table>

    <div>
        <bs:paginate total="${productInstanceCount}"/>
    </div>
</section>

</body>

</html>
