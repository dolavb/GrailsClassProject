<div class="panel panel-default">
    <h4><g:message code="producteditor.product.label" default="Product"/></h4>

    <div id="productEditPannel" class="panel-body">
        <div class="panel-title">${product.name}:  ${product.description}</div>
        <g:if test="${product}">
            <ul id="productList" class="list-group">
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

    var productList = document.getElementById('productList');

    var productSortable = new Sortable( productList, {
        group: {
            name: "productEditor",
            pull: false,
            put: true
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
            data: {'materialId': materialId, 'index': index, 'productId': ${product.id}},
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

    function updateItemList(){
    <g:remoteFunction controller="productEditor" action="loadProductItems" update="productList"
                      id="${product.id}" method="GET"/>
    }

</r:script>

<r:require module="product_editor"/>