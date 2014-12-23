<div class="panel panel-default]">
    <h4><g:message code="producteditor.material.selector.label" default="Materials"/></h4>

    <div class="panel-body">
        <ul id="materialList" class="list-group">
            <g:render template="/producteditor/materialList"/>
        </ul>
    </div>
</div>
<r:script>
    jQuery(function(){
        <g:remoteFunction controller="productEditor" action="materialList" update="materialList" method="GET"/>
    });
    var materialList = document.getElementById('materialList');
    var materialSortable = new Sortable (materialList, {
        group: {
            name: "productEditor",
            pull: "clone",
            put: false
        },
        sort: false
    });

</r:script>

<r:require module="product_editor"/>