node {

    stage('Preparation') { // for display purposes
        echo "Current workspace : ${workspace}"
    }
    stage('Checkout') {
        // Get some code from a Git repository
        checkout scm
    }
    stage('CommitCheck') {
		changedFiles = []
		for (changeLogSet in currentBuild.changeSets) {
			for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
				echo "commit : ${entry}"
				for (file in entry.getAffectedFiles()) {
					changedFiles.add(file.getPath()) // add changed file to list
				}
			}
		}
		echo "changed files : ${changedFiles}"
    }
}
