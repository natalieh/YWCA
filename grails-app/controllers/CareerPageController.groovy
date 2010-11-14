class CareerPageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [careerPageInstanceList: CareerPage.list(params), careerPageInstanceTotal: CareerPage.count()]
    }

    def create = {
        def careerPageInstance = new CareerPage()
        careerPageInstance.properties = params
        return [careerPageInstance: careerPageInstance]
    }

    def save = {
        def careerPageInstance = new CareerPage(params)
        if (careerPageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), careerPageInstance.id])}"
            redirect(action: "show", id: careerPageInstance.id)
        }
        else {
            render(view: "create", model: [careerPageInstance: careerPageInstance])
        }
    }

    def show = {
        def careerPageInstance = CareerPage.get(params.id)
        if (!careerPageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [careerPageInstance: careerPageInstance]
        }
    }

    def edit = {
        def careerPageInstance = CareerPage.get(params.id)
        if (!careerPageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [careerPageInstance: careerPageInstance]
        }
    }

    def update = {
        def careerPageInstance = CareerPage.get(params.id)
        if (careerPageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (careerPageInstance.version > version) {
                    
                    careerPageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'careerPage.label', default: 'CareerPage')] as Object[], "Another user has updated this CareerPage while you were editing")
                    render(view: "edit", model: [careerPageInstance: careerPageInstance])
                    return
                }
            }
            careerPageInstance.properties = params
            if (!careerPageInstance.hasErrors() && careerPageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), careerPageInstance.id])}"
                redirect(action: "show", id: careerPageInstance.id)
            }
            else {
                render(view: "edit", model: [careerPageInstance: careerPageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def careerPageInstance = CareerPage.get(params.id)
        if (careerPageInstance) {
            try {
                careerPageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'careerPage.label', default: 'CareerPage'), params.id])}"
            redirect(action: "list")
        }
    }
}
