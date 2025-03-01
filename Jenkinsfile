pipeline {
    agent any
    triggers {
      githubPush()
    }
    environment {
        DOCKER_IMAGE_NAME = 'mohit082003/calculator'
        GITHUB_REPO_URL = 'https://github.com/mohit2808/SPECalculator.git'
    }

    stages {
        stage('Checkout') {
            steps {
                script {
                    git branch: 'main', url: "${GITHUB_REPO_URL}"
                }
            }
        }

        stage('Build JAR') {
            steps {
                script {
                    sh 'mvn clean package'
                }
            }
        }

        stage('Build Docker Image') {
            steps {
                script {
                    docker.build("${DOCKER_IMAGE_NAME}", '.')
                }
            }
        }

        stage('Push Docker Image') {
            steps {
                script {
                    docker.withRegistry('', 'MyDockerCred') {
                        sh "docker tag calculator ${DOCKER_IMAGE_NAME}:latest"
                        sh "docker push ${DOCKER_IMAGE_NAME}"
                    }
                }
            }
        }

        stage('Run Ansible Playbook') {
            steps {
                script {
                    ansiblePlaybook(
                        playbook: 'deploy.yml',
                        inventory: 'inventory'
                    )
                }
            }
        }
    }
}
