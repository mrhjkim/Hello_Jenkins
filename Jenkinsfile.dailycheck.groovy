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
			changedFilesInCommit = []
			echo "changeLogSet:${changeLogSet}"
			for (entry in changeLogSet.getItems()) { // for each commit in the detected changes
				echo "entry:${entry}"
				for (file in entry.getAffectedFiles()) {
					changedFiles.add(file.getPath()) // add changed file to list
					changedFilesInCommit.add(file.getPath()) // add changed file to list
				}
				author = entry.getAuthor()
				echo "user:${author}, files:${changedFilesInCommit}"
			}
		}
		echo "changed files : ${changedFiles}"
    }
}
