pipeline {
    agent any

    environment {
        PROJECT_NAME = "AutomateProject"
        RECIPIENT_EMAIL = "your-email@example.com"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/SwapnilQA-Auto/AutomateProject.git'
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install -DskipTests'
            }
        }

        stage('Test') {
            parallel {
                stage('Unit Tests') {
                    steps { sh 'mvn test -Dtest=Unit*' }
                }
                stage('Integration Tests') {
                    steps { sh 'mvn test -Dtest=Integration*' }
                }
            }
        }

        stage('Deploy') {
            steps { sh 'echo Deployment logic goes here' }
        }
    }

    post {
        success {
            mail to: "${RECIPIENT_EMAIL}", subject: "Build Successful", body: "Congrats! Build passed."
        }
        failure {
            mail to: "${RECIPIENT_EMAIL}", subject: "Build Failed", body: "Build failed. Check logs."
        }
        always {
            cleanWs()
        }
    }
}