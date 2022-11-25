pipeline {
    agent any

    stages {
        stage('Connect to device') {
            steps {
                bat 'adb connect bcbcb6de'
            }
        }
        stage('Install apk') {
            steps {
                bat 'adb -s bcbcb6de install "E:\\Scripts\\Gitee\\Apk\\minplan-1.1.1.apk"'
            }
        }
    }
}
