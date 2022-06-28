def call(body) {
    node {
        try {
            // list of steps to run
            def appConfig = readYaml text: libraryResource("config.yaml")
            appConfig = appConfig["jobs"][env.JOB_NAME]
            println appConfig
            gitCheckout()
            if (appConfig.build) {
                if (appConfig.BUILD_TYPE == "maven") {
                    mavenBuild()
                }
            }
        } catch (e) {
            if (e instanceof InterruptedException) {
                currentBuild.result = "ABORTED"
            } else {
                currentBuild.result = "FAILED"
            }
            throw e
        } finally {
            if (currentBuild.currentResult == 'SUCCESS') {
                // do something as post step
            }
        }
    }
}
