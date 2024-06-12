pipeline {
    agent any
    parameters {
        choice(name: 'CATEGORY', choices: ['Fruits', 'Vegetables'], description: 'Select a category')
        cascadeChoice(name: 'ITEM', 
                      script: [
                          classpath: [], 
                          fallbackScript: [
                              classpath: [], 
                              script: 'return ["No options available"]'
                          ], 
                          script: 'if (CATEGORY == "Fruits") {return ["Apple", "Banana", "Orange"]} else {return ["Carrot", "Broccoli", "Spinach"]}'
                      ], 
                      description: 'Select an item based on the selected category')
    }
    stages {
        stage('Example') {
            steps {
                echo "Selected category: ${params.CATEGORY}"
                echo "Selected item: ${params.ITEM}"
            }
        }
    }
}
