pipeline {
    agent any
    stages {
        stage('build') {
            steps {
               echo 'i am doing somthing'
               sh 'mvn --version'
            }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
                /* `make check` returns non-zero on test failures,
                * using `true` to allow the Pipeline to continue nonetheless
                */
                //sh 'make check || true'
                sh 'ls'
                sh 'make'
                archiveArtifacts artifacts: '**/target/*.jar', fingerprint: true
                junit '**/target/*.xml'
            }
        }
    }
}