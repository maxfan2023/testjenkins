pipeline {
    agent any

    parameters {
        string(name: 'DUMMY', defaultValue: '', description: '')
        activeChoiceReactiveParam(
            name: 'HTML_PARAM',
            description: 'Enter your password',
            choiceType: 'FORMATTED_HTML',
            groovyScript: [
                script: '''
                    return '''
                        <label for="password">Password:</label>
                        <input type="password" id="password" name="password">
                        <input type="checkbox" onclick="togglePassword()"> Show Password
                        <br><br>
                        <label for="confirm-password">Confirm Password:</label>
                        <input type="password" id="confirm-password" name="confirm-password">
                        <input type="checkbox" onclick="toggleConfirmPassword()"> Show Password
                        <br><br>
                        <script>
                            function togglePassword() {
                                var passwordField = document.getElementById("password");
                                if (passwordField.type === "password") {
                                    passwordField.type = "text";
                                } else {
                                    passwordField.type = "password";
                                }
                            }

                            function toggleConfirmPassword() {
                                var confirmPasswordField = document.getElementById("confirm-password");
                                if (confirmPasswordField.type === "password") {
                                    confirmPasswordField.type = "text";
                                } else {
                                    confirmPasswordField.type = "password";
                                }
                            }
                        </script>
                    '''
            ]
        )
    }

    stages {
        stage('Validate Passwords') {
            steps {
                script {
                    def password = params.PASSWORD
                    def confirmPassword = params.CONFIRM_PASSWORD

                    if (password != confirmPassword) {
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