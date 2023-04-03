node{
   def commit_id
   stage('Preparation') {
     checkout scm
     sh 'echo 12345'  
     sh "git rev-parse --short HEAD > .git/commit-id"                        
     commit_id = readFile('.git/commit-id').trim()
   }
   stage('test2') {
     def myTestContainer = docker.image('node:16')
     myTestContainer.pull()
     myTestContainer.inside {
       sh 'echo 12345' 
       sh 'npm install --only=dev'
       sh 'npm test'
     }
   }
   stage('docker build/push') {
     docker.withRegistry('https://registry-1.docker.io/v2/', 'dockerhub') {
       def app = docker.build("wardviaene/docker-nodejs-demo:${commit_id}", '.').push()
     }
   }
}
