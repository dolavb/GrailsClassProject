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
    <div class=""></div>

    <div>
        <grid:grid name="product">
            <grid:set col="name" width="80"/>
        </grid:grid>
    </div>
</section>

</body>

</html>
