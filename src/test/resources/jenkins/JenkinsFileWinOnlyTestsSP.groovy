node('win') {
    def mvnHome
    def javaHome
    stage('Preparation') {
        git 'https://github.com/kpassoubady/Calc.git'
        mvnHome = tool 'MVN-WIN'
        javaHome = tool 'JDK11-WIN'
    }
    stage('Build') {
        withEnv([
                "MVN_HOME=$mvnHome",
                "JAVA_HOME=$javaHome",
                "PATH=$javaHome\bin:$PATH"
        ]) {
            bat(/"%MVN_HOME%\bin\mvn" clean test/)
        }
    }
    stage('Test Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
    }
}