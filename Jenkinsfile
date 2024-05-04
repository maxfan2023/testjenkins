pipeline {
    agent any
    stages {
            stage('Initialize Parameters') {
                steps {
                    script {
                        def jobParameters = readJson file: 'job_parameters.json'
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
                    }
                }
            }
        stage('Hello') {
            steps {
                echo "Selected option: ${params.MY_CHOICE}"
            }
        }
    }
}
