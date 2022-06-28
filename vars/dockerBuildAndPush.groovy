def call(Map stageParams) {
    stage('Docker Build') {
        println "Building Docker Image..."
    }
    stage('Docker Push') {
        println "Pushing Docker Image..."
    }
}