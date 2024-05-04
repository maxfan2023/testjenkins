import java.text.SimpleDateFormat
import java.util.Date

def jobParameters = readJSON file: 'job_parameters.json'
// 解析 JSON
// def jsonSlurper = new JsonSlurper()
// def jobParameters = jsonSlurper.parseText(jsonText)

properties([
    parameters([
                choice(
                    name: 'Some choices',
                    description: 'Select from these choices',
                    choices: jobParameters.someChoices
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

pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                echo "The selected option is: ${params.DYNAMIC_CHOICE}"
            }
        }
    }
}
