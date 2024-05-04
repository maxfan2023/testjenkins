pipeline {
    agent any
    stages {
        stage('Initialize Parameters') {
            steps {
                script {
                    // 假设从外部系统获取了参数列表
                    def newChoices = 'Option 1,Option 2,Option 3'
                    properties([
                        parameters([
//                             choice(name: 'MY_CHOICE', choices: newChoices.split(','), description: '动态生成的选项')
                            choice(name: 'MY_CHOICE', choices: "Option 1\nOption 2", description: '动态生成的选项')
                        ])
                    ])
                }
            }
        }
        stage('Use Parameters') {
            steps {
                echo "动态设置的参数 MY_CHOICE 的值是：${params.MY_CHOICE}"
            }
        }
    }
}
