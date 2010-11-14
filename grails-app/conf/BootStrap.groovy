import grails.util.GrailsUtil

class BootStrap {

  def init = { servletContext ->
    switch(GrailsUtil.environment){
      case "development":
        def jdoe = new User(login:"jdoe", password:"password", name:"John Doe")
        jdoe.save() 
        def jsmith = new User(login:"jsmith", password:"wordpass", name:"Jane Smith")
        jsmith.save()              
      break

      case "production":
      break
    }

  }
  def destroy = {
  }
}