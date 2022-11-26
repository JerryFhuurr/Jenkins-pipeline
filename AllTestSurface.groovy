pipeline {
    agent any

    
    stages {
        stage('Login part') {
            steps {
                echo 'Login part start'
            }
        }
        stage('TC3') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
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
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
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
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
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
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
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
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC8.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('Warning sign & strategy part') {
            steps {
                echo 'Warning sign & strategy part start'
            }
        }
        stage('TC10') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC10.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC11') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC11.js'''
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
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC14.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC15') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC15.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC16') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC16.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC18') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 15, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC18.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC19') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC19.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('Contact part') {
            steps {
                echo 'Contact part start'
            }
        }
        stage('TC12') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC12.js'''
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
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC13.js'''
                            }
                        }
                    }
                }
            }
        }
        stage('TC20') {
            steps {
                script {
                    catchError(buildResult: 'FAILURE', stageResult: 'FAILURE') {
                        timeout(time: 8, unit: 'MINUTES') {
                            retry(10) {
                                
                                bat '''E:
                                cd E:\\Scripts\\Github\\Tests\\OnRealDevice\\Surface
                                node TC20.js'''
                            }
                        }
                    }
                }
            }
        }
    }
    stage('Finished') {
        steps {
            echo 'All tests finished'
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
                                    <h2>Build result:<span color='#0000FF'>${BUILD_DISPLAY_NAME} Fail</span></h2>
                                </td>
                            </tr>
                            <!-- 构建信息 -->
                            <tr>
                                <td><br />
                                    <b>
                                        <font color="#0B610B">Build info</font>
                                    </b>
                                    <hr size="2" width="100%" align="center" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <ul>
                                        <li>Build &nbsp;：&nbsp;No.${BUILD_NUMBER}</li>
                                        <li>Build node：&nbsp;${NODE_NAME}</li>
                                        <li>Project location：&nbsp;<a href="${JOB_URL}">${JOB_URL}</a></li>
                                        <li>Build output：&nbsp;<a href="${BUILD_URL}console">${BUILD_URL}console</a></li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    You need to download Zerotier if you want to open the link!
                                </td>
                                <td>
                                    Please contact <a href="mailto:1063128177@qq.com">admin</a> if you have any problem!
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
                                    <h2>Build result:<span color='#0000FF'>${BUILD_DISPLAY_NAME} OK</span></h2>
                                </td>
                            </tr>
                            <!-- 构建信息 -->
                            <tr>
                                <td><br />
                                    <b>
                                        <font color="#0B610B">Build info</font>
                                    </b>
                                    <hr size="2" width="100%" align="center" />
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    <ul>
                                        <li>Build &nbsp;：&nbsp;No.${BUILD_NUMBER}</li>
                                        <li>Build node：&nbsp;${NODE_NAME}</li>
                                        <li>Project location：&nbsp;<a href="${JOB_URL}">${JOB_URL}</a></li>
                                        <li>Build output：&nbsp;<a href="${BUILD_URL}console">${BUILD_URL}console</a></li>
                                    </ul>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    You need to download Zerotier if you want to open the link!
                                </td>
                                <td>
                                    Please contact <a href="mailto:1063128177@qq.com">admin</a> if you have any problem!
                                </td>
                            </tr>
                        </table>
                    </body>
                    """,
                )
            }
    }
}
