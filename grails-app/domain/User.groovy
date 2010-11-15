class User {
  static constraints = {
    login(unique:true)
    password(password:true)
    name()
  }
  
  static hasMany = [pages:Page]
  
  String login
  String password
  String name
  
  String toString(){"$name"}
}

