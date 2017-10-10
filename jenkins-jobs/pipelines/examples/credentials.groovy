node {

//here is binding!
// testuser1 is default test credentials record
withCredentials([[$class: 'UsernamePasswordMultiBinding',
    credentialsId: 'testuser1',
    usernameVariable: 'USERNAME',
    passwordVariable: 'PASSWORD']]) {
    
        stage('Test creds Extended syntax') {
        //available as an env variable, 
        // but will be masked if you try to print it
        // out any which way
                sh 'echo $PASSWORD'
                echo "${env.USERNAME}"
    }
}


// using credentials by external plugins like git/git-hub
// checkout with creds
// stage('Checkout') {
//        git branch: 'lts-1.532',
//        credentialsId: '82aa2d26-ef4b-4a6a-a05f-2e1090b9ce17',
//        url: 'git@github.com:jenkinsci/maven-plugin.git'
//    }

}


// here is setup pipeline variables
//  works with pipeline {} syntax
// environment {
//     AWS_ACCESS_KEY_ID     = credentials('AWS_ACCESS_KEY_ID')
//     AWS_SECRET_ACCESS_KEY = credentials('AWS_SECRET_ACCESS_KEY')
// }