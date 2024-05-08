properties([
    parameters([
        [$class: 'ExtendedChoiceParameterDefinition',
            name: 'TEMPLATE_NAME',
            type: 'PT_SINGLE_SELECT',
            description: 'Select a template',
            value: 'Template1', // 默认值
            choiceType: 'PT_LOAD_FROM_FILE', // 从文件加载选项
            choiceFile: 'templates.yaml', // YAML 文件路径
            choiceTarget: '$$.key', // 从 YAML 中提取 key 作为选项
            referencedParameter: 'TEMPLATE_NAME' // 引用自身作为关联参数
        ],
        [$class: 'ExtendedChoiceParameterDefinition',
            name: 'APPLICATION_NAME',
            type: 'PT_SINGLE_SELECT',
            description: 'Select an application',
            value: 'App1', // 默认值
            choiceType: 'PT_LOAD_FROM_FILE', // 从文件加载选项
            choiceFile: 'applications.yaml', // YAML 文件路径
            choiceTarget: '$[_EXTENDED_CHOICE_PARAMETER_REFERENCE_VALUE.TEMPLATE_NAME].value', // 根据 TEMPLATE_NAME 的值动态加载选项
            referencedParameter: 'TEMPLATE_NAME' // 关联参数
        ]
    ])
])

pipeline {
    agent any
    stages {
        stage('Example') {
            steps {
                echo "Selected template: ${params.TEMPLATE_NAME}"
                echo "Selected application: ${params.APPLICATION_NAME}"
            }
        }
    }
}
