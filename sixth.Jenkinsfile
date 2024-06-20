boolean hasUpperCase(String str) {
  return str =~ /[A-Z]/
}

boolean hasLowerCase(String str) {
  return str =~ /[a-z]/
}

boolean hasNumber(String str) {
  return str =~ /\d/
}

boolean hasSymbol(String str) {
  return str =~ /[^a-zA-Z0-9]/
}

boolean validateComplexity(String password) {
  return hasUpperCase(password) && hasLowerCase(password) && hasNumber(password) && hasSymbol(password);
}

boolean validatePassword(String password) {
  if (password.isEmpty()) {
    return false; // Password cannot be empty
  }
  if (password.length() < 8) { // Adjust minimum length as needed
    return false; // Password must meet minimum length requirement
  }
  if (!validateComplexity(password)) {
    return false; // Password must meet complexity requirements
  }
  return true; // Password is valid
}
pipeline {
    agent any

    parameters {
        password(name: 'password', defaultValue: '', description: 'Enter your password', sensitive: true)
    }

    properties([
        booleanProperty(name: 'passwordValid', defaultValue: false, description: '')
    ])

    stages {
        stage('Validate Password') {
            steps {
                script {


                    passwordValid = validatePassword(params.password)
                }
            }
            post {
                successIf true: "${passwordValid}"
                failure {
                    error "Invalid password. Please ensure it meets the requirements (minimum 8 characters with uppercase, lowercase, number, and symbol)."
                }
            }
        }

        stage('Build') {
            when {
                expression { return "${passwordValid}" }
            }
            steps {
                // Build steps go here
            }
        }
    }
}


pipeline {
    agent any

    parameters {
        password(name: 'password', defaultValue: '', description: 'Enter your password', sensitive: true)
    }

    properties([
        booleanProperty(name: 'passwordValid', defaultValue: false, description: '')
    ])

    stages {
        stage('Validate Password') {
            steps {
                script {
≈

                    passwordValid = validatePassword(params.password)
                }
            }
            post {
                successIf true: "${passwordValid}"
                failure {
                    error "Invalid password. Please ensure it meets the requirements (minimum 8 characters with uppercase, lowercase, number, and symbol)."
                }
            }
        }

        stage('Build') {
            when {
                expression { return "${passwordValid}" }
            }
            steps {
                // Build steps go here
            }
        }
    }
}
