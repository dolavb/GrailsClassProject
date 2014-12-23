<g:each in="${product.items}" var="item">
    <li id="${item.id}" class="list-group-item">
        ${item.material.number}.${item.itemNumber}
        <g:remoteLink class="badge" controller="productEditor" update="productList"
                      method="POST" action="removeProductItemFromProduct" id="${item.id}">
            x
        </g:remoteLink>
    </li>
</g:each>

