pipeline {
    
    agent {
        label 'docker'
        
    }
    tools {
        maven 'maven' 
    }
    stages {
        stage('clone'){
            steps {
                sh "rm -rf *"
                sh "git clone https://github.com/Ahmed584/spring-mysql-compose-jenkins.git"
            }
        }
        stage('build'){
            steps {
                sh'''cd spring-mysql-compose-jenkins
                 mvn clean install -DskipTests'''
            }
        }
        stage('build and deploy'){
            steps {
                sh'pwd'
                sh ' ls'
               // sh 'docker container stop $(docker container ls -aq)'
            sh'''cd spring-mysql-compose-jenkins
             ls
                docker-compose up -d'''
             sh 'docker ps'
             sh 'docker images'
            }
        }
        stage('push image'){
            steps {
          withDockerRegistry([ credentialsId: "dockerHub", url: "" ]) {
            sh 'docker tag spring-boot-jpa-image:latest akrout123/spring-boot-jpa-image:$BUILD_NUMBER'
          sh 'docker push akrout123/spring-boot-jpa-image:$BUILD_NUMBER'
        }
            }
        }
    }
}
