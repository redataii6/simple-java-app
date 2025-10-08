pipeline {
    agent any

    triggers {
        // Triggered by GitHub webhook (pushes and PRs)
        githubPush()
    }

    stages {
        stage('Checkout') {
            steps {
                git(
                    branch: 'main',
                    url: 'https://github.com/redataii6/simple-java-app.git',
                    credentialsId: 'github_path' // your Jenkins credential
                )
            }
        }

        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true
        }
        success {
            echo 'Build succeeded!'
        }
        failure {
            echo 'Build failed.'
        }
    }
}
