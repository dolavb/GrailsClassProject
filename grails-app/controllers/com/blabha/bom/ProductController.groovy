package com.blabha.bom

import org.grails.plugin.easygrid.Easygrid

import static org.springframework.http.HttpStatus.*

@Easygrid
class ProductController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    static defaultAction = "list"

    def productService

    def list() {}

    def productGrid = {
        gridImpl 'dataTables'
        domainClass Product

        columns {
            name {
                value {
                    def href = createLink(controller: 'productEditor', action: 'editor', id: it.id)
                    """<a href="${href}">${it.name}</a>"""
                }
            }
            description
            dateCreated
            lastUpdated
        }
    }

    def show(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }
        respond productInstance
    }

    def create() {
        respond new Product(params)
    }


    def save(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view: 'create'
            return
        }

        productService.save(productInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: CREATED] }
        }
    }

    def edit(Product productInstance) {
        redirect(controller: 'productEditor', action: 'editor', params: [product: productInstance])
    }


    def update(Product productInstance) {
        if (productInstance == null) {
            notFound()
            return
        }

        if (productInstance.hasErrors()) {
            respond productInstance.errors, view: 'edit'
            return
        }

        productService.save(productInstance)

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect productInstance
            }
            '*' { respond productInstance, [status: OK] }
        }
    }


    def delete(Product productInstance) {

        if (productInstance == null) {
            notFound()
            return
        }

        productInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Product.label', default: 'Product'), productInstance.id])
                redirect action: "list", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'product.label', default: 'Product'), params.id])
                redirect action: "list", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
