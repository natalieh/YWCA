class ApplicationBootStrap {
	def init = {servletContext -> new User(email:"eg@eg.com", password:"password").save()}
	def destroy = {
		
	}
}
