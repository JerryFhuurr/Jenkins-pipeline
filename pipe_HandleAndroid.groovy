pipeline {
    agent any

    stages {
        stage('Connect to Android') {
            steps {
                bat 'adb connect 192.168.187.103:5555'
            }
        }
        stage('Install new version') {
            steps {
                bat 'adb install "E:\\Scripts\\TestCodes\\Apk\\minplan-1.1.0.apk"'
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
                <!DOCTYPE html>
                <body>
                    <h1>
                        Build report
                    </h1>
                
                    <h2>Result:<span color='#0000FF'>${BUILD_DISPLAY_NAME} Fail</span></h2>
                
                    <p>The adb operations failed! Maybe you didn't start the WSA on your device ?</p>
                </body>
                """
            )
        }
        success {
            echo 'Build success'
        }
    }
}
