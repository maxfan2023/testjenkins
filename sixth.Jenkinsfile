pipeline {
    agent any
    parameters {
        password(name: 'PASSWORD1', defaultValue: '', description: 'Enter your password')
        password(name: 'PASSWORD2', defaultValue: '', description: 'Re-enter your password')
        extendedChoice(
            name: 'PASSWORD_VALIDATION',
            type: 'PT_TEXTBOX',
            defaultValue: '',
            description: 'Password validation result',
            visibleItemCount: 1,
            script: [
                classpath: [],
                fallbackScript: 'return [""]',
                script: '''
                    def password1 = binding.getVariable("PASSWORD1")
                    def password2 = binding.getVariable("PASSWORD2")

                    if (password1 != password2) {
                        return ["Passwords do not match!"]
                    } else {
                        return ["Passwords match!"]
                    }
                '''
            ]
        )
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building...'
            }
        }
    }
}