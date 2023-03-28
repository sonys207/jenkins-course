job('NodeJS example') {
    scm {
        git('https://github.com/wardviaene/docker-demo.git')
    }
    triggers {
        scm('H/5 * * * *')
    }
    wrappers {
        nodejs('nodejs19.8.1') // this is the name of the NodeJS installation in 
                         // Manage Jenkins -> Configure Tools -> NodeJS Installations -> Name
    }
    steps {
        shell("npm install")
    }
}
