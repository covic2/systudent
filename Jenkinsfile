
node {
    def dockerImageTag = "docker-stest"
	try{
	    stage('Clone Repo') {
	        // for display purposes
	        // Get some code from a GitHub repository
	        git url: 'https://github.com/covic2/systudent.git',
	            credentialsId: 'covic2',
	            branch: 'main'
	     }
	    stage('Build Project') {
	      // build project via maven
	      bat "cd systudent-db & ${MAVEN_HOME}/bin/mvn install"
	    }
	    stage('Build docker') {
	         bat "cd systudent-db & docker build . -t docker-systudent-discovery"
	    }
	    stage('Deploy docker'){
	          echo "Docker Image Tag Name: ${dockerImageTag}"
	          bat "docker run -p 8761:8761 --name docker-systudent-discovery --link kafka -d docker-systudent-discovery"
	    }
	}catch(e){
	    currentBuild.result = "FAILED"
	    throw e
	}finally{
	
 	}
}