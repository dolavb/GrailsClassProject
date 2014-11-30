<%@ page import="com.blabha.bom.Material" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="kickstart"/>
    <g:set var="entityName" value="${message(code: 'material.label', default: 'Material')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>

<section id="show-material" class="first">

    <table class="table">
        <tbody>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="material.description.label" default="Description"/></td>

            <td valign="top" class="value">${fieldValue(bean: materialInstance, field: "description")}</td>

        </tr>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="material.dateCreated.label" default="Date Created"/></td>

            <td valign="top" class="value"><g:formatDate date="${materialInstance?.dateCreated}"/></td>

        </tr>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="material.lastUpdated.label" default="Last Updated"/></td>

            <td valign="top" class="value"><g:formatDate date="${materialInstance?.lastUpdated}"/></td>

        </tr>

        <tr class="prop">
            <td valign="top" class="name"><g:message code="material.number.label" default="Number"/></td>

            <td valign="top" class="value">${fieldValue(bean: materialInstance, field: "number")}</td>

        </tr>

        </tbody>
    </table>
</section>

</body>

</html>
