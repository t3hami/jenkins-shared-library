import com.nisum.devops.Sample


def call(body) {
    def config = [:]
    body.resolveStrategy = Closure.DELEGATE_FIRST
    body.delegate = config
    body()

    def sampleObj = new Sample(config.x, config.y)
    println sampleObj

    // closure body delegates it's body(parameter/properties) to it's delegate
    // the properties inside body closure will be available to config object only if body closure is executed
}