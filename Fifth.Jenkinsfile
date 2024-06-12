properties([
    parameters([
        [$class: 'ChoiceParameter', choiceType: 'PT_SINGLE_SELECT', name: 'CATEGORY', script:[$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["ERROR"]'],script: [classpath: [], sandbox: false, script:  '''return ["Fruits","Vegetables"]''']]],
        [$class: 'CascadeChoiceParameter', choiceType: 'PT_SINGLE_SELECT',name: 'FRUIT', referencedParameters: 'CATEGORY',script: [$class: 'GroovyScript', fallbackScript: [classpath: [], sandbox: false, script: 'return ["error"]'], script: [classpath: [], sandbox: false, script: '''if (CATEGORY == "Fruits") {return ["Apple", "Banana", "Orange"]} else {return ["Carrot", "Broccoli", "Spinach"]}''']]],
    ])
])

pipeline {
    agent any


    stages {
        stage('Example') {
            steps {
                echo "Selected category: ${params.CATEGORY}"
                echo "Selected item: ${params.FRUIT}"
            }
        }
    }
}
