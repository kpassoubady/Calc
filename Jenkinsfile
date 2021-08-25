node('win1') {
  stage('SCM') {
    def  gitTool = tool 'GIT-WIN'
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'MVN-WIN';
    withEnv([
                    "MVN_HOME=$mvnHome",
                    "JAVA_HOME=$javaHome",
                    "PATH=.:C:\\WINDOWS\\SYSTEM32;$mvnHome\\bin;$javaHome\\bin;$PATH"
            ]) {
                    echo "PATH=$PATH"
                    withSonarQubeEnv() {
                       bat(/"%MVN_HOME%\bin\mvn" sonar:sonar/)
                    }
            }
  }
}