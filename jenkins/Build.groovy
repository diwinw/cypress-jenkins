pipeline {
    agent any
    
    stages {
        stage('Clone repository') {
            steps {
               
                    git branch: 'main', url: 'https://github.com/diwinw/cypress-jenkins'
                
            }
        }

          stage('Build') {
            steps {
                sh 'sudo apt update'
                sh 'sudo apt install nodejs'
                sh 'sudo apt install npm'
               sh 'npm install'
            }
        }

          stage('Run test') {
            steps {
                sh './node_modules/.bin/cypress run'
            }
        }
    }

}
