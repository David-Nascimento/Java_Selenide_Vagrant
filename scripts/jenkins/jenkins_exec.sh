#!/bin/bash
echo "build the docker image"
result=$( sudo docker images -q jenkinsci/blueocean )
if [[ $? -eq 0 ]];
then
  echo "built docker images and proceeding to delete existing container"
  sudo docker rm -f jenkins-blueocean
else
  echo "no such image"
fi
sudo docker container run --name jenkins-blueocean --detach \
  --network skynet -u root \
  --volume jenkins-data:/var/jenkins_home \
  --volume /var/run/docker.sock:/var/run/docker.sock \
  --publish 9000:8080 --publish 50000:50000 jenkinsci/blueocean
echo "Deploying the container"