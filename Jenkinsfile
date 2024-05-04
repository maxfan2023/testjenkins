properties([
    parameters([
        activeChoiceParam(
            name: 'DYNAMIC_CHOICE',
            description: 'Dynamically populated choices',
            script: [
                $class: 'GroovyScript',
                script: '''
                    def jsonSlurper = new groovy.json.JsonSlurper()
                    def file = new File('job_parameters.json')
                    def data = jsonSlurper.parse(file)
                    return data.someChoices
                ''',
                fallbackScript: [
                    script: "return ['Error: Failed to load choices']",
                    sandbox: true
                ]
            ],
            choiceType: 'PT_SINGLE_SELECT',
            description: 'Select an option'
        )
    ])
])

pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                echo "The selected option is: ${params.DYNAMIC_CHOICE}"
            }
        }
    }
}
