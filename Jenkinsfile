pipeline {
    agent any

    parameters {
        choice(name: 'templateName', choices: readFile(workspacePath + '/templates.yaml').templateNames, description: '选择模板')
        choice(name: 'detailedApplication', choices: ['': ''], description: '选择应用')
    }

    stages {
        stage('准备') {
            steps {

                    // 读取 detailed_applications.yaml 文件
                    detailedApplications = readYaml(file(workspacePath + '/applications.yaml'))

                    // 根据 templateName 过滤 detailedApplications
                    filteredApps = detailedApplications[params.templateName] ?: []

                    // 更新第二个下拉列表选项
                    updateChoiceParameter('detailedApplication', filteredApps.collect { it })

            }
        }

        stage('构建') {
            steps {
                // 您的构建步骤...

                // 显示选定的下拉列表值
                echo "选择的模板: ${params.templateName}"
                echo "选择的应用: ${params.detailedApplication}"
            }
        }
    }
}
