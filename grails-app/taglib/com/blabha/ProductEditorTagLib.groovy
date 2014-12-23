package com.blabha

class ProductEditorTagLib {


    static final namespace = "bb"

    def productItem = { args ->
        def productItem = args.value

        out << """
                <li id="${productItem.id}" class="list-group-item">
                    ${productItem.material.number}.${productItem.itemNumber}
                </li>
                """

    }

}
