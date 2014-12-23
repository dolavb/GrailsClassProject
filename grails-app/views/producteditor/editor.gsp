<html>

<head>
    <title><g:message code="default.welcome.title" args="[meta(name: 'app.name')]"/></title>
    <meta name="layout" content="kickstart"/>
    <g:set var="layout_nosecondarymenu" value="${true}" scope="request"/>
</head>

<body>

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
