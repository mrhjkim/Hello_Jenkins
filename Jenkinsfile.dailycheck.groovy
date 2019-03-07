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
				changedFilesInCommit = []
				for (file in entry.getAffectedFiles()) {
					changedFiles.add(file.getPath()) // add changed file to list
					changedFilesInCommit.add(file.getPath()) // add changed file to list
				}
				authorName = entry.getAuthorName
				echo "user:${authorName}, files:${changedFilesInCommit}"
			}
		}
		echo "changed files : ${changedFiles}"
    }
}
