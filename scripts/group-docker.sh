#!/bin/sh
# Criando grupo docker
sudo groupadd docker
# Adicionar o usuário atual ao grupo docker.
sudo usermod -aG docker $USER