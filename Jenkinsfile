pipeline {
	agent any

    environment {
		DOCKER_IMAGE = "gestion-etablissement"
        DOCKER_CONTAINER = "gestion-etablissement-container"
    }

    stages {
		stage('Cloner le repo') {
			steps {
				git branch: 'main', url: 'https://github.com/zenitsu2001/gestion-etablissement.git'
            }
        }

        stage('Build Maven') {
			steps {
				script {
					sh './mvnw clean package'
                }
            }
        }

        stage('Construire l’image Docker') {
			steps {
				script {
					sh 'docker build -t ${DOCKER_IMAGE} .'
                }
            }
        }

        stage('Exécuter le conteneur') {
			steps {
				script {
					sh 'docker run -d --name ${DOCKER_CONTAINER} -p 8080:8080 ${DOCKER_IMAGE}'
                }
            }
        }
    }

    post {
		always {
			script {
				sh 'docker stop ${DOCKER_CONTAINER} || true'
                sh 'docker rm ${DOCKER_CONTAINER} || true'
                sh 'docker rmi ${DOCKER_IMAGE} || true'
            }
        }
    }
}
