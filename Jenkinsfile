pipeline {
    agent any

    parameters {
        stringParam(name: 'templateName', defaultValue: '', description: 'Select a template')
        stringParam(name: 'detailedApplication', defaultValue: '', description: 'Select an application')
    }

    stages {
        stage('Prepare') {
            steps {
                script {
                    // Read template names from YAML file
                    templateNames = readFile('templates.yaml').split("\n").findAll { it.trim() }.collect { it.trim() }

                    // Get user-selected template name
                    selectedTemplate = params.templateName

                    // Read detailed applications from YAML file
                    detailedApplications = readYaml('applications.yaml')

                    // Filter applications based on selected template (using conditional logic)
                    filteredApps = detailedApplications[selectedTemplate] ?: []

                    // Update second dropdown options dynamically (using conditional logic in next stage)
                    availableApps = filteredApps.collect { it }
                }
            }
        }

        stage('Build') {
            steps {
                // Your build steps...

                // Conditionally set choices for second dropdown based on selectedTemplate
                script {
                    if (selectedTemplate) {
                        echo "Selected template: ${selectedTemplate}"
                        stage('Update Application Choices') {
                            // Update choices for 'detailedApplication' parameter dynamically
                            updateChoiceParameter('detailedApplication', availableApps)
                        }
                    } else {
                        echo "No template selected."
                    }

                    // Access selected application (if applicable)
                    echo "Selected application: ${params.detailedApplication}"
                }
            }
        }
    }
}
