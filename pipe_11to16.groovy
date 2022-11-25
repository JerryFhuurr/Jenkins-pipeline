pipeline {
    agent any

    stages {
        stage('Pull code from Gitee') {
            steps {
                echo 'Updating code...'
                pwsh '''cd D:\\\\TestAutoCodes
                git init
                git remote add origin https://gitee.com/fhuurr/TestAutomation.git
                git pull origin main'''
                echo 'Updating finished'
            }
        }
        stage('Connect to Android') {
            steps {
                bat 'adb connect bcbcb6de'
            }
        }
        stage('Install app to device') {
            steps {
                pwsh 'adb -s bcbcb6de install D:\\TestAutoCodes\\Apk\\minplan-1.1.1.apk'
            }
        }
        stage('Excuting scripts') {
            steps {
                echo 'Start to excute the scripts'
            }
        }
        stage('TC11') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                bat 'adb shell am force-stop com.minplan.minplan_app'
                                pwsh '''D:
                                cd D:\\TestAutoCodes\\TestPy
                                python TC11R.py
                                '''
                            }
                        }
                    }
                }
            }
        }
        stage('TC12') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                bat 'adb shell am force-stop com.minplan.minplan_app'
                                pwsh '''D:
                                cd D:\\TestAutoCodes\\TestPy
                                python TC12R.py
                                '''
                            }
                        }
                    }
                }
            }
        }
        stage('TC13') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                bat 'adb shell am force-stop com.minplan.minplan_app'
                                pwsh '''D:
                                cd D:\\TestAutoCodes\\TestPy
                                python TC13R.py
                                '''
                            }
                        }
                    }
                }
            }
        }
        stage('TC14') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                bat 'adb shell am force-stop com.minplan.minplan_app'
                                pwsh '''D:
                                cd D:\\TestAutoCodes\\TestPy
                                python TC14R.py
                                '''
                            }
                        }
                    }
                }
            }
        }
        stage('Excute done') {
            steps {
                echo 'Excute scripts done, please check the results'
            }
        }
    }

    post {
            failure {
                echo 'Build failed'

                emailext (
                    subject :"Project ${JOB_NAME} build failed",
                    to: "caoxuanyuan4105@126.com",
                    body: """
                    <body>
                        <table width='95%' cellpadding='0' cellspacing='0'>
                            <tr>
                                <td>
                                    <h2>构建结果:<span color='#0000FF'>${BUILD_DISPLAY_NAME} Fail</span></h2>
                                </td>
                            </tr>
                            <!-- 构建信息 -->
                            <tr>
                                <td><br />
                                    <b>
                                        <font color="#0B610B">构建信息</font>
                                    </b>
                                    <hr size="2" width="100%" align="center" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <ul>
                                        <li>构建编号&nbsp;：&nbsp;第${BUILD_NUMBER}次构建</li>
                                        <li>构建节点：&nbsp;${NODE_NAME}</li>
                                        <li>项目地址：&nbsp;<a href="${JOB_URL}">${JOB_URL}</a></li>
                                        <li>构建日志：&nbsp;<a href="${BUILD_URL}console">${BUILD_URL}console</a></li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                              <td>
                                  请将localhost换成<a href="http://qbtest.free.idcfengye.com">http://qbtest.free.idcfengye.com </a>后打开
                              </td>
                              <td>
                                  若无法打开，请联系<a href="mailto:1063128177@qq.com">管理员</a>解决！
                              </td>
                          </tr>
                        </table>
                    </body>
                    """,
                )
                
            }
            success {
                echo 'Build OK'
                
                emailext (
                    subject :"Project ${JOB_NAME} build OK",
                    to: "caoxuanyuan4105@126.com",
                    body: """
                    <body>
                        <table width='95%' cellpadding='0' cellspacing='0'>
                            <tr>
                                <td>
                                    <h2>构建结果:<span color='#0000FF'>${BUILD_DISPLAY_NAME} OK</span></h2>
                                </td>
                            </tr>
                            <!-- 构建信息 -->
                            <tr>
                                <td><br />
                                    <b>
                                        <font color="#0B610B">构建信息</font>
                                    </b>
                                    <hr size="2" width="100%" align="center" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <ul>
                                        <li>构建编号&nbsp;：&nbsp;第${BUILD_NUMBER}次构建</li>
                                        <li>构建节点：&nbsp;${NODE_NAME}</li>
                                        <li>项目地址：&nbsp;<a href="${JOB_URL}">${JOB_URL}</a></li>
                                        <li>构建日志：&nbsp;<a href="${BUILD_URL}console">${BUILD_URL}console</a></li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                              <td>
                                  请将localhost换成<a href="http://qbtest.free.idcfengye.com">http://qbtest.free.idcfengye.com </a>后打开
                              </td>
                              <td>
                                  若无法打开，请联系<a href="mailto:1063128177@qq.com">管理员</a>解决！
                              </td>
                          </tr>
                        </table>
                    </body>
                    """,
                )
            }
    }
}
