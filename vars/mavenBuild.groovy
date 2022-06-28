def call(Map stageParams) {
    stage('Build') {
        sh "mvn -v"
    }
}