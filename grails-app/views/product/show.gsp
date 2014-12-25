<%@ page import="com.blabha.bom.Product" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="kickstart"/>
    <g:set var="entityName" value="${message(code: 'product.label', default: 'Product')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<section id="show-product" class="first">

    <table class="table">
        <tbody>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="product.name.label"
                                                     default="Name"/></td>

            <td valign="top" class="value">${fieldValue(bean: productInstance, field: "name")}</td>

        </tr>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="product.description.label"
                                                     default="Description"/></td>

            <td valign="top" class="value">${fieldValue(bean: productInstance, field: "description")}</td>

        </tr>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="product.dateCreated.label"
                                                     default="Date Created"/></td>

            <td valign="top" class="value"><g:formatDate date="${productInstance?.dateCreated}"/></td>

        </tr>



        <tr class="prop">
            <td valign="top" class="name"><g:message code="product.lastUpdated.label"
                                                     default="Last Updated"/></td>

            <td valign="top" class="value"><g:formatDate date="${productInstance?.lastUpdated}"/></td>

        </tr>

        </tbody>
    </table>
</section>

</body>

</html>
