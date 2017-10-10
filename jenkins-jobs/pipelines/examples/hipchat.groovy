pipeline{

stage 'Test'{
    sh 'ls'
}

hipchatSend color: 'GREEN',
  failOnError: true,
   message: 'it is only test',

}