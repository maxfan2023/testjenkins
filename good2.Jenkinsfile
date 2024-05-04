import groovy.json.JsonSlurper
pipeline {
    agent any
    stages {
            stage('Initialize Parameters') {
                steps {
                    script {
                        // 读取文件
                        def jsonText = readFile 'job_parameters.json'
                        // 解析 JSON
                        def jsonSlurper = new JsonSlurper()
                        def jobParameters = jsonSlurper.parseText(jsonText)
                        properties([
                            parameters([
                                        choice(
                                            name: 'Some choices',
                                            description: 'Select from these choices',
                                            choices: jobParameters.someChoices.join('\n')
                                        ),
                                        // all your parameters go here
                                        string(
                                            name: 'Some value',
                                            description: 'Define this value',
                                            defaultValue: jobParameters.someDefaultValue,
                                            trim: true
                                        ),
                                        booleanParam(
                                            name: 'Abort on parameter change',
                                            description: 'Enable to update the build parameters',
                                            defaultValue: false
                                        )
                            ])
                        ])
                    }
                }
            }
        stage('Hello') {
            steps {
                echo "Selected option: ${params.MY_CHOICE}"
            }
        }
    }
}
