import com.nisum.devops.Sample


def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    def sampleObj = new Sample(config.x, config.y)
    println sampleObj
}