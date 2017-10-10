node {
    if ("${Enter_Password}" == "P@ssw0rd") {
        echo "Wow, you guess!"
    }

    stage('Test'){
        echo 'Wow!'
    }
    stage('Clean up stage'){
        echo 'It is cleaning'
        echo 'Wow! It is Cleaned'
    }
}
