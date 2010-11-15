import grails.util.GrailsUtil

class BootStrap {

  def init = { servletContext ->
    switch(GrailsUtil.environment){
      case "development":
        def jdoe = new User(login:"jdoe", password:"password", name:"John L Doe")
        jdoe.save() 
        def jsmith = new User(login:"jsmith", password:"wordpass", name:"Jane R Smith")
        jsmith.save()              
      break
      case "production":
      break
    }

  }
  def destroy = {
  }
}