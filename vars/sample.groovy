import com.nisum.devops.Sample

def call(body) {
    @NonCPS
    stage('Sample') {
        script {
            def sampleObj = new Sample(1, 2)
            println sampleObj
        }
    }
}