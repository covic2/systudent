
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
	    stage('Build docker') {
	         dockerImage = docker.build("systudent-db/docker-stest")
	    }
	    stage('Deploy docker'){
	          echo "Docker Image Tag Name: ${dockerImageTag}"
	          sh "docker run -p 8086:8086 --name docker-stest --link mysql-standalone:mysql -d docker-stest"
	    }
	}catch(e){
	    currentBuild.result = "FAILED"
	    throw e
	}finally{
	
 	}
}