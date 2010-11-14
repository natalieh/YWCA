

class Page {
	static belongsTo = [owner:User]
    static constraints = {
		title()
		description()
    }
	
	String title
	String description
}
