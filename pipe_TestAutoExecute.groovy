pipeline {
    agent any

    stages {
        stage('TC3') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(5) {
                               bat '''e:
                               cd E:\\Scripts\\TestCodes\\Tests
                               node TC3.js''' 
                            }
                        }
                    }
                }
            }
        }
        stage('TC4') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(5) {
                                bat '''e:
                                cd E:\\Scripts\\TestCodes\\Tests
                                node TC4.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC5') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(5) {
                                bat '''e:
                                cd E:\\Scripts\\TestCodes\\Tests
                                node TC5.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC7') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(5) {
                                bat '''e:
                                cd E:\\Scripts\\TestCodes\\Tests
                                node TC7.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC8') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(5) {
                                bat '''e:
                                cd E:\\Scripts\\TestCodes\\Tests
                                node TC8.js'''
                            }
                        }
                    }
                }
            }
        }
    }

    post {
            failure {
                echo 'Build failed'

                emailext (
                    subject :"Project ${JOB_NAME} build failed",
                    from: "1063128177@qq.com",
                    to: "fhuurr@163.com",
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
                    from: "1063128177@qq.com",
                    to: "fhuurr@163.com",
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
