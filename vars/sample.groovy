import com.nisum.devops.Sample

def call(body) {
    stage('Deploy') {
        script {
            def sampleObj = new Sample(1, 2)
            println sampleObj
        }
    }
}