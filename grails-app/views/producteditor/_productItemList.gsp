<g:each in="${product.items}" var="item">
    <li id="${item.id}" class="list-group-item">
        ${item.material.number}.${item.itemNumber}
        <sec:ifAnyGranted roles="ROLE_EDITOR">
            <g:remoteLink class="badge" controller="productEditor" update="productList"
                          method="POST" action="removeProductItemFromProduct" id="${item.id}">
                x
            </g:remoteLink>
        </sec:ifAnyGranted>
    </li>
</g:each>

