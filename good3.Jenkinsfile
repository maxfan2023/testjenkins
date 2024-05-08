pipeline {
    agent any
    stages {
        stage('Initialization') {
            steps {
                script {
                    properties([
                        parameters([
                            choice(
                                name: 'TEMPLATE',
                                choices: ['Template1', 'Template2', 'Template3'].join('\n'),
                                description: 'Select a template'
                            ),
                            choice(
                                name: 'APPLICATION',
                                choices: getApplications(env.TEMPLATE).join('\n'),
                                description: 'Select an application based on template'
                            )
                        ])
                    ])
                }
            }
        }
        stage('Build') {
            steps {
                echo "Selected Template: ${params.TEMPLATE}"
                echo "Selected Application: ${params.APPLICATION}"
            }
        }
    }
}

// A helper method to get applications based on the template
def getApplications(String template) {
    def applications = [
        'Template1': ['App1', 'App2'],
        'Template2': ['App3', 'App4'],
        'Template3': ['App5', 'App6']
    ]
    return applications[template] ?: []
}
