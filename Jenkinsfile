pipeline {
    agent any
    parameters {
        activeChoiceParam(name: 'MY_CHOICE', description: 'Select an option') {
            choiceType('SINGLE_SELECT')
            scriptlerScriptPath('generate_dropdown_menu.groovy') // 使用 Scriptler 插件来运行 Groovy 脚本
        }
    }
    stages {
        stage('Hello') {
            steps {
                echo "Selected option: ${params.MY_CHOICE}"
            }
        }
    }
}
