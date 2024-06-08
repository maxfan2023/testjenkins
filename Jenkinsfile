pipeline {
    agent any

    stages {
        stage('Setup Parameters') {
            steps {
                script {
                    properties([
                        parameters([
                            // 第一级参数：选择国家
                            [$class: 'ChoiceParameter',
                             choiceType: 'PT_SINGLE_SELECT',
                             name: 'COUNTRY',
                             description: "<font size=8 cols=\"60\" style=\"color:red\">*</font>Select Country Please",
                             filterLength: 1,
                             filterable: false,
                             randomName: 'choice-parameter-1538199013155082',
                             script: [$class: 'GroovyScript',
                                      fallbackScript: [classpath: [], sandbox: true, script: ''],
                                      script: [classpath: [], sandbox: true,
                                               script: "return ['China', 'US']"
                                              ]
                                     ]
                            ],

                            // 第二级参数：选择省份
                            [$class: 'DynamicReferenceParameter',
                             choiceType: 'ET_FORMATTED_HTML',
                             name: 'PROVINCE2',
                             description: "<font size=8 cols=\"60\" style=\"color:red\">*</font>Select province2 Please",
                             omitValueField: true,
                             referencedParameters: 'COUNTRY',
                             randomName: 'choice-parameter-1538199013155083',
                             script: [$class: 'GroovyScript',
                                      fallbackScript: [classpath: [], sandbox: true, script: ''],
                                      script: [classpath: [], sandbox: true,
                                               script: '''
                                                def country = COUNTRY
                                                if (country == 'China') {
                                                    return ["guangdong", "shandong"]
                                                } else if (country == 'US') {
                                                    return ["New York", "California"]
                                                } else {
                                                    return ["No provinces available"]
                                                }
                                               '''
                                              ]
                                     ]
                            ],

                            // 第三级参数：选择城市
                            [$class: 'DynamicReferenceParameter',
                             choiceType: 'ET_FORMATTED_HTML',
                             name: 'CITY',
                             description: "Select city",
                             omitValueField: true,
                             referencedParameters: 'COUNTRY, PROVINCE2',
                             randomName: 'choice-parameter-1538199014172793',
                             script: [$class: 'GroovyScript',
                                      fallbackScript: [classpath: [], sandbox: true, script: ''],
                                      script: [classpath: [], sandbox: true,
                                               script: '''
                                                def cityMap = [
                                                    "China": [
                                                        "guangdong": ["GuangZhou", "Shenzhen"],
                                                        "shandong" : ["JiNan", "QingDao"]
                                                    ],
                                                    "US": [
                                                        "New York"    : ["New York City", "Buffalo"],
                                                        "California"  : ["Los Angeles", "San Francisco"]
                                                    ]
                                                ]

                                                def country = COUNTRY
                                                def province = PROVINCE2

                                                if (country && province && cityMap[country] && cityMap[country][province]) {
                                                    return cityMap[country][province]
                                                } else {
                                                    return ["No cities available"]
                                                }
                                               '''
                                              ]
                                     ]
                            ]
                        ])
                    ])
                }
            }
        }

        stage('Display Selection') {
            steps {
                script {
                    echo "Selected Country: ${params.COUNTRY}"
                    echo "Selected Province: ${params.PROVINCE2}"
                    echo "Selected City: ${params.CITY}"
                }
            }
        }
    }
}
