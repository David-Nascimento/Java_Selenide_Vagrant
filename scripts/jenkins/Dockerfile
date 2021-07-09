FROM jenkinsci/blueocean
USER root
RUN mkdir /srv/backup && chown jenkins:jenkins /srv/backup
USER jenkins
ENV JAVA_HOME /usr/lib/jvm/java-8-openjdk-amd64