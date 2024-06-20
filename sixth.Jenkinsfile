pipeline {
    agent any

    parameters {
        string(name: 'PASSWORD', defaultValue: '', description: 'Enter your password')
        string(name: 'CONFIRM_PASSWORD', defaultValue: '', description: 'Confirm your password')
        activeChoiceReactiveParam(
            name: 'PASSWORD_VALIDATION',
            description: 'Password Validation',
            choiceType: 'SINGLE_SELECT',
            groovyScript: [script: '''
                if (!PASSWORD.equals(CONFIRM_PASSWORD)) {
                    return ['Passwords do not match!']
                } else {
                    return ['Passwords match.']
                }
            ''', fallbackScript: 'return ["Validation Failed"]']
        )
    }

    stages {
        stage('Validate Passwords') {
            steps {
                script {
                    def validation = params.PASSWORD_VALIDATION
                    if (validation.contains('do not match')) {
                        error "Passwords do not match. Please re-enter."
                    } else {
                        echo "Passwords match. Proceeding with the pipeline."
                    }
                }
            }
        }
        // Additional stages can be added here
    }
}