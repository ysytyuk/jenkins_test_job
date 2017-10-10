folder('Maintenance') {
  description 'Jenkins maintenance jobs'
}

pipelineJob('Maintenance/Docker GC') {
  concurrentBuild(false)
  definition {
    cps {
      sandbox()
      script(readFileFromWorkspace('jenkins-jobs/pipelines/docker_gc.groovy'))
    }
  }
  triggers {
    cron('@daily')
  }
  logRotator {
    numToKeep(7)
  }
}
