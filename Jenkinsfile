pipeline {
    agent any

    parameters {
        activeChoiceParam('TEMPLATE') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script("""
                    // 这里假设已经通过某种方式读取了YAML文件内容
                    return ['Template1', 'Template2', 'Template3']
                """)
            }
        }
        activeChoiceReactiveParam('APPLICATION') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script("""
                    def applications = [
                        'Template1': ['App1', 'App2'],
                        'Template2': ['App3', 'App4'],
                        'Template3': ['App5', 'App6']
                    ]
                    return applications[params.TEMPLATE]
                """)
            }
            referencedParameter('TEMPLATE')
        }
    }

    stages {
        stage('Example') {
            steps {
                script {
                    echo "Selected template: ${params.TEMPLATE}"
                    echo "Selected application: ${params.APPLICATION}"
                }
            }
        }
    }
}
