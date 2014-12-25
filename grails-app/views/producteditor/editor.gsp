<html>

<head>
    <title><g:message code="default.welcome.title" args="[meta(name: 'app.name')]"/></title>
    <meta name="layout" content="kickstart"/>
    <g:set var="layout_nosecondarymenu" value="${true}" scope="request"/>
</head>

<body>
<ul id="Menu" class="nav nav-pills margin-top-small">
    <li>
        <g:link controller="product" action="show" id="${product.id}"><i
                class="glyphicon glyphicon-info-sign"></i> <g:message code="producteditor.produt.detail"/></g:link>
    </li>
    <li>
        <g:link controller="product" action="list"><i class="glyphicon glyphicon-th-list"></i> <g:message
                code="default.list.label"
                args="['Product']"/></g:link>
    </li>
</ul>
<section id="editor">
    <div class="row">
        <div class="col-md-6">
            <g:render template="/producteditor/productViewer"/>
        </div>

        <div class="col-md-4">
            <g:render template="/producteditor/materialSelector"/>
        </div>
    </div>
</section>

</body>

</html>
