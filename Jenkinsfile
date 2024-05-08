pipeline {
    agent any

    // 定义全局参数
    parameters {
        extendedChoice(
            name: 'TEMPLATE_NAME',
            type: 'PT_SINGLE_SELECT',
            description: 'Select a template',
            choiceType: 'PT_LOAD_FROM_FILE',
            choiceFile: 'templates.yaml',
            choiceTarget: '$$.key'
        )
    }

    stages {
        stage('Initialization') {
            steps {
                script {
                    // 输出选定的模板名，用于验证参数是否正确加载
                    echo "Selected Template: ${params.TEMPLATE_NAME}"
                }
            }
        }

        stage('Build') {
            steps {
                echo 'Building the project...'
                // 这里可以添加实际的构建逻辑
            }
        }
    }
}
