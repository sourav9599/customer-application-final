pipeline {
    agent {
        label 'slave-1'
    }
    stages {
        stage('Static Code Analysis') {
            steps {
                sh 'mvn pmd:pmd'
            }
        }
        stage('Sonarqube Analysis') {
            steps {
                    withSonarQubeEnv('SonarQube') {
                        sh 'mvn clean verify sonar:sonar -Dsonar.projectKey=Customer-application'
                    }
            }
        }
        stage('Quality gate') {
            steps {
                waitForQualityGate abortPipeline: true
            }
        }
        stage ('Artifactory configuration') {
            steps {
                rtMavenDeployer (
                    id: 'MAVEN_DEPLOYER',
                    serverId: 'jfrog-gcp',
                    releaseRepo: 'maven-local-release',
                    snapshotRepo: 'maven-local-snapshot'
                )
            }
        }

        stage ('Exec Maven') {
            steps {
                rtMavenRun (
                    tool: 'MAVEN_HOME',
                    pom: 'pom.xml',
                    goals: 'clean package',
                    deployerId: 'MAVEN_DEPLOYER'
                )
            }
        }

        stage ('Publish build info') {
            steps {
                rtPublishBuildInfo (
                    serverId: 'jfrog-gcp'
                )
            }
        }
        stage ('Deploy To VM using ansible') {
            steps {
                ansiblePlaybook becomeUser: 'sourav10mohanty', installation: 'ansible', inventory: 'ansible/hosts', playbook: 'ansible/ansible-playbook.yaml'
            }
        }
    }
    post {
        always {
            cleanWs()
        }
    }
}
