def call(body) {
    node {

        try {
            def appConfig = readYaml text: libraryResource("config.yaml")
            appConfig = appConfig["jobs"][env.JOB_NAME]

            // list of stages to run
            // gitCheckout()
            if (appConfig.build) {
                if (appConfig.BUILD_TYPE == "maven") {
                    mavenBuild()
                }
                else if (appConfig.BUILD_TYPE == "npm") {
                    npmBuild()
                }
            }
            if (appConfig.artifact_upload) uploadArtifact()
            if (appConfig.docker_build_and_push) dockerBuildAndPush()
            if (appConfig.deploy) deploy()
            if (appConfig.sample_step) sample()
        }
        
        
        catch (e) {
            if (e instanceof InterruptedException) {
                currentBuild.result = "ABORTED"
            } else {
                currentBuild.result = "FAILED"
            }
            throw e
        }
        
        finally {
            if (currentBuild.currentResult == 'SUCCESS') {
                // do something as post step
            }
        }
    }
}
