String directory = 'Graphite'

folder(directory) {
    description 'Contains jobs for MML graphite nodes'
}

pipelineJob("$directory/Remove old metrics(template)") {
    description '''
    Template pipeline for removing old metrics from a graphite node
    Managed by DSL (jenkins-setup repo)
    '''
    definition {
        logRotator {
            numToKeep(5)
            artifactNumToKeep(1)
            daysToKeep(7)
        }
        parameters {
            stringParam('Enter_Password', '', 'Please, enter something :)')
        }
        cps {
            sandbox()
            script(readFileFromWorkspace('jenkins-jobs/pipelines/graphite_stack/clean_jobs.groovy'))
        }
    }
}

pipelineJob("$directory/Migration(template)") {
    description '''
    Template pipeline for migration from a graphite node
    Managed by DSL (jenkins-setup repo)
    '''
    definition {
        logRotator {
            numToKeep(5)
            artifactNumToKeep(1)
            daysToKeep(7)
        }
        cps {
            sandbox()
            script(readFileFromWorkspace('jenkins-jobs/pipelines/graphite_stack/vip_migration.groovy'))
        }
    }
}