<div class="panel panel-default">
    <h4><g:message code="producteditor.product.label" default="Product"/></h4>

    <div id="productEditPannel" class="panel-body">

        <g:if test="${product}">
            <div class="panel-title">

                <div>${product.name}:  ${product.description}</div>

            </div>

            <ul id="productList" class="list-group">
                <li class="list-group-item">
                    <g:message code="producteditor.product.emptyproduct" default="Empty Product"/>
                </li>
                <g:render template="/producteditor/productItemList"/>
            </ul>
        </g:if>
        <g:else>
            <div class="panel panel-info"><g:message code="producteditor.product.noproduct.mesaage"
                                                     default="No data"/></div>
        </g:else>
    </div>
</div>
<r:script>
    jQuery(function(){
        updateItemList();
    });

    function updateItemList(){
    <g:remoteFunction controller="productEditor" action="loadProductItems" update="productList"
                      id="${product?.id}" method="GET"/>
    }

    <sec:ifAnyGranted roles="ROLE_EDITOR">
        var productList = document.getElementById('productList');

        var productSortable = new Sortable( productList, {
            group: {
                name: "productEditor",
                pull: false,
                put: true,
                scroll: true
            },

            onAdd: function (evt) {
                var itemEl = evt.item;  // dragged HTMLElement
                addItemToProduct(itemEl.id, evt.newIndex);
            },

            onUpdate: function(evt){
                var itemEl = evt.item;
                reoderItem(itemEl.id, evt.newIndex);
            }


        });

        function addItemToProduct(materialId, index){
            jQuery.ajax({
                type: 'POST',
                url: "${createLink(action: 'addItemToProduct', controller: 'productEditor')}",
            data: {'materialId': materialId, 'index': index, 'productId': ${product?.id}},
            success: function(data,textStatus){
                $('#productList').html(data);
            }
        });
    }

    function reoderItem(itemID, newIndex){
        jQuery.ajax({
            type: 'POST',
            url: "${createLink(action: 'updateProductItemOrder', controller: 'productEditor')}",
            data: {'Id': itemID, 'index': newIndex},
            success: function(data,textStatus){
                $('#productList').html(data);
            }
        });
    }
    </sec:ifAnyGranted>
</r:script>

<r:require module="product_editor"/>