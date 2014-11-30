<%@ page import="com.blabha.bom.Material" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="kickstart"/>
    <g:set var="entityName" value="${message(code: 'material.label', default: 'Material')}"/>
    <title><g:message code="default.index.label" args="[entityName]"/></title>
</head>

<body>

<section id="index-material" class="first">

    <table class="table table-bordered margin-top-medium">
        <thead>
        <tr>

            <g:sortableColumn property="description"
                              title="${message(code: 'material.description.label', default: 'Description')}"/>

            <g:sortableColumn property="dateCreated"
                              title="${message(code: 'material.dateCreated.label', default: 'Date Created')}"/>

            <g:sortableColumn property="lastUpdated"
                              title="${message(code: 'material.lastUpdated.label', default: 'Last Updated')}"/>

            <g:sortableColumn property="number" title="${message(code: 'material.number.label', default: 'Number')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${materialInstanceList}" status="i" var="materialInstance">
            <tr class="${(i % 2) == 0 ? 'odd' : 'even'}">

                <td><g:link action="show"
                            id="${materialInstance.id}">${fieldValue(bean: materialInstance, field: "description")}</g:link></td>

                <td><g:formatDate date="${materialInstance.dateCreated}"/></td>

                <td><g:formatDate date="${materialInstance.lastUpdated}"/></td>

                <td>${fieldValue(bean: materialInstance, field: "number")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div>
        <bs:paginate total="${materialInstanceCount}"/>
    </div>
</section>

</body>

</html>
