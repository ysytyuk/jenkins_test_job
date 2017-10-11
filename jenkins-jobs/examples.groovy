String directory = 'Examples'

folder(directory) {
    description 'Contains jobs for graphite stack'
}

pipelineJob("$directory/hipchat-notify") {
    definition {
        logRotator {
            numToKeep(5)
            artifactNumToKeep(1)
            daysToKeep(7)
        }
        cps {
            sandbox()
            script(readFileFromWorkspace('jenkins-jobs/pipelines/examples/hipchat.groovy'))
        }
    }
}

pipelineJob("$directory/use_credentials") {
    definition {
        logRotator {
            numToKeep(5)
            artifactNumToKeep(1)
            daysToKeep(7)
        }
        cps {
            sandbox()
            script(readFileFromWorkspace('jenkins-jobs/pipelines/examples/credentials.groovy'))
        }
    }
}

pipelineJob("$directory/input_timeout") {
    definition {
        logRotator {
            numToKeep(5)
            artifactNumToKeep(1)
            daysToKeep(7)
        }
        cps {
            sandbox()
            script(readFileFromWorkspace('jenkins-jobs/pipelines/examples/input_timeout.groovy'))
        }
    }
}