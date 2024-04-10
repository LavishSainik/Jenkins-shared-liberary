#!/usr/bin/env groovy

def call() {
    echo "building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t lavish11/my-repo:2.0 .'
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh 'docker push lavish11/my-repo:2.0'
    }
}