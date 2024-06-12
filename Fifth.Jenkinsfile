#!/usr/bin/env groovy

// Load YAML file
def locations = readYaml file: 'locations2.yml'

// Define variables
List country_list = ["\"Select:selected\""] + locations.keySet().collect { "\"${it}\"" }
List default_item = ["\"Not Applicable\""]
Map province_map = locations.collectEntries { country, provinces -> [country, ["\"Select:selected\""] + provinces.keySet().collect { "\"${it}\"" }] }
Map city_map = locations.collectEntries { country, provinces -> provinces.collectEntries { province, cities -> [province, ["\"Select:selected\""] + cities.collect { "\"${it}\"" }] } }

String countries = buildScript(country_list)
String provinces = buildProvinceScript(province_map, default_item)
String cities = buildCityScript(city_map, default_item)

// Methods to build groovy scripts to populate data
String buildScript(List values) {
    return "return ${values}"
}

String buildProvinceScript(Map province_map, List default_item) {
    def script = "if (COUNTRY.equals('Select:selected')) { return ${default_item} }"
    province_map.each { country, provinces ->
        script += " else if (COUNTRY.equals('${country}')) { return ${provinces} }"
    }
    script += " else { return ${default_item} }"
    return script
}

String buildCityScript(Map city_map, List default_item) {
    def script = "if (PROVINCE.equals('Select:selected')) { return ${default_item} }"
    city_map.each { province, cities ->
        script += " else if (PROVINCE.equals('${province}')) { return ${cities} }"
    }
    script += " else { return ${default_item} }"
    return script
}

// Properties step to set the Active choice parameters via Declarative Scripting
properties([
    parameters([
        [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["ERROR"]'], script: [classpath: [], sandbox: false, script: countries]]],
        [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'PROVINCE', referencedParameters: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: provinces]]],
        [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'CITY', referencedParameters: 'PROVINCE', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: cities]]]
    ])
])

pipeline {
    agent any
    stages {
        stage('Build') {
            steps {
                echo 'Building..'
            }
        }
    }
}
