#!/bin/bash
echo "build the docker image"
result=$( sudo docker images -q jenkins/jenkins:2.112 )
if [[ $? -eq 0 ]];
then
  echo "built docker images and proceeding to delete existing container"
  sudo docker rm -f jenkins
else
  echo "no such image"
fi
sudo docker container run --name jenkins --detach \
  -u root \
  --volume jenkins-data:/var/jenkins_home \
  --volume /var/run/docker.sock:/var/run/docker.sock \
  --publish 8080:8080 --publish 50000:50000 jenkins/jenkins:2.112
echo "Deploying the container"