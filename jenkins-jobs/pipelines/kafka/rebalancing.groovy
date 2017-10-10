node {
    if ("${Enter_agree}" != "yes") {
        echo "Should be yes if you wanna action"
        sh 'exit 0'
    }

    stage('Test'){
        echo 'Wow!'
    }
    stage('Clean up stage'){
        echo 'It is cleaning'
        echo 'Wow! It is Cleaned'
    }
}
