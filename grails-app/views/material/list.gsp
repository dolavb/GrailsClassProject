<%@ page import="com.blabha.bom.Material" %>
<!DOCTYPE html>
<html>

<head>
    <meta name="layout" content="kickstart"/>
    <g:set var="entityName" value="${message(code: 'material.label', default: 'Material')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>

<body>
<section id="list-material" class="first"

<div>
    <grid:grid name="material"/>
</div>
</section>

</body>

</html>
