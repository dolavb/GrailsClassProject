<%--<ul class="nav pull-right">--%>
<li class="dropdown">

    <sec:ifNotLoggedIn>

        <a class="dropdown-toggle" data-toggle="dropdown" href="#">
            <!-- TODO: integrate Springsource Security etc. and show User's name ... -->
            <i class="glyphicon glyphicon-user"></i>
            <g:message code="security.signin.label"/><b class="caret"></b>
        </a>

        <ul class="dropdown-menu" role="menu">
            <g:link controller="login">
                <li class="button-container">

                    <button class="btn btn-block btn-success" role="button">
                        <i class="glyphicon glyphicon-signin"></i>
                        <g:message code='springSecurity.login.button' code='Login'/>
                    </button>

                </li>
            </g:link>
            <li class="divider"></li>
            <li class="button-container">
                <!-- NOTE: the renderDialog MUST be placed outside the NavBar (at least for Bootstrap 2.1.1): see bottom of main.gsp -->
                <g:render template="/_common/modals/registerTextLink"/>
            </li>
        </ul>

    </sec:ifNotLoggedIn>
    <sec:ifLoggedIn>

        <a class="dropdown-toggle" role="button" data-toggle="dropdown" data-target="#" href="#">
            <!-- TODO: Only show menu items based on permissions (e.g., Guest has no account page) -->
            <i class="glyphicon glyphicon-user icon-white"></i>


            <bb:fullusername/> <b class="caret"></b>
        </a>
        <ul class="dropdown-menu" role="menu">
            <!-- TODO: Only show menu items based on permissions -->
            <li class=""><a href="${createLink(uri: '/')}">
                <i class="glyphicon glyphicon-user"></i>
                <g:message code="user.show.label"/>
            </a></li>
            <li class=""><a href="${createLink(uri: '/')}">
                <i class="glyphicon glyphicon-cogs"></i>
                <g:message code="user.settings.change.label"/>
            </a></li>

            <li class="divider"></li>
            <li class=""><g:remoteLink controller="logout" action="index" onComplete="">
                <g:message code="security.signoff.label"/>
            </g:remoteLink>
            </li>
        </ul>
    </sec:ifLoggedIn>

</li>
<%--</ul>--%>

<noscript>
    <ul class="nav pull-right">
        <li class="">
            <g:link controller="user" action="show"><g:message code="default.user.unknown.label"/></g:link>
        </li>
    </ul>
</noscript>
