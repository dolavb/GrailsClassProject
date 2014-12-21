package com.blabha.bom

import org.grails.plugin.easygrid.Easygrid

import static org.springframework.http.HttpStatus.*

/**
 * MaterialController
 * A controller class handles incoming web requests and performs actions such as redirects, rendering views and so on.
 */

@Easygrid
class MaterialController {

    static defaultAction = "list"

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def materialService

    def list(Integer max) {
        params.max = Math.min(max ?: 10, 100)

        [materialInstanceCount: Material.count(), materialInstanceList: Material.list(params)]
    }


    def materialGrid = {
        gridImpl 'dataTables'
        domainClass Material

        columns {
            number
            description
        }

    }


    def show(Material materialInstance) {
        respond materialInstance
    }

    def create() {
        respond new Material(params)
    }

    def save(Material materialInstance) {
        if (materialInstance == null) {
            notFound()
            return
        }

        if (materialInstance.hasErrors()) {
            respond materialInstance.errors, view: 'create'
            return
        }

        materialService.save(materialInstance)

        request.withFormat {
            form {
                flash.message = message(code: 'default.created.message', args: [message(code: 'materialInstance.label', default: 'Material'), materialInstance.id])
                redirect materialInstance
            }
            '*' { respond materialInstance, [status: CREATED] }
        }
    }

    def edit(Material materialInstance) {
        respond materialInstance
    }


    def update(Material materialInstance) {
        if (materialInstance == null) {
            notFound()
            return
        }

        if (materialInstance.hasErrors()) {
            respond materialInstance.errors, view: 'edit'
            return
        }

        materialService.save(materialInstance)

        request.withFormat {
            form {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Material.label', default: 'Material'), materialInstance.id])
                redirect materialInstance
            }
            '*' { respond materialInstance, [status: OK] }
        }
    }


    def delete(Material materialInstance) {

        if (materialInstance == null) {
            notFound()
            return
        }

        materialInstance.delete flush: true

        request.withFormat {
            form {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Material.label', default: 'Material'), materialInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'materialInstance.label', default: 'Material'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }
}
