<g:each in="${materialList}" var="material">
    <li id="${material.id}" class="list-group-item">
        <g:link controller="material" action="show" id="${material.id}">
            ${material.number}
        </g:link>
    </li>
</g:each>