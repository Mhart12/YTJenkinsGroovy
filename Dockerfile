FROM jenkins/jenkins:lts
USER root
RUN apt-get update && apt-get install -y groovy
USER jenkins
#RUN jenkins-plugin-cli --plugins "blueocean:1.24.7 docker-workflow:1.26"