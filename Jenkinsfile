import groovy.json.JsonSlurper

pipeline {
    agent any

    parameters {
        script {
            properties([
                pipelineParameter(
                    name: 'TEMPLATE',
                    type: 'choice',
                    choices: [],
                    defaultValue: ''
                ),
                pipelineParameter(
                    name: 'APPLICATION',
                    type: 'choice',
                    choices: [],
                    defaultValue: ''
                )
            ])
        }
    }

    stages {
            stage('Initialize Parameters') {
                steps {
                    script {
                            // 读取模板名称
                            def templates = readYaml file: 'templates.yaml'
                            def templateList = templates.templateNames

                            // 读取具体应用程序
                            def applications = readYaml file: 'applications.yaml'
                            def applicationMap = applications.detailedApplications
                        properties([
                                pipelineParameter(
                                    name: 'TEMPLATE',
                                    type: 'choice',
                                    choices: templateList,
                                    defaultValue: templateList[0]
                                ),
                                pipelineParameter(
                                    name: 'APPLICATION',
                                    type: 'choice',
                                    choices: applicationMap[templateList[0]],
                                    defaultValue: applicationMap[templateList[0]][0]
                                )

                        ])
                    }
                }
            }
        stage('Hello') {
            steps {
                echo "Selected option: ${params.Some_choices}"
            }
        }
    }
}
