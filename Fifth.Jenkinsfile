pipeline {
    agent any
    parameters {
        activeChoiceParam('PASSWORD_CHOICE') {
            description('Enter and confirm your password')
            choiceType('TEXT')
            groovyScript {
                script("""
                    def html = '''
                    <script>
                        function validatePassword() {
                            var pass1 = document.getElementsByName("PASSWORD")[0].value;
                            var pass2 = document.getElementsByName("CONFIRM_PASSWORD")[0].value;
                            if(pass1 != pass2) {
                                alert("Passwords do not match!");
                                return false;
                            }
                            return true;
                        }
                    </script>
                    <form onsubmit="return validatePassword()">
                        Password: <input type="password" name="PASSWORD"/><br/>
                        Confirm Password: <input type="password" name="CONFIRM_PASSWORD"/><br/>
                        <input type="submit" value="Submit"/>
                    </form>
                    '''
                    return html
                """)
                fallbackScript('return ["<h3>Unable to display form</h3>"]')
            }
        }
    }
    stages {
        stage('Validate Input') {
            steps {
                script {
                    // Access the submitted password values here
                    def password = params.PASSWORD
                    def confirmPassword = params.CONFIRM_PASSWORD
                    if (password != confirmPassword) {
                        error("Passwords do not match. Please try again.")
                    }
                }
            }
        }
        stage('Proceed with Build') {
            steps {
                echo "Password is set and matches the confirmation."
                // Your build steps here
            }
        }
    }
}