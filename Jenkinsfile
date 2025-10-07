pipeline {
    agent any
    tools {
        jdk 'JDK17'
        maven 'Maven3'
    }
    stages {
        stage('Checkout') { 
            steps { 
                git branch: 'main', url: 'https://github.com/redataii6/simple-java-app.git' 
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
