#!/bin/sh
#Instal o Java versão 8
sudo apt-get update
sudo apt-get upgrade -y
sudo apt-get install openjdk-8-jdk -y

#Criar a variavel do java
export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

echo $JAVA_HOME

#Importa o Java_home para o PATH
export PATH=$PATH:$JAVA_HOME/bin

echo $PATH

#Verifica a versão
java -version