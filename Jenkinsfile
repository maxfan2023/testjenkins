pipeline {
    agent any

    parameters {
        extendedChoice(
            name: 'TEMPLATE',
            type: 'PT_SINGLE_SELECT',
            groovyScript: [
                script: "return ['Template1', 'Template2', 'Template3']",
                classpath: []
            ]
        )
        extendedChoice(
            name: 'APPLICATION',
            type: 'PT_SINGLE_SELECT',
            groovyScript: [
                script: """
                    def detailedApplications = [
                        'Template1': ['App1', 'App2'],
                        'Template2': ['App3', 'App4'],
                        'Template3': ['App5', 'App6']
                    ]
                    return detailedApplications[params.TEMPLATE]
                """,
                classpath: []
            ],
            referencedParameters: "TEMPLATE"
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
