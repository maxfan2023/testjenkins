pipeline {
    agent any

    stages {
        stage('Init Job') {
            steps {
                script {
                    // 使用 readYaml 步骤读取外部 YAML 文件
                    def templateData = readYaml file: 'templates.yaml'
                    def applicationData = readYaml file: 'applications.yaml'

                    def templateChoices = templateData.templateNames.join("\\n")
                    def applicationsMap = applicationData.detailedApplications.collect { key, value ->
                        "\"${key}\": [${value.collect { "\"${it}\"" }.join(", ")}]"
                    }.join(", ")

                    def dslScript = """
                    job('dynamic-job') {
                        parameters {
                            activeChoiceParam('TEMPLATE') {
                                choiceType('SINGLE_SELECT')
                                groovyScript {
                                    script("return [${templateChoices}]")
                                }
                            }
                            activeChoiceReactiveParam('APPLICATION') {
                                choiceType('SINGLE_SELECT')
                                groovyScript {
                                    script('''
                                        def applications = [${applicationsMap}]
                                        return applications[params.TEMPLATE]
                                    ''')
                                }
                                referencedParameter('TEMPLATE')
                            }
                        }
                    }
                    """
                    // 执行 Job DSL 脚本来创建或更新作业
                    jobDsl(script: dslScript)
                }
            }
        }
    }
}
