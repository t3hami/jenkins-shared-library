def call(Map stageParams) {
    stage('Checkout SCM') {
        def gitObj = checkout([
                $class: 'GitSCM',
                branches: [[name:  stageParams.branch ]],
                userRemoteConfigs: [[ url: stageParams.url ]]
            ])
        return gitObj
    }
}