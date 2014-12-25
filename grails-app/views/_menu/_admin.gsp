<sec:ifAnyGranted roles="ROLE_ADMIN">
    <li class="dropdown">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
        <i class="glyphicon glyphicon-wrench"></i>
        <g:message code="default.admin.label"/><b class="caret"></b>
    </a>
    <ul class="dropdown-menu">
        <li class="">
            <a tabindex="-1" href="#"><b>Security Admin</b></a>
        </li>

        <li class="">
            <g:link controller="user">
                <g:message code="admin.user.label"/>
            </g:link>
        </li>
        <li class="">
            <g:link controller="role">
                <g:message code="admin.role.label"/>
            </g:link>
        </li>
    </ul>
</li>
</sec:ifAnyGranted>