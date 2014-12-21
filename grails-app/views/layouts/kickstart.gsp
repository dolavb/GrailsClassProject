<!DOCTYPE html>
<%-- <html lang="${org.springframework.web.servlet.support.RequestContextUtils.getLocale(request).toString().replace('_', '-')}"> --%>
<html lang="${session.'org.springframework.web.servlet.i18n.SessionLocaleResolver.LOCALE'}">

<head>
    <g:render template="/layouts/layoutHead"/>
</head>

<body>
<g:render template="/_menu/navbar"/>

<g:render template="/layouts/content"/>

<g:render template="/layouts/footer"/>

<g:render template="/layouts/layoutBottom"/>

</body>

</html>