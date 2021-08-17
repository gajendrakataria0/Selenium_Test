pipeline {
  agent any
  stages {
    stage('1st') {
      parallel {
        stage('1st') {
          steps {
            echo '1st Jenkins'
          }
        }

        stage('2nd') {
          steps {
            sleep 2
          }
        }

      }
    }

    stage('') {
      steps {
        echo 'final'
      }
    }

  }
  environment {
    firstjenkin = '1'
  }
}