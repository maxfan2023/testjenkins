pipeline {
    agent any
    parameters {
        activeChoiceParam(name: 'MY_CHOICE', description: '选择一个选项') {
            choiceType('SINGLE_SELECT')
            groovyScript {
                script("""
                    return ['Option 1', 'Option 2', 'Option 3']
                """)
                fallbackScript("return ['Error: No options available']")
            }
        }
    }
    stages {
        stage('Example') {
            steps {
                echo "选中的选项是: ${params.MY_CHOICE}"
            }
        }
    }
}