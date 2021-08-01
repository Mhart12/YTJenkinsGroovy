FROM jenkins/jenkins:lts
USER root
RUN apt-get update && apt-get install -y groovy sudo
USER jenkins
ENV JAVA_OPTS="-Djava.awt.headless=true -Dmail.smtp.starttls.enable=true"
