class PlantController {
def beforeInterceptor = [action:this.&checkUser,except:
['index','list','show']]
def scaffold = true
def checkUser() {
if(!session.user) {
// i.e. user not logged in
redirect(controller:'user',action:'login')
return false
}
}
}
