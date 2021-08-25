node('ubuntu1') {
  stage('SCM') {
    def  gitTool = tool 'GIT-UBUNTU'
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'MVN-UBUNTU';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn sonar:sonar"
    }
  }
}