// 在 Jenkinsfile 的开头定义两个变量
def templateNames = ['Template1', 'Template2', 'Template3']
def detailedApplications = [ 'Template1': ['App1', 'App2'], 'Template2': ['App3', 'App4'], 'Template3': ['App5', 'App6'] ]

pipeline {
    agent any
    parameters {
        // 第一个下拉列表
        choice(
            name: 'TEMPLATE_NAME',
            choices: templateNames,
            description: 'Select a template'
        )
        // 第二个下拉列表
        script {
            // 根据第一个下拉列表的选择动态生成第二个下拉列表的选项
            def apps = detailedApplications[params.TEMPLATE_NAME]
            choice(
                name: 'APPLICATION_NAME',
                choices: apps,
                description: 'Select an application'
            )
        }
    }
    stages {
        stage('Example') {
            steps {
                echo "Selected template: ${params.TEMPLATE_NAME}"
                echo "Selected application: ${params.APPLICATION_NAME}"
            }
        }
    }
}