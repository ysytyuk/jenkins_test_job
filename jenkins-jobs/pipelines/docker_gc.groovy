pipeline {
  // https://github.com/spotify/docker-gc#running-as-a-docker-container
  agent {
    docker {
      image 'spotify/docker-gc'
      args '-v /var/run/docker.sock:/var/run/docker.sock -v /etc:/etc:ro'
    }
  }
  stages {
    stage('run') {
      steps {
        sh '/docker-gc'
      }
    }
  }
}
