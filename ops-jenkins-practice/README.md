# Ops Jenkins Practice

Small Java 17 + Maven + JUnit 5 project with three automated tests and a parameterized Jenkins pipeline.

## Local test

```bash
mvn test
```

## Jenkins setup

1. Install Java 17, Maven and Git on the Jenkins agent. For the provided Jenkinsfile, use a Linux/Unix agent with `sh` available.
2. Create a **Pipeline** job. In **Pipeline > Definition**, select **Pipeline script from SCM**.
3. Select Git, enter the repository URL and credentials if the repository is private. Set the script path to `Jenkinsfile`.
4. Save and run once to load parameters. Subsequent runs can use **Build with Parameters**.
5. Choose `BRANCH_NAME` (e.g. `main` or `feature/new-test`), `TEST_MODE`, and `RUN_TESTS`.
6. Open **Console Output** to view logs and **Test Result** to see JUnit reports.

**Important:** The Pipeline job's configured SCM branch must contain the Jenkinsfile. `BRANCH_NAME` selects the source code checked out inside the pipeline, not the Jenkinsfile loaded by the job.

## Git exercise

```bash
git init
git add .
git commit -m "Initial Java tests and Jenkins pipeline"
git branch -M main
git remote add origin <YOUR-REPOSITORY-URL>
git push -u origin main

git switch -c feature/new-test
# Make a code or test change
git add .
git commit -m "Add a test"
git push -u origin feature/new-test
```

Create a PR from `feature/new-test` to `main`, review/comment, and merge it. For a failing-test demonstration, create a separate branch and deliberately change one expected value in a test, then run Jenkins against that branch. Do not merge that branch.

## Notes

The example Jenkinsfile assumes Jenkins Git plugin and Pipeline Maven execution are available. Jenkins credentials must be configured in Jenkins, not committed into this repository. The Jenkinsfile uses the remote configured in the Pipeline job and checks out the chosen branch explicitly.
