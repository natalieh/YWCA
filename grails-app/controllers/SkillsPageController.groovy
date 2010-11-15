class SkillsPageController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [skillsPageInstanceList: SkillsPage.list(params), skillsPageInstanceTotal: SkillsPage.count()]
    }

    def create = {
        def skillsPageInstance = new SkillsPage()
        skillsPageInstance.properties = params
        return [skillsPageInstance: skillsPageInstance]
    }

    def save = {
        def skillsPageInstance = new SkillsPage(params)
        if (skillsPageInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), skillsPageInstance.id])}"
            redirect(action: "show", id: skillsPageInstance.id)
        }
        else {
            render(view: "create", model: [skillsPageInstance: skillsPageInstance])
        }
    }

    def show = {
        def skillsPageInstance = SkillsPage.get(params.id)
        if (!skillsPageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), params.id])}"
            redirect(action: "list")
        }
        else {
            [skillsPageInstance: skillsPageInstance]
        }
    }

    def edit = {
        def skillsPageInstance = SkillsPage.get(params.id)
        if (!skillsPageInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [skillsPageInstance: skillsPageInstance]
        }
    }

    def update = {
        def skillsPageInstance = SkillsPage.get(params.id)
        if (skillsPageInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (skillsPageInstance.version > version) {
                    
                    skillsPageInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'skillsPage.label', default: 'SkillsPage')] as Object[], "Another user has updated this SkillsPage while you were editing")
                    render(view: "edit", model: [skillsPageInstance: skillsPageInstance])
                    return
                }
            }
            skillsPageInstance.properties = params
            if (!skillsPageInstance.hasErrors() && skillsPageInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), skillsPageInstance.id])}"
                redirect(action: "show", id: skillsPageInstance.id)
            }
            else {
                render(view: "edit", model: [skillsPageInstance: skillsPageInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def skillsPageInstance = SkillsPage.get(params.id)
        if (skillsPageInstance) {
            try {
                skillsPageInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'skillsPage.label', default: 'SkillsPage'), params.id])}"
            redirect(action: "list")
        }
    }
}
