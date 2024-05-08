pipeline {
    agent any

    stages {
        stage('Init Job') {
            steps {
                script {
                    // 使用 readYaml 步骤读取外部 YAML 文件
                    def templateData = readYaml file: 'templates.yaml'
                    def applicationData = readYaml file: 'applications.yaml'

                    def dslScript = """
                    job('dynamic-job') {
                        parameters {
                            activeChoiceParam('TEMPLATE') {
                                choiceType('SINGLE_SELECT')
                                groovyScript {
                                    script("return \$${templateData.templateNames}")
                                }
                            }
                            activeChoiceReactiveParam('APPLICATION') {
                                choiceType('SINGLE_SELECT')
                                groovyScript {
                                    script('''
                                        def applications = \$${applicationData.detailedApplications}
                                        return applications[params.TEMPLATE]
                                    ''')
                                }
                                referencedParameter('TEMPLATE')
                            }
                        }
                    }
                    """
                    // 替换脚本中的占位符
                    dslScript = dslScript.replace("\$${templateData}", templateData.templateNames.join('\n'))
                    dslScript = dslScript.replace("\$${applicationData}", applicationData.detailedApplications)

                    // 执行 Job DSL 脚本来创建或更新作业
                    jobDsl(script: dslScript)
                }
            }
        }
    }
}
