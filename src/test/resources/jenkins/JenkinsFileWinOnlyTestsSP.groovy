node('win1') {
    def mvnHome
    def javaHome
    stage('Preparation') {
        gitTool = tool 'GIT-WIN'
        mvnHome = tool 'MVN-WIN'
        javaHome = tool 'JDK11-WIN'
        echo "gitTool=$gitTool"
        //git 'https://github.com/kpassoubady/Calc.git'
        scm checkout
    }
    stage('Build') {
        withEnv([
                "MVN_HOME=$mvnHome",
                "JAVA_HOME=$javaHome",
                "PATH=.:C:\\WINDOWS\\SYSTEM32;$mvnHome\\bin;$javaHome\\bin;$PATH"
        ]) {
            echo "PATH=$PATH"
            bat(/"%MVN_HOME%\bin\mvn" -Dmaven.test.failure.ignore clean package/)
        }
    }
    stage('Results') {
        junit '**/target/surefire-reports/TEST-*.xml'
    }
}