import groovy.json.JsonSlurper
pipeline {
    agent any

    parameters {
        extendedChoice(
            name: 'TEMPLATE',
            type: 'PT_SINGLE_SELECT',
            groovyScript: """
                return readYaml(file: 'templates.yaml')['templateNames']
            """,
            groovyClasspath: []
        )
        extendedChoice(
            name: 'APPLICATION',
            type: 'PT_SINGLE_SELECT',
            groovyScript: """
                def applications = readYaml(file: 'applications.yaml')['detailedApplications']
                return applications[params.TEMPLATE]
            """,
            groovyClasspath: [],
            referencedParameters: 'TEMPLATE'
        )
    }

    stages {
        stage('Example') {
            steps {
                echo "Selected template: ${params.TEMPLATE}"
                echo "Selected application: ${params.APPLICATION}"
            }
        }
    }
}
