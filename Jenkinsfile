pipeline {
    agent any

    parameters {
        choiceParam(name: 'templateName', choices: readFile('templates.yaml').templateNames, description: 'Select a template')
        choiceParam(name: 'detailedApplication', choices: ['': ''], description: 'Select an application')
    }

    stages {
        stage('Prepare') {
            steps {
                script {
                    // 读取 detailed_applications.yaml 文件
                    detailedApplications = readYaml('applications.yaml')

                    // 根据 templateName 过滤 detailedApplications
                    filteredApps = detailedApplications[params.templateName] ?: []

                    // 更新第二个下拉列表选项
                    updateChoiceParameter('detailedApplication', filteredApps.collect { it })
                }
            }
        }

        stage('Build') {
            // 您的构建步骤...
            // 显示选定的下拉列表值
            echo "Selected template: ${params.templateName}"
            echo "Selected application: ${params.detailedApplication}"
        }
    }
}
