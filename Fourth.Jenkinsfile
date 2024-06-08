pipeline {
    agent any
    stages {
       stage('Build'){
        steps {
            script {
               // Read the YAML file
               def locationMap = readYaml file: 'locations.yml'

               // Define methods to populate data
               String populateProvinces(String country){
                   return locationMap[country]?.keySet().toList() ?: ["Not Applicable"]
               }

               String populateCities(String country, String province){
                   return locationMap[country]?.get(province) ?: ["Not Applicable"]
               }

               // Properties step to set the Active choice parameters via Declarative Scripting
               properties([
                   parameters([
                       [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["ERROR"]'], script: [classpath: [], sandbox: false, script:  "return ${locationMap.keySet().toList()}"]]],
                       [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'PROVINCE', referencedParameters: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: "return ${populateProvinces(params.COUNTRY)}"]]],
                       [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'CITY', referencedParameters: 'PROVINCE', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: "return ${populateCities(params.COUNTRY, params.PROVINCE)}"]]]
                   ])
               ])
               echo 'Building..'

            }

        }
    }
}