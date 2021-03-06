modules = {
    'application' {
        resource url: 'js/application.js'
    }

    /* Bootstrap definitions without less (if resource processing is switched off) */
    'bootstrap' {
        resource url: [dir: 'bootstrap/dist/js', file: 'bootstrap.js']
        resource url: [dir: 'bootstrap/dist/css', file: 'bootstrap.css']
    }
    log.info "| Using CSS files instead of generating from LESS files! (resource processing was switched off)"

    'datatable_bootstrap' {
        resource url: 'js/bootstrap.datatable.js'
        resource url: 'css/bootstrap.datatables.css'
    }

    /* Utility resources (must be loaded after bootstrap skin resources) */
    'bootstrap_utils' {
        dependsOn 'bootstrap'
        resource url: [dir: 'datepicker/js', file: 'bootstrap-datepicker.js']
        resource url: [dir: 'datepicker/css', file: 'datepicker.css']
        resource url: [dir: 'kickstart/js', file: 'kickstart.js']
        resource url: [dir: 'kickstart/js', file: 'checkboxes.js']
        resource url: [dir: 'kickstart/css', file: 'docs.css']
        resource url: [dir: 'kickstart/css', file: 'kickstart.css']
    }

    'product_editor' {
        resource url: 'js/sortable.js'
    }

//	if (!(grails.resources?.processing?.enabled != [:] && grails.resources.processing.enabled.booleanValue() == false) ) {
//    /* Bootstrap definitions with less */
//    'bootstrap_less' {
//        resource url: [dir: 'bootstrap/js/tests/vendor', file: 'jquery.js']
//        resource url: [dir: 'bootstrap/dist/js', file: 'bootstrap.js']
//        resource url: [dir: 'bootstrap/less', file: 'bootstrap.less']
//        resource url: [dir: 'kickstart/css', file: 'dummy.css']
//        // empty css: see https://github.com/paulfairless/grails-lesscss-resources/issues/25
//    }
//    log.info "| Using LESS files to generate CSS files!"
//
//    /* Utility resources (must be loaded after bootstrap skin resources) */
//    'bootstrap_less_utils' {
//        dependsOn 'bootstrap_less'
//        resource url: [dir: 'datepicker/js', file: 'bootstrap-datepicker.js']
//        resource url: [dir: 'datepicker/css', file: 'datepicker.css']
//        resource url: [dir: 'kickstart/js', file: 'kickstart.js']
//        resource url: [dir: 'kickstart/js', file: 'checkboxes.js']
//        resource url: [dir: 'kickstart/css', file: 'docs.css']
//        resource url: [dir: 'kickstart/css', file: 'kickstart.css']
//    }
//	}
}