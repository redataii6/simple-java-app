pipeline {
    agent any  // Runs on your EC2 agent

    tools {
        jdk 'JDK17'  // Match your Java 17; configure this in Jenkins Global Tool Configuration
        maven 'Maven3'  // Match your Maven 3.8.7; configure this in Jenkins
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/spring-projects/spring-petclinic.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'  // Builds and runs tests
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'  // Explicitly runs tests (optional, as 'install' includes tests)
            }
        }
    }

    post {
        always {
            archiveArtifacts artifacts: 'target/*.jar', allowEmptyArchive: true  // Archives the built JAR
        }
        success {
            echo 'Build and test succeeded! Check target/spring-petclinic.jar'
        }
        failure {
            echo 'Build failed. Check Jenkins console output for errors.'
        }
    }
}
