pipeline {
    agent any
    
    stages {
        stage('Clone repository') {
            steps {
               
                    git branch: 'master', url: 'https://github.com/diwinw/cypress-jenkins'
                
            }
        }

          stage('Build') {
            steps {
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
