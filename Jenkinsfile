pipeline {
    agent any
    parameters {
        // 使用Active Choices插件提供的参数类型
        extendedChoice(
            name: 'TEMPLATE',
            type: 'PT_SINGLE_SELECT',
            groovyScript: '''return ['Template1', 'Template2', 'Template3']'''
        )
        extendedChoice(
            name: 'APPLICATION',
            type: 'PT_SINGLE_SELECT',
            groovyScript: '''return [
                'Template1': ['App1', 'App2'],
                'Template2': ['App3', 'App4'],
                'Template3': ['App5', 'App6']
            ][params.TEMPLATE]'''
        )
    }
    stages {
        stage('Build') {
            steps {
                echo "Selected Template: ${params.TEMPLATE}"
                echo "Selected Application: ${params.APPLICATION}"
            }
        }
    }
}
