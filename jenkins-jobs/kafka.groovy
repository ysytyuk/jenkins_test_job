String directory = 'Kafka'

folder(directory) {
    description 'Contains quadra-logging related jobs'
}

pipelineJob("$directory/Re-balance topics(DSL)") {
    definition {
        logRotator {
            numToKeep(5)
            artifactNumToKeep(1)
            daysToKeep(7)
        }
        parameters {
            stringParam('Enter_agree', '', 'Are you agree? Say yes')
        }
        cps {
            sandbox()
            script(readFileFromWorkspace('jenkins-jobs/pipelines/kafka/rebalancing.groovy'))
        }
    }
}