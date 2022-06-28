import com.nisum.devops.Sample

@NonCPS
def call(body) {
    def sampleObj = new Sample(1, 2)
    println sampleObj
}