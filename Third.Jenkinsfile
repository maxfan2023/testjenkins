#!/usr/bin/env groovy
// Define variables
List country_list = ["\"Select:selected\"","\"China\"","\"US\""]
List china_list = ["\"Select:selected\"","\"guangdong\"","\"shandong\"","\"jiangsu\"","\"zhejiang\""]
List us_list = ["\"Select:selected\"","\"New York\"","\"California\""]
List guangdong_list = ["\"Select:selected\"","\"GuangZhou\"","\"Shenzhen\""]
List shandong_list = ["\"Select:selected\"","\"JiNan\"","\"QingDao\""]
List default_item = ["\"Not Applicable\""]
String countries = buildScript(country_list)
String china = buildScript(china_list)
String us = buildScript(us_list)
String provinces = populateItems(default_item,china_list,us_list)
String cities = populateCities(default_item, guangdong_list, shandong_list)
// Methods to build groovy scripts to populate data
String buildScript(List values){
  return "return $values"
}
String populateItems(List default_item, List chinaList, List usList){
return """if(COUNTRY.equals('China')){
     return $chinaList
     }
     else if(COUNTRY.equals('US')){
     return $usList
     }else{
     return $default_item
     }
     """
}
String populateCities(List default_item, List guangdongList, List shandongList){
return """if(PROVINCE.equals('guangdong')){
     return $guangdongList
     }
     else if(PROVINCE.equals('shandong')){
     return $shandongList
     }else{
     return $default_item
     }
     """
}
// Properties step to set the Active choice parameters via
// Declarative Scripting
properties([
    parameters([
        [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT',   name: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["ERROR"]'], script: [classpath: [], sandbox: false,
        script:  countries]]],
        [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'PROVINCE', referencedParameters: 'COUNTRY', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: provinces]]],
        [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'CITY', referencedParameters: 'PROVINCE', script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: cities]]]
    ])
])
pipeline {
    agent any
stages {
   stage('Build'){
    steps {
       echo 'Building..'
      }
    }
   }
}