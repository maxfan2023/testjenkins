// Define methods to populate data
def populateProvinces(country, locationMap){
    def provinces = locationMap[country]
    return provinces ? provinces.keySet().toList() : ["Not Applicable"]
}

def populateCities(country, province, locationMap){
    def cities = locationMap[country]?.get(province)
    return cities ? cities : ["Not Applicable"]
}

pipeline {
    agent any
    stages {
       stage('Build'){
        steps {
            script {
               // Read the YAML file
               def locationMap = readYaml file: 'locations.yml'
               // Extract the keys (countries) from the map
               def countries = locationMap.keySet().toList()
               // Print the countries
               println(countries)

               // Properties step to set the Active choice parameters via Declarative Scripting
               properties([
                   parameters([
//                        [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["ERROR"]'], script: [classpath: [], sandbox: false, script:  "return ${locationMap.keySet().toList()}"]]],
                       [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["ERROR"]'], script: [classpath: [], sandbox: false, script:  "return ${countries}"]]],
                       [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'PROVINCE', referencedParameters: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: "return ${populateProvinces(params.COUNTRY, locationMap)}"]]],
                       [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'CITY', referencedParameters: 'PROVINCE', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: "return ${populateCities(params.COUNTRY, params.PROVINCE, locationMap)}"]]]
                   ])
               ])
               echo 'Building..'
            }
          }
        }
    }
}