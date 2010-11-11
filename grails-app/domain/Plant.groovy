class Plant {
Long id
Long version
String description
Boolean validated
String hardiness
Boolean evergreen
String annual
String genus
String genusHybrid
String species
String speciesHybrid
String variety
String subSpecies
String cultivar
String forma
def constraints = {
hardiness(inList:["Hardy", "Half Hardy", "Tender"])
annual(inList:["Annual", "Perennial", "Biennial"])
}
String toString() { "${this.class.name} : $id" }
boolean equals(other) {
if(other?.is(this))return true
if(!(other instanceof Plant)) return false
if(!id || !other?.id || id!=other?.id) return false
return true
}
int hashCode() {
int hashCode = 0
hashCode = 29 * (hashCode + ( !id ? 0 : id ^ (id >>> 32) ) )
}
}
