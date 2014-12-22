package com.blabha

class ProductEditorTagLib {
    static defaultEncodeAs = [taglib: 'html']

    static final namespace = "bb"

    def productItem = { args ->
        def productItem = args.value
        out << '<li class="bs-callout">'
        out << "${productItem.material.name}"
        out << '</li>'
    }

}
